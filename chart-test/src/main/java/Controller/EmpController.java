package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Service.EmpService;
import Service.IEmpService;

@WebServlet("/Controller/*")		// 하나의 컨트롤러에서 여러개 요청할수 있도록 만듦, 프론트컨트롤러 : 다 모아서 분기시켜줌
public class EmpController extends HttpServlet {		
	private IEmpService empService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 응답 형태 결정
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		Gson gson = new Gson();
		String result = "";
		
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		int n = request.getContextPath().length();		
		String command = uri.substring(n);			// /chart-test/Controller/* 11부터 자름
		
		empService = new EmpService();
		
		if(command.equals("/Controller/getCountByDept")) {
			// EmpService 실행  (EmpService.getCountByDept)
			List<Map<String,Object>> list = empService.getCountByDept();
			result = gson.toJson(list);
		} else if (command.equals("/Controller/getCountByHiredate")) {
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			if(request.getParameter("year") != null) {
				year = Integer.parseInt(request.getParameter("year"));
			}
			
			// EmpService 실행  (EmpService.getCountByHiredate)
			List<Map<String,Object>> list = empService.getCountByHiredate(year);
			result = gson.toJson(list);
			
		} else {
			System.out.println("잘못된 요청.");
		}
		System.out.println(result);
	
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

}
