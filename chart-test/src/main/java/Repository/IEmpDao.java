package Repository;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface IEmpDao {

    List<Map<String,Object>> selectCountByDept (Connection conn) throws Exception;
    
    List<Map<String,Object>> selectCountByHiredate (Connection conn, int year) throws Exception;
   
}