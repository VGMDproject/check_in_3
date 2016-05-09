package FrontEnd;

import java.util.Scanner;

import BackEnd.Data;
import BackEnd.User;

public class main {

	public static void main(String[] args) {
	
		helpMain hm = new helpMain();
		Scanner sc 	= new Scanner(System.in);	
		hm.startMessage();
		hm.selectCnfer();
		System.out.println("########## Menu ##########");
		System.out.println("1) Login");
		System.out.println("2) Register");
		System.out.print("\nPlease Select Number : ");
		int num = sc.nextInt();
		if(num == 1){
			hm.loginMethod();
		
		}
		else if (num == 2){
			hm.registerMethod();
		}
		//User.makeSerialize(Data.dataList);
	}

}
