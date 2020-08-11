import java.util.*;

class IteratorListIteratorEx{
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("1");		list.add("2");		list.add("3");
		list.add("4");		list.add("5");		list.add("6");

		ListIterator it = list.listIterator();
		while (it.hasNext()){	// 다음 요소가 잇으면
			Object obj = it.next();	// 다음 요소를 추출하여 Object형 인스턴스로 생성
			System.out.print(obj + " ");
		}
		System.out.println();
		while (it.hasPrevious()){
			Object obj = it.previous();
			System.out.print(obj + " ");
		}

		System.out.println("\n");

		// ListIterator를 이용하여 순방향과 역방향으로 각각 데이터를 출력
	}
}
