import java.util.*;

class StackQueueEx{
	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList();
		// LinkedList�� �ƴ� Queue�μ� ������ �Ǹ�, Queue�� ��ɵ鸸 ����ϰ� ��
		// Queue�� LinkedList�� ����Ŭ����(�����δ� �������̽�) �����̹Ƿ�
		// JVM�� q�� LinkedList�� �ƴ� Queue �� �ν��Ͻ��� �ν�

		st.push("0");		st.push("1");		st.push("2");
		// ���� st�� �� ���� ��ü�� ����
		
		q.offer("0");		q.offer("1");		q.offer("2");
		// ť q�� �� ���� ��ü�� ����
		
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
