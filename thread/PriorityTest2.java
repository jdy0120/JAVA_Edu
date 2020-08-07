class MessageSendingThread extends Thread{
	String message;
	public MessageSendingThread(String str, int prio){
		message = str;
		setPriority(prio);
		// setPriority() : ������ �Ű������� ���� �� �������� �켱������ ����
	}
	public void run(){
		for (int i = 0; i < 10 ; i++ ){
			System.out.println(message + "(" + getPriority() + ")");
		}
	}
}

class  PriorityTest2{
	public static void main(String[] args) {
		MessageSendingThread tr1 = new MessageSendingThread("1st", Thread.MAX_PRIORITY);
		// MAX_PRIORITY : ThreadŬ������ �ʵ尪���� �켱���� �ְ� - 10
		MessageSendingThread tr2 = new MessageSendingThread("2st", Thread.NORM_PRIORITY);
		// NORM_PRIORITY : ThreadŬ������ �ʵ尪���� �켱���� �⺻�� - 5
		MessageSendingThread tr3 = new MessageSendingThread("3st", Thread.MIN_PRIORITY);
		// MIN_PRIORITY : ThreadŬ������ �ʵ尪���� �켱���� ������ - 1
		tr1.start();	tr2.start();	tr3.start();
	}
}


/*
�����忡 �켱������ ������ �� ������ ��������� ū ������ ������ ����
������� ��ü�� OS�� �������̱� ������ JVM������� ������ ������ ���� ����
*/