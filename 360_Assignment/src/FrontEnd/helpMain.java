package FrontEnd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import BackEnd.Author;
import BackEnd.Conference;
import BackEnd.Data;
import BackEnd.Paper;
import BackEnd.ProgramChair;
import BackEnd.Reviewer;
import BackEnd.Serializer;
import BackEnd.SubprogramChair;
import BackEnd.User;

public class helpMain implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User myUser;
	//Data myData;
	Conference conf;
	Scanner sc;
	String strUserName;
	int selecInt;

	public helpMain(){
		myUser = new User();
		myUser.help();
		sc	= new Scanner(System.in);
	}
	public void startMessage(){
		System.out.println("*******************************************************");
		System.out.println("*                                                     *");
		System.out.println("*             Welcome Conference Program              *");
		System.out.println("*                                                     *");
		System.out.println("*******************************************************");
	}
	public void selectCnfer(){
		System.out.println("########## Comference List ########## \n");
		for(int i = 0; i < 5; i++){
			System.out.println((i+1)+") Conference "+ (i+1));
		}
		System.out.print("\nPlease Select Conference : ");
		selecInt = sc.nextInt();
		System.out.print(selecInt);
		
		conf = myUser.selectedConfer(selecInt);
		//.out.println(conf.getName());

	}
	public void loginMethod(){
		//int count = 1;
		//while( true){
		System.out.println("########## Login ########## \n");
		System.out.println("Enter Name Please : ");	
		strUserName = sc.nextLine();
		strUserName = sc.nextLine();	
		
		if(myUser.login(strUserName)){
		for(int i = 0; i < myUser.getCurrentData().getRole().size(); i++){
			switch(myUser.getCurrentData().getRole().get(i).toString()){
			case "Program Chair" :{
				System.out.println("\n********* As a Program Chair *********\n");
				System.out.println("1)"+"Set Subprogram Chair");
				System.out.println("2)"+"View Papers");
				System.out.println("3)"+"Set Paper Status (Reject / Accept )");
				System.out.println("4)"+"Assign Papers to Subprogram Chair");

				continue;
			}

			case "Subprogram Chair" :{
				System.out.println("\n********* As a Subprogram Chair *********\n");
				System.out.println("5)"+"Submit Reviewers");
				System.out.println("6)"+"Submit Recommendation");
				System.out.println("7)"+"Assign Papers to Reviewer");
				continue;
			}

			case "Reviewer" :{
				System.out.println("\n********* As a Reviewer *********\n");
				System.out.println("8)"+"Submit Reviewers");
				continue;
			}
			}
			
		}
		System.out.println("9)Submit Paper");
		//sc.nextLine();
		int seleInt = sc.nextInt();
			switch(seleInt){
			case 1 :
				checkIfSubProgramChair();
				break;
			case 2 :
				viewPaperforPC();
				break;
			case 3 :
				checkIfSubProgramChair();
				break;
			case 4 :
				checkIfSubProgramChair();
				break;
			case 5 :
				checkIfSubProgramChair();
				break;
			case 6 :
				submitRevieweAsReviewer();
				break;
			case 7 :
				submitRevieweAsReviewer();
				break;
			case 8 :
				submitRevieweAsReviewer();
				break;
			case 9 :
				submitPaper();
				break;
			}
		}
		else {
			System.out.println("Error");
		}
		//}
			//User.makeSerialize(myUser);
	}
	public void assignPaperSub(){
		viewPaperforPC();
		ArrayList<Object> tempRoleList = new ArrayList<Object>() ;
		for(int i = 0; i < Data.dataList.size(); i++) {
			if(!Data.dataList.get(i).getUser().equals(myUser.getUserName())) {
				if(Data.dataList.get(i).getConf().equals(conf)){
					System.out.println((i + 1) + ") " + Data.dataList.get(i).getUser());
					tempRoleList.add(Data.dataList.get(i).getUser()); // no need this
				}
			}
		}
		//myUser.getCurrentData().getRole().get(myUser.getCurrentData().getRole().indexOf(o))
		
	}
	public void viewPaperforPC(){
		ArrayList<Paper> temp = myUser.getCurrentData().getConf().showConfPaper();
		for(int i = 0; i < temp.size(); i ++ ){
			System.out.println(temp.get(i).getAuthorName() + " " +temp.get(i).getConference().getName());
		}
	}

	public void registerMethod(){
		System.out.println("########## Register ########## \n");
		System.out.println("Plese Enter Your User Name : ");
		sc.nextLine();
		strUserName = sc.nextLine();	
		myUser.register(strUserName,conf);
		submitPaper();
		//Serializer.serialize(myUser);
		///User.makeSerialize(myUser);
	}
	public void submitRevieweAsReviewer() {
		Data currentUserData = myUser.getCurrentData();
		System.out.println("review as reviewer");
	}
	public void submitPaper() {   
		System.out.println("Please select the following job");
		System.out.println("(1) Submit paper");
		System.out.println("(2) Exit the program");
		int userSelected = sc.nextInt();

		switch(userSelected) {
		case 1 : 
			// Create a role to the current user
			
			Data currentUserData = myUser.getCurrentData();
			Author newAuthor = new Author(myUser.getCurrentData());
			// Add "Author" to the current user position list
			currentUserData.getRole().add(newAuthor);

			String tempFileURL;

			System.out.println("Please enter the path of the file : ");
			tempFileURL = sc.nextLine();
			tempFileURL = sc.nextLine();

			try {
				newAuthor.submitPaper(tempFileURL);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(myUser.getCurrentData().getUser()+" Added Papers to " +myUser.getCurrentData().getConf().getName());
			viewPaperforPC();
			break;

		case 2 : System.exit(0);   
		default : break;
		}
	}
	public void checkIfSubProgramChair() {	
		ArrayList<Object> tempRoleList = new ArrayList<Object>() ;
		for(int i = 0; i < Data.dataList.size(); i++) {
			if(!Data.dataList.get(i).getUser().equals(myUser.getUserName())) {
				if(Data.dataList.get(i).getConf().equals(conf)){
					System.out.println((i + 1) + ") " + Data.dataList.get(i).getUser());
					tempRoleList.add(Data.dataList.get(i).getUser()); // no need this
				}
			}
		}
		if(tempRoleList.isEmpty() == false){
			sc.nextLine();
			String strSubPro = sc.nextLine();
			ProgramChair pc = new ProgramChair();
			pc.setSubprogramchair(strSubPro,conf);
			System.out.println("'"+strSubPro+"' is now Subprogram Chair");
		}
		else {
			System.out.println("No User Registered Yet");
		}

	}	
}

