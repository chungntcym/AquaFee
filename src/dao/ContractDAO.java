package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Contract;

public class ContractDAO extends DAO {

	private static final String GET_CONTRACT_BY_ID = "SELECT * FROM `tblContract` WHERE `id` = ?;";
	
	private static final String INSERT_INTO_CONTRACT = "INSERT INTO `tblContract` VALUE (?);";

	private static final String UPDATE_CONTRACT_BY_ID = "UPDATE `tblContract` SET ? WHERE `id` = ?;";
	
	private static final String DETETE_CONTRACT_BY_ID = "DELETE `tblContract` SET ? WHERE `id` = ?;";
	
	public Contract getContractById(String contractId) throws SQLException {
		try {
			Connection connection = getConnection();
			// try-with-resource statement will auto close the connection.
			PreparedStatement preparedStatement = connection.prepareStatement(GET_CONTRACT_BY_ID);
			preparedStatement.setString(1, contractId);
			ResultSet resultSet = preparedStatement.executeQuery();
			Contract contract = new Contract();
			while(resultSet.next()) {
				contract.setId(resultSet.getInt("id"));
			}
			return contract;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
