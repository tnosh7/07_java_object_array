package step7_01.objectArray;

import java.util.ArrayList;

/*
 * 
 *  # foreach문
 *  
 *  [ 구조 ]
 *  
 *  for (element type 변수명 : 반복가능한 자료형) {
 *  	명령어;
 *  }
 * 
 *  - for문의 반복횟수 제어가 없다.
 *  - 반복 자료형의 크기만큼 처음부터 끝까지 반복하면서 반복 자료형의 element가 직접 변수에 저장되고 
 *    for문의 몸체{}를 반복하여 실행한다.
 * 
 * */

public class ObjectArrayEx11 {

	public static void main(String[] args) {
		
		// 사용 예시 1)
		int[] arr1 = {10 , 20 , 30 , 40 , 50 , 60 , 70 , 80 , 90 , 100};
		
		for (int num : arr1) {
			System.out.print(num + " ");
		}
		System.out.println("\n");
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println("\n");
		
		System.out.println("\n=====================================\n");
		
		// 사용 예시 2)
		String[] arr2 = {"한놈" , "두시기" , "석삼" , "너구리" , "오징어"};
		for (String idx : arr2) {
			System.out.print(idx + " ");
		}
		System.out.println();
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		
		System.out.println("\n=====================================\n");
		
		// 사용 예시 3)
		ArrayList<Product> productList = new ArrayList<Product>();
		
		//productList[0] = new Product();
		//productList.add(new Product());
		
		// 실습용 데이터 생성
		for (int i = 1; i < 11; i++) {
			Product temp = new Product();
			temp.name = "상품" + i;
			temp.price = 10000 * i;
			productList.add(temp);
		}
		
		System.out.println("productList : " + productList);
		
		for (int i = 0; i < productList.size(); i++) {
			System.out.println("name : " + productList.get(i).name);
			System.out.println("price : " + productList.get(i).price);
			System.out.println();
		}
		
		System.out.println();
		
		for (Product product : productList) {
			System.out.println("name : " + product.name);
			System.out.println("price : " + product.price);
			System.out.println();
		}
		
		
		
		
	}

}
