package BackEnd;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.io.*;


public class UpdateSerFile implements java.io.Serializable {
	private String fileName = null;
	private Object myObject = null;
	private Object myReturnObject = null;
	
	
	
	public UpdateSerFile(Object theObject) {
		myObject = theObject;
		if(myObject instanceof Data) {
			fileName = "Data.ser";
		}
//		makeSerialize();
//		deserialize();
	}

	/**
	 * you know this
	 */
	public void makeSerialize(Object theObject) {

		try {
			//			 System.out.println("ff  " + mm.size());
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(theObject);
			out.close();
			fileOut.close();
		} catch(IOException i) {
			i.printStackTrace();
		}
		//		  return myObject;
	}
	
	/**
	 * you better know this
	 */
	public Object deserialize() throws ClassNotFoundException, ClassNotFoundException {
//		ArrayList<User> returnArrayList = new ArrayList<User>();
		try
	      {
//			System.out.println(fileName);
	         FileInputStream fileIn = new FileInputStream(fileName);
//	         try{
	        	 ObjectInputStream in = new ObjectInputStream(fileIn);
	        	 myReturnObject = in.readObject();
	        	 in.close();
//	         } catch(StreamCorruptedException sc) {
////	        	 System.out.println("Invalid data!");
//	         } catch(EOFException sc) {
////	        	 System.out.println("No data available!");
//	         } catch(IOException i) {
	        	 
//	         } 
	         fileIn.close();
	      }catch(IOException i) {
//	         i.printStackTrace();
//	    	  System.out.println("FAIL1");
	      }catch(ClassNotFoundException c)
	      {
//	    	  System.out.println("FAIL2");
//	    	  c.printStackTrace();
	      }

//		ArrayList<User> mm = (ArrayList<User>) myReturnObject;
//		if(mm!=null){
//		for(User ss : mm) {
//			System.out.println(ss.getName()  + " ,  " + ss.getUserName());
//		}
//		}
		return myReturnObject;
		
//		System.out.println("Deserialized User...");
//		System.out.println("Name: " + myObject);
//		System.out.println("User name: " + what.myUserName);
//		System.out.println("Role: " + what.myRole);
	}
	
}
