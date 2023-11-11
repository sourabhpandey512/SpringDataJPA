package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import in.ineuron.bo.Employee;
import in.ineuron.dao.EmployeeRepository;
import in.ineuron.dto.EmployeeDTO;

@Service
public class IEmployeeServiceImpl implements IEmployeeService {
	@Autowired
    EmployeeRepository employeeRepository; 

	@Override
	public EmployeeDTO saveMethod(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		System.out.println(emp);
		Employee empbo=new Employee(); 
		BeanUtils.copyProperties(emp,empbo);
		System.out.println(empbo);
		empbo=employeeRepository.save(empbo);
		BeanUtils.copyProperties(empbo,emp);
		emp.setId(empbo.getId());
		return emp;
		
		
		
	}

	@Override
	public Optional<Employee> findById(Long i) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(i);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void delete(Employee emp) {
		// TODO Auto-generated method stub
		employeeRepository.delete(emp);
		
	}

	@Override
	public List<Employee> getByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepository.findByName(name);
		
	}

	@Override
	public List<Employee> getByNameandCity(String name, String city, double sal) {
		// TODO Auto-generated method stub
		return employeeRepository.findByNameAndCityOrSalaryGreaterThan(name, city, sal);
	}

	@Override
	public List<Employee> getDetailsByQuery(String name, String city) {
		// TODO Auto-generated method stub
	    System.out.println(employeeRepository.getAllUser(name,city));
		return employeeRepository.getAllUser(name,city);
	}
	
	

}
