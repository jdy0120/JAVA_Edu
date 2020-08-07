class SimpleMath{
	public static final double PI = 3.1415;
	public static double add(double n1, double n2) {return n1+n2;}
	public static double min(double n1, double n2) {return n1-n2;}
	public static double mul(double n1, double n2) {return n1*n2;}
}

class AreaMath{
	public double calCircleArea(double rad) {
		double result = SimpleMath.mul(rad, rad);
		result = SimpleMath.mul(result, SimpleMath.PI);
		return result;
	}
	public double calRectArea(double width, double height){
		return SimpleMath.mul(width,height);
	}
}

class PeriMath{
	public double calCirclePeri(double rad) {
		double result = SimpleMath.mul(rad, 2);
		result = SimpleMath.mul(result, SimpleMath.PI);
		return result;
	}
	public double calRectPeri(double width, double height){
		return SimpleMath.add(SimpleMath.mul(width,2), SimpleMath.mul(height, 2));
	}
	public double calRectPeri(double width, double height){
		Simple
	}
}

class ClassMethod2 {
	public static void main(String[] args) {
		AreaMath am = new AreaMath();
		PeriMath pm = new PeriMath();

		System.out.println("원의 넓이 : " + am.calCircleArea(2.4));
		System.out.println("사각형의 둘레 : " + pm.calRectPeri(2.0,4.0));
	}
}
