package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Employee;
import com.app.service.EmployeeService;

@RestController // =@Controller : class level +
//@ResponseBody : added implicitly on ret types of req handling methods
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
//dependency : service layer i/f
	@Autowired
	private EmployeeService empService;
	
	public EmployeeController() {
		System.out.println("in ctor of "+getClass());
	}
	//URL : http://host:port/employees , method=GET
	@GetMapping
	public /* @ResponseBody */   List<Employee> listEmps() 
	{
		System.out.println("in list emps");
		return empService.getAllEmps();
	}
	//URL : http://host:port/employees , method=POST
	//payload : JSON representation of emp(transient)
	@PostMapping
	public Employee addEmpDetails(@RequestBody Employee emp)
	//@RequestBody => method level annotation, in request handling methods
	//unmarshalling (de serilisation)[@RequestBody JSON -> Java Object]
	{
		System.out.println("in add emp "+emp);
		return empService.addEmpDetails(emp);
	}//handler(RestController)-->@ResponseBody(JAVA Object -->JSON) Employee
	//returns representation(JSON) of detached entity to the caller (REST)
	//consumer of the REST API
	
	/*
	 * URL: http://host:port/employees/empId
	 * method:GET
	 */
	@GetMapping("/{empId}")//template URI Variable: path variable
	//@PathVariable: method arg level annotations for data binding between 
	//incoming path var --> method arg
	public Employee getEmployeeDetails(@PathVariable() Long empId)
	{
		System.out.println("in get emp details "+getClass());
		//return emp details to the REST client
		return empService.getEmployeeDetails(empId);
	}
	
	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee emp)
	{
		System.out.println("in update emp "+emp); //id must be null
		return empService.updateEmpDetails(emp);
	}
	
	// URL : http://host:port/employee/empId , method=DELETE
		// path variable
		@DeleteMapping("/{empId}")
		public String deleteEmpDetails(@PathVariable Long empId)
		{
			System.out.println("in del emp details "+empId);
			return empService.deleteEmpDetails(empId);
		}

}
