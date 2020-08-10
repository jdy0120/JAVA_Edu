import java.util.*;

class ArraylistEx1{
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
		// 크기가 10인 ArrayList의 인스턴스 list1을 선언 및 생성
		list1.add(new Integer(5));	list1.add(new Integer(4));
		list1.add(new Integer(2));	list1.add(new Integer(0));
		list1.add(new Integer(1));	list1.add(new Integer(3));
		// list1에 정수 객체를 차례대로 저장 
		// 컬렉션에는 Object형으로 저장해야 하므로 Wrapper클래스 사용
		// 단, 기본자료형 데이터를 직접 넣어도 상관없음
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		// list1dml 1번 부터 4-1까지의 인덱스로 잘라 list2로 Arraylist 생성
		print(list1,list2);
		/*
		list1 : [5, 4, 2, 0, 1, 3]
		list2 : [4, 2, 0]
		*/
		Collections.sort(list1);	Collections.sort(list2);
		// Collections클래스의 sort()메소드를 이용하여 리스트내의ㅏ 데이터들을 오름차순 정렬 시킴
		print(list1,list2);
		/*
		list1 : [0, 1, 2, 3, 4, 5]
		list2 : [0, 2, 4]
		*/
		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));
		//list1.containsAll(list2) : true
		//list1안에 list2의 데이터가 모두 포함되어 있는 지 여부
		list2.add("B");	list2.add("C");	
		// list2의 마지막 위치에 새로운 데이터(객체)들을 추가
		list2.add(3,"A");
		// list2의 3번 인덱스 위치에 "A"를 추가(기존의 데이터는 뒤로 밀림)
		print(list1,list2);
		
		/*
		list1 : [0, 1, 2, 3, 4, 5]
		list2 : [0, 2, 4, A, B, C]
		*/

		list2.set(3,"AA");	print(list1,list2);
		// list2의 3번 인덱스 위치에 "AA"를 추가(기존의 데이터는 삭제됨)

		/*
		list1 : [0, 1, 2, 3, 4, 5]
		list2 : [0, 2, 4, AA, B, C]
		*/
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
		//list1.retainAll(list2) : true
		// list1에서 list2와 동일한 데이터를 제외한 나머지를 모두 삭제
		print(list1,list2);
		/*
		list1 : [0, 2, 4]
		list2 : [0, 2, 4, AA, B, C]
		*/
		list2.removeAll(list1);
		print(list1,list2);
		/*
		list1 : [0, 2, 4]
		list2 : [AA, B, C]
		*/
	}	
	public static void print(ArrayList list1,ArrayList list2){
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println();
	}
}
