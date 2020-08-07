class BufferBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("AB");
		sb.append(25);
		sb.append('Y').append(true);
		System.out.println(sb); // AB25Ytrue

		sb.insert(2, false);
		sb.insert(sb.length(),'Z');
		System.out.println(sb); // ABfalse25YtrueZ
		sb.reverse();
		System.out.println(sb); // ZeurtY52eslafBA

		String str = "123-45-6789";
		StringBuilder str1 = new StringBuilder(str);
		// str의 값을 "123-456789"로 변경시킴(StringBuilder 사용)
		str1.deleteCharAt(6);
		str = str1.toString();
		System.out.println(str);
	}
}
