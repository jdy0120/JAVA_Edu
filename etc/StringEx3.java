class StringEx3{
	public static void main(String[] args) {
		String file1 = "test.jpg";
		String file2 = "test.gif";
		String file3 = "test.zip";
		String file4 = "test.docx";

		isImg2(file1);	isImg2(file2);	isImg2(file3);	isImg2(file4);
	}
	public static void isImg(String file){
		//�̹��� �������� ���θ� �˻��� �޼ҵ�
		/*
		�޾ƿ� ������ �̹��� ����(jpg,gif,png,jpeg)������ �˻��Ͽ�
		"�̹��� ���ϸ� ���ε尡 �����մϴ�." or "�̹��� ������ �½��ϴ�." �� 1 ���
		*/
		if (file.endsWith("jpg")){
			System.out.println(file + "�� �̹��� ������ �½��ϴ�.");
			return;
		}
		if (file.endsWith("gif")){
			System.out.println(file + "�� �̹��� ������ �½��ϴ�.");
			return;
		}
		if (file.endsWith("png")){
			System.out.println(file + "�� �̹��� ������ �½��ϴ�.");
			return;
		}
		if (file.endsWith("jpeg")){
			System.out.println(file + "�� �̹��� ������ �½��ϴ�.");
			return;
		}
		System.out.println(file + "�� �̹��� ������ �ƴմϴ�.");
		return;
	}
	public static void isImg2(String file){
		String ext = file.substring(file.lastIndexOf('.')+1);

		if (ext.equals("jpg") || ext.equals("gif") || ext.equals("png") || ext.equals("jpeg")){
			System.out.println(file + "�� �̹��� ������ �½��ϴ�.");
		}else System.out.println(file + "�� �̹��� ������ �ƴմϴ�.");
	}
}
