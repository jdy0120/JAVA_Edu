class NumberEx {
	int num = 0; // �������
	public void addNum(int n) { num += n; }
	public int getNum() { return num; }
}

class InstanceEx{
	static int num2 = 0;
	public static void main(String[] args) {
		NumberEx inst;
		// NumberEx �� �ν��Ͻ� inst�� ����(�޸� �� ��ġ�� ���� �ּҸ� ����)
		// �ν��Ͻ��� Ư���� �뷮�� ��Ȯ�ϰ� �� �� �����Ƿ� �̸� ������ Ȯ�������� ����
		inst = new NumberEx(); // new : �ν��Ͻ� ���� ��ɾ�
		// inst��� �̸��� NumberEx�� �ν��Ͻ��� ������Ŵ

		System.out.println("�޼ҵ� ȣ�� �� : " + inst.getNum());
		// inst.getNum() : inst ���� getNum()�޼ҵ� ȣ��

		testMethod(inst);
		// testMethod()�� ȣ���ϸ� inst�� �Ű������� ������
		// �ν��Ͻ��� �Ű������� ����� �� ����
		// �ν��Ͻ��� �Ű������� ����ϸ� �ν��Ͻ��� �ּҰ� ���� ���� �ν��Ͻ��� �۾��ϰ� ��
		System.out.println("�޼ҵ� ȣ�� �� : " + inst.getNum()); // 12

		testMethod2(num2);
		// �ν��Ͻ��� �ƴ� �Ϲ� ������ �Ű������� ������ �� ���� �Ѿ�� ��
		System.out.println("���� ��� �� : " + num2); // 0
	}
	public static void testMethod(NumberEx numb){
	// �ν��Ͻ��� �Ű������� ������ �� �ν��Ͻ��� �ּҸ� �޾ƿ��Ƿ�
	// �ּҿ� �ش��ϴ� �ν��Ͻ��� ������ �۾��ϰ� ��
		numb.addNum(12);
		// numb ���� addNum()�޼ҵ� ����
	}
	public static void testMethod2(int n){
		n += 20;
	}
}
/*
�Ű������� �ν��Ͻ��� ������ ���� ����� ��� ������
 - ���� : ������ ���� �Ѿ�� �Ǿ� �� ���� �̿��� ���� �۾��� �� �� ������ ���� ������ ���� ������ ����
 - �ν��Ͻ� : �ν��Ͻ��� �ּҰ��� �Ѿ�� �Ǿ� �� �ּ��� �ν��Ͻ��� �״�� ����� �� ������, ���� �۾��� �ϰ� �Ǹ� ���� �ν��Ͻ����� �� ������ ��ġ�� ��
*/