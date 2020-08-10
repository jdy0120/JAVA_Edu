class Orange{
	int sugar;
	public Orange(int s) {sugar = s;}
	public void showSugar() { System.out.println("당도 : " + sugar); }
}


class OrangeBox{
	Orange item;
	public void store(Orange item) { this.item = item; }
	public Orange pullOut() { return item; }
}

class Apple{
	int weight;
	public Apple(int weight) { this.weight = weight; }
	public void showWeight() { System.out.println("무제 : " + weight); }
}

class FruitBox<T>{
// <T> : FruitBox클래스에서 T로 지정된 모든 자료형은 Object처럼 사용할 수 잇음
// 단, 인스턴스 생성시 지정해 주는 자료형으로 사용됨
	T item;
	public void store(T item) {this.item = item;}
	public T pullOut() {return item;}
}

class FruitBoxGeneric{
	public static void main(String[] args) {
		FruitBox<Orange> fBox1 = new FruitBox<Orange>();
		// FruitBox<Orange> : FruitBox 형 인스턴스 생성시 제네릭을 지정한 T를 Orange클래스로 사용하겠다는 의미
		fBox1.store(new Orange(10));
		Orange org1 = (Orange)fBox1.pullOut();
		// 제네릭으로 Orange를 자료형으로 지정했기 때문에 형변환 없이 Orange로 받을 수 있음
		org1.showSugar();
		
		FruitBox<Apple> fBox2 = new FruitBox<Apple>();
		// FruitBox클래스의 제네릭 T를 Apple클래스로 사용하겠다는 의미
		fBox2.store(new Apple(20));
		Apple app = fBox2.pullOut();
		app.showWeight();
	}
}

/*
문제점
 - 한가지 종류의 데이터만 받을 수 잇음(Orange)
 - 다른 종류의 데이터를 받으려면 OrangeBox클래스가 여러개 필요함

해결책
 - 제네릭 사용
*/