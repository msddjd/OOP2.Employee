import java.text.*;
import java.io.*;
import java.util.*;
public class Personnel
{

	public static Scanner stdin = new Scanner(System.in);
	public static ArrayList<Object> database = new ArrayList<Object>(1);

	public static void main (String[]args) throws IOException
	{
		menu();


	}


	public static void menu() throws IOException
	{

		clearScreen();

		for(int i = 0; i < 40; i++)
		System.out.print("-");


		System.out.println();

		System.out.print("|Commands:  n - New employee\t\t|\n");

		System.out.print("|           c - Compute paychecks\t|\n");
		System.out.print("|           r - Raise Wages\t\t|\n");
		System.out.print("|           p - Print records\t\t|\n");
		System.out.print("|           d - Download data\t\t|\n");
		System.out.print("|           u - Upload data\t\t|\n");
		System.out.print("|           q - Quit\t\t\t|\n");

		for(int i = 0; i < 40; i++)
		System.out.print("-");


		System.out.println();

	System.out.print("Enter Command:");
	char command = stdin.nextLine().toLowerCase().charAt(0);

		switch (command)
		{

			case 'n': new_emp();
				  menu();
				  break;
			case 'c': compute_pay();
				  menu();
				  break;

			case 'r': raise_wages();
				  menu();
				  break;

			case 'p': print_records();
				  menu();
				  break;
			case 'd': download();
				  menu();
				  break;

			case 'u': upload();
				  menu();
				  break;


			case 'q': break;

			default : System.out.println("Command was not recognized; press enter to try again...");
				  stdin.nextLine();
				  menu();
		}

	}


	private static void clearScreen()
    	{
        	System.out.println("\u001b[H\u001b[2J");
    	}


	public static void new_emp()
	{
	
		System.out.print("Enter the name of new employee: ");
		String emp_name = stdin.nextLine();

		System.out.print("\nHourly (h) or salaried (s): ");	
		char emp_type = stdin.nextLine().toLowerCase().charAt(0);

			switch (emp_type)
			{
				case 'h':	 
						System.out.print("\nEnter hourly wage: ");
						double hrwage = stdin.nextDouble();
						database.add(new HourlyEmployee(emp_name,hrwage));
						break;

				case's':	
						System.out.print("\nEnter Annual Salary: ");
						double salary = stdin.nextDouble();
						database.add(new SalariedEmployee(emp_name,salary));
						break;

				//If anything else show error message
				default:	System.out.println("Input was not h or s; please try again:");
						new_emp();
						break;
			}
		
		
		System.out.println("Press Enter to continue...");
		stdin.nextLine();
		stdin.nextLine();

	}


	public static void compute_pay() //Computes pay for any employee
	{
		DecimalFormat fix = new DecimalFormat("0.00"); //To format currency properly
		database.trimToSize();				//Always trim arraylist for efficiency

		for(int i = 0; i < database.size(); i++)
		{
			System.out.print("\nEnter number of hours worked by "+((Employee) database.get(i)).getName()+":");
			int hrs = stdin.nextInt();
			System.out.println("Pay: $"+fix.format( ((Employee) database.get(i)).computePay(hrs)) );
		}
		
		System.out.println();

		System.out.println("Press Enter to continue...");
		stdin.nextLine();
		stdin.nextLine();

	}
	
	public static void raise_wages() //Raises all wages by a certain percentage
	{

		database.trimToSize();

		System.out.print("Enter percentage increase: ");
		double percentincrease = stdin.nextDouble();
		
		for(int i = 0; i < database.size(); i++)
		((Employee) database.get(i)).raiseWage(percentincrease);

		System.out.println("\nNew Wages\n_________");
		print_records();
		

		stdin.nextLine();

	}

	public static void print_records()
	{
		if(database.isEmpty())
		System.out.println("There are currently no records");
		else
		{
			for(int i = 0; i < database.size(); i++)
			System.out.print(((Employee) database.get(i)).toString());
		}
	
		System.out.println("Press Enter to continue...");
		stdin.nextLine();
		
	}

	public static void download() throws IOException //Saves all current records in file Employee.dat
	{

		database.trimToSize();

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Employee.dat")));
		for(int i = 0; i < database.size(); i++)
		out.print(((Employee) database.get(i)).toString());

		out.close();	

		System.out.println("Total Employees Processed:"+database.size()+"\n\nPress Enter to continue...");
		stdin.nextLine();

			
	}

	public static void upload() throws IOException //Loads all current records from file Employee.dat into arraylist
	{

		database.trimToSize();

		int count = 0;

		Scanner in = new Scanner(new File("Employee.dat"));
		while (in.hasNext())
		{
			//Sample Strings
			//"Mike Dumas				$44.00/hour"
			//"Susan Stroupe			$44000.00/year"
			String line = in.nextLine();
			String emp_name = line.substring(0,(line.indexOf("$"))).trim();
			Double payrate = Double.parseDouble( line.substring((line.indexOf("$")+1),line.indexOf("/")) );
		

			if(line.endsWith("hour"))		//if true its a hourly employee
			{database.add(new HourlyEmployee(emp_name,payrate));
				count++;}
			if(line.endsWith("year"))		//if true its a salaried employee
			{database.add(new SalariedEmployee(emp_name,payrate));
				count++;}

		}

		System.out.println("Successfully Uploaded "+count+" Employees\nPress Enter to Continue...");
		stdin.nextLine();

	}  
	
	
}
