import java.util.GregorianCalendar;


public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
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
		
	}

}
