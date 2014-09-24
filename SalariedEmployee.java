import java.text.*;
public class SalariedEmployee extends Employee
{

	public SalariedEmployee(String name, double AnnualSal)
		{super( name,( AnnualSal/(52*40) ) );		}	

	public double getAnnualSal()
		{return super.getWage()*40*52;			}

	public void setAnnualSal(double AnnualSal)
		{super.setWage( AnnualSal/(52*40) );		}


	public double computePay(int hrs) //return 1/52 of annual salary regardless of hrs worked
		{return getAnnualSal()/52;			}
	
	public String getName()
	{ return super.getName(); }
	
	public String toString()
		{	DecimalFormat fix = new DecimalFormat("0.00");
			return super.getName()+"\t\t\t$"+fix.format(getAnnualSal())+"/year\n";}
			


}
