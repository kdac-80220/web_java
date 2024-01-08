package com.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Employee;

@DataJpaTest // => Spring boot test frmwork will scan entities n dao
@AutoConfigureTestDatabase(replace = Replace.NONE) // => use regulate DB
@Rollback(false)
class EmployeeDaoTest {
	// dep : dao layer i/f
	@Autowired
	private EmployeeDao dao;

	@Test
	void testEmpSaveAll() {
		// create list of emps n save them in db
		/*
		 * firstName, String lastName, String email, String password, LocalDate
		 * joinDate, double salary, String location, String department
		 */
		List<Employee> list = List.of(new Employee("a1", "b1", "a1@gmail.com",
				"1234", LocalDate.parse("2024-10-12"), 12345, "Pune", "Rnd"),
				new Employee("a2", "b2", "a2@gmail.com",
						"2234", LocalDate.parse("2024-10-12"), 22345, "Pune", "Rnd"),
				new Employee("a3", "b3", "a3@gmail.com",
						"1734", LocalDate.parse("2024-10-12"), 52345, "Pune", "Rnd")
				,new Employee("a4", "b4", "a4@gmail.com",
						"7234", LocalDate.parse("2024-10-12"), 42345, "Pune", "Rnd"));
		List<Employee> list2 = dao.saveAll(list);
		assertEquals(4, list2.size());
	}

}
