import java.util.*;

class ArrayListLinkedList{
	public static void main(String[] args) {
		ArrayList al1 = new ArrayList(2000000);
		LinkedList ll1 = new LinkedList();

		System.out.println("= 순차적으로 추가하기 =");
		System.out.println("ArrayList : " + add1(al1));
        System.out.println("LinkedList : " + add1(ll1));
		System.out.println();
		System.out.println("= 중간에 추가하기 =");
		System.out.println("ArrayList : " + add2(al1));
        System.out.println("LinkedList : " + add2(ll1));
		System.out.println();
		System.out.println("= 중간에서 삭제하기 =");
		System.out.println("ArrayList : " + remove2(al1));
        System.out.println("LinkedList : " + remove2(ll1));
		System.out.println();
		System.out.println("= 순차적으로 삭제하기 =");
		System.out.println("ArrayList : " + remove1(al1));
        System.out.println("LinkedList : " + remove1(ll1));
		System.out.println();

        // 중간에 작업하는 것까지 보면 LinkedList가 ArrayList보다 전체적으로 빠름
		// 단, 거의 대부분의 작업이 순차적으로 이루어지기 대문에 ArrayList가 더 많이 사용됨
		// 중간에 하는 작업이 많을 경우 LinkedList호 작업하다가, 중간 작업이 끝나면 다시 ArrayList로
		// 변환하여 작업하는 경우도 있다.
	}
	public static long add1(List list){
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000 ; i++ ){
			list.add(i+"");
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	public static long add2(List list){
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000 ; i++ ){
			list.add(500,"X");
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	public static long remove1(List list){
		long start = System.currentTimeMillis();
		for (int i = list.size()-1; i >= 0 ; i-- ){
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	public static long remove2(List list){
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000 ; i++ ){
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
}
