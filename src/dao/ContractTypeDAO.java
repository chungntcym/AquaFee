package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Contract;
import model.ContractType;

public class ContractTypeDAO extends DAO {
	private static final String GET_CONTRACTTYPE_BY_ID = "SELECT * FROM `tblContractType` WHERE `id` = ?;";

	private static final String INSERT_INTO_CONTRACTTYPE = "INSERT INTO `tblContractType` VALUE (?);";

	private static final String UPDATE_CONTRACTTYPE_BY_ID = "UPDATE `tblContractType` SET ? WHERE `id` = ?;";

	private static final String DETETE_CONTRACTTYPE_BY_ID = "DELETE `tblContractType` SET ? WHERE `id` = ?;";

	public ContractType getContractById(String contractTypeId) throws SQLException {
		try {
			Connection connection = getConnection();
			// try-with-resource statement will auto close the connection.
			PreparedStatement preparedStatement = connection.prepareStatement(GET_CONTRACTTYPE_BY_ID);
			preparedStatement.setString(1, contractTypeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			ContractType contractType = new ContractType();
			while (resultSet.next()) {
				contractType.setId(resultSet.getInt("id"));
			}
			return contractType;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
