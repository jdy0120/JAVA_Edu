class Orange{
	int sugar;
	public Orange(int s) {sugar = s;}
	public void showSugar() { System.out.println("´çµµ : " + sugar); }
}

class FruitBox{
	Object item;
	public void store(Object item) { this.item = item; }
	public Object pullOut() { return item; }
}

class FruitBoxObject{
	public static void main(String[] args) {
		FruitBox fBox1 = new FruitBox();
		fBox1.store(new Orange(10));
		Orange org1 = (Orange)fBox1.pullOut();
		org1.showSugar();
		
		FruitBox fBox2 = new FruitBox();
		fBox2.store(new String("¿À·»Áö"));
		Orange org2 = (Orange)fBox1.pullOut();
		org2.showSugar();

		System.out.println("Hello World!");
	}
}
