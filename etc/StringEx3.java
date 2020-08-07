class StringEx3{
	public static void main(String[] args) {
		String file1 = "test.jpg";
		String file2 = "test.gif";
		String file3 = "test.zip";
		String file4 = "test.docx";

		isImg2(file1);	isImg2(file2);	isImg2(file3);	isImg2(file4);
	}
	public static void isImg(String file){
		//이미지 파일인지 여부를 검사할 메소드
		/*
		받아온 파일이 이미지 파일(jpg,gif,png,jpeg)인지를 검사하여
		"이미지 파일만 업로드가 가능합니다." or "이미지 파일이 맞습니다." 중 1 출력
		*/
		if (file.endsWith("jpg")){
			System.out.println(file + "는 이미지 파일이 맞습니다.");
			return;
		}
		if (file.endsWith("gif")){
			System.out.println(file + "는 이미지 파일이 맞습니다.");
			return;
		}
		if (file.endsWith("png")){
			System.out.println(file + "는 이미지 파일이 맞습니다.");
			return;
		}
		if (file.endsWith("jpeg")){
			System.out.println(file + "는 이미지 파일이 맞습니다.");
			return;
		}
		System.out.println(file + "는 이미지 파일이 아닙니다.");
		return;
	}
	public static void isImg2(String file){
		String ext = file.substring(file.lastIndexOf('.')+1);

		if (ext.equals("jpg") || ext.equals("gif") || ext.equals("png") || ext.equals("jpeg")){
			System.out.println(file + "는 이미지 파일이 맞습니다.");
		}else System.out.println(file + "는 이미지 파일이 아닙니다.");
	}
}
