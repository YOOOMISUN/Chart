package Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Commons.DBUtil;
import Repository.EmpDao;
import Repository.IEmpDao;

public class EmpService implements IEmpService {
	private IEmpDao empDao;
	
	@Override
	public List<Map<String,Object>> getCountByDept(){
		
		List<Map<String,Object>> list = null;
		empDao = new EmpDao();		// 다형성
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			list = empDao.selectCountByDept(conn);
			conn.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}		// end getCountByDept
	
	@Override
	public List<Map<String, Object>> getCountByHiredate(int year) {
		
		List<Map<String,Object>> list = null;
		empDao = new EmpDao();		// 다형성
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			list = empDao.selectCountByHiredate(conn,year);
			conn.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}	// end getCountByHiredate
	
}
