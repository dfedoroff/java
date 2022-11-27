import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

	private static Map<String, String> book = new TreeMap<>();

	public void add(String surname, String number) {
		book.put(number, surname);
	}

	public List<String> get(String surname) {

		ArrayList<String> resultSearch = new ArrayList<>();

		for (Map.Entry<String, String> entry : book.entrySet()) {
			if (entry.getValue().equals(surname)) {
				resultSearch.add(entry.getKey());
			}
		}
		return resultSearch;
	}
}
