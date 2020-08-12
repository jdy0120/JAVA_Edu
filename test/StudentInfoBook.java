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
		System.out.println("학번 : " + id + "/ 이름 : " + name + "/ 국어 : " + korean + "/ 국사 : " + history + "/ 수학 : " + math + "/ 평균 : " + average);
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
		System.out.print("학번 : ");	id = sc.nextLine(); // 학번을 입력합니다.
		for (int i = 0; i < numOfstudents ; i++ ){
			if (id.equals(students[i].getID()))	{ // 학생들을 검사하여 id가 같은 학생이 있다면 false를 리턴합니다.
				return false;
			}
		}
		System.out.print("이름 : ");	name = sc.nextLine();
		System.out.print("국어점수 : ");	korean = sc.nextDouble();
		System.out.print("국사점수 : ");	history = sc.nextDouble();
		System.out.print("수학점수 : ");	math = sc.nextDouble();
		System.out.println("입력 완료\n");
		addStudentInfo(new Student(id,name,korean,history,math));
		return true; // 정보입력이 완료되면 true를 리턴합니다.
	}
	public void showAllData(){ // 모든 학생의 정보를 보여줍니다.
		for (int i = 0 ; i < numOfstudents ; i++ ){
			students[i].showInfo();
			System.out.println();
		}
	}
	public void searchID(String ID){ // 입력한 id와 같은 학번을 가진 학생을 출력합니다.
		boolean foundname = false;
		for (int i =0 ; i < numOfstudents ; i++ ){
			if ( ID.equals(students[i].getID()) ){
				foundname = true;
				students[i].showInfo();
				System.out.println();
			}
		}
		if (foundname == false){
			System.out.println("존재하지 않는 학번입니다.");
		}
	}
}


class StudentInfoBook{
	public static void main(String[] args) {
		Studenthandler handler = new Studenthandler(10);
		
		while (true){
			System.out.println("***메뉴 선택***");
			System.out.println("1. 정보입력");
			System.out.println("2. 정보검색");
			System.out.println("3. 전체정보");
			System.out.println("4. 종료");
			System.out.print("선택 >> ");

			Scanner sc = new Scanner(System.in); 
			int choice = sc.nextInt(); //메뉴 선택에 대한 숫자를 입력합니다.
			sc.nextLine();

			if (choice == 1){
				if (!handler.addStudent()){ // handler.addStudent()가 false를 리턴하면 정보입력을 하지 않습니다.
					System.out.println("정보입력에 실패했습니다.");
				}else{ // handler.addStudent()가 true를 리턴하면 정보입력를 입력합니다.
					System.out.println("정보입력에 성공했습니다.");
				}
			}else if (choice == 2){
				System.out.print("학번을 입력하세요 >> ");
				String id = sc.nextLine();
				handler.searchID(id);
			}else if (choice == 3){
				handler.showAllData();
			}else if (choice == 4){
				System.out.println("프로그램을 종료합니다.");
				break;
			}else{ //메뉴 선택에 대한 번호가 1,2,3,4가 아니면 메뉴 선택부터 다시시작합니다.
				System.out.println("잘못된 번호입니다. 다시입력해주세요.");
				continue;
			}
		}
	}
}