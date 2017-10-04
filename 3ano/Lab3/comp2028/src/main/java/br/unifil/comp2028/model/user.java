package br.unifil.comp2028.model;

public class user {

	private static String username;
	private static String password;
	
	
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		user.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		user.password = password;
	}
}
