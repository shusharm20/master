import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;


public class Hotel 
{
    static RoomType hotel_ob=new RoomType();
    static Scanner sc = new Scanner(System.in);
    //customer details
    //i=room type rn=room no.
    static void CustDetails(int i,int rn)
    {
        String name, contact, gender;
        String name2 = null, contact2 = null; 
        String gender2="";
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
    //check this logic
      //if i==1 then customer wants single room.
        //if i==2 then customer wants double room
        if(i==2)
        {
        System.out.print("Enter second customer name: ");
        name2 = sc.next();
        System.out.print("Enter contact number: ");
        contact2=sc.next();
        System.out.print("Enter gender: ");
        gender2 = sc.next();
        }      //different types of room 
        
          switch (i) {
            case 1:hotel_ob.luxury_singleroom[rn]=new Singleroom(name,contact,gender);
                break;
           
            case 2:hotel_ob.luxury_doubleroom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
            	
                break;
            default:System.out.println("Wrong option");
                break;
          }
          
          String filepath = "C:\\db6.csv";
          
         if(saveRecord(name,contact,gender,i,rn,filepath))
         System.out.println("Data Stored Successfully");
          
          
    }
    
	public static boolean saveRecord(String name, String contact, String gender, int i, int rn,String filepath) {
			String roomType="";
		if(i==1)
			roomType="Single";
		else if(i==2)
			roomType="Double";
			
		try {rn=rn+1;
			FileWriter fw = new FileWriter(filepath,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(name +","+contact+"," + gender + "," + roomType + "," + rn );
			pw.flush();
			pw.close();
			return true;
			
			
			
		}
		catch(Exception E){
			
			return false;
			
		}
		
		
		
	
		
	}
    
    
}
         
          
    
    
    