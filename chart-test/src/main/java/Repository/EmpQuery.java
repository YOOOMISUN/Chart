package Repository;

public class EmpQuery {
	
	// 안바뀌게 final , 어디서든 같은 값을 쓰고 싶어서 static final
	
	// 부서별 카운트
	public static final String SELECT_COUNT_BY_DEPT 		
			= "SELECT d.dname dname, IFNULL(e.cnt, 0) cnt"
			+ " FROM dept d"
			+ " LEFT OUTER JOIN"
			+ " (SELECT deptno, COUNT(*) cnt"
			+ " FROM emp"
			+ " GROUP BY deptno) e"
			+ " ON d.deptno = e.deptno"
			+ " ORDER BY IFNULL(e.cnt, 0) DESC";

		 
	 
	public static final String SELECT_COUNT_BY_HIREDATE 
	
			= "SELECT MONTH(hiredate) m, COUNT(*) cnt"
			+ " FROM emp"
			+ " WHERE YEAR(hiredate) = ?"
			+ " GROUP BY MONTH(hiredate)"
			+ " ORDER BY MONTH(hiredate) ASC";
	 
	// 스프링 들어가서 마이바티스 쓰면 뭐 쿼리랑 나머지랑 알아서 분리된다는데



}
