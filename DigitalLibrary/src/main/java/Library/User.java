package Library;

import java.io.InputStream;

public class User {
	private static String name;
	private static String id;
	private static String email;
	private static String password;
	private static String dob;
	private static InputStream profile;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String id, String name, InputStream profile, String email, String password, 
			String dob) {
	this.id=id;
	this.name=name;
	this.email=email;
	this.password=password;
	this.dob=dob;
	this.profile=profile;
	}
	public static String getEmail() {
		return email;
	}
	public static String getPassword() {
		return password;
	}
	public static String getDob() {
		return dob;
	}
	public static InputStream getProfile() {
		return profile;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		User.name = name;
	}
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		User.id = id;
	}
}

