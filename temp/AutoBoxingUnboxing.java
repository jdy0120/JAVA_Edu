class AutoBoxingUnboxing{
	public static void main(String[] args) {
		Integer iValue = 10;
		Double dValue = 3.14;
		// WrapperŬ������ �����ڸ� �̿����� �ʰ� �����͸� ���� �־ ��ü�� ������
		// auto boxing
		System.out.println(iValue); 
		System.out.println(dValue);
        
		int n1 = iValue.intValue();
		double n2 = dValue.doubleValue();
		// ������ ��ü�� �ٷ� �־ �������� ���۵� : auto unboxing
		System.out.println(n1);
        System.out.println(n2);
	}
}
