package BackEnd;
//same as author


/**
 * 
 * @author Gabriela
 *
 */
public class SubprogramChair extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1578153711119973104L;
	private String mySPCUser;
	private boolean SPCflag; 
	private Data myData;

	/**
	 * 
	 * @param theUserID
	 */
	public SubprogramChair(Data theCurrentData) {
		myData = theCurrentData;
	}
	/**
	 * 
	 */
	private void setReviewer() {
		
	}
	/**
	 * 
	 */
	private void submitRecommendation(){

	}
	public String toString(){
		return "Subprogram Chair";
	}

}
