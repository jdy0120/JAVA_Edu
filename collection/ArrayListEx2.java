import java.util.*;

class ArrayListEx2{
	public static void main(String[] args) {
		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();
		ArrayList listSource = new ArrayList((length/LIMIT)+1);
		String temp = "";
		for (int i = 0; i < source.length() ; i++ ){
			temp += source.charAt(i);
			if ((i+1)%10 == 0){
				listSource.add(temp);
				temp = "";
			}
		}
		if (temp != ""){
			listSource.add(temp);
		}
		for (int i = 0; i < listSource.size() ; i++ ){
			System.out.println(listSource.get(i));	
		}
		
	}
}
