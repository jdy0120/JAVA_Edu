import java.util.*;

class ArraylistEx1{
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
		// ũ�Ⱑ 10�� ArrayList�� �ν��Ͻ� list1�� ���� �� ����
		list1.add(new Integer(5));	list1.add(new Integer(4));
		list1.add(new Integer(2));	list1.add(new Integer(0));
		list1.add(new Integer(1));	list1.add(new Integer(3));
		// list1�� ���� ��ü�� ���ʴ�� ���� 
		// �÷��ǿ��� Object������ �����ؾ� �ϹǷ� WrapperŬ���� ���
		// ��, �⺻�ڷ��� �����͸� ���� �־ �������
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		// list1dml 1�� ���� 4-1������ �ε����� �߶� list2�� Arraylist ����
		print(list1,list2);
		/*
		list1 : [5, 4, 2, 0, 1, 3]
		list2 : [4, 2, 0]
		*/
		Collections.sort(list1);	Collections.sort(list2);
		// CollectionsŬ������ sort()�޼ҵ带 �̿��Ͽ� ����Ʈ���Ǥ� �����͵��� �������� ���� ��Ŵ
		print(list1,list2);
		/*
		list1 : [0, 1, 2, 3, 4, 5]
		list2 : [0, 2, 4]
		*/
		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));
		//list1.containsAll(list2) : true
		//list1�ȿ� list2�� �����Ͱ� ��� ���ԵǾ� �ִ� �� ����
		list2.add("B");	list2.add("C");	
		// list2�� ������ ��ġ�� ���ο� ������(��ü)���� �߰�
		list2.add(3,"A");
		// list2�� 3�� �ε��� ��ġ�� "A"�� �߰�(������ �����ʹ� �ڷ� �и�)
		print(list1,list2);
		
		/*
		list1 : [0, 1, 2, 3, 4, 5]
		list2 : [0, 2, 4, A, B, C]
		*/

		list2.set(3,"AA");	print(list1,list2);
		// list2�� 3�� �ε��� ��ġ�� "AA"�� �߰�(������ �����ʹ� ������)

		/*
		list1 : [0, 1, 2, 3, 4, 5]
		list2 : [0, 2, 4, AA, B, C]
		*/
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
		//list1.retainAll(list2) : true
		// list1���� list2�� ������ �����͸� ������ �������� ��� ����
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
