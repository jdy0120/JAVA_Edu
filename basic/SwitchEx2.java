class SwitchEx2{
	public static void main(String[] args) {
		// 정수(score)를 이용하여 학점을 출력
		int score = 88;
		if (score >= 90)
		{
			System.out.println("A");
		} else if (score >= 80)
		{
			System.out.println("B");
		} else if (score >= 70)
		{
			System.out.println("C");
		} else if (score >= 60)
		{
			System.out.println("D");
		} else{
			System.out.println("F");
		}


		switch (score/10)
		{
		case 10: case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
		}
		// num의 값을 10단위로 끊어 '0이상 10미만', '10이상 20미만',
		// '20이상 30미만', '30이상' 으로 출력
		int num = 10;
		switch ((num-1)/10)
		{
		case 0:
			System.out.println("1이상 10이하");
			break;
		case 1: 
			System.out.println("11이상 20이하");
			break;
		case 2:
			System.out.println("21이상 30이하");
			break;
		default:
			System.out.println("31이상");
		}
	}
}