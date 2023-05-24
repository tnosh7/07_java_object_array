package step7_01.objectArray;
import java.util.Scanner;

class Subject1{
	
	String name;
	int score;

}


class Student1{
	
	Subject1[] subjects;
	String name;

}


public class ObjectArrayEx08_연습2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// # 학생 추가 삭제 컨트롤러
		//   => 컨트롤러를 완성해 아래 3개의 정보를 추가하시오.
		//   김철수 : 과목3개 수학 50 국어50 영어 60 
		//   이만수 : 과목2개 수학 20 국어 30 
		//   이영희 : 과목1개 수학 100
		
		Student1[] studentList = new Student1[3];
		int studentCnt = 0;	// 학생 수
		
		while (true) {
		
			for (int i = 0; i < studentCnt; i++) {
				System.out.println("[" + (i+1) + "]" + studentList[i].name);
				if (studentList[i].subjects != null) {
					for (int j = 0; j < studentList[i].subjects.length; j++) {
						System.out.println("[" + (j+1) + "]" + studentList[i].subjects[j].name + "과목 \t성적  :" + studentList[i].subjects[j].score + "점");
					}
				}
				System.out.println();
			}
			System.out.print("1.이름 추가하기\n2.과목 추가하기\n3.성적 추가하기\n4.종료하기");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				System.out.println("이름 입력 : ");
				String name = scan.next();
				
				studentList[studentCnt] = new Student1();
				studentList[studentCnt].name = name;
				studentCnt++;
			}
			
			else if (sel == 2) {
				for (int i = 0; i < studentCnt; i++) {
					System.out.println("["+ (i+1) +"]" + studentList[i].name);
				}
				System.out.print("이름 선택 :");
				int select  = scan.nextInt()-1;
				
				System.out.print("과목 입력 : ");
				String sub  = scan.next();
				if (studentList[select].subjects == null) {
					studentList[select].subjects = new Subject1[1];
					studentList[select].subjects[0] = new Subject1();
					studentList[select].subjects[0].name = sub;
				}
				else {
					int length = studentList[select].subjects.length;
					Subject1[] tmp = studentList[select].subjects;
 					studentList[select].subjects = new Subject1[length+1];
					for (int i = 0; i < length; i++) {
						studentList[select].subjects[i] = tmp[i];
					}
					studentList[select].subjects[length] = new Subject1();
					studentList[select].subjects[length].name = sub;
 				}
			}
			else if (sel ==3) {
				for (int i = 0; i < studentCnt; i++) {
					System.out.println("["+ (i+1) +"]" + studentList[i].name);
				}
				System.out.print("이름 선택 :");
				int select  = scan.nextInt()-1;
				
				for (int i = 0; i < studentList[select].subjects.length; i++) {
					System.out.println("["+ (i+1) +"]" + studentList[select].subjects[i].name);
				}
				System.out.print("과목 선택 :");
				int subnum  = scan.nextInt()-1;
				
				System.out.print("성적 입력 : ");
				int score = scan.nextInt();
				
				studentList[select].subjects[subnum].score = score;
				
			}
			
			else if (sel == 4) {
				break;
			}
		}
		scan.close();

	}

}
