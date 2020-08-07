class MessageSendingThread extends Thread{
	String message;
	public MessageSendingThread(String str, int prio){
		message = str;
		setPriority(prio);
		// setPriority() : 지정된 매개변수의 값을 현 쓰레드의 우선순위로 지정
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
		// MAX_PRIORITY : Thread클래스의 필드값으로 우선순위 최고값 - 10
		MessageSendingThread tr2 = new MessageSendingThread("2st", Thread.NORM_PRIORITY);
		// NORM_PRIORITY : Thread클래스의 필드값으로 우선순위 기본값 - 5
		MessageSendingThread tr3 = new MessageSendingThread("3st", Thread.MIN_PRIORITY);
		// MIN_PRIORITY : Thread클래스의 필드값으로 우선순위 최저값 - 1
		tr1.start();	tr2.start();	tr3.start();
	}
}


/*
쓰레드에 우선순위를 지정할 수 있으나 실행순서에 큰 영향을 주지는 못함
실행순서 자체가 OS에 의존적이기 때문에 JVM마음대로 순서를 지정할 수는 없음
*/