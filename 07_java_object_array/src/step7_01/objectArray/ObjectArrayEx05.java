package step7_01.objectArray;


class Client {
	
	String id;
	String passwd;
	String name;
	String birth;
	int age;
	String contact;
	String address;
	
	void setData(String id, String passwd, String name, String birth, int age, String contact, String address) { 
		
		this.id = id; 			// 파라메타로 전달된 데이터를 필드에 대입
		this.passwd = passwd;	// 파라메타로 전달된 데이터를 필드에 대입
		this.name = name;		// 파라메타로 전달된 데이터를 필드에 대입
		this.birth = birth;		// 파라메타로 전달된 데이터를 필드에 대입
		this.age = age;			// 파라메타로 전달된 데이터를 필드에 대입
		this.contact = contact; // 파라메타로 전달된 데이터를 필드에 대입
		this.address = address; // 파라메타로 전달된 데이터를 필드에 대입
		
	}
	
	void printData() {
		System.out.println(this.id + "/ " +this.passwd + "/ " +this.name + "/ " +this.birth + "/ " +this.age + "/ " +this.contact + "/ " +this.address );
	}
}


public class ObjectArrayEx05 {

	public static void main(String[] args) {
		
		Client[] clientList = new Client[3];
		for (int i = 0; i < clientList.length; i++) {
			clientList[i] = new Client();
		}
		// before 
		clientList[0].id = "user1";
		clientList[0].passwd = "1111";
		clientList[0].name = "사용자1";
		clientList[0].birth = "1990-01-01";
		clientList[0].age = 34;
		clientList[0].contact = "010-1111-2222";
		clientList[0].address = "서울";
		
		
		// after 
		clientList[1].setData( "트레비1", "2222","차은숙1", "2000-01-01", 24, "010-9999-8888", "강남");
		clientList[2].setData( "트레비2", "3333","차은숙2", "2010-01-01", 14, "010-5555-6666", "인천");
		
		// test 
		clientList[0].printData();
		clientList[1].printData();
		clientList[2].printData();
		
	}

}
