import java.util.regex.Pattern;

public class Task2 {

    public static void main(String[] args) {
        String[][] strArr = { { "3", "7", "5", "-6", "you", "3" }, { "9", null, "2", "8", "-", "5" } };
        System.out.println(sum2d(strArr));
    }

    public static int sum2d(String[][] arr) {

        int sum = 0;

        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {  //NullPointerException
                for (int j = 0; j < arr[i].length; j++) {  //IndexOutOfBoundsException
                    if (arr[i][j] != null) {
                        if (isNumber(arr[i][j])) {
                            int val = Integer.parseInt(arr[i][j]);  //NumberFormatException
                            sum += val;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static boolean isNumber(String array) {

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (array == null) {
            return false;
        }
        return pattern.matcher(array).matches();
    }
}
