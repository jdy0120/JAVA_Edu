/* ��� �Ǹ� ���α׷�
����Ǹ��� : FruitSeller Ŭ����
 - ������� : ���������(numOfApple), �����(myMoney), ����(APPLE_PRICE)
 - �޼ҵ� : �Ǹ�(saleApple()), ��Ȳ����(showSaleResult())
��������� : FruitBuyer Ŭ����
 - ������� : ���Ż����(numOfApple), �ܾ�(myMoney)
 - �޼ҵ� : ����(buyApple()), ��Ȳ����(showBuyResult())
*/
class FruitSeller {
	int numOfApple = 20;// ���������
	int myMoney = 0;	// �����
	final int APPLE_PRICE = 1000;	//�������
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		// �����ڰ� ������ �ݾ�(money)���� �� �� �ִ� ������� ����
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
	int numOfApple = 0;	// ���Ż����
	int myMoney = 5000;	// �ܾ�
	public void buyApple(FruitSeller seller,int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("��� ���� : " + numOfApple);
		System.out.println("���� �ܾ� : " + myMoney);
	}
}

class  FruitSalesMain1 {
	public static void main(String[] args) {
		FruitSeller seller = new FruitSeller();
		// FruitSeller �� �ν��Ͻ� seller�� ���� �� ����
		FruitBuyer buyer = new FruitBuyer();
		// FruitBuyer �� �ν��Ͻ� buyer�� ���� �� ����
		buyer.buyApple(seller,2000);
		// buyer�ν��Ͻ� ���� buyApple() �޼ҵ� ����
		System.out.println("���� �Ǹ��� ��Ȳ");
		seller.showSaleResult();

		System.out.println("���� ������ ��Ȳ");
		buyer.showBuyResult();
	}
}

/*
������
 - �ν��Ͻ����� ���� �����ص� ��� ������ ��(�������)�� ������ ����

�ذ�å
 - �ν��Ͻ� ���� ��������� ���� �ٸ��� ������ �� �־�� ��
*/