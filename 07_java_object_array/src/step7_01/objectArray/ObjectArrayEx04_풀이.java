package step7_01.objectArray;

import java.util.Scanner;


class User_풀이 {
	
	String id;
	int money;
	
}

public class ObjectArrayEx04_풀이 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		//a[] b = new a[];  ==> a 메서드명 
		//b[i]  = new a();	
		User_풀이[] userList = new User_풀이[100];	
		
		for (int i = 0; i < userList.length; i++) {
			userList[i] = new User_풀이();
		}
		
		int userCnt = 0;
		int log = -1;
		while (true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 탈퇴");
			System.out.println("3. 출력");
			System.out.println("4. 종료");
			int sel = scan.nextInt();
			
			if (sel == 1 ) {
				User_풀이 temp = new User_풀이();
				
				System.out.print("이름을 입력하세요 :");
				temp.id = scan.next();
				
				System.out.print("금액을 입력하세요 :");
				temp.money = scan.nextInt();
				
				userList[userCnt] = temp;
				userCnt++;
				
			}
			
			else if (sel == 2) {
				System.out.print("인덱스를 입력하세요 : ");
				int idx = scan.nextInt();
				for (int i = 0; i < userCnt-1; i++) {
					userList[i] = userList[i+1];
				}
				userCnt--;
			}
			else if (sel == 3) {
				for (int i = 0; i < userCnt; i++) {
					System.out.println(userList[i].id + " " + userList[i].money);
				}
			}
			
			
			else if (sel == 4) {
				break;
			}
		}
		
		
		
		
		
	
		scan.close();
	}

}
