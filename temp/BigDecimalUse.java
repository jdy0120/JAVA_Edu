import java.math.*;

class BigDecimalUse{
	public static void main(String[] args) {
		double d1 = 1.6;
		double d2 = 0.1;
		System.out.println("���� ��� : " + (d1 + d2));
		//���� ��� : 1.7000000000000002
		System.out.println("���� ��� : " + (d1 * d2));
		//���� ��� : 0.16000000000000003
		//�Ǽ��� ǥ���� ��Ȯ�� ���� ǥ���� ������ ������ �α� ������ ������ ��Ȯ���� ����

		BigDecimal bd1 = new BigDecimal(1.6);
		BigDecimal bd2 = new BigDecimal(0.1);
		// BigDecimal �ν��Ͻ� ������ �Ǽ��� ���� �Է��Ͽ� ������ ����� ��
		System.out.println("���� ��� : " + bd1.add(bd2));
		//���� ��� : 1.7000000000000000943689570931383059360086917877197265625...
		System.out.println("���� ��� : " + bd1.multiply(bd2));
		//���� ��� : 0.1600000000000000177635683940025051398161724525855033823...

		BigDecimal bd3 = new BigDecimal("1.6");
		BigDecimal bd4 = new BigDecimal("0.1");
		// BigDecimal �ν��Ͻ��� ���ڿ��� ��Ȯ�� �Ǽ��� �Է��� �� �����ؾ� ��
		System.out.println("���� ��� : " + bd3.add(bd4));
		//���� ��� : 1.7
		System.out.println("���� ��� : " + bd3.multiply(bd4));
		//���� ��� : 0.16
	}
}
