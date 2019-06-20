package staff;

public class Staff {
	
	private int id;
	private String username;
	private String password;
	private String position;
	private String contact;
	private double salary;
	private String gender;
	
	public Staff() {
		super();
	}
	
	public Staff(int id, String username, String password, String position, String contact, double salary, String gender) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.position = position;
		this.contact = contact;
		this.salary = salary;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Staff [id=" + id + ", username=" + username + ", password=" + password + ", position=" + position + ", contact=" + contact + ", salary=" + salary + ", gender=" + gender + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
