public class HarshadNumber {
	public boolean isHarshad(int num) {
		int origin = num;
		int sum = 0;

		while (num / 10 != 0) {
			sum += num % 10;
			num = num / 10;
		}

		sum += num;
		if (origin % sum == 0)
			return true;

		return false;
	}

	public static void main(String[] args) {
		HarshadNumber sn = new HarshadNumber();
		System.out.println(sn.isHarshad(18));
	}
}