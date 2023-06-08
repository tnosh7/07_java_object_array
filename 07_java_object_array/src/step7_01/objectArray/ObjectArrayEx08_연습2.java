package step7_01.objectArray;
import java.util.Scanner;

class Subj{
	
	String name;
	int score;

}


class Stud{
	
	Subj[] subjects;
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
		Stud[] studList = new Stud[3];
		int cnt = 0 ;
		
		while (true) {
			System.out.println("================");
			if (cnt > 0 ) {
				for (int i = 0; i < cnt; i++) {
					System.out.println("<-----학생 "+(i+1)+ "----->");
					System.out.println("[" + (i+1) + "]" + studList[i].name);
					System.out.println("-----과목-----");
					if (studList[i].subjects != null ) {
						for (int j = 0; j < studList[i].subjects.length; j++) {
							System.out.println("[" + (i+1) + "]" + studList[i].subjects[j].name + " : " + studList[i].subjects[j].score );
							System.out.println();
						}
					}
				}
			}
			System.out.println("================");
			System.out.println("[1]학생추가하기\n[2]과목추가하기\n[3]점수 추가하기\n[4]종료하기 : ");
			int sel = scan.nextInt();
			if (sel == 1) {
				System.out.print("학생 이름 입력 : ");
				String student = scan.next();
				
				if (cnt > 2) {
					System.out.println("더이상 추가할 수 없습니다.");
					continue;
				}
				studList[cnt] = new Stud();
				studList[cnt].name = student;
				cnt++;
			}
			else if (sel == 2) {
				for (int i = 0; i < cnt; i++) {
					System.out.println("[" + (i+1) + "]" + studList[i].name);
				}
				System.out.print("학생 선택해주세요 : ");
				int num = scan.nextInt()-1 ;
				if (num < 0 && num > 2) {
					System.out.println("잘못입력하셨습니다.");
					continue;
				}
				else {
					System.out.print("과목을 입력해주세요  : ");
					String sub = scan.next();
					if (studList[num].subjects == null) {
						studList[num].subjects = new Subj[1];
						studList[num].subjects[0] = new Subj();
						studList[num].subjects[0].name = sub;
					}
					else {
						int tmp = studList[num].subjects.length;
						Subj[]temp = studList[num].subjects;
						studList[num].subjects = new Subj[tmp +1];
						for (int i = 0; i < tmp; i++) {
							studList[num].subjects[i] = temp[i];
						}
						studList[num].subjects[tmp] = new Subj();
						studList[num].subjects[tmp].name = sub;
					}
				}
			}
			else if (sel == 3) {
				for (int i = 0; i < cnt; i++) {
					System.out.println("[" + (i+1) + "]" + studList[i].name);
				}
				System.out.print("학생 선택해주세요 : ");
				int num = scan.nextInt()-1 ;
				if (num < 0 && num > 2) { 
					System.out.println("잘못입력하셨습니다.");
					continue;
				}
				else {
					for (int i = 0; i < studList[num].subjects.length; i++) {
						System.out.println("[" + (i+1) + "]" + studList[num].subjects[i].name);
						}
					}
					System.out.print("과목을 선택해주세요 : ");
					int subNum = scan.nextInt()-1;
					if (subNum < 0 && subNum > 2) {
						System.out.println("잘못입력하셨습니다.");
						continue;
					}
					else {
						System.out.print("성적을 입력해주세요 : ");
						int score = scan.nextInt();
						studList[num].subjects[subNum].score = score; 
					}
				}
			else if (sel == 4) {
				break;
			}
		}
	}
}
