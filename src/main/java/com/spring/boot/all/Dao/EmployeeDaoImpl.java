package com.spring.boot.all.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.spring.boot.all.bean.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	
	@Autowired
	public RestTemplate restTemplate;

	@Override
	public Employee addEmployee(Employee employee) {


		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, header);
		ResponseEntity<Employee> response = restTemplate.exchange("http://localhost:8081/save/insert", HttpMethod.POST, entity,
				Employee.class);
		return response.getBody();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		// return sessionFactory.getCurrentSession().createQuery("from
		// Employee").list();

		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Employee> entity = new HttpEntity<Employee>(header);
		ResponseEntity<Employee> response = restTemplate.exchange("http://localhost:8081/getall", HttpMethod.GET,
				entity, Employee.class);

		return (List<Employee>) response.getBody();
	}

	@Override
	public Employee deleteEmployee(Integer employeeId) {

		/*
		 * Employee employee = (Employee)
		 * sessionFactory.getCurrentSession().load(Employee.class, employeeId); if (null
		 * != employee) { this.sessionFactory.getCurrentSession().delete(employee); }
		 */

		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Integer> entity = new HttpEntity<Integer>(employeeId, header);
		ResponseEntity<Employee> reponse = restTemplate.exchange("http://localhost:8081/delete", HttpMethod.GET,
				entity, Employee.class, employeeId);
		return reponse.getBody();

	}

	@Override
	public Employee updateEmployee(Employee employee) {
		/*
		 * sessionFactory.getCurrentSession().update(employee); return employee;
		 */

		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, header);
		ResponseEntity<Employee> reponse = restTemplate.exchange("http://localhost:8081/update", HttpMethod.POST,
				entity, Employee.class, employee);
		return reponse.getBody();

	}

	@Override
	public Employee getEmployee(int employeeid) {

		// return (Employee) sessionFactory.getCurrentSession().get(Employee.class,
		// employeeid);

		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Integer> entity = new HttpEntity<Integer>(employeeid, header);
		ResponseEntity<Employee> reponse = restTemplate.exchange("http://localhost:8081/getall/{eid}", HttpMethod.GET,
				entity, Employee.class, employeeid);
		return reponse.getBody();

	}

}
