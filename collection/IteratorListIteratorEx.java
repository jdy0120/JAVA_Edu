import java.util.*;

class IteratorListIteratorEx{
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("1");		list.add("2");		list.add("3");
		list.add("4");		list.add("5");		list.add("6");

		ListIterator it = list.listIterator();
		while (it.hasNext()){	// ���� ��Ұ� ������
			Object obj = it.next();	// ���� ��Ҹ� �����Ͽ� Object�� �ν��Ͻ��� ����
			System.out.print(obj + " ");
		}
		System.out.println();
		while (it.hasPrevious()){
			Object obj = it.previous();
			System.out.print(obj + " ");
		}

		System.out.println("\n");

		// ListIterator�� �̿��Ͽ� ������� ���������� ���� �����͸� ���
	}
}
