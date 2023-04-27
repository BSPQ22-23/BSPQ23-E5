package database;

public class a {
	
	public static void main(String[] args) {
		System.out.println(GuestDAO.getInstance().exists("123456789J"));
		System.out.println(GuestDAO.getInstance().exists("123456789J"));
		System.out.println(GuestDAO.getInstance().exists("12345678J"));
	}
}
