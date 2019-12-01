package ie.lyit.bank;
import java.lang.Exception;;
public class Employee extends Person
{
	private Date startDate;
	private double salary;
	private int number;
	private static int nextNumber;
	
	public Employee()
	{
		super();
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public static int getNextNumber() {
		return nextNumber;
	}

	public static void setNextNumber(int nextNumber) {
		Employee.nextNumber=nextNumber;//has to be referenced in static context
	}

	public Employee(Name n,Date dob,Date startDate,double salary)
	{
		super(n,dob);
		this.startDate=startDate;
		this.salary=salary;
		setNextNumber(nextNumber+1);//increments employee number
		this.number=nextNumber;
	}
	
	public String toString()
	{
		return("Number: "+this.number+"\nName: " + this.name +"\nDate of Birth: " + this.dateOfBirth.toString() +
				"\nStart date: "+this.startDate.toString() + "\nSalary: " + this.salary);
	}
	
	public boolean equals(Employee e)
	{
		boolean isEqual= false;
		if(this.name.equals(e.getName()))
		{
			if(this.dateOfBirth.equals(e.dateOfBirth))
				if(this.startDate.equals(e.startDate))
					if(this.salary==e.salary)
						isEqual = true; //true only if all variables are the same
		}
		return isEqual;		
	}
	
	public void incrementSalary(double incrementAmount) throws Exception
	{
		if(this.salary+incrementAmount<=150000)
			salary = salary + incrementAmount;
		else
		{
			throw new Exception("Salary cannot exceed 150000");
		}
	}
	
	public double calculateWage(double taxPercentage)
	{
		double wage = this.salary/12;
		wage = wage - (wage*taxPercentage);
		return wage;
	}
}
