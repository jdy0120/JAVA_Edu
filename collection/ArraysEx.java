import java.util.*;

class ArraysEx{
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4};
		int[][] arr2D = {{11,12,13},{21,22,23}};

		System.out.println("arr : " + Arrays.toString(arr));
		//arr : [0, 1, 2, 3, 4]
		System.out.println("arr2D : " + Arrays.deepToString(arr2D));
		//arr2D : [[11, 12, 13], [21, 22, 23]]
		//deepToString() : 2���� �迭 ���� toSring()�޼ҵ�

		int[] arr2 = Arrays.copyOf(arr,arr.length);
		int[] arr3 = Arrays.copyOf(arr,3);
		int[] arr4 = Arrays.copyOf(arr,7);
		// copyOf() : ���� �迭�� �����Ͽ� ���ο� �迭�� ������Ŵ
		// �ι�° �μ��� �ε�����ȣ�� �ƴ� ������ ����� ����
		// �ι�° �μ��� ���� �迭�� ���̸� ������ �Ѿ� �� ��ŭ �� �迭�� ĭ�� ����� �⺻���� ä��

		int[] arr5 = Arrays.copyOfRange(arr,2,4);
		int[] arr6 = Arrays.copyOfRange(arr,0,7);
		// copyOfRange() : ���� �迭�� Ư�� �κ��� �����Ͽ� ���ο� �迭�� ������Ŵ
		// �ι�° �μ� �ε��� ���� ������ �μ� - 1 �ε������� ������ ����
		// ����° �μ��� ���� �迭�� ���̸� ������ �Ѿ� �� ��ŭ �� �迭�� ĭ�� ����� �⺻���� ä��
		
		System.out.println("arr2 : " + Arrays.toString(arr2));
		//arr2 : [0, 1, 2, 3, 4]
		System.out.println("arr3 : " + Arrays.toString(arr3));
		//arr3 : [0, 1, 2]
		System.out.println("arr4 : " + Arrays.toString(arr4));
		//arr4 : [0, 1, 2, 3, 4, 0, 0]
		System.out.println("arr5 : " + Arrays.toString(arr5));
		//arr5 : [2, 3]
		System.out.println("arr6 : " + Arrays.toString(arr6));
		//arr6 : [0, 1, 2, 3, 4, 0, 0]

		int[] arr7 = new int[5];
		Arrays.fill(arr7,9);
		// fill() : �迭�� ������ ��(�ι�° �μ�)�� ���
		System.out.println("arr7 : " + Arrays.toString(arr7));
		//arr7 : [9, 9, 9, 9, 9]

		char[] chArr = {'A','D','C','B','E'};
		System.out.println("chArr : " + Arrays.toString(chArr));
		//chArr : [A, D, C, B, E]
		System.out.println("index of 'B' : " + Arrays.binarySearch(chArr,'B'));
		//index of 'B' : -2
		System.out.println("= Ater sorting = ");
		Arrays.sort(chArr);
		//������ �迭�� ������������ ���Ľ�Ŵ
		System.out.println("chArr : " + Arrays.toString(chArr));
		//chArr : [A, B, C, D, E]
		System.out.println("index of 'B' : " + Arrays.binarySearch(chArr,'B'));
		//index of 'B' : 1

	}
}
