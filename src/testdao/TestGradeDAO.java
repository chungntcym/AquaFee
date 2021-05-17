package testdao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import dao.DAO;
import dao.GradeDAO;
import model.Grade;

class TestGradeDAO extends DAO {

	@Test
	void testGradeDAO() {
		try {
			GradeDAO gradeDao = new GradeDAO();
				
			Date date = new Date();
			java.sql.Timestamp startDate = new java.sql.Timestamp(date.getTime());		
			
			//Fake data
			ArrayList<Grade> listGradeTest = new ArrayList<>();
			listGradeTest.add(new Grade(0,1,0,1000,startDate));
			listGradeTest.add(new Grade(0,2,3,5000,startDate));
			listGradeTest.add(new Grade(0,3,9,9000,startDate));
			
			gradeDao.saveGradeTable(listGradeTest, 1);
			
			ArrayList<Grade> listGradeResult = gradeDao.getTableGradeByContractTypeId("1");
			
			//If pass => both create and read function work normally
			assertEquals(listGradeTest, listGradeResult);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
