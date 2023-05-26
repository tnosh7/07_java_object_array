package step7_01.objectArray;

import java.util.ArrayList;
import java.util.Arrays;

// MyArrayList 만들기
class MyArrayList {

	int[] arr;
	int elementCnt;

	void print() {
		
		System.out.println(Arrays.toString(arr));
		
	}

	
	void add(int value) {
		
		if (elementCnt == 0) {
			arr = new int[elementCnt + 1];
		} 
		else if (elementCnt > 0) {
			int[] temp = arr;
			arr = new int[elementCnt + 1];

			for (int i = 0; i < elementCnt; i++) {
				arr[i] = temp[i];
			}
			temp = null;
		}

		arr[elementCnt] = value;
		elementCnt++;
		
	}

	
	void add(int index, int value) {
		
		if (elementCnt == 0) {
			arr = new int[elementCnt + 1];
		} 
		else if (elementCnt > 0) {
			int[] temp = arr;
			arr = new int[elementCnt + 1];

			int j = 0;
			for (int i = 0; i < elementCnt + 1; i++) {
				if (i != index) {
					arr[i] = temp[j++];
				}
			}
			temp = null;
		}

		arr[index] = value;
		elementCnt++;
		
	}

	
	void remove(int index) {
		
		if (elementCnt == 1) {
			arr = null;
		} 
		else if (elementCnt > 1) {
			int[] temp = arr;
			arr = new int[elementCnt - 1];

			int j = 0;
			for (int i = 0; i < elementCnt; i++) {
				if (i != index) {
					arr[j++] = temp[i];
				}
			}
			temp = null;
		}
		elementCnt--;
		
	}

	
	int size() {
		return elementCnt;
	}

	
	int get(int index) {
		return arr[index];
	}

	
	void set(int index, int value) {
		arr[index] = value;
	}

	
	void clear() {
		arr = null;
		elementCnt = 0;
	}

}


public class ObjectArrayEx14_연습 {

	public static void main(String[] args) {

		// [ ArrayList 사용 ] 
		ArrayList<Integer> list = new ArrayList<Integer>();

		// 추가하기
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println(list);
		
		// 삽입하기
		list.add(0, 19);
		// 출력하기
		System.out.println(list);

		// (index로)삭제하기
		list.remove(3);
		System.out.println(list);

		// 길이 구하기
		int elementCnt = list.size();
		System.out.println("elementCnt = " + elementCnt);

		// (index로)값 꺼내오기
		System.out.print("[");
		for (int i = 0; i < elementCnt; i++) {
			System.out.print(list.get(i));
			if (i != elementCnt - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");

		// 특정 위치의 값 수정하기
		list.set(3, 5);
		System.out.println(list);
		//set을 이용해 정렬하기
		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j < list.size(); j++) {
				if (list.get(i)> list.get(j) ) {
					int tmp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, tmp);
				}
			}
		}
		System.out.println(list);
		// 모든 데이터를 제거하기
		list.clear();
		System.out.println(list.size());

		
		
		
		System.out.println("\n========================================\n");
		
		
		
		
		// [ 직접 구현한 ArrayList ] 
		MyArrayList myList = new MyArrayList();

		// 추가하기
		myList.add(10);
		myList.add(20);
		myList.add(30);
		myList.add(40);
		myList.add(50);
		myList.print();
		
		// 삽입하기
		myList.add(0, 9);
		// 출력하기
		myList.print();

		// (index로)삭제하기
		myList.remove(3);
		myList.print();

		// 길이 구하기
		int elementCount = myList.size();
		System.out.println("elementCnt = " + elementCount);

		// (index로)값 꺼내오기
		System.out.print("[");
		for (int i = 0; i < elementCount; i++) {
			System.out.print(myList.get(i));
			if (i != elementCount - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");

		// 특정 위치의 값 수정하기
		myList.set(3, 5);
		myList.print();

		// 모든 데이터를 제거하기
		myList.clear();
		System.out.println(myList.size());

	}

}
