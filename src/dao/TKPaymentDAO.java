package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TKPaymentDAO extends DAO {

	private static final String GET_PAYMENT_STATISTICAL	 = "SELECT * FROM  `tblpayment`, `tblcontracttype`, `tblcustomer` "
			+ "WHERE tblcontracttype.id = tblcustomer.tblContractTypeid AND tblcustomer.id = tblCustomerid "
			+ "AND tblpayment.payment_time IS NULL;";

	public ResultSet getPaymentStats() throws SQLException {
		try {
			Connection connection = getConnection();
			// try-with-resource statement will auto close the connection.
			PreparedStatement preparedStatement = connection.prepareStatement(GET_PAYMENT_STATISTICAL);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
