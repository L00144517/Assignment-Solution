package ie.lyit.testers;

import static org.junit.jupiter.api.Assertions.*;
import ie.lyit.bank.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTester
{

	private Employee employee1;
	private Employee employee2;
	@BeforeEach
	void setUp() throws Exception 
	{
		employee1 = new Employee(new Name("Mr","Peter","Newman"),
				new Date(24,12,1997),new Date(12,12,2012),2400);
	}

	@Test
	void testToString() //tests the ToString method returns correct results
	{
		String testToString = ("Number: "+employee1.getNumber()+"\nName: " + employee1.getName() +"\nDate of Birth: " + employee1.getDateOfBirth().toString() +
				"\nStart date: "+employee1.getStartDate().toString() + "\nSalary: " + employee1.getSalary());
		assertTrue(employee1.toString().contentEquals(testToString));
	}

	@Test
	void testSetStartDate() //tests date is initialised correctly
	{
		assertTrue(employee1.getStartDate().toString().contentEquals("12/12/2012"));
	}

	@Test
	void testSetSalary() 
	{
		employee1.setSalary(20000);
		assertTrue(employee1.getSalary()==20000);
	}

	@Test
	void testSetNumber() 
	{
		employee1.setNumber(100);
		assertTrue(employee1.getNumber()==100);
	}

	@Test
	void testSetNextNumber() //tests the setNext number method increments number
	{
		Employee.setNextNumber(1);
		assertTrue(Employee.getNextNumber() == 1);
	}

	@Test
	void testEmployeeNameDateDateDouble() //tests the constructor creates objects with correct variables
	{
		employee2 = new Employee(new Name("Mr","Joe","Bloggs"),
				new Date(12,11,1990),new Date(11,11,2011),3000);
		assertTrue(employee2.getName().toString().contentEquals("Mr Joe Bloggs"));
		assertTrue(employee2.getDateOfBirth().toString().contentEquals("12/11/1990"));
		assertTrue(employee2.getStartDate().toString().contentEquals("11/11/2011"));
		assertTrue(employee2.getSalary()==3000);
	}

	@Test
	void testIncrementSalary() throws Exception //test the increment salary method works
	{
		employee1.incrementSalary(1600);
		assertTrue(employee1.getSalary()==4000);
	}
	
	@Test
	void testIncrementSalaryException() throws Exception //tests that correct Exception is thrown and gives correct error message
	{
		try
		{
			employee1.incrementSalary(150000);
		}
		catch(Exception e)
		{
		assertTrue(e.getMessage()=="Salary cannot exceed 150000");
		}	
	}

	@Test
	void testCalculateWage() //tests the calculate wage method against calculated output
	{
		assertTrue(employee1.calculateWage(0.2)==160);
	}

}
