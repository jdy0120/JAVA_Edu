import java.math.*;

class BigIntegerUse{
	public static void main(String[] args) {

		System.out.println("�ִ� ���� : " + Long.MAX_VALUE);  
        System.out.println("�ּ� ���� : " + Long.MIN_VALUE);

		BigInteger big1 = new BigInteger("10000000000000000000");
		BigInteger big2 = new BigInteger("-9999999999999999999");
		
		BigInteger plus = big1.add(big2);
		BigInteger mul = big1.multiply(big2);
		BigInteger minus = big1.subtract(big2);

		System.out.println("���� : " + plus);
		System.out.println("���� : " + mul);
		System.out.println("���� : " + minus);
        
	}
}
