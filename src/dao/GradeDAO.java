package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Contract;
import model.Grade;

public class GradeDAO extends DAO {

	private static final String GET_GRADE_TABLE_BY_CONTRACT_TYPE = "SELECT grade, max(startDate) as startDate, value, price "
			+ "FROM `tblgrade` WHERE tblContractTypeid=? GROUP BY grade ORDER BY grade";

	public ArrayList<Grade> getTableGradeByContractTypeId(String contractTypeId) throws SQLException {
		try {
			Connection connection = getConnection();
			// try-with-resource statement will auto close the connection.
			PreparedStatement preparedStatement = connection.prepareStatement(GET_GRADE_TABLE_BY_CONTRACT_TYPE);
			preparedStatement.setString(1, contractTypeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			ArrayList<Grade> listGrade = new ArrayList<>();
			while (resultSet.next()) {
				Grade grade = new Grade();
				grade.setGrade(resultSet.getInt("grade"));
				grade.setPrice(resultSet.getFloat("price"));
				grade.setValue(resultSet.getInt("value"));
				listGrade.add(grade);
			}
			return listGrade;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
