import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class HSMSdemo
{
    public static void main(String[] args)
    {
        int user_input_menu;
        int empl_id;
        String empl_name;
        int empl_dept_num;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Homless Shelter Mangaement System");
        System.out.println("Welcome to HSMS program.");
        System.out.println("To proceed, please type 1) Employee ID, 2)Name, 3)Department ID number");
        System.out.println();
        System.out.print("Employee ID >>  ");
        empl_id = scan.nextInt();
        System.out.println();
        System.out.print("Employee Name >>  ");
        empl_name = scan.next() + scan.nextLine();
        System.out.println();
        System.out.print("Department ID number >>  ");
        empl_dept_num = scan.nextInt();
        
        //Use static method to check if the id and name are in the database;
        
        //Once the validity is confirmed,
        
        System.out.println("---------------------------------");
        System.out.println("----------Menu-------------------");
        System.out.println("1. Employee Directory DB");
        System.out.println("2. Finance Information DB");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Please select a number >>  ");
        user_input_menu = scan.nextInt();
        
        switch (user_input_menu)
        { 
            case (0):
                System.out.println("Good bye!");
                System.exit(0);
                
            case (1):
                Volunteer volunteer = new Volunteer("mary ann", "Stewart", new GregorianCalendar(1989,8,13), Location.ST_ANDREWS, 23);
		
		System.out.println("Number of Volunteers: " + Volunteer.getNumVolunteers());
		Volunteer.printAllVolunteers();
		System.out.println("Number of Employees: " + Employee.getNumEmployees() );
		Employee.printAllEmployees();
		System.out.println("Number of Persons: " + Person.getNumPersons());
		Person.printAllPersons();
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		Employee employee   = new Employee("jOhn jAKob", "jingleheim33erschmitt", new GregorianCalendar(1990, 0, 21), 22.25, 30, Location.BREAD_AND_WATER_DEPOT);

		System.out.println("Number of Volunteers: " + Volunteer.getNumVolunteers());
		Volunteer.printAllVolunteers();
		System.out.println("Number of Employees: " + Employee.getNumEmployees() );
		Employee.printAllEmployees();
		System.out.println("Number of Persons: " + Person.getNumPersons());
		Person.printAllPersons();
                           
            case (2):
                finance(empl_id, empl_name, empl_dept_num);
                break;
        }
        
    }
    
    public static void finance(int id, String name, int dept)
    {
        int user_menu;
        
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("HSMS - Finance Information Database");
        System.out.println("Select a number for the operation");
        System.out.println("1. Donation records"); // finance income
        System.out.println("2. Expenditure database"); //finance outcome
        System.out.println("0. Exit");
        System.out.println();
        System.out.print(">>    ");
        user_menu = keyboard.nextInt();
        
        switch(user_menu)
        {
            case(0):
                System.out.println("Good bye!");
                System.exit(0);
            case(1):
                System.out.println("Accessing Donation records....");
                FinanceIncome userIncome = new FinanceIncome(id, name, dept);
                userIncome.incomeMenu();
            case(2):
                System.out.println("Accessing Expenditure records...");
                FinanceOutcome userOutcome = new FinanceOutcome(id, name, dept);
                userOutcome.outcomeMenu();
        }        
        
        
                
    }
}