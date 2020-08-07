class BoxingUnboxing{
	public static void main(String[] args) {
		Integer iValue = new Integer(10);
		Double dValue = new Double(3.14);
		// �⺻�ڷ��� �����͸� WrapperŬ������ �̿��Ͽ� ��ü�� ���� : boxing
		System.out.println(iValue); // 10
		System.out.println(dValue); // 3.14
		// WrapperŬ������ �ν��Ͻ��� ��½� �����͸� �״�� �����
        
		int n1 = iValue.intValue();
		double n2 = dValue.doubleValue();
		// ��ü�� �⺻�ڷ��� �����ͷ� ��ȯ : unboxing
		System.out.println(n1);
        System.out.println(n2);
	}
}
