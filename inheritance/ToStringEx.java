class MemberInfo{
	private String id, name, gender, addr;
	public MemberInfo(String id,String name,String gender,String addr){
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.addr = addr;
	}
	public String getId()				{ return id; }
	public String getName()				{ return name; }
	public String getGender()			{ return gender; }
	public String getAddr()				{ return addr; }
	public void setAddr(String addr)	{ this.addr = addr; }

	public String toString(){
	// Objectũ������ �ִ� �޼ҵ� �������̵��Ͽ� ����ϴ� ���� ����
	// ��ü(�ν��Ͻ�)�� ����� �� �ڵ����� ȣ��Ǵ� �޼ҵ�
		String str = "ID : " + id + " / �̸� : " + name + " / ���� : " + gender + " / �ּ� : " + addr;
		return str;
	}
}

class ToStringEx{
	public static void main(String[] args) {
		MemberInfo mi1 = new MemberInfo("test1","ȫ�浿","��","����");
		MemberInfo mi2 = new MemberInfo("test2","����ġ","��","�԰浵");
		MemberInfo mi3 = new MemberInfo("test3","�Ӳ���","��","������");

		System.out.println(mi1);
		System.out.println(mi2);
		System.out.println(mi3);
		// �ν��Ͻ��� ����ϸ� �ڵ����� ObjectŬ������ toString()�޼ҵ尡 �����Ͽ�
		// �ν��Ͻ��� ����� �� �ִ� ���ڿ��� ����� ��
	}
}
