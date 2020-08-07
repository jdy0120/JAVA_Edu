class OpLogical {
	public static void main(String[] args) {
		int n1 = 0, n2 = 0;
		boolean result;

		result = (n1 += 10) < 0 && (n2 += 10) > 0;
		// &&������ ��� �տ��� ������ �߻��ϸ� �� �� ���ǵ��� �˻����� ����
		System.out.println("result : " + result); // false
		System.out.println("n1 : " + n1 + ", n2 : " + n2);
		// n1 : 10, n2 : 0


		result = (n1 += 10) > 0 || (n2 += 10) > 0;
		// ||������ ��� �տ��� ���� �߻��ϸ� �� �� ���ǵ��� �˻����� ����
		System.out.println("result : " + result); // true
		System.out.println("n1 : " + n1 + ", n2 : " + n2);
		// n1 : 20, n2 : 0

		// ���� ���ο����� ������ ���� �����ϴ� ���� ����� ���� �ʾƾ� ��
		// ���� �����Ϸ���, ���� ���ΰ� �ƴ� �ܺο��� �����ؾ� ��
		n1 = 0;
		n2 = 0;

		n1 += 10; n2 += 10;
		result = n1 < 0 && n2 > 0;
		System.out.println("result : " + result);
		System.out.println("n1 : " + n1 + ", n2 : " + n2);
		// n1 : 10, n2 : 10

		n1 += 10; n2 += 10;
		result = n1 > 0 || n2 > 0;
		System.out.println("result : " + result);
		System.out.println("n1 : " + n1 + ", n2 : " + n2);
		// n1 : 20, n2 : 20

	}
}