class BreakContinue{
	public static void main(String[] args) {
		// 100������ ����߿��� 5�� 7�� �ּҰ������ ���Ͽ� ���
		int n = 1;
		boolean search = false; // 5�� 7�� �ּҰ������ ã�Ҵ� �� ���θ� ������ ����
		while (n <= 100){
			if (n%5 == 0 && n%7 == 0){
				search = true;
				break;
				//�ش� �������� ���ǿ� ������� ��������
			}
			n++;
		}
		if (search)
		{
			System.out.println(n);
		}else{
			System.out.println("�ּҰ������ ã�� ���߽��ϴ�.");		
		}

		// 100������ ����߿��� 5�� 7�� ������� �� ������ ���

		int num = 0,count = 0;
		while (num <=100){
			num++;
			if (num%5 != 0 || num%7 != 0){
				continue;
			}

			count++;
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.println("5�� 7�� ����� ���� : " + count);
	}
}
