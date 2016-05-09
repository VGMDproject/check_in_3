package BackEnd;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//This class is a child for User class
public class Author extends User implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1212792982582478027L;
	//myUser is and instance of the User class
	private String myAuthorUser;
	private boolean authorFlag;
	private Paper myPaper;
	//myUsername is the username for this User class passed in as constructor's parameters
	private int myUsername;
	private Data myData;

	public Author(Data theCurrentData) {
		// TODO Auto-generated constructor stub
		myData = theCurrentData;
	}

	public void submitPaper(String tempFileURL) throws IOException {
		
		myPaper = new Paper(myData.getUser(),myData.getConf());
		System.out.println("in the submitPaper"+myData.getConf().getName());
		myData.getConf().addPaper(myPaper);
		//myPaper.setAuthor(myData.getUser());
		File myFile = new File(tempFileURL);
		myPaper.submitPaper(myFile);
	}

	//when author submits a paper, this status should be set to 1
	//we can change this status to 0 when we want to decline the paper
	private void setStatusPaper() {
		
	}

	//author can call the editPaper method in Paper class. I don't know how.
	private void editPaper() {
		
	}
	public String toString(){
		return "Author";
	}

}
