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
		System.out.println("�ܿ� ���ָ� : " + gasolineGauge);
		System.out.println("�ܿ� ���ⷮ : " + electricGauge);
		System.out.println("�ܿ� ���ͷ� : " + waterGauge);
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
