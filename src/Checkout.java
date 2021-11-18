import java.io.*;

public class Checkout extends Hotel {
	//room no.(rn) and room type(rt) 
	static void bill(int rn,int rtype)
    {
        double amount=0;
        
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");
               
        switch(rtype)
        {
            case 1:
                amount+=2000;
                    System.out.println("\nRoom Charge - "+2000);
                    
                break;
        
            case 2:amount+=1200;
                    System.out.println("Room Charge - "+1200);
                
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- "+amount);
    }

	
	
	
	//checking out
	public static void deallocate(int rn,int rtype)
	    {
	        int j;
	        char w;
	        switch (rtype) {
	            case 1:               
	                if(hotel_ob.luxury_singleroom[rn]!=null)
	                    System.out.println("Room used by "+hotel_ob.luxury_singleroom[rn].name);                
	                else 
	                {    
	                    System.out.println("Empty Already");
	                        return;
	                }
	                System.out.println("Do you want to checkout ?(y/n)");
	                 w=sc.next().charAt(0);
	                if(w=='y'||w=='Y')
	                {
	                    bill(rn,rtype);
	                    hotel_ob.luxury_singleroom[rn]=null;
	                    System.out.println();
	                    System.out.println("********************");
	                    System.out.println("Checkout successfull");
	                    System.out.println("********************");
	                }
	                
	                break;
	            
	            case 2:
	                if(hotel_ob.luxury_doubleroom[rn]!=null)
	                    System.out.println("Room used by "+hotel_ob.luxury_doubleroom[rn].name);                
	                else 
	                 {    
	                    System.out.println("Empty Already");
	                        return;
	                }
	                System.out.println(" Do you want to checkout ? (y/n)");
	                 w=sc.next().charAt(0);
	                if(w=='y'||w=='Y')
	                {
	                    bill(rn,rtype);
	                    hotel_ob.luxury_doubleroom[rn]=null;
	                    System.out.println();
	                    System.out.println("********************");
	                    
	                    System.out.println("Checkout successfull");
	                    removeRecord("C:/db6.txt","rn",5,",");
	                    System.out.println("********************"); 
	               
	                    
	              }
	                break;
	            default:
	                System.out.println("\nEnter valid option : ");
	                break;
	        }
	        
	    }

	public static void removeRecord(String filepath, String removeTerm, int positionofTerm, String delimiter)
	{
		int position= positionofTerm -1;

	String tempFile="C:/input1.txt";
	File oldFile = new File (filepath);
	File newFile= new File(tempFile);
	String currentLine;
	String data[];
	try
	{
		FileWriter fw= new FileWriter (tempFile, true) ;
		BufferedWriter bw = new BufferedWriter (fw) ;
		PrintWriter pw = new PrintWriter (bw) ;
		FileReader fr= new FileReader(filepath);
		BufferedReader br = new BufferedReader(fr);
		while ((currentLine = br. readLine ()) != null)
		{
			data = currentLine.split(",");
			if(!data[position].equalsIgnoreCase(removeTerm))
			{
				pw.println(currentLine);
			}
		
		}
		pw.flush();
		pw.close();
		fr.close();
		br.close();
		bw.close();
		fw.close();
		
		oldFile.delete();
		File dump=new File(filepath);
		newFile.renameTo(dump);
	}
		

		catch(Exception e)
	{
	
}}}