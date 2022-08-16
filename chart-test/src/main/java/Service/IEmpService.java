package Service;

import java.util.List;
import java.util.Map;

public interface IEmpService {
	
	public List<Map<String,Object>> getCountByDept();
	public List<Map<String,Object>> getCountByHiredate(int year);
	
}
