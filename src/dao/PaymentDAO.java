package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Payment;

public class PaymentDAO extends DAO{
	public PaymentDAO() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	private static final String GET_INVOICE_BY_CUS_ID = "SELECT * FROM aquaman.tblpayment where tblcustomerid = ?;";
	
	public ArrayList<Payment> getInvoiceByCusId(int id) throws SQLException{
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_INVOICE_BY_CUS_ID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			ArrayList<Payment> listGrade = new ArrayList<Payment>();
			while(resultSet.next()) {
				Payment grade = new Payment();
				grade.setId(resultSet.getInt("id"));
				grade.setPayment_time(resultSet.getTimestamp("payment_time"));
				grade.setIssue_time(resultSet.getTimestamp("issue_time"));
				grade.setWater_meter_value(resultSet.getInt("water_meter_value"));
				grade.setPrice(resultSet.getFloat("price"));
				listGrade.add(grade);
			}	
			return listGrade;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
