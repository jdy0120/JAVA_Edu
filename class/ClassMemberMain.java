class ClassMember{
	static int clsNum = 0;
	int instNum = 0;
	public ClassMember(){
		clsNum++;
		instNum++;
		System.out.println("clsNum : " + clsNum);
		System.out.println("instNum : " + instNum);
	}
}

class ClassMemberMain {
	public static void main(String[] args) {
		ClassMember cm1 = new ClassMember();
		ClassMember cm2 = new ClassMember();
		ClassMember cm3 = new ClassMember();
		System.out.println("Hello World!");
	}
}
