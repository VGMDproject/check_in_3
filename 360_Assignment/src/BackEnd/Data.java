package BackEnd;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Data implements java.io.Serializable {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 2341263830388783429L;
	private String myUser;
	private Conference myConf;
	private ArrayList<Object> myRoleList; 
	public static ArrayList<Data> dataList = new ArrayList<Data>() ;
	
	public Data(){
		myUser = "";
		myConf = null;
		myRoleList = new ArrayList<Object>();
	}
	public String getUser() {
		return myUser;
	}
	public void setUser(String theUser) {
		myUser = theUser;
	}
	public Conference getConf() {
		return myConf;
	}
	public void setConf(Conference theConf) {
		myConf = theConf;
	}
	public ArrayList<Object> getRole() {
		return myRoleList;
	}
	public void setRole(Object role) {
		myRoleList.add(role);
	}

//	public ArrayList<Object> roles(){
//		
//		for(int i = 0; i < dataList.size(); i ++){
//			if(dataList.get(i).getUser )
//		}
//	}
	public Data getData(String theUserName, Conference theConference) {
		for(int i =0;i <dataList.size(); i++){
			if(dataList.get(i).getUser().equals(theUserName)){
				if(dataList.get(i).getConf().equals(theConference)){
					return dataList.get(i);
				}
			}
		}
		return null;
		
	}
}
