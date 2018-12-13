public class NumOfPrime {
	int numberOfPrime(int n) {
		int start = 2;
		int result = 0;
		boolean isPrime = true;
		
		// 함수를 완성하세요.
		while(start <= n) {
			isPrime = true;
			int temp = 2;
			while(temp <= start) {
				if(temp != start && start%temp == 0) {
					isPrime = false;
					break;
				}
				temp++;
			}
			if(isPrime)
				result++;
			start++;
		}

		return result;
	}

	public static void main(String[] args) {
		NumOfPrime prime = new NumOfPrime();
		System.out.println(prime.numberOfPrime(5));
	}

}