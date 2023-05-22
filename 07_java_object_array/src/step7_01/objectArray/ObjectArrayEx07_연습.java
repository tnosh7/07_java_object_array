package step7_01.objectArray;

//# 클래스 배열 응용

class Subject{
	
	String name;
	int score;
	
}


class Student{
	
	Subject[] subjects;	// Subject 객체를 담을 클래스 배열 
	String name;
	
}


public class ObjectArrayEx07_연습 {

	public static void main(String[] args) {

		Student[] studentList = new Student[4];
		
		studentList[0] = new Student();			 // student클래스와 링크 연결
		studentList[0].name = "학생0";			
		studentList[0].subjects = new Subject[3];// student클래스의 subject배열을  subject클래스에 링크연결
													
		for (int i = 0; i < 3; i++) {
			studentList[0].subjects[i] = new Subject();	//subject배열 인덱스에 링크 연결 
			studentList[0].subjects[i].name = "학생0 과목" + i;	
			studentList[0].subjects[i].score = 100;
		}
		
		studentList[1] = new Student();
		studentList[1].name = "학생1";
		studentList[1].subjects = new Subject[2];		//subject배열 길이 2 //맨 처음만 길이 선언
		studentList[1].subjects[0] = new Subject();		//
		studentList[1].subjects[0].name = "학생1 과목0";
		studentList[1].subjects[0].score = 100;
		
		studentList[1].subjects[1] = new Subject();		//같은 배열에도 인덱스마다 new클래스 선언할것.
		studentList[1].subjects[1].name = "학생1 과목1";
		studentList[1].subjects[1].score = 100;			
		
		studentList[2] = new Student();
		studentList[2].name = "학생2";
		studentList[2].subjects = new Subject[1];
		studentList[2].subjects[0] = new Subject();
		studentList[2].subjects[0].name = "학생2 과목1";
		studentList[2].subjects[0].score = 100;
		
		studentList[3] = new Student();
		studentList[3].name = "닥터페퍼";
		studentList[3].subjects = new Subject[2];
		studentList[3].subjects[0] = new Subject();
		studentList[3].subjects[0].name = "페퍼코딩1";
		studentList[3].subjects[0].score = 10;
		
		studentList[3].subjects[1] = new Subject();
		studentList[3].subjects[1].name = "트레비";
		studentList[3].subjects[1].score = 70;
		
		for (int i = 0; i < studentList.length; i++) {
			System.out.println("--- " + studentList[i].name + " ---");
			for (int j = 0; j < studentList[i].subjects.length; j++) {
				System.out.println(studentList[i].subjects[j].name  + " / " + studentList[i].subjects[j].score);
			}
			System.out.println();
		}
		
	}

}
