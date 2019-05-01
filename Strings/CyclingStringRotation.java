public class CyclingStringRotation {

	public static boolean stringRotate(String s, String t) {
		//concatenated string will contains all rotations(if such exists)
		String concatenated = s.concat(s);
		if (s.length() == t.length() && concatenated.indexOf(t) != -1) {
			return true;
		} else {
			return false;
		}
}

	public static void main(String[] args) { 
		String rotation = "bcaed";
		String source = "aedbc";

		//it should be true
		System.out.println(stringRotate(rotation, source));
		
		rotation = "cbaed";

		//it should be false		
		System.out.println(stringRotate(rotation, source));

		rotation = "a";
		source = "aa";

		//it should be false
		System.out.println(stringRotate(rotation, source));
	}
}
