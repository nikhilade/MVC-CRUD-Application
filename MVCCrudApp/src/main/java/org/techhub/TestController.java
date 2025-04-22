package org.techhub;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.techhub.model.Employee;
import org.techhub.service.EmployeeService;

@Controller
public class TestController {
	@Autowired
	EmployeeService empService;
	
	@RequestMapping("/")
	public String test() {
		return "master";
	}
	
	@RequestMapping(value = "/addemp")
	public String addNewEmployee() {
		return "addemployee";
	}
	
	@RequestMapping(value="/saveemp", method=RequestMethod.POST)
	public String saveEmployee(Employee employee, Map<String, String> map) {
		boolean b = empService.isAddNewEmployee(employee);
		if(b) {
			map.put("msg", "New Employee Added");
		}else {
			map.put("msg", "Employee Not Added");
		}
		return "addemployee";
	}
	
	@RequestMapping("/view")
	public String viewAllEmp(Map map) {
		List<Employee> list = empService.getAllEmployee();
		map.put("empList", list);
		return "viewallemp";
	}
	
	@RequestMapping("/del")
	public String delEmp(@RequestParam("empid") Integer empid, Map map) {
		//System.out.println(empid);
		boolean b = empService.isDeleteEmployee(empid);
		if(b) {
			List<Employee> list = empService.getAllEmployee();
			map.put("empList", list);
		}
		return "viewallemp";
	}
	
	@RequestMapping(value="/upd", method=RequestMethod.GET)
	public String updateEmployee(HttpServletRequest request, Map map) {
		int empid=Integer.parseInt(request.getParameter("empid"));
		String name=request.getParameter("empname");
		String email=request.getParameter("empemail");
		String contact=request.getParameter("empcontact");
		map.put("id", empid);
		map.put("name", name);
		map.put("email", email);
		map.put("contact", contact);
		return "update";
	}
	
	@RequestMapping("/finalupdate")
	public String finalUpdate(Employee employee, Map map) {
		empService.isUpdateEmployee(employee);
		List<Employee> list = empService.getAllEmployee();
		map.put("empList", list); 
		return "viewallemp";
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public List<Employee> searchEmployee(@RequestParam("v") String value) {
	    List<Employee> list = empService.getAllEmployeeByName(value);
	    return list;
	}
}
