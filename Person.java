/**
 * 
 * @author Michaela
 * This class constitutes the direct super class for the classes Employee and Homeless
 * instance variables:  name
 *                      age
 *                      nationality
 *                      
 *            methods:  get and setters for all instance variables
 *            Use LocalDate from JodaTime and only store the date for the birthday, not the time.                                 
 *                 
 */
import java.util.ArrayList;
import java.util.GregorianCalendar;
public class Person {
	
	private static int               numberOfPersons = 0;
	private static ArrayList<Person> persons         = new ArrayList<Person>();
	

	private String            firstName = null;//first name of a person
	private String            lastName  = null;//last name of a person
	private GregorianCalendar birthDate = null; //birthday of a person
	
	
	
	/**
	 * Default constructor. Sets firstName to Demo
	 *                           lastName  to Demo
	 *                           birthDate to today's date
	 */
	public Person(){
		firstName = "Demo";
		lastName  = "Demo";
		birthDate = new GregorianCalendar();  //sets it to today's date
		numberOfPersons++;
		persons.add(this);
	}
	
	
	/**
	 * Constructor that sets firstName, lastName, and birthDate to: 
	 * @param first
	 * @param last
	 * @param DOB   
	 * 
	 *             respectively
	 */
	public Person(String first, String last, GregorianCalendar DOB) throws NullPointerException, IllegalArgumentException {
		if( first == null || last == null || DOB == null ){
			String msg = "";
			if( first == null ){
				msg += "first == null\n";
			}
			if( last == null ){
				msg += "last == null\n";
			}
			if( DOB == null ){
				msg += "DOB == null\n";
			}
			
			throw new NullPointerException(msg);
		}
		
		
		firstName = ValidateInput.validateName(first);
		lastName  = ValidateInput.validateName(last);
		birthDate = DOB;
		numberOfPersons++;
		persons.add(this);
	}
	
	/**
	 * Constructor that sets firstName and lastName to :
	 * @param first
	 * @param last
	 *             respectively
	 */
	public Person(String first, String last){
		if( first == null || last == null ){
			String msg = "";
			if( first == null ){
				msg += "first == null\n";
			}
			if( last == null ){
				msg += "last == null\n";
			}
			
			throw new NullPointerException(msg);
		}
		firstName = ValidateInput.validateName(first);
		lastName  = ValidateInput.validateName(last);
		numberOfPersons++;
		persons.add(this);
	}
	
	/**
	 * 
	 * @return the number of Person objects that have been created thus far
	 */
	public static int getNumPersons(){
		return numberOfPersons;
	}
	
	/**
	 * 
	 * @return return an ArrayList of the all of the Person objects that have been created thus far.
	 */
	public static ArrayList<Person> getPersons(){
		return Person.persons;
	}
	
	/**
	 * 
	 * Prints a single person
	 * 
	 * @param person represents the person that will be printed
	 */
	public static void printPerson( Person person ){
		if( person == null ){
			return;
		}
		System.out.println();
		System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
		System.out.print("DOB:  ");
		ValidateInput.printDate(person.getBirthDate());
		System.out.println();
	}
	
	/**
	 * Prints every Person that has been created
	 */
	public static void printAllPersons(){
		for( Person person : getPersons() ){
			printPerson(person);
		}
	}
	
	/**
	 * Returns the first name of a person
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Takes the parameter and sets the instance variable firstName equal to the parameter
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the last name of a person
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Takes the parameter and sets the instance variable lastName equal to the parameter
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Returns the date of birth of a person
	 * @return birthDate
	 */
	public GregorianCalendar getBirthDate() {
		return birthDate;
	}
	
	/**
	 * Takes the parameter and sets the instance variable birthDate equal to that parameter
	 * @param birthDate
	 */
	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}
		
	
}
