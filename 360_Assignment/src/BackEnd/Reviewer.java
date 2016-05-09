package BackEnd;

public class Reviewer extends User implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8379584783492155263L;
	private String myRevUser;
	private boolean reviewerflag;
	private Data myData;

	//private int myUsername;

	public Reviewer(Data theCurrentData) {
		myData = theCurrentData;
		//constructor 
	//	myRevUser =  this.getUserName();
	}
	private void submitReview() {
		
	}
	public String toString(){
		return "Reviewer";
	}
	
	
}
