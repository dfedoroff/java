public class PalindromeValid {
	public static boolean isPalindrome(String rawStr) {

		String str = rawStr.replace(" ", "");
		String revStr = new StringBuilder(str).reverse().toString();
		return str.equalsIgnoreCase(revStr);
	}
}
