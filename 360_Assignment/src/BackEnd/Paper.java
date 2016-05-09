package BackEnd;

import java.io.File;

public class Paper implements java.io.Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = -6406983617585512726L;

		//we need an ID for paper 'cause two papers can have the same names\
		//this is how you identify your paper
		private int myPaperID;

		//the PC for this paper
		private ProgramChair myProgramchair;

		//the SPC for this paper
		private SubprogramChair mySubprogramChair; 

		//the reviewer for this paper
		private Reviewer myReviewer;

		//the author for this paper
		private String myAuthor;

		//the name of the paper same as title
		private String myName;

		//the conference that this paper belongs to
		private Conference myConference;

		//0 means new paper not touched yet by anyone
		//1 means approved to be in conference
		//2 means suspended by the author
		private int myStatus; 

		//review made by reviewer
		private String myReview; 

		//recommendation made by SPC
		private String myRecommendation; 

		//the text of the paper
		//different than name. name is title
		private String myText;  
		private File myFile;

		//constructor. takes an ID as parameter. 
		//id is unique but not random. something like (total articles + 1)
		public Paper(String theAuthorName, Conference theConf) {
			myAuthor = theAuthorName;
			myConference = theConf ;
		}
		public String getAuthorName(){
			return myAuthor;
		}
		public Conference getConference(){
			return myConference;
					
		}
		public void setConference(){
			
		}

		private void setProgramchair(ProgramChair theProgramChair){
			
		}

		private void setSubprogramChair(SubprogramChair theSubprogramChair){
			
		}

		private void setReviewer(Reviewer theReviewer){
			
		}
		private void setName(String theName) {
			
		}

		private void setConference(int theConferenceID){
			
		}
		private void setStatusPaper(int theStatus){
			
		}
		
		public void submitReview(String theReview) {
		
		}

		private void submitRecommendation(String theRecommendation) {
			
		}
		public void submitPaper(File theFile){
			myFile = theFile;
		}

		private void editPaper(String theText) {
			
		}

		//this happens when author submits a paper
		private void submitPaper() {
			
		}

}
