package com.harshad.model;


  import java.util.List;
  
  import javax.persistence.CascadeType; import javax.persistence.Column; import
  javax.persistence.Entity; import javax.persistence.FetchType; import
  javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
  import javax.persistence.Id; import javax.persistence.JoinColumn; import
  javax.persistence.JoinTable; import javax.persistence.ManyToMany;

import
  javax.persistence.Table; import javax.validation.constraints.Email; import
  javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
  
  @Data
  
  @Entity
  
  @Table(name = "user")
  
  public class User {
    
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO) 
      
      private int id;
  
  
  @Column(name = "username", nullable = false) private String username;
  @Size(max = 10,min = 10)

  @Column(name = "phoneno", nullable = false) private String phoneno;
  
  @NotEmpty
  
  @Column(name = "email", unique = true, nullable = false)
  
  @Email(message = "{errors.invalid_email}") private String email;
  
  // @NotEmpty
  
  @Column(name = "password", nullable = false) private String password;
  
  private boolean isEnabled;
  private String userAddress;
  private String City;
  private String pincode;
  @Column(name = "confirmation_token")
	private String confirmationToken;
//reset pass
  @Column(name = "reset_password_token")
  private String resetPasswordToken;
  // Roles
  
  @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  
  @JoinTable(
  
  name = "user_role", joinColumns = {
  
  @JoinColumn(name = "USER_ID", referencedColumnName = "ID") },
  inverseJoinColumns = {
  
  @JoinColumn(name = "Role_ID", referencedColumnName = "ID") }
  
  ) private List<Role> roles;
  
  
  
  //@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    //private ShoppingCart cart;

  // Parametric COnstructor
  
  public String getResetPasswordToken() {
	return resetPasswordToken;
}


public void setResetPasswordToken(String resetPasswordToken) {
	this.resetPasswordToken = resetPasswordToken;
}


public String getAddress() {
	return userAddress;
}


public User(int id, String username, @Size(max = 10, min = 10) String phoneno,
		@NotEmpty @Email(message = "{errors.invalid_email}") String email, String password, boolean isEnabled,
		String userAddress, String city, String pincode, String confirmationToken, String resetPasswordToken,
		List<Role> roles) {
	super();
	this.id = id;
	this.username = username;
	this.phoneno = phoneno;
	this.email = email;
	this.password = password;
	this.isEnabled = isEnabled;
	this.userAddress = userAddress;
	City = city;
	this.pincode = pincode;
	this.confirmationToken = confirmationToken;
	this.resetPasswordToken = resetPasswordToken;
	this.roles = roles;
}


public String getUserAddress() {
	return userAddress;
}


public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}


public String getPincode() {
	return pincode;
}


public void setPincode(String pincode) {
	this.pincode = pincode;
}


public void setAddress(String address) {
	this.userAddress = address;
}


public User(User user) {
  
  this.username = user.getUsername(); this.phoneno = user.getPhoneno();
  this.email = user.getEmail(); this.password = user.getPassword(); this.roles
  = user.getRoles(); }
  

  // Associations
  //@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  //private Booking booking;
  // Default COnstructor
  
  public User() { }
  
  public int getId() { return id; }
  
  public void setId(int id) { this.id = id; }
  
  public String getUsername() { return username; }
  
  public void setUsername(String username) { this.username = username; }
  
  public String getCity() { return City; }
  
  public void setCity(String City) { this.City = City; }
  
  public String getPhoneno() { return phoneno; }
  
  public void setPhoneno(String phoneno) { this.phoneno = phoneno; }

  public String getpincode() { return pincode; }
  
  public void setpincode(String pincode) { this.pincode = pincode; }
  
  public String getEmail() { return email; }
  
  public void setEmail(String email) { this.email = email; }
  
  public String getPassword() { return password; }
  
  public void setPassword(String password) { this.password = password; }
  
  public List<Role> getRoles() { return roles; }
  
  public void setRoles(List<Role> roles) { this.roles = roles; }
  //public ShoppingCart getCart() {
		//return cart;
	//}

	//public void setCart(ShoppingCart cart) {
	//	this.cart = cart;
	//}
  public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

  public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	 public String getresetPasswordToken() {
			return resetPasswordToken;
		}

		public void setresetPasswordToken(String resetPasswordToken) {
      this.resetPasswordToken = resetPasswordToken;
    }


      
  
  // Generate Getter And Setter Method
  
  }
 