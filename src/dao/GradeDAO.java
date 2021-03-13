package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Contract;
import model.Grade;

public class GradeDAO extends DAO {
	
private static final String GET_GRADE_BY_ID = "SELECT * FROM `tblGrade` WHERE `id` = ?;";
	
	private static final String INSERT_INTO_GRADE = "INSERT INTO `tblGrade` VALUE (?);";

	private static final String UPDATE_GRADE_BY_ID = "UPDATE `tblGrade` SET ? WHERE `id` = ?;";
	
	private static final String DETETE_GRADE_BY_ID = "DELETE `tblGrade` SET ? WHERE `id` = ?;";
	
	public Grade getGradeById(String gradeId) throws SQLException {
		try {
			Connection connection = getConnection();
			// try-with-resource statement will auto close the connection.
			PreparedStatement preparedStatement = connection.prepareStatement(GET_GRADE_BY_ID);
			preparedStatement.setString(1, gradeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			Grade grade = new Grade();
			while(resultSet.next()) {
				grade.setId(resultSet.getInt("id"));
			}
			return grade;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
