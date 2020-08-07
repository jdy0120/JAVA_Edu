import java.util.*;

class AgeInputException extends Exception {
// ExceptionŬ������ ��ӹ޾����Ƿ� AgeInputException�� ���� Ŭ������ ��
	public AgeInputException(){
		super("��ȿ���� ���� ���̰� �ԷµǾ����ϴ�.");
		// ���ܹ߻��� ������ �޽����� �Ű������� �Ͽ� ����Ŭ������ �����ڸ� ȣ��
	}
}

class UserDefineException{
	public static void main(String[] args) {
		System.out.println("���̸� �Է��ϼ��� : ");

		try{
			int age = readAge();
			System.out.println("����� " + age + "���Դϴ�.");
		}catch (AgeInputException e){
			System.out.println(e.getMessage());
		}
	}
	public static int readAge() throws AgeInputException {
	// throws AgeInputException : �޼ҵ� ����ο� �Է��ϴ� ����ó�� ������ AgeInputException���ܰ� �߻��ϸ� �� �޼ҵ忡�� ó���ϴ� ���� �ƴ� 
	// �� �޼ҵ带 ȣ���� ������ ó���� �ѱ�ڴٴ� �ǹ�
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if (age < 0) {	// ��ȿ���� ���� ���̰��� �Է����� ���
			AgeInputException excpt = new AgeInputException();
			// ����Ŭ������ �ν��Ͻ� ����(������ �ν��Ͻ��� �߻��� ����)
			throw excpt;
			// excpt�� �ش��ϴ� ���ܰ� �߻��ߴٴ� ���� JVM�� �˷��ִ� ������ ��
			// JVM�� ���ܹ߻��� ���� ó�� ��Ŀ������ �ߵ���Ŵ
		}
		return age;
	}
}
