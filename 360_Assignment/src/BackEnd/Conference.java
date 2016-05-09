package BackEnd;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */

/**
 * @author Gabriela
 *
 */
public class Conference {
	
	private int myConferenceID;

	//a list of all papers with conferenceID == myConferenceID
	private ArrayList<Paper> myPaperList;

	//the name of the conference
	private String myName;

	//will be set to 1. 0 means conference is not active anymore
	private int myStatus; 

	//make sure you use Date datatype
	private Date myDeadline;

	//constructor 	
	public Conference(int theConferenceID) {
		myConferenceID = theConferenceID;
		myPaperList = new ArrayList<Paper>();
	//	myPaperList.add(new Paper("Park", ));
	}
	public void addPaper(Paper thePaper){
		myPaperList.add(thePaper);
	}
	public ArrayList<Paper> showConfPaper(){
		return myPaperList;
	}
	
	//set the name of the conference. name is the same as title
	public void setName(String theName) {
		myName = theName;
	}
	public String getName() {
		return myName;
	}
	
	private void setStatusConference(int theStatus) {
		
	}

	public void setDeadline(Date theDeadline) {
		myDeadline = theDeadline;
	}

	public Date getDeadline() {
		return myDeadline; 
	}
}
