class ForDupBreak{
	public static void main(String[] args) {
		// i�� j�� �� �� ¦���̸� ����� ����
		outerLoop: // ���̺�μ� �������� ǥ���� �ϴ� ��
		for (int i = 1; i <= 3 ; i++ ){
			for (int j = 1; j <= 3 ; j++ ){
				System.out.println("[" + i + ", " + j + "]");
				if (i%2 == 0 && j%2 == 0){
					break outerLoop;
					// outerLoop��� ���̺��� �� �������� ��������
				}
			}
		}
	}
}