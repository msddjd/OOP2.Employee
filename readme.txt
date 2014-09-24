Mike Dumas
Nov 22, 2012
Project #3: The Personnel Database

Problem Description:

	Write a program that maintains wage information for the employees of a company. The user must enter a character from the keyboard that corresponds to one out of seven options necessary to navigate through the program. The options will be displayed on the screen in a menu format and are the following;n to add a new employee, c to Compute paychecks, r to Raise Wages, p to Print Records to the screen, d to Download data into a dat file, u to Upload data from a dat file, and q to terminate the program. If an entry other than those listed is entered, the user will be given an opportunity to try again.


Specification:

	When the user choses to add a new employee, the name, type, and pay rate of the employee shall be provided. An employee can either be payed hourly or based on a Salary. If user incorrectly supplies the type of employee, an error message is outputted to the screen and the user is given another attempt. 

	When Compute paychecks is selected the program will calculate what each employee's paycheck would be, given the number of hours they work per week. For an employee that is paid on an hourly basis, if they work less than or equal to 40 hours a week the paycheck amount is the number of hours worked multiplied by their pay rate. If they work for more than 40 hours a week, for every hour over 40 they get paid 1.5% more than there hourly rate. For a salaried employee, regardless of the number of hours worked, there paycheck is always 1/52 of their annual salary.

	When Raise wages is selected, program prompts user to enter a percentage. The hourly rate of each employee is raised by that given amount. This is done by converting the percentage into a decimal and multiplying the employee's current rate by 1 + that decimal number.

	When Print Records is selected the program will output to the screen every employee in the database, followed by their respective pay rate. This is done by navigating through the array list to access each employee object, and calling each object's toString method which should be formatted appropriately.

	When Download data is selected, the program will store all employees and their pay rates in a file entitled "Employee.dat".

	When Upload data is selected, the program will load the employees and there respective pay rates from the “Employee.dat” file and add them to the database.

Algorithm:

	Each employee is either a SalariedEmployee object or a HourlyEmployee object. The two inherit similar characteristics from a Employee class. The employee's name is a String and there pay rate is of type double. The Employee class consist of constructors for the name and hourly wage as well as getter and setter methods for them. It also consists of a computePay method which will calculate the paycheck as described in the specification. The HourlyEmployee class consist of a constructor that calls the parent method, a computePay method that does what is described in the specification, a getter method for the employee's name and a tostring method that prints out the employee's name followed by their payrate in a tabulated form. The SalariedEmployee class consists of a constructur that converts that converts the annual salary passed in as a paramater to a hourly salary and then calls the parent method with the employee's name and the calculated hourly salary as a paramater. It consists of getter and setter methods for the annual salary and the employee's name. It also consists of a to string method to print the employee's name followed by their payrate in tabulated form.

An object arraylist is used to store each Employee object. If an employee is a HourlyEmployee than an HourlyEmployee object with the employee's name and there hourly pay rate gets added to the Arraylist. If an employee is a SalariedEmployee than a SalariedEmployee object consisting of the employee's name and there annual salary gets added to the Arraylist.

