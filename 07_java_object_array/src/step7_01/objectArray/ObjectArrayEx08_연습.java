package step7_01.objectArray;
import java.util.Scanner;

class Subject8{
	
	String name;
	int score;

}


class Student8{
	
	Subject8[] subjects;
	String name;

}


public class ObjectArrayEx08_연습 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// # 학생 추가 삭제 컨트롤러
		//   => 컨트롤러를 완성해 아래 3개의 정보를 추가하시오.
		//   김철수 : 과목3개 수학 50 국어50 영어 60 
		//   이만수 : 과목2개 수학 20 국어 30 
		//   이영희 : 과목1개 수학 100
		
		Student8[] studentList = new Student8[3];
		int studentCnt = 0;	// 학생 수
		
		while (true) {
			
			for (int i = 0; i < studentCnt; i++) {
				System.out.println("[" + (i+1) + "]" + studentList[i].name + "학생>>>");	//맨 처음 나옴 학생 추가한만큼 출력 
				if (studentList[i].subjects != null) {	//과목이 있다면 출력!!(까먹지말기) 
					for (int j = 0; j < studentList[i].subjects.length; j++) { //과목 수만큼 
						System.out.println("[" + (j+1) + "]" + studentList[i].subjects[j].name + "과목 = " + studentList[i].subjects[j].score + "점");
					}
				}
				System.out.println();
			}
			
			System.out.println("[1]학생 추가하기");		// 이름 입력받아 추가
			System.out.println("[2]과목 추가하기");		// 이름과 과목 입력받아 추가
			System.out.println("[3]성적 추가하기");		// 이름과 과목 그리고 성적 입력받아 추가
			System.out.println("[4]종료하기");
			int choice = scan.nextInt();
			
			if (choice == 1) {
				
				System.out.print("이름 입력 : ");
				String name = scan.next();
				
				studentList[studentCnt] = new Student8();		//연결 
				studentList[studentCnt].name = name;
				studentCnt++;
				
			}
			else if (choice == 2) {
				
				for (int i = 0; i < studentCnt; i++) {	//수만큼 
					System.out.println("[" + (i+1) + "]" + studentList[i].name);	//학생이름 출력 	
				}
				System.out.print("학생 선택 : ");
				int select = scan.nextInt();
				select--;								//학생선택할 때 번호가 1부터 시작해서 -1을 해준다.
				
				System.out.print("과목 입력 : ");
				String subject = scan.next();
				
				if (studentList[select].subjects == null) {		//처음 
					
					studentList[select].subjects = new Subject8[1];	//인덱스 길이 지정해주기 !!
					
					studentList[select].subjects[0] = new Subject8();
					studentList[select].subjects[0].name = subject;
					
				}
				else {
																		//과목 배열은 길이 안정함 
					int size = studentList[select].subjects.length;		//기존에 과목이있을경우 추가하기 
					
					Subject8[] temp = studentList[select].subjects;		//주소 옮기기 []X; 
					studentList[select].subjects = new Subject8[size + 1]; //배열 인덱스 길이 +1한 다음에 ; 
					
					for(int i = 0; i < size; i++) {
						studentList[select].subjects[i] = temp[i];		//데이터값 옮기기 
					}
					
					studentList[select].subjects[size] = new Subject8();	
					studentList[select].subjects[size].name = subject;
					
					temp = null;
					
				}
			}
			else if (choice == 3) {
				
				for (int i = 0; i < studentCnt; i++) {					//성적 과목 추가할 때 학생이름 기본으로 나오기 
					System.out.println("[" + (i+1) + "]" + studentList[i].name);
				}
				System.out.print("학생 선택 : ");		//i+1해서 select--해줌
				int select = scan.nextInt();
				select--;
				
				if (studentList[select].subjects != null) {				//기존에 추가한 과목이 있을 경우 
					for (int i = 0; i < studentList[select].subjects.length; i++) { //select
						System.out.println("[" + (i+1) + "]" + studentList[select].subjects[i].name);//과목 출력
					}
				}
				
				System.out.print("과목 선택 : ");		//i+1해서 num--해줌
				int num = scan.nextInt();
				num--;
				
				System.out.print("성적 입력 : ");
				int score = scan.nextInt();
				
				studentList[select].subjects[num].score = score; //덮어쓰는 
				
			}
			else if (choice == 4) {
				System.out.println("종료");
				break;
			}
		
		}

		scan.close();

	}

}
