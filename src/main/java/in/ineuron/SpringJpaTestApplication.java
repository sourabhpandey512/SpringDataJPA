package in.ineuron;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import in.ineuron.bo.Employee;
import in.ineuron.dto.EmployeeDTO;
import in.ineuron.service.*;

import org.hibernate.mapping.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpaTestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJpaTestApplication.class, args);

		Scanner sc=new Scanner(System.in);
		IEmployeeService service=context.getBean(IEmployeeService.class);
		
		while(true) {
			System.out.println("_________********________________");
			System.out.println("1. To add the data into database");
			System.out.println("2. To search the data by Id");
			System.out.println("3. To get the data of all the employees ");
			System.out.println("4. To delete the Employee Record");
			System.out.println("5. To update the record ");
			System.out.println("6. To get details by name");
			System.out.println("7. To get details by name,city and salary");
			System.out.println("8. To get the deatils by QueryMethod: ");
			
			
			int a=sc.nextInt();
			switch(a) {
			case 1:
				System.out.println("Enter your name");
				String name=sc.next();
				System.out.println();
				System.out.println("Enter your city");
				String city=sc.next();
				System.out.println();
				System.out.println("Enter your salary");
				double salary=sc.nextDouble();
				EmployeeDTO emp=new EmployeeDTO();
				emp.setName(name);
				emp.setCity(city);
				emp.setSalary(salary);
				System.out.println(emp);
				emp=service.saveMethod(emp);
				System.out.println("After saving the data into database");
				System.out.println(emp);
				break;
				
			case 2:
				System.out.println("Enter the your id ");
				long l=sc.nextLong();
				Optional<Employee> emp2=service.findById(l);
				if(emp2.isPresent()) {
					System.out.println(emp2);
				}
				else {
					System.out.println("no record is present for this id");
				}
				break;
			case 3:
				System.out.println();
				Iterable<Employee> emp3=new ArrayList<Employee>();
				emp3=service.findAll();
				for(Employee empex:emp3) {
					System.out.println(empex);
					break;
						
				}
				break;
			case 4:
				System.out.println("Enter the id of your record which you want to delete");
				long a1=sc.nextLong();
				Optional<Employee> emp4=service.findById(a1);
				if(emp4.isPresent()) {
				Employee emp5=emp4.get();
				service.delete(emp5);
					 
					System.out.println("Record deleted Successfully");
				}
				else {
					System.out.println("Record not found");
				}
				break;
				
			case 5:
				System.out.println("Enter the id of your record which you want to update ");
				long a2=sc.nextLong();
				Optional<Employee> emp6=service.findById(a2);
				if(emp6.isPresent()) {
					Employee emp5=emp6.get();
					System.out.println(emp5.getName());
					System.out.println(emp5.getCity());
					System.out.println(emp5.getSalary());
				    System.out.println("Enter your name to update ");
				    String name1=sc.next();
				    System.out.println("Enter your city to update ");
				    String city1=sc.next();
				    System.out.println("Enter your salary");
				    double salary1=sc.nextDouble();
				    EmployeeDTO empu=new EmployeeDTO();
				    empu.setName(name1);
				    empu.setCity(city1);
				    empu.setSalary(salary1);
				    empu=service.saveMethod(empu);
				    if(empu!=null) {
				    	System.out.println("Data updated successfully");
				    	System.out.println(empu);
				    }
				    else {
				    	System.out.println("Record not update successfully");
				    }
				    
				   }
				
				break;
			case 6:
				System.out.println("Enter the name ");
				String name6=sc.next();
				Iterable<Employee> emp7=new ArrayList<Employee>();
				
				emp7=service.getByName(name6);
				for(Employee emps:emp7) {
					System.out.println(emps);
				}
				break;
			case 7:
				System.out.println("Enter the name");
				String name7=sc.next();
				System.out.println("Enter the City ");
				String city7=sc.next();
				System.out.println("Enter the salary");
				double sal=sc.nextDouble();
				Iterable<Employee> emp8=new ArrayList<Employee>();
				emp8=service.getByNameandCity(name7, city7, sal);
				System.out.println(emp8);
				break;
				
			case 8:
				System.out.println("Enter the name");
				String name8=sc.next();
				System.out.println("Enter the city ");
				String city1=sc.next();
				Iterable<Employee> emp9=new ArrayList<Employee>();
				emp9=service.getDetailsByQuery(name8,city1);
				System.out.println(emp9);
				
				
				
		}
	}

}}
