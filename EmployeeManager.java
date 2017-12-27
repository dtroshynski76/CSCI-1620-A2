//Name: Donovan Troshynski
//Class: 1620-002
//Program #: 2
//Due Date: 1 October 2015
//Honor Pledge: On my honor as a student of the University of Nebraska at Omaha,I have neither given nor received unauthorized help on this homework assignment.
//NAME: Donovan Troshynski
//Partners: NONE
//This assignment will implement everything from the first assignment along with an employee manager system which the user can operate to add, delete, or alter different types of employees. It will show use of basic inheritance, polymorphism, and abstraction.

import employeeType.employee.Employee;
import employeeType.subTypes.HourlyEmployee;
import employeeType.subTypes.SalaryEmployee;
import employeeType.subTypes.CommissionEmployee;
import java.util.Scanner;
public class EmployeeManager
{
    private final int employeeMax = 10;
    private Employee[] employees = new Employee[employeeMax];
    private int currentEmployees;

    //Method Name: EmployeeManager
    //Parameters: none, it's the constructor
    //Return value(s): none
    //Partners: None
    //The constructor for the class, it creates the Employee array and sets currentEmployees to 0.
    public void EmployeeManager ()
    {
        currentEmployees = 0;
    }

    //Method Name: addEmployee
    //Parameters: int type; String fn, ln; char m, g; int en; boolean ft; double amount
    //Return value(s): none
    //Partners: None
    //Receives input on what type of employee to add (hourly, salary, or commission) and then prompts for the required data included in that employee type. Doesn't add an employee if one of these three conditions are met: one of the required data fields is not passed, an employee with the given employee number already exists, or if the array is at maximum capacity.
    public void addEmployee(int type, String fn, String ln, char m, char g, int en, boolean ft, double amount)
    {

        //Doesn't add an employee if the max number of employees has been reached
        if (currentEmployees == 10)
        {
            System.out.println();
            System.out.println("Cannot add more Employees.");
            return;
        }

        //Doesn't add an employee if any of the required data fields is not passed
        boolean inputError = false;

        if ( type <= 0 || type > 3 ) inputError = true;
        if ( fn.length() == 0 ) inputError = true;
        if ( ln.length() == 0 ) inputError = true;
        if ( Character.toString(m).length() == 0 ) inputError = true;
        if ( Character.toString(g).length() == 0 ) inputError = true;
        if ( en <= 0 ) inputError = true;
        if ( amount <= 0 ) inputError = true;

        if ( inputError == true )
        {
            System.out.println("Invalid Employee Type, None Added.");
            return;
        }

        //Doesn't add an employee if the given employee number is equal to an existing employee number
        Employee equalEmpnum;
        int findEmpnum;
        for ( int y = 0; y < currentEmployees; y++)
        {
            equalEmpnum = employees[y];
            findEmpnum = equalEmpnum.getEmployeeNumber();

            if (findEmpnum == en)
            {
                System.out.println();
                System.out.println("Duplicate Not Added.");
                return;
            }   
        }

        //creates hourly employee
        if (type == 1)
        {
            HourlyEmployee hourlyEmployee = new HourlyEmployee(fn, ln, m, g, en, ft, amount);
            employees[currentEmployees++] = hourlyEmployee;
        }

        //creates salary employee
        if (type == 2)
        {
            SalaryEmployee salaryEmployee = new SalaryEmployee(fn, ln, m, g, en, ft, amount);
            employees[currentEmployees++] = salaryEmployee;
        }

        //creates commission employee
        if (type == 3)
        {
            CommissionEmployee commissionEmployee = new CommissionEmployee(fn, ln, m, g, en, ft, amount);
            employees[currentEmployees++] = commissionEmployee;
        }
    }

    //Method Name: removeEmployee
    //Parameters: int index
    //Return value(s): none
    //Partners: None
    //Removes the employee at the given index value.
    public void removeEmployee(int index)
    {
        if (index == -1)
        {
            System.out.println();
            System.out.println("Can't remove nonexistent employee.");
            return;
        }
        employees[index] = null;
        for( int i = index+1; i < currentEmployees; i++ ) {
            employees[i - 1] = employees[i];
            employees[i] = null;
        }
        currentEmployees--;
    }

    //Method Name: listAll
    //Parameters: none
    //Return value(s): none
    //Partners: None
    //Iterates through the array of employees and prints all the information about those employees, outputting "No Employees" if there are no employees to print.
    public void listAll()
    {
        if (currentEmployees == 0)
        {
            System.out.println();
            System.out.println("No Employees.");
            System.out.println();
            return;
        }

        //iterates through the array and prints all the employees' relevant information
        for ( int i = 0; i < currentEmployees; i++)
        {
            System.out.println( employees[i] );
        }
    }

    //Method Name: listHourly
    //Parameters: none
    //Return value(s): none
    //Partners: None
    //Goes through the array and lists all instances of HourlyEmployees, outputting "There are none." if there are no HourlyEmployees in the array
    public void listHourly()
    {
        boolean hourlyEmployee = false;
        for (Employee a : employees)
        {
            if (a instanceof HourlyEmployee)
            {
                hourlyEmployee = true;
                System.out.println();
                System.out.println(a);
                System.out.println();
            }
        }
        if (hourlyEmployee == false)
        {
            System.out.println();
            System.out.println("There are none."); 
            System.out.println();
            return;
        }
        return;
    }

    //Method Name: listSalary
    //Parameters: none
    //Return value(s): none
    //Partners: None
    //Iterates through the array and lists all instances of SalaryEmployees, outputting "There are none." if there are no SalaryEmployees in the array
    public void listSalary()
    {
        boolean salaryEmployee = false;
        for (Employee b : employees)
        {
            if (b instanceof SalaryEmployee)
            {
                salaryEmployee = true;
                System.out.println();
                System.out.println(b);
                System.out.println();
            }
        }
        if (salaryEmployee == false)
        {
            System.out.println();
            System.out.println("There are none.");
            System.out.println();
            return;
        }
        return;
    }

    //Method Name: listCommission
    //Parameters: none
    //Return value(s): none
    //Partners: None
    //Iterates through the array and lists all instances of CommissionEmployees, outputting "There are none." if there are no CommissionEmployees in the array
    public void listCommission()
    {
        boolean commissionEmployee = false;
        for (Employee c : employees)
        {
            if (c instanceof CommissionEmployee)
            {
                commissionEmployee = true;
                System.out.println();
                System.out.println(c);
                System.out.println();
            }
        }
        if (commissionEmployee == false)
        {
            System.out.println();
            System.out.println("There are none");
            System.out.println();
            return;
        }
        return;
    }

    //Method Name: resetWeek
    //Parameters: none
    //Return value(s): none
    //Partners: None
    //Resets the week for each employee in the array
    public void resetWeek()
    {
        for (int k = 0; k < currentEmployees; k++)
        {
            employees[k].resetWeek();
        }
    }

    //Method Name: calculatePayout
    //Parameters: none
    //Return value(s): double
    //Partners: None
    //Calculates the weekly pay for each employee in the array
    public double calculatePayout()
    {
        double totalPay = 0;
        for (int x = 0; x < currentEmployees; x++)
        {
            totalPay = totalPay + employees[x].calculateWeeklyPay();
        }
        return totalPay;
    }

    //Method Name: getIndex
    //Parameters: int empNum
    //Return value(s): int
    //Partners: None
    //Returns the index value of the employee whose employee number equals the given employee number, returning -1 if the employee doesn't exist
    public int getIndex(int empNum)
    {
        Employee lookEmployee;
        int lookEmpnum;
        
        for ( int x = 0; x < currentEmployees; x++ )
        {
            lookEmployee = employees[x];

            lookEmpnum = lookEmployee.getEmployeeNumber();
            if ( lookEmpnum == empNum )
                return x;
        }
        return -1;
    }

    //Method Name: annualRaises
    //Parameters: none
    //Return value(s): none
    //Partners: None
    //Gives each employee their annual raises
    public void annualRaises()
    {
        for (int t = 0; t < currentEmployees; t++)
        {
            employees[t].annualRaise();
        }
    }

    //Method Name: holidayBonuses
    //Parameters: none
    //Return value(s): double
    //Partners: None
    //Applies holiday bonuses to each employee
    public double holidayBonuses()
    {
        double holidayTotal = 0;
        for (int x = 0; x < currentEmployees; x++)
        {
            System.out.printf("%n%sHoliday Bonus: %.2f%n%n", employees[x].toString(), employees[x].holidayBonus());
            holidayTotal = holidayTotal + employees[x].holidayBonus();
        }
        return holidayTotal;
    }

    //Method Name: increaseHours
    //Parameters: int index; double amount
    //Return value(s): none
    //Partners: None
    //Increases the hours worked for the employee at the given index value
    public void increaseHours(int index, double amount)
    {
        Employee d = employees[index];
        boolean hourly = false;
        if (d instanceof HourlyEmployee)
        {
            hourly = true;
        }
        if (hourly == false)
        {
            System.out.println();
            System.out.println("Can't add hours to non-HourlyEmployee.");
            System.out.println();
            return;
        }
        HourlyEmployee em = (HourlyEmployee) employees[index];
        em.increaseHours( amount );
    }

    //Method Name: increaseSales
    //Parameters: int index; double amount
    //Return value(s): none
    //Partners: None
    //
    public void increaseSales(int index, double amount)
    {
        CommissionEmployee em = (CommissionEmployee) employees[index];
        em.increaseSales(amount);
    }
}
