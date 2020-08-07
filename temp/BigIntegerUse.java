import java.math.*;

class BigIntegerUse{
	public static void main(String[] args) {

		System.out.println("ÃÖ´ë Á¤¼ö : " + Long.MAX_VALUE);  
        System.out.println("ÃÖ¼Ò Á¤¼ö : " + Long.MIN_VALUE);

		BigInteger big1 = new BigInteger("10000000000000000000");
		BigInteger big2 = new BigInteger("-9999999999999999999");
		
		BigInteger plus = big1.add(big2);
		BigInteger mul = big1.multiply(big2);
		BigInteger minus = big1.subtract(big2);

		System.out.println("µ¡¼À : " + plus);
		System.out.println("°ö¼À : " + mul);
		System.out.println("»¬¼À : " + minus);
        
	}
}
