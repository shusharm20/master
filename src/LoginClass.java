

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LoginClass {

	private static Scanner x;
	public static boolean login() throws NoSuchElementException{
		boolean state=false;
		try {
		System.out.println("________________________________");
		System.out.println("\n******* User Login *********");
		
		Scanner scanner1 = new Scanner(System.in);
        System.out.print("\nEnter user name => ");
       // scanner1.next();
        String userName = scanner1.nextLine();
        
        System.out.print("Enter password => ");
        String password = scanner1.nextLine();
        System.out.println("________________________________");
        String filepath = "C:\\db1.csv";
        boolean found = false;
        state =verifyLogin(userName, password, filepath);
        
		}
		catch(NoSuchElementException ne) {
			Main.Startpoint();
		}
		return state;
	}

public static boolean verifyLogin( String userName,String password, String filepath){
 boolean found = false;
 String tempUsername="";
 String tempPassword="";
 
 try {
 	
		x = new Scanner(new File(filepath));
		x.useDelimiter("[,\n]");
		
		while(x.hasNext() && !found) {
			
			tempUsername=x.next();
			tempPassword=x.next();
			
 		
 		
 		if (tempUsername.trim().equals(userName.trim()) && tempPassword.trim().equals(password.trim())) {
 			 	System.out.println("\nHi " + userName );
 				found=true;
 			}
 		}
		x.close();
		
 }
 
 catch(Exception ex) {
 	ex.printStackTrace();
 }
return found;
 
 
}




}