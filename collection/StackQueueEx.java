import java.util.*;

class StackQueueEx{
	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList();
		// LinkedList가 아닌 Queue로서 생성이 되며, Queue의 기능들만 사용하게 됨
		// Queue가 LinkedList의 상위클래스(실제로는 인터페이스) 개념이므로
		// JVM이 q를 LinkedList가 아닌 Queue 형 인스턴스로 인식

		st.push("0");		st.push("1");		st.push("2");
		// 스택 st에 세 개의 객체를 저장
		
		q.offer("0");		q.offer("1");		q.offer("2");
		// 큐 q에 세 개의 객체를 저장
		
		System.out.println("=== Stack ===");
		while (!st.empty()){
			System.out.println(st.pop());
		}

		System.out.println("=== Queue ===");
		while (!q.empty()){
			System.out.println(q.poll());
		}
	}
}
