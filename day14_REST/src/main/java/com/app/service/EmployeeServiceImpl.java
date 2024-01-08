package com.app.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.EmployeeDao;
import com.app.entities.Employee;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	// dependency : dao layer i/f
	@Autowired // =byType with field level D.I
	private EmployeeDao empDao;

	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}

	@Override
	public Employee addEmpDetails(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.save(emp);
	}//tx.commit
/*
 * Spring supplied transaction manager will begin the transation -when controller invokes
 * @Transational method. it will end the tx-- when service layer method
 * returns.In case of no runtime error (un checked exceptions) exc--> tx.commit
 * session.flush()--DMLs: insert --> session.close() --> L1 cache 
 * is destroyed and db connection returns to the pool (currently DBCP vendor :Hikari
 * In case of run time error--> tx.rollback() -->session.close() 
 */

	@Override
	public Employee getEmployeeDetails(Long empId) {
		return empDao.findById(empId).orElseThrow(()->new ResourceNotFoundException("Invalid id, Data not found"));
	}

	@Override
	public Employee updateEmpDetails(Employee emp) {
		if(empDao.existsById(emp.getId()))
		{
			//emp is detached
			return empDao.save(emp);
		}
		throw new ResourceNotFoundException("Invalid emp id , Details can't be updated!!!!");
	}
	
	@Override
	public String deleteEmpDetails(Long empId) {
		if(empDao.existsById(empId))
		{
			empDao.deleteById(empId);
			return "Emp details deleted.....";
		}
		return "Emp details can't be deleted";
	}
	

}
