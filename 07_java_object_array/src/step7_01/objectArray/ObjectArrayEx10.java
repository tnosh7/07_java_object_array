package step7_01.objectArray;

import java.util.ArrayList;
import java.util.Arrays;

/*
 *
 *  [ java.util.ArrayList ]
 *  
 *	 - 배열은 한번 선언하면 프로그램에서 배열의 크기를 바꿀 수 없다.
 * 	 - ArrayList 클래스는 데이터가 입력되면 자동으로 크기가 커지고 데이터가 삭제되면 자동으로 크기가 작아진다.
 *   - 중간에 데이터가 삽입되면 데이터가 삽입될 위치부터 모든 데이터가 뒤로 이동되고 중간의 데이터가 제거된 다음 위치부터 모든 데이터가 앞으로 이동한다.
 *   
 *   [ ArrayList 생성 방법 ]
 * 
 *   ArrayList<Integer> list = new ArrayList<Integer>();     
 *   ArrayList<Integer> list = new ArrayList<>();           // 우변의 제네릭의 데이터형은 생략 가능하다.
 *   ArrayList<String> list = new ArrayList<String>();
 *   ArrayList<Product> list = new ArrayList<Product>();
 *   ArrayList<Member> list = new ArrayList<Member>();
 *   
 *   
 *   
 *   * [ 래퍼 클래스(wrapper class) ]
 * 
 * 	- 래퍼 클래스란 기본 자료형을 클래스로 만들어 놓은 것을 의미한다.
 *   [기본형]          [래퍼 클래스]
 *    byte              Byte
 *    short             Short
 *    int              Integer
 *    long              Long
 *    float             Float
 *    double            Double
 *    char              Character
 *    boolean           Boolean
 *
 *
 *
 *  [ 제네릭 ]
 *  
 * - 제네릭(generic)이라 부르며 ArrayList에 저장될 데이터 타입을 반드시 클래스로 작성한다.
 * - 기본 자료형 데이터를 저장하는 ArrayList를 만들어야 하는 경우에는 래퍼 클래스를 사용한다.
 *   
 *   
 */

public class ObjectArrayEx10 {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		ArrayList<Integer> list = new ArrayList<Integer>(); 
			
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("list : " + list);
		System.out.println("\n==================\n");
		
		// add(value) : arrayList의 맨뒤에 value를 추가한다.
		// add(index,value) : arrayList의 index번째에 value를 추가한다.
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30; 
		arr[3] = 40;
		arr[4] = 50;
		
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(2 , 30);
		list.add(50);
		
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("list : " + list);
		System.out.println("\n==================\n");
		
		// size() : arrayList의 데이터의 개수를 반환한다.
		System.out.println("arr 크기 : " + arr.length);
		System.out.println("list 크기 : " + list.size());
		System.out.println("\n==================\n");
		
		// set(index,value) : ArrayList의 index번째의 값을 value값으로 수정한다.
		arr[0] = 1000;
		arr[1] = 2000;
		arr[2] = 3000;
		
		list.set(0, 1000);
		list.set(1, 2000);
		list.set(2, 3000);
		
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("list : " + list);
		System.out.println("\n==================\n");
		
		// remove(index) : ArrayList의 index번째 위치의 값을 삭제한다.
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 0;
		
		list.remove(2);
		list.remove(1);
		list.remove(0);
		
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("list : " + list);
		System.out.println("\n==================\n");
	
		// get(index) : ArrayList의 index번째의 value를 얻어온다. 
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("\n");
		
		arr = null;
		list.clear(); // ArrayList의 데이터만 삭제
		//list.add(1000);
		
		list = null;  // ArrayList 자체를 삭제
		//list = new ArrayList<Integer>();
		//list.add(1000);
		
	}

}
