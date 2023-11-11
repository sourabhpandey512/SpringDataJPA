package in.ineuron.dao;

import java.util.List;
import java.util.Optional;
import in.ineuron.bo.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
   public List<Employee> findByName(String name); 	
   public List<Employee> findByNameAndCityOrSalaryGreaterThan(String name,String city,double sal);
   @Query("SELECT u FROM Employee u WHERE u.name =:n and u.city =:c")
   public List<Employee> getAllUser(@Param("n") String name, @Param("c") String sal);
   
   

}
