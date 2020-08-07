class Car{
	int gasolineGauge;
	public Car(int g) {gasolineGauge = g;}
}

class HybridCar extends Car{
	int electricGauge;
	public HybridCar(int g, int e){
		super(g);
		this.electricGauge = e;
	}
}

class WaterCar extends HybridCar{
	int waterGauge;
	public WaterCar(int g, int e, int w){
		super(g,e);
		waterGauge = w;
	}

	public void showCurrentGauge(){
		System.out.println("잔여 가솔린 : " + gasolineGauge);
		System.out.println("잔여 전기량 : " + electricGauge);
		System.out.println("잔여 워터량 : " + waterGauge);
	}
}

class SuperConstrucuor{
	public static void main(String[] args) {
		WaterCar wc1 = new WaterCar(4,2,3);
		wc1.showCurrentGauge();
		WaterCar wc2 = new WaterCar(9,5,7);
		wc2.showCurrentGauge();
	}
}
