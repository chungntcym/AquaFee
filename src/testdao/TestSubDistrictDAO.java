package testdao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import dao.*;
import model.*;

class TestSubDistrictDAO {

	@Test
	void testSubDistrictDAOgetAllSubDistrict() throws Exception {
		SubDistrictDAO 	subDistrictDAO = new 	SubDistrictDAO();
		try {
			String id="1";
			ArrayList<SubDistrict> listSubDistrictsTest1 = 	subDistrictDAO.getAllSubDistrictById(id);
			//Test if the returned arraylist is as same as in database
			System.out.print(listSubDistrictsTest1.get(0).getName());
			assertTrue(listSubDistrictsTest1.get(0).getName().equals("Mộ Lao"));
			id="2";
			ArrayList<SubDistrict> listSubDistrictsTest2 = 	subDistrictDAO.getAllSubDistrictById(id);
			assertTrue(listSubDistrictsTest2.get(0).getName().equals("Hạ Đình"));
			id="3";
			ArrayList<SubDistrict> listSubDistrictsTest3 = 	subDistrictDAO.getAllSubDistrictById(id);
			assertTrue(listSubDistrictsTest3.get(0).getName().equals("Định Công"));
			id="4";
			ArrayList<SubDistrict> listSubDistrictsTest4 = 	subDistrictDAO.getAllSubDistrictById(id);
			assertTrue(listSubDistrictsTest4.get(0).getName().equals("Cửa Đông"));
			id="5";
			ArrayList<SubDistrict> listSubDistrictsTest5 = 	subDistrictDAO.getAllSubDistrictById(id);
			assertTrue(listSubDistrictsTest5.get(0).getName().equals("Hàng Khoai"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
