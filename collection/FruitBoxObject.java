class Orange{
	int sugar;
	public Orange(int s) {sugar = s;}
	public void showSugar() { System.out.println("당도 : " + sugar); }
}


class OrangeBox{// 모든 종류의 과일을 담는 클래스
	Orange item;
	// Object로 선언하였기 때문에 어떠한 종류의 데이터도 담을 수 있음
	public void store(Orange item) { this.item = item; }
	public Orange pullOut() { return item; }
}

class FruitBoxObject2{
	public static void main(String[] args) {
		OrangeBox fBox1 = new OrangeBox();
		fBox1.store(new Orange(10));
		// Orange클래스의 인스턴스를 생성하여 store()메소드의 매개변수로 가져감
		Orange org1 = (Orange)fBox1.pullOut();
		org1.showSugar();
		
		OrangeBox fBox2 = new OrangeBox();
		fBox2.store(new String("오렌지"));
		Orange org2 = (Orange)fBox1.pullOut();
		// fBox2에 들어있는 객체는 String이므로 Orange로 형변환이 불가
		// fBox2에 들어있는 객체는 String이므로 Orange로 형변환이 불가
		org2.showSugar();
	}
}


/*
문제점
 - store()메소드를 통해 Orange가 아닌 String의 인스턴스가 저장이 됨
 - 형변환이 불가능한 코드에서 컴파일시 error가 나지 않고 실행시 exception이 발생

해결책
 - 정확한 자료형의 인스턴스만 받을 수 잇게 작업해야 함
    잘못된 자료형의 인스턴스가 들어오면 예외가 아닌 에러가 발생하게 해야 함
*/