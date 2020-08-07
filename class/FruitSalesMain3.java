/*
FruitSellerŬ������ �����ڸ� �ۼ�
 - ������� �� ����� �ʱ�ȭ��Ű�� ������
 - �����ڸ� �̿��Ͽ� seller1, seller2�� �ν��Ͻ� ����

FruitBuyerŬ������ �����ڸ� �ۼ�
 - �������(numOfApple, myMoney)�� �ʱ�ȭ
 - buyer�ν��Ͻ� ����(��������� 0, �ܾ��� 10000)
*/

class FruitSeller {
	int numOfApple;
	int myMoney;	
	final int APPLE_PRICE;

	public FruitSeller(int num,int money, int price){

		numOfApple = num;
		myMoney = money;
		APPLE_PRICE = price;
		//�����ڿ����� ������� ���� �ʱ�ȭ �� �� ����
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
	int numOfApple;
	int myMoney;
	
	public FruitBuyer(int money){
		numOfApple = 0;
		myMoney = money;
	}
	public void buyApple(FruitSeller seller,int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("��� ���� : " + numOfApple);
		System.out.println("���� �ܾ� : " + myMoney);
	}
}

class  FruitSalesMain3 {
	public static void main(String[] args) {
		FruitSeller seller1 = new FruitSeller(30,0,1500);
		FruitSeller seller2 = new FruitSeller(20,0,1000);
		FruitBuyer buyer = new FruitBuyer(10000);
		// �����ڸ� �̿��ϸ� ��������� �ʱ�ȭ �ϸ鼭 �ν��Ͻ��� ������ �� ����

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
