import java.util.*;
import java.text.*;

public class HourlyEmployee extends Employee
{


	public HourlyEmployee(String name, double hrWage)
	{	
		super(name,hrWage);

	}

	public double computePay(int hrsworked)
	{

		if(hrsworked>40)
		return 40*(super.getWage()) + (hrsworked-40)*(1.5*super.getWage());
		else
		return hrsworked*(super.getWage());

	}	

	public String getName()
	{ return super.getName(); }

	public String toString()
	{
		DecimalFormat fix = new DecimalFormat("0.00");
		return super.getName()+"\t\t\t$"+fix.format(super.getWage())+"/hour\n";

	}

	

}
