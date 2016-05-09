package BackEnd;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String myUserName;
	private Data myData;
	private int myConfNum;
	private Conference myConference; //2
	private Conference myConference1; //2
	private Conference myConference2;
	private Conference myConference3;
	private Conference myConference4;
	private Conference myConference5;
	public UpdateSerFile myUpdateSerFileUser;
	private ArrayList<String> myUserNameList;
	public User() {
		myData = new Data();
		myUserNameList = new ArrayList<String>();
		myConference1 = new Conference(1);
		myConference2 = new Conference(2);
		myConference3 = new Conference(3);
		myConference4 = new Conference(4);
		myConference5 = new Conference(5);
		
		myUserNameList.add("Mr.PC");
		//User.deserialize();
		//help();
		//getSvaedData();
	}
	public User(String theUserName){
		myUserName = theUserName;
	}
	public Data getCurrentData(){
		return myData;
	}

	public Conference selectedConfer(int theConfNum){
		myConfNum = theConfNum;
		switch(theConfNum){
		case 1 : theConfNum = 1;
		myConference1.setName("Conference"+ theConfNum);
		myConference = myConference1;
		setAllPC(myConference1);
		break;
		
		case 2 : theConfNum = 2;
		myConference2.setName("Conference"+ theConfNum);
		myConference = myConference2;
		setAllPC(myConference2);
		break;
		
		case 3 : theConfNum = 3;
		myConference3.setName("Conference"+ theConfNum);
		myConference = myConference3;
		setAllPC(myConference3);
		break;
		
		case 4 : theConfNum = 4;
		myConference4.setName("Conference"+ theConfNum);
		myConference = myConference4;
		setAllPC(myConference4);
		break;
		
		case 5 : theConfNum = 5;
		myConference5.setName("Conference"+ theConfNum);
		myConference = myConference5;
		setAllPC(myConference5);
		break;
		}
		return myConference;
	}
	private void setAllPC(Conference theConference){
		myData = new Data();
		myData.setUser("Mr.PC");
		myData.setConf(theConference);
		ProgramChair pc = new ProgramChair();
		Author au = new Author(myData);
		myData.setRole(pc);
		myData.setRole(au);
		Data.dataList.add(myData);
	}

	public void help(){
//		myData = new Data();
//		myData.setUser("Tim");
//		myData.setConf(myConference1);
//		ProgramChair pc = new ProgramChair();
//		myData.setRole(pc);
//		Data.dataList.add(myData);

		myData = new Data();
		myData.setUser("Park");
		myData.setConf(myConference1);
		SubprogramChair spc = new SubprogramChair(myData);
		Reviewer aut = new Reviewer(myData);
		myData.setRole(spc);
		myData.setRole(aut);
		Data.dataList.add(myData);
		myUserNameList.add("Park");
		
		myData = new Data();
		myData.setUser("Kim");
		myData.setConf(myConference1);
		//SubprogramChair spc = new SubprogramChair();
	//	myData.setRole(spc);
		Data.dataList.add(myData);
		myUserNameList.add("Kim");
//
//		myData = new Data();
//		myData.setUser("Daniel");
//		myData.setConf(myConference1);
//		Reviewer rev = new Reviewer();
//		myData.setRole(rev);
//		Data.dataList.add(myData);

	}
	public boolean login(String theUserName){
		if(myUserNameList.contains(theUserName)) {
			myUserName = theUserName;
			myData = myData.getData(theUserName,myConference);
//			System.out.println("Conference Name : "+ myData.getConf().getName()
//			+"\nUser Name : "+myData.getUser()+ "\nUser Roles are : " +myData.getRole().get(0));
			return true;
		} 
		else{
			return false;
		}
	} // void ?? String ??
	/**
	 * 
	 * @param theUserName
	 * @param theRole
	 * @return
	 */
	public void register(String theUserName,Conference theConference ){
		//
		int counter = 0;
//		System.out.println("Befor the Add new ");
//		for(int i = 0 ; i < Data.dataList.size(); i++){
//			//System.out.println(Data.dataList.get(i).getConf());
//			if(Data.dataList.get(i).getConf().equals(myConference)){
//				System.out.println((counter+1)+") "+Data.dataList.get(i).getUser() + "  "+ Data.dataList.get(i).getRole().get(0).toString());
//				counter++;
//			}
//		}
		if(myUserNameList.contains(theUserName)){
			//return "Already Exists";
		}
		else {
			myUserNameList.add(theUserName);
			myData = new Data();
			//myConference.setName("Conference"+myConfNum);
			myData.setConf(myConference);
			myData.setUser(theUserName);
			//System.out.println(myConference.getName() + "   "+myData.getConf());
			Data.dataList.add(myData);		
			//return "have been add to List";
		}
	}
	/**
	 * 
	 */
	public static void Serialize(User theUser){
		try {
			FileOutputStream fileOut = new FileOutputStream("user.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(theUser);
			out.close();
			fileOut.close();
		} catch(IOException i) {
			i.printStackTrace();
		}
	}

	//need in this class?
	public static Object deserialize() {
		User savedUser = null;      
		try {
			FileInputStream fis = new FileInputStream("user.ser");
			ObjectInputStream inputStream = new ObjectInputStream(fis);
			savedUser = (User) inputStream.readObject();
			inputStream.close();
		} catch (IOException | ClassNotFoundException ex) {
			System.err.println(ex);
		}
		return savedUser;
	}
	private void getSvaedData(){
		@SuppressWarnings("unchecked")
		User tempName = (User) deserialize();
		//Data tmepData = (Data)deserialize();
		//Data.dataList = tmepData.dataList;
		
		//System.out.println(temp.getUserNameList().get(temp.getUserNameList().size()-1));
		//myRoleMap = temp.getRoleMap();
		myUserNameList = tempName.getUserNameList();
		//myConferenceArrayList = temp.getConferenceList();
		//myPaperArrayList = temp.getPaperList();

	}

	//   public HashMap<String,Object> getRoleMap(){
	//	   return myRoleMap;
	//   }
	// ArrayList<String> myUserNameList; 
	public ArrayList<String> getUserNameList() {
		return myUserNameList;
	}
	/**
	 * 
	 * @return
	 */
	//	public ArrayList<Conference> getConferenceList() {
	//		return myConferenceArrayList;
	//	}
	/**
	 * 
	 * @return
	 */	
	//	public ArrayList<Paper> getPaperList() {
	//		return myPaperArrayList;
	//	}
	//	

	/**
	 * 
	 * @return
	 */
	public String getUserName() {
		return myUserName;
	}

	/**
	 * @return
	 */
	//	public role getRole() {
	//		role tmpeRole;
	//		tmpeRole = (role) myRoleMap.get(myUserName);
	//		return tmpeRole;
	//	}

}
