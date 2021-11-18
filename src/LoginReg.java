

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class LoginReg {
	static boolean regStatus=false;
	public static boolean registration() {
		System.out.println("\n********** Registration **********\n");
		Register register = new Register(); 
		
	    	try (Scanner scanner = new Scanner(System.in)) {
	            System.out.print(" Enter firstName => ");
	            String firstName = scanner.nextLine();
	            register.setFirstName(firstName);

	            System.out.print(" Enter lastName => ");
	            String lastName = scanner.nextLine();
	            register.setLastName(lastName);

	            System.out.print(" Enter userName => ");
	            String userName = scanner.nextLine();
	            register.setUserName(userName);

	            System.out.print(" Enter password => ");
	            String password = scanner.nextLine();
	            register.setPassword(password);

	            System.out.print(" Enter emailId => ");
	            String emailId = scanner.nextLine();
	            register.setEmailId(emailId);

	            System.out.print(" Enter phoneNo => ");
	            long phoneNo = scanner.nextLong();
	            register.setPhoneNo(phoneNo);

	            System.out.println(register.toString());
	            String filepath = "C:\\db1.csv";
	           
	            saveRecord(firstName,lastName,userName,password,emailId,phoneNo,filepath);
	           
				
	        }
	    	return regStatus;
	    }
		
		

	



	public static boolean saveRecord(String firstName, String lastName, String userName, String password, String emailId,
			long phoneNo, String filepath) {
		
		try {
			FileWriter fw = new FileWriter(filepath,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(userName +","+password+"," + firstName + "," + lastName + "," + emailId + ","+phoneNo);
			pw.flush();
			pw.close();
			String regstatus="Registration successful !";
			if(regstatus=="Registration successful !") {
				regStatus=true;
			}
			
			
			
		}
		catch(Exception E){
			String regstatus="Something went wrong";
			if(regstatus=="Something went wrong") {
				System.out.println("Something went wrong");
				regStatus=false;
			}
			
		}
		return regStatus;
		
		
	
		
	}


	

}

class Register {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String emailId;
    private long phoneNo;
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
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public long getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    @Override
    public String toString() {
        return "\nRegister [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" +
            password + ", emailId=" + emailId + ", phoneNo=" + phoneNo + "]\n";
        
    }   
}
