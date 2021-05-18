package testdao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import dao.DAO;
import dao.GradeDAO;
import model.Grade;

class TestGradeDAO extends DAO {

	@Test
	void testGetTableGradeByContractTypeId() throws Exception {
		GradeDAO gradeDao = new GradeDAO();

		Connection connection = gradeDao.getDAOConnection();
		connection.setAutoCommit(false);
		try {

			//Test 1: Normal
			Date date = new Date();
			java.sql.Timestamp startDate = new java.sql.Timestamp(date.getTime());

			// Fake data
			ArrayList<Grade> listGradeTest = new ArrayList<>();
			listGradeTest.add(new Grade(0, 1, 0, 1000, startDate));
			listGradeTest.add(new Grade(0, 2, 3, 5000, startDate));
			listGradeTest.add(new Grade(0, 3, 9, 9000, startDate));

			gradeDao.saveGradeTable(listGradeTest, 1);

			ArrayList<Grade> listGradeResult = gradeDao.getTableGradeByContractTypeId("1");

			// If pass => both create and read function work normally
			assertEquals(listGradeTest, listGradeResult);
			
			//Test 2: Negative id
			listGradeResult = gradeDao.getTableGradeByContractTypeId("-1");
			listGradeTest = new ArrayList<>();
			assertEquals(listGradeTest, listGradeResult);
			
			//Test 3: Wrong type
			listGradeResult = gradeDao.getTableGradeByContractTypeId("abcd");
			listGradeTest = new ArrayList<>();
			assertEquals(listGradeTest, listGradeResult);

		} finally {
			connection.rollback();
			connection.close();
		}
	}
	
	@Test
	void testSaveGradeTable() throws Exception {
		GradeDAO gradeDao = new GradeDAO();

		Connection connection = gradeDao.getDAOConnection();
		connection.setAutoCommit(false);
		try {
			
			//Test 1: Normal
			Date date = new Date();
			java.sql.Timestamp startDate = new java.sql.Timestamp(date.getTime());

			// Fake data
			ArrayList<Grade> listGradeTest = new ArrayList<>();
			listGradeTest.add(new Grade(0, 1, 0, 1000, startDate));
			listGradeTest.add(new Grade(0, 2, 3, 5000, startDate));
			listGradeTest.add(new Grade(0, 3, 9, 9000, startDate));

			gradeDao.saveGradeTable(listGradeTest, 1);

			ArrayList<Grade> listGradeResult = gradeDao.getTableGradeByContractTypeId("1");

			// If pass => both create and read function work normally
			assertEquals(listGradeTest, listGradeResult);
			
			//Test 2: save Empty Table
			listGradeTest = gradeDao.getTableGradeByContractTypeId("1");

			// Fake data
			ArrayList<Grade> listGradeFakeData = new ArrayList<>();
			gradeDao.saveGradeTable(listGradeFakeData, 1);

			listGradeResult = gradeDao.getTableGradeByContractTypeId("1");

			// If pass => both create and read function work normally and can handle empty arraylist in input
			assertEquals(listGradeTest, listGradeResult);

		} finally {
			connection.rollback();
			connection.close();
		}
	}

}
