class IfEx2{
	public static void main(String[] args) {
		int num = 120;

		if (num < 0){
			System.out.println("Hello World!");
		}else{	// num�� 0���� ũ�ų� ������
			// ���� if���� ���� else���� ������ ���� ���·� �����ϰ� ��
			if (num < 100){
			// num�� 100���� ������(else�� ������ 0�̻��� ���Ե� ����)
				System.out.println("0�̻� 100 �̸�");
			} else{
				System.out.println("100 �̻�");
			}
		}
	}
}
