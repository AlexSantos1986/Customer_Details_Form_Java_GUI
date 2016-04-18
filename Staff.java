
public class Staff {

	private int staffId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String department;
	private double salary;
	private String startDate;
	private boolean fullTime;

	public Staff(int staffId, String firstName, String lastName, String dateOfBirth, String department, double salary,
			String startDate, boolean fullTime) {

		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
		this.salary = salary;
		this.startDate = startDate;
		this.fullTime = fullTime;
	}

	public Staff() {
		
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirthday(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public boolean isFullTime() {
		return fullTime;
	}

	public String hasFullTime() {
		return (fullTime ? "Yes" : "No");
	}

	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}

	public String ToString() {
		String s = "";
		s += "Staff ID: " + getStaffId() + "\n";
		s += "First Name: " + getFirstName() + "\n";
		s += "Last Name: " + getLastName() + "\n";
		s += "Date of Birth: " + getDateOfBirth() + "\n";
		s += "Department: " + getDepartment() + "\n";
		s += "Salary: " + getSalary() + "\n";
		s += "Start Date: " + getStartDate() + "\n";
		s += "Full-Time: " + hasFullTime() + "\n";
		return s;
	}

}
