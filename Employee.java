import java.util.*;

public class Employee
{
	//Instance variables
	private String name;
	private double hrWage;
	

	//Constructor
	public Employee(String name, double hrWage)
	{
		this.name = name;
		this.hrWage = hrWage;			

	}

	public void setName(String name)
	{	this.name = name;	}

	

	public void setWage(double hrWage)
	{
		this.hrWage = hrWage;

	}

	public void raiseWage(double percentage)
	{
		this.hrWage = hrWage*(1+(percentage/100));	//20$/hr * (1 + 30%) increase

	}

	public double computePay(int hrsworked)
	{	return this.hrWage*hrsworked; }	
	
	public String getName()
	{ return this.name; }

	
	public double getWage()
	{ return this.hrWage; }


}












