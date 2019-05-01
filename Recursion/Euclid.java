public class Euclid {

	public static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		return gcd(q, p % q);
	}

	public static void main(String[] args) {
		System.out.println(gcd(12, 3));
		System.out.println(gcd(3, 12));
		System.out.println(gcd(12, 5));
	}
}
