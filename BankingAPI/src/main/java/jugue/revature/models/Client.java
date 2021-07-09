package jugue.revature.models;

//import java.util.Date;

public class Client {

	private int Client_Id;
	private String Firstname;
	private String Lastname;
	private String Middlename;
	private String Phone;
	private String Email;
	private Long Dateofbirth;
	private String Address;
	

	public Client() {
		super();
		
	}

	public Client(int client_Id, String firstname, String lastname, String middlename, String phone, String email,
			Long dateofbirth, String address) {
		super();
		Client_Id = client_Id;
		Firstname = firstname;
		Lastname = lastname;
		Middlename = middlename;
		Phone = phone;
		Email = email;
		Dateofbirth = dateofbirth;
		Address = address;
	}
	
	

	public int getClient_Id() {
		return Client_Id;
	}

	public void setClient_Id(int client_Id) {
		Client_Id = client_Id;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getMiddlename() {
		return Middlename;
	}

	public void setMiddlename(String middlename) {
		Middlename = middlename;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Long getDateofbirth() {
		return Dateofbirth;
	}

	public void setDateofbirth(Long dateofbirth) {
		Dateofbirth = dateofbirth;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}


	@Override
	public String toString() {
		return "Client [Client_Id=" + Client_Id + ", Firstname=" + Firstname + ", Lastname=" + Lastname
				+ ", Middlename=" + Middlename + ", Phone=" + Phone + ", Email=" + Email + ", Dateofbirth="
				+ Dateofbirth + ", Address=" + Address + "]";
	}
	
	

	
	
	
	
	
	
	

}
