class ArrayEx1{
	public static void main(String[] args) {
		int[] arrInt = new int[3]; // 3���� int�� �����͸� ������ �� �ִ� int�� �迭 ����

		arrInt[0] = 10;	arrInt[1] = 35;	arrInt[2] = 23;
		//�ε��� ��ȣ�� �̿��Ͽ� �迭�� �� ĭ�� �����͸� ����
		
		System.out.println("arrInt�� �� �� : " + (arrInt[0] + arrInt[1] + arrInt[2]));

		String[] arrStr = new String[3];
		arrStr[0] = "abc";	arrStr[1] = "DEF";	arrStr[2] = "ghi";
		for (int i = 0; i < arrStr.length ; i++ ){
		// arrStr.length : arrStr�迭�� ũ��
			System.out.println(arrStr[i]);
		}

		for (int i = 2; i >=0 ;i-- ){
			System.out.println(arrStr[i]);
		}
		
		// �迭���� �����Ϳ��� �ι�° ���ڸ� ���
		for (int i = 0; i < arrStr.length; i++ ){
			System.out.println(arrStr[i].charAt(1));
		}

		int[] arrInt2 = {2,4,6,8};
		// 2,4,6,8�� ���� ������ arrInt2 �迭 ����
		int sum = 0;
		for (int i = 0; i < arrInt2.length ; i++ ) {
			sum += arrInt2[i];
		}
	}
}
