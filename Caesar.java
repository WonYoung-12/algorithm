public class Caesar {
	String caesar(String s, int n) {
		String result = "";
		// 함수를 완성하세요.
		int length = s.length();
		for(int i=0; i<length; i++) {
			char ch = s.charAt(i);
			if(ch == ' ') {
				result = result + " ";
			}
			else {
				// 원래 문자가 소문자.
				if(ch >= 'a') {
					if((char)(ch+n) > 'z') {
						ch = (char)('a'+ ((ch+n)-'a')%26);
					}
					else {
						ch = (char)(ch+n);
					}
				}
				// 원래 문자가 대문자.
				else {
					if((char)(ch+n) > 'Z') {
						ch = (char)('A'+ ((ch+n)-'A')%26);
					}
					else {
						ch = (char)(ch+n);
					}
				}
				result = result + ch;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Caesar c = new Caesar();
		System.out.println("s는 'a B z', n은 4인 경우: " + c.caesar("n", 46));
	}
}
