import java.util.ArrayList;

public class Day4_kakao5 {
	public static void main(String[] args) {
		String str1 = "aadcc";
		String str2 = "AAabb";
		
		solution(str1, str2);
	}
	
	public static int solution(String str1, String str2) {
		if(str1.length() == 0 && str2.length() == 0)
			return 65536;
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		
		makeList(str1, list1);
		makeList(str2, list2);

		ArrayList<String> interSectionList = new ArrayList<String>();
		ArrayList<String> unionList = new ArrayList<String>(list1);
		unionList.addAll(list2);
		
		if(list1.size() >= list2.size()) {
			for(int i=0; i<list2.size(); i++) {
				if(list1.contains(list2.get(i))) {
					interSectionList.add(list2.get(i));
					list1.remove(list2.get(i));
				}
			}
		}
		else {
			for(int i=0; i<list1.size(); i++) {
				if(list2.contains(list1.get(i))) {
					interSectionList.add(list1.get(i));
					list2.remove(list1.get(i));
				}
			}
		}
		
		System.out.println("inter size : " + interSectionList.size());
		for(int i=0; i<interSectionList.size(); i++)
			System.out.println(interSectionList.get(i));
		
		for(int i=0; i<interSectionList.size(); i++) {
			if(unionList.contains(interSectionList.get(i))) {
				unionList.remove(interSectionList.get(i));
			}
		}

		System.out.println("union size : " + unionList.size());
		for(int i=0; i<unionList.size(); i++)
			System.out.println(unionList.get(i));
		
		int equalCount = interSectionList.size();
		int unionCount = unionList.size();
		
		if(unionCount == 0)
			return 65536;
		System.out.println(65536 * equalCount / unionCount);
		return 65536 * equalCount / unionCount;
	}
	
	public static void makeList(String string, ArrayList<String> list) {
		String temp = "";
		int length = 0;
		for(int i=0; i<string.length(); i++) {
			char ch = string.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				if(length < 2) {
					temp = temp + ch;
					length++;
					if(length == 2) {
						list.add(temp);
						temp = ch + "";
						length = 1;
					}
				}
			}
			else {
				temp = "";
				length = 0;
			}
		}
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		System.out.println();
	}
}
