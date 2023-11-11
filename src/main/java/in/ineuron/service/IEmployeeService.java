package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import in.ineuron.bo.Employee;
import in.ineuron.dto.EmployeeDTO;

public interface IEmployeeService {
	public EmployeeDTO saveMethod(EmployeeDTO emp);
	public Optional<Employee> findById(Long i);
	public List<Employee> findAll();
	public void delete(Employee emp);
    public List<Employee> getByName(String name);
    public List<Employee> getByNameandCity(String name,String city,double sal);
    public List<Employee> getDetailsByQuery(String name,String city);
}
