class MessageSendingThread extends Thread{
	String message;
	public MessageSendingThread(String str){
		message = str;
	}
	public void run(){
		for (int i = 0; i < 10 ; i++ ){
			System.out.println(message + "(" + getPriority() + ")");
		// getPriority() : ���� ����ǰ� �ִ� �������� �켱������ ����
		// �켱���� : 10�� ���� ����, 1�� ���� ������, 5�� �⺻��
		}
	}
}

class  PriorityTest1{
	public static void main(String[] args) {
		MessageSendingThread tr1 = new MessageSendingThread("1st");
		MessageSendingThread tr2 = new MessageSendingThread("2st");
		MessageSendingThread tr3 = new MessageSendingThread("3st");
		// �����Ų ������ ������� tr1,tr2,tr2�� �������� ������ �����
		tr1.start();	tr2.start();	tr3.start();
	}
}
