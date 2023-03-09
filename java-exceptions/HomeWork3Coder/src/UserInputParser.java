public class UserInputParser {

    public static UserData parse(String input) throws WrongParsingDataException {
        String[] data = input.split(" ");
        if (data.length != 6) {
            throw new WrongParsingDataException("Введено меньше или больше данных чем требуется");
        }

        String lastName = validateName(data[0], "фамилии");
        String firstName = validateName(data[1], "имени");
        String patronymicName = validateName(data[2], "отчества");
        String birthDate = validateBirthDate(data[3]);
        String phoneNumber = validatePhoneNumber(data[4]);
        String gender = validateGender(data[5]);

        return new UserData(lastName, firstName, patronymicName, birthDate, phoneNumber, gender);
    }
}