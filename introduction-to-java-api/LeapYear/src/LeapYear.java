public class LeapYear {
	public static boolean isLeap(int n) {
		return ((n % 4 == 0) && (!(n % 100 == 0)) || (n % 400 == 0));
	}
}
