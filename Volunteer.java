import java.util.GregorianCalendar;
public class Volunteer extends Person {

	private String workLocation = "No workLocation has been assigned yet";
	private double hoursVolunteered = 0;
	
	public Volunteer(){
		super();
		workLocation = "No location has been assigned yet.";
		hoursVolunteered = 0;
	}
	
	public Volunteer(String first, String last){
		super(first, last);
		workLocation = getWorkLocation();
		hoursVolunteered = getHoursVolunteered();
	}
	public Volunteer(String first, String last, GregorianCalendar DOB){
		super();
		workLocation = getWorkLocation();
		hoursVolunteered = getHoursVolunteered();
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public double getHoursVolunteered() {
		return hoursVolunteered;
	}

	public void setHoursVolunteered(double hoursVolunteered) {
		this.hoursVolunteered = hoursVolunteered;
	}
	
	
}
