import java.util.List;

public class Main {
	public static void main(String[] args) {

		PhoneBook phoneBook = new PhoneBook();

		phoneBook.add("Gibson", "33344");
		phoneBook.add("Hamilton", "344");
		phoneBook.add("Brooks", "344");
		phoneBook.add("Brooks", "122");

		List<String> strings = phoneBook.get("Brooks");
		System.out.println(strings);
	}
}
