package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDao implements IEmpDao{
	
	// 계층은 독립적이어야 Ex 레파짓토리, 서비스 계층은 독립적이어야
	// >>> controller > service > repository 호출시 명확한 호출이 아니라 추상적인 호출이 좋다
	// 박성환쌤이 승현씨를 부를때 조승현 오세요 [X] / 3층의 GDJ50반 반장 와주세요[O] >>> 승현씨가 사퇴하고 새로운 반장이 나와도 상관없음
	// 다른계층에서 직접적으로 클래스 호출하는건 별로 좋지 않대 >>> 자바에는 인터페이스라는 개념이 있다!
	// 근데 우리는 오늘만 fm이라 인터페이스 만들거래
	
	
	// 통계데이터의 리턴값은 map이나 list
	@Override
	public List<Map<String, Object>> selectCountByDept(Connection conn) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		String sql = EmpQuery.SELECT_COUNT_BY_DEPT;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt= conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> m =new HashMap<String, Object>();
				m.put("dname", rs.getString("dname"));
				m.put("cnt", rs.getInt("cnt"));
				
				list.add(m);
				
			}
			
		} finally {
			if(rs !=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
		}
		
		return list;
	}
	
	
	@Override
	public List<Map<String, Object>> selectCountByHiredate(Connection conn, int year) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		String sql = EmpQuery.SELECT_COUNT_BY_HIREDATE;
		ResultSet rs = null;
		
		PreparedStatement stmt = null;
	
		
		try {
			
			stmt= conn.prepareStatement(sql);
			stmt.setInt(1, year);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> m =new HashMap<String, Object>();
				m.put("m", rs.getInt("m"));
				m.put("cnt", rs.getInt("cnt"));
				
				list.add(m);
				
			}
			
		} finally {
			if(rs !=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
		}
		
		return list;
	}
	
}
