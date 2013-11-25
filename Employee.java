import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 * 
 * @author Michaela
 * Represents and creates an employee for the homeless shelters
 */

public class Employee extends Person {
	
	private static int numberOfEmployees = 0;
	private static ArrayList<Employee> employees = new ArrayList<>();

	private double   hourlyPay    = 0;
	private double   hoursWorked  = 0;
	private Location workLocation = Location.UNASSIGNED; 
	
	/**
	 * Default constructor
	 * Sets firstName to Demo
	 *                           lastName  to Demo
	 *                           birthDate to today's date
	 */
	public Employee(){
		super();
		numberOfEmployees++;
		employees.add(this);
		
	}
	/**
	 * Constructor: Sets
	 * @param first
	 * @param last to the first and last name respectively.
	 * sets hourlyPay, hoursWorked, and workLocation to zero
	 */
	public Employee(String first, String last){
		super(first,last);
		numberOfEmployees++;
		employees.add(this);
	}
	
	/**
	 * Constructor: 
	 * Sets
	 * @param first
	 * @param last
	 * @param DOB
	 * and sets horlyPay, hoursWorked, and workLcation to zero
	 */
	public Employee(String first, String last, GregorianCalendar DOB){
		super(first,last, DOB);
		numberOfEmployees++;
		employees.add(this);
	}
	/**
	 * Constructor: 
	 * Sets
	 * @param first
	 * @param last
	 * @param DOB
	 * @param hourlyPay
	 * @param hoursWorked
	 * @param workLocation
	 * to values contained in the parameters
	 */
	public Employee(String first, String last, GregorianCalendar DOB, double hourlyPay, double hoursWorked, Location workLocation) throws NullPointerException, IllegalArgumentException{
		super(first, last, DOB);
		if( workLocation == null ){
			String msg = "";
			if( workLocation == null ){
				msg += "workLocation == null\n";
			}
			
			throw new NullPointerException(msg);
		}
		if(  hourlyPay < 0.0 || hoursWorked < 0.0  ){
			String msg = "";
			if( hourlyPay < 0.0 ){
				msg += "hourlyPay < 0.0\n";
			}
			if( hoursWorked < 0.0 ){
				msg += "hoursWorked < 0.0\n";
			}
			
			throw new IllegalArgumentException(msg);
		}
		this.hourlyPay    = hourlyPay;
		this.hoursWorked  = hoursWorked;
		this.workLocation = workLocation;
		numberOfEmployees++;
		employees.add(this);
	}
	
	/**
	 * 
	 * @return the number of Employees that have been created
	 */
	public static int getNumEmployees(){
		return numberOfEmployees;
	}
	
	/**
	 * 
	 * @return an ArrayList of all the employees that have been created.
	 */
	public static ArrayList<Employee> getEmployees(){
		return Employee.employees;
	}

	/**
	 * 
	 * Prints a single employee
	 * 
	 * @param employee represents the employee that will be printed
	 */
	public static void printEmployee( Employee employee ){
		if( employee == null ){
			return;
		}
		System.out.println();
		System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
		System.out.print("DOB:  ");
		ValidateInput.printDate(employee.getBirthDate());
		System.out.println("WorkLocation: " + employee.getWorkLocation());
		System.out.println("Hours Worked: " + employee.hoursWorked);
		System.out.println("Hourly Pay: " + employee.hourlyPay);
		
		System.out.println();
	}
	
	/**
	 * Prints every Employee that has been created
	 */
	public static void printAllEmployees(){
		for( Employee employee : getEmployees() ){
			printEmployee(employee);
		}
	}
	
	
	//--------------------Getters and Setters----------------------------------
	
	/**
	 * Getter:
	 * Returns hourlyPay
	 */
	public double getHourlyPay() {
		return hourlyPay;
	}
	
	/**
	 * Setter:
	 * @param hourlyPay
	 * method does not accept a negative number. Gives an error message if it is less or equal to zero.
	 */
	public void setHourlyPay(double hourlyPay) {
		
		if(hourlyPay<=0){
			
			System.out.println("Error, hourly pay cannot be less or equal to zero");
			return;
			
		}else{
			
			this.hourlyPay = hourlyPay;
		}
	}
	
	/**
	 * Getter:
	 * @return hoursWorked
	 * 
	 */
	public double getHoursWorked() {
		return hoursWorked;
	}
	
	/**
	 * Setter:
	 * @param hoursWorked
	 * method does not accept a negative number. Gives an error message if it is less or equal to zero.
	 */
	public void setHoursWorked(double hoursWorked) {
		if(hoursWorked<=0){
			System.out.println("Error, hours worked cannot be less or equal to zero");
			return;
		}else{
			
		this.hoursWorked = hoursWorked;
		
		}
	}
	
	/**
	 * Getter:
	 * @return workLoaction
	 */
	public Location getWorkLocation() {
		return workLocation;
	}
	
	/**
	 * Setter:
	 * @param workLocation
	 * workLocation has to match one of the preset work locations
	 */
	public void setWorkLocation(Location workLocation) throws NullPointerException{
		if( workLocation == null ){
			String msg = "workLocation == null";
			throw new NullPointerException(msg);
		}
		this.workLocation = workLocation;
	}
	
	
}
