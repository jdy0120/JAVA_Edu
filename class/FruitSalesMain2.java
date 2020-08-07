
class FruitSeller {
	int numOfApple;
	int myMoney;	
	int APPLE_PRICE;
	// ����� ��� �Ϲ� �޼ҵ忡�� ���� ������ ������ �߻���
	// ���߿��� �ٽ� �޼ҵ带 ȣ���� �� �����Ƿ� �̸� ������ �߻���Ŵ

	public void initMember(int num,int money, int price){
	// ����������� �ʱ�ȭ ��Ű�� �޼ҵ�
		numOfApple = num;
		myMoney = money;
		APPLE_PRICE = price;
	}
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("���� ��� : " + numOfApple);
		System.out.println("�Ǹ� ���� : " + myMoney);
	}
}

class FruitBuyer {
	int numOfApple = 0;
	int myMoney = 10000;

	public void buyApple(FruitSeller seller,int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("��� ���� : " + numOfApple);
		System.out.println("���� �ܾ� : " + myMoney);
	}
}

class  FruitSalesMain2 {
	public static void main(String[] args) {
		FruitSeller seller1 = new FruitSeller();
		// FruitSeller �� �Ž��Ͻ� seller1�� ���� �� ����
		seller1.initMember(30,0,1500);
		// seller1�� ��������鿡 ���� initMember()�޼ҵ带 ���� �ʱ�ȭ ��Ŵ
		FruitSeller seller2 = new FruitSeller();
		seller2.initMember(20,0,1000);

		FruitBuyer buyer = new FruitBuyer();
		buyer.buyApple(seller1,4500);
		buyer.buyApple(seller2,2000);

		System.out.println("���� �Ǹ���1 ��Ȳ");
		seller1.showSaleResult();

		System.out.println("���� �Ǹ���2 ��Ȳ");
		seller2.showSaleResult();

		System.out.println("���� ������ ��Ȳ");
		buyer.showBuyResult();
	}
}
/*
������
 - �ν��Ͻ� ������ �� ���� ����� �ʿ���
 - APPLE_PRICE�� ����� �ƴ� ������ ������
 - initMember()�ʱ�ȭ �޼ҵ带 �������� ȣ���� �� ����(ȣ��Ǹ� �Ǹű���� ��� ���µ�)
 
�ذ�å
 - ������ ���
*/