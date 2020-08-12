import java.util.*;

class Student{
	String id,name;
	double korean,history,math;
	public Student(String id,String name,double korean,double history,double math){
		this.id = id;
		this.name = name;
		this.korean = korean;
		this.history = history;
		this.math = math;
	}
	String getID() {return id;}
	public void showInfo(){
		double average = (korean + history + math)/3;
		System.out.println("�й� : " + id + "/ �̸� : " + name + "/ ���� : " + korean + "/ ���� : " + history + "/ ���� : " + math + "/ ��� : " + average);
	}
}



class Studenthandler{
	private Student[] students;
	private int numOfstudents;

	public Studenthandler(int num) {
		students = new Student[num];
		numOfstudents = 0;
	}
	private void addStudentInfo(Student fren){
		students[numOfstudents] = fren;
		numOfstudents++;
	}
	public boolean addStudent(){
		String id, name;
		double korean, history, math;

		Scanner sc = new Scanner(System.in);
		System.out.print("�й� : ");	id = sc.nextLine(); // �й��� �Է��մϴ�.
		for (int i = 0; i < numOfstudents ; i++ ){
			if (id.equals(students[i].getID()))	{ // �л����� �˻��Ͽ� id�� ���� �л��� �ִٸ� false�� �����մϴ�.
				return false;
			}
		}
		System.out.print("�̸� : ");	name = sc.nextLine();
		System.out.print("�������� : ");	korean = sc.nextDouble();
		System.out.print("�������� : ");	history = sc.nextDouble();
		System.out.print("�������� : ");	math = sc.nextDouble();
		System.out.println("�Է� �Ϸ�\n");
		addStudentInfo(new Student(id,name,korean,history,math));
		return true; // �����Է��� �Ϸ�Ǹ� true�� �����մϴ�.
	}
	public void showAllData(){ // ��� �л��� ������ �����ݴϴ�.
		for (int i = 0 ; i < numOfstudents ; i++ ){
			students[i].showInfo();
			System.out.println();
		}
	}
	public void searchID(String ID){ // �Է��� id�� ���� �й��� ���� �л��� ����մϴ�.
		boolean foundname = false;
		for (int i =0 ; i < numOfstudents ; i++ ){
			if ( ID.equals(students[i].getID()) ){
				foundname = true;
				students[i].showInfo();
				System.out.println();
			}
		}
		if (foundname == false){
			System.out.println("�������� �ʴ� �й��Դϴ�.");
		}
	}
}


class StudentInfoBook{
	public static void main(String[] args) {
		Studenthandler handler = new Studenthandler(10);
		
		while (true){
			System.out.println("***�޴� ����***");
			System.out.println("1. �����Է�");
			System.out.println("2. �����˻�");
			System.out.println("3. ��ü����");
			System.out.println("4. ����");
			System.out.print("���� >> ");

			Scanner sc = new Scanner(System.in); 
			int choice = sc.nextInt(); //�޴� ���ÿ� ���� ���ڸ� �Է��մϴ�.
			sc.nextLine();

			if (choice == 1){
				if (!handler.addStudent()){ // handler.addStudent()�� false�� �����ϸ� �����Է��� ���� �ʽ��ϴ�.
					System.out.println("�����Է¿� �����߽��ϴ�.");
				}else{ // handler.addStudent()�� true�� �����ϸ� �����Է¸� �Է��մϴ�.
					System.out.println("�����Է¿� �����߽��ϴ�.");
				}
			}else if (choice == 2){
				System.out.print("�й��� �Է��ϼ��� >> ");
				String id = sc.nextLine();
				handler.searchID(id);
			}else if (choice == 3){
				handler.showAllData();
			}else if (choice == 4){
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}else{ //�޴� ���ÿ� ���� ��ȣ�� 1,2,3,4�� �ƴϸ� �޴� ���ú��� �ٽý����մϴ�.
				System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ��Է����ּ���.");
				continue;
			}
		}
	}
}