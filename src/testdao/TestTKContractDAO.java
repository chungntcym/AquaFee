package testdao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import dao.TKContractDAO;
import model.TKContract;

class TestTKContractDAO {

	@Test
	void testTKContractDAO() {
		TKContractDAO tkContractDAO = new TKContractDAO();
		
		try {
			ArrayList<TKContract> listTK = tkContractDAO.getAllContract("1");
			assertTrue(listTK.size() == 4);
			for (TKContract item: listTK) {
				if (item.getId() == 1) {
					assertTrue(item.getFullname().equals("Tráº§n Ngá»�c Nam Anh"));
					assertTrue(item.getAddress().equals("Sá»‘ nhÃ  1 ngÃµ 12 Ä�Æ°á»�ng ChÃ¹a Bá»™c"));
					assertTrue(item.getPhonenumber().equals("0123456789"));
					assertTrue(item.getIdentityNumber().equals("101355975"));
					assertTrue(item.getEmail().equals("AnhTN@email.com"));
					assertTrue(item.getLoaihopdong().equals("há»™ dÃ¢n cÆ°"));
				}
				if (item.getId() == 2) {
					assertTrue(item.getFullname().equals("VÅ© Tuáº¥n Anh"));
					assertTrue(item.getAddress().equals("Báº¯c Giang"));
					assertTrue(item.getPhonenumber().equals("0987654321"));
					assertTrue(item.getIdentityNumber().equals("101369745"));
					assertTrue(item.getEmail().equals("AnhVT@email.com"));
					assertTrue(item.getLoaihopdong().equals("há»™ nghÃ¨o"));
				}
				if (item.getId() == 3) {
					assertTrue(item.getFullname().equals("Nguyá»…n VÅ© Chiáº¿n"));
					assertTrue(item.getAddress().equals("Quáº£ng Ninh"));
					assertTrue(item.getPhonenumber().equals("0123459876"));
					assertTrue(item.getIdentityNumber().equals("101323698"));
					assertTrue(item.getEmail().equals("ChienNV@email.com"));
					assertTrue(item.getLoaihopdong().equals("há»™ dÃ¢n cÆ°"));
				}
				if (item.getId() == 4) {
					assertTrue(item.getFullname().equals("Nguyá»…n ThÃ nh Chung "));
					assertTrue(item.getAddress().equals("HÆ°ng YÃªn"));
					assertTrue(item.getPhonenumber().equals("0987612345"));
					assertTrue(item.getIdentityNumber().equals("101254795"));
					assertTrue(item.getEmail().equals("ChungNT@email.com"));
					assertTrue(item.getLoaihopdong().equals("há»™ dÃ¢n cÆ°"));
				}
	
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		

	}

}
