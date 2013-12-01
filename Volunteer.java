import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 * @author Michaela
 * 
 * class represents a volunteer object that has a first and last name, DOB, workLocation, and hoursVolunteered
 *
 */
public class Volunteer extends Person {

	private static int                  numberOfVolunteers = 0;
	private static ArrayList<Volunteer> volunteers         = new ArrayList<Volunteer>();
	
	private Location workLocation     = Location.UNASSIGNED;
	private double   hoursVolunteered = 0;
	
	/**
	 * Default constructor
	 * Sets                  firstName to Demo
	 *                        lastName to Demo
	 *                       birthDate to today's date
	 *                    workLocation to No location has been assigned yet
	 *                hoursVolunteered to 0
	 */
	public Volunteer(){
		super();
		numberOfVolunteers++;
		volunteers.add(this);
	}
	
	/**
	 * Constructor:
	 * Sets
	 * @param first
	 * @param last to first and last name respectively
	 * and workLocation and hoursVolunteered to what's currently stored in the variables
	 */
	public Volunteer(String first, String last){
		super(first, last);
		numberOfVolunteers++;
		volunteers.add(this);
	}
	/**
	 * Constructor: 
	 * Sets
	 * @param first
	 * @param last
	 * @param DOB
	 * to the instance variables
	 */
	public Volunteer( String first, String last, GregorianCalendar DOB){
		super(first,last,DOB);
		numberOfVolunteers++;
		volunteers.add(this);
	}
	
	public Volunteer( String first, String last, GregorianCalendar DOB, Location workLocation, double hoursVolunteered ) throws NullPointerException, IllegalArgumentException{
		super( first, last, DOB );
		if( workLocation == null ){
			String msg = "";
			if( workLocation == null ){
				msg += "workLocation == null\n";
			}
			
			throw new NullPointerException(msg);
		}
		if( hoursVolunteered < 0.0  ){
			String msg = "";
			if( hoursVolunteered < 0.0 ){
				msg += "hoursWorked < 0.0\n";
			}
			
			throw new IllegalArgumentException(msg);
		}
		this.workLocation     = workLocation;
		this.hoursVolunteered = hoursVolunteered;
		numberOfVolunteers++;
		volunteers.add(this);
	}
	
	/**
	 * 
	 * @return the total number of Volunteers that have been created
	 */
	public static int getNumVolunteers(){
		return numberOfVolunteers;
	}
	
	/**
	 * 
	 * @return all of the volunteers that have been created
	 */
	public static ArrayList<Volunteer> getVolunteers(){
		return Volunteer.volunteers;
	}
	
	/**
	 * 
	 * Prints a single volunteer
	 * 
	 * @param vol represents the volunteer that will be printed
	 */
	public static void printVolunteer( Volunteer vol ){
		if( vol == null ){
			return;
		}
		System.out.println();
		System.out.println("Name: " + vol.getFirstName() + " " + vol.getLastName());
		System.out.print("DOB:  ");
		ValidateInput.printDate(vol.getBirthDate());
		System.out.println("WorkLocation: " + vol.getWorkLocation());
		System.out.println("Hours Volunteered: " + vol.hoursVolunteered);
		System.out.println();
	}
	
	/**
	 * Prints every Volunteer that has been created
	 */
	public static void printAllVolunteers(){
		for( Volunteer vol : getVolunteers() ){
			printVolunteer(vol);
		}
	}
	


	public Location getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(Location workLocation) throws NullPointerException {
		if( workLocation == null ){
			String msg = "workLocation == null";
			throw new NullPointerException(msg);
		}
		this.workLocation = workLocation;
	}

	public double getHoursVolunteered() {
		return this.hoursVolunteered;
	}

	public void setHoursVolunteered(double hoursVolunteered) throws IllegalArgumentException{
		
		if(hoursVolunteered <= 0){
			throw new IllegalArgumentException("Error, input cannot be less or equal to zero.");
		}
			
		this.hoursVolunteered = hoursVolunteered;
	}
	
	
}
