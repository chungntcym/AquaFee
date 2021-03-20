package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Contract;
import model.Grade;

public class GradeDAO extends DAO {

	private static final String GET_GRADE_TABLE_BY_CONTRACT_TYPE = "SELECT grade, value, price FROM `tblgrade`, "
			+ "(SELECT max(startDate) as latestDate FROM `tblgrade` WHERE tblContractTypeid=?) as latestDate "
			+ "WHERE tblContractTypeid=? AND startDate = latestDate.latestDate ORDER BY grade;";

	private static final String INSERT_GRADE = "INSERT INTO `tblgrade` (`grade`, `value`, `price`, `startDate`, `tblContractTypeid`) "
			+ "VALUES (?,?,?,?,?);";

	public ArrayList<Grade> getTableGradeByContractTypeId(String contractTypeId) throws SQLException {
		try {
			Connection connection = getConnection();
			// try-with-resource statement will auto close the connection.
			PreparedStatement preparedStatement = connection.prepareStatement(GET_GRADE_TABLE_BY_CONTRACT_TYPE);
			preparedStatement.setString(1, contractTypeId);
			preparedStatement.setString(2, contractTypeId);
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

	public boolean saveGradeTable(ArrayList<Grade> listGrade, int contractTypeId) throws SQLException {
		try {
			Connection connection = getConnection();
			// try-with-resource statement will auto close the connection.
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GRADE);

			for (Grade grade : listGrade) {
				preparedStatement.setInt(1, grade.getGrade());
				preparedStatement.setInt(2, grade.getValue());
				preparedStatement.setFloat(3, grade.getPrice());
				preparedStatement.setTimestamp(4, grade.getStartDate());
				preparedStatement.setInt(5, contractTypeId);
				preparedStatement.addBatch();
				;
			}

			int[] result = preparedStatement.executeBatch();
			if (result.length > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
