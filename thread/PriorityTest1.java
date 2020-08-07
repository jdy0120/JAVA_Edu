class MessageSendingThread extends Thread{
	String message;
	public MessageSendingThread(String str){
		message = str;
	}
	public void run(){
		for (int i = 0; i < 10 ; i++ ){
			System.out.println(message + "(" + getPriority() + ")");
		// getPriority() : 현재 실행되고 있는 스레드의 우선순위를 리턴
		// 우선순위 : 10이 가장 높고, 1이 가장 낮으며, 5가 기본값
		}
	}
}

class  PriorityTest1{
	public static void main(String[] args) {
		MessageSendingThread tr1 = new MessageSendingThread("1st");
		MessageSendingThread tr2 = new MessageSendingThread("2st");
		MessageSendingThread tr3 = new MessageSendingThread("3st");
		// 실행시킨 순서와 상관없이 tr1,tr2,tr2가 순서없이 섞여서 실행됨
		tr1.start();	tr2.start();	tr3.start();
	}
}
