class SumThread extends Thread{
	int num, start, end;
	public SumThread(int s,int e){
		num = 0;
		start = s;
		end = e;
	}
	
	public void run(){
		for (int i = start ; i <= end ; i++ ){
			addNum(i);
		}
	}

	public void addNum(int n) {num += n;}
	public int getNum() {return num;}
}

class Sum1To100{
	public static void main(String[] args) {
		SumThread at1 = new SumThread(1,50);
		SumThread at2 = new SumThread(51,100);
		Thread tr1 = new Thread(at1);
		Thread tr2 = new Thread(at2);
		tr1.start();	tr2.start();
		try	{
			tr1.join();
			tr2.join();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("1~100 гу : " + (at1.getNum() + at2.getNum()));
	}
}
