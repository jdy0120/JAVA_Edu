class Sum{
	int num;
	public Sum() {num = 0;}
	public void addNum(int n) {num += n;}
	public int getNum() {return num;}
}

class AdderThread extends Sum implements Runnable{
// �ٸ� Ŭ������ ��ӹ޾����Ƿ� ThreadŬ������ ��ӹ��� ���� ��� Runnable�������̽��� �����ϴ� ������� �����带 �۾�
	int start, end;
	public AdderThread(int s,int e){
		start = s;
		end = e;
	}
	public void run(){
		for (int i = start ; i <= end ; i++ ){
			addNum(i);
		}
	}
}

class RunnableThread{
	public static void main(String[] args) {
		AdderThread at1 = new AdderThread(1,50);
		AdderThread at2 = new AdderThread(51,100);
		Thread tr1 = new Thread(at1);
		Thread tr2 = new Thread(at2);
		//Thread�� Runnable�� �ν��Ͻ��� �Ű������� �Ͽ� �����带 ������ �� ����
		// ��� Runnable�� �������̽��̹Ƿ� �ν��Ͻ��� ������ �� ������ Runnable�� implements�� AdderThreadŬ������ �ν��Ͻ��� Runnable�� ����Ŭ���� �������� �����Ͽ�
		// Runnable�������̽��� �ν��Ͻ�ó�� ����� �� ����
		tr1.start();	tr2.start();
		// tr1�� tr2�� �����带 �����Ŵ(run()�޼ҵ� ����)
		try	{
			tr1.join();
			tr2.join();
			// tr1�� tr2�� �۾��� ��� ����� �� ���� �ٸ� �۾��� ���� ���ϰ� ��
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("1~100 �� : " + (at1.getNum() + at2.getNum()));
	}
}
