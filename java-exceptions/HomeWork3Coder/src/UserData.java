public class UserData {

    private final String lastName;
    private final String firstName;
    private final String patronymicName;
    private final String birthDate;
    private final String phoneNumber;
    private final String gender;

    public UserData(String lastName, String firstName, String patronymicName, String birthDate, String phoneNumber, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "<" + lastName + ">" +
                "<" + firstName + ">" +
                "<" + patronymicName + ">" +
                "<" + birthDate + ">" +
                "<" + phoneNumber + ">" +
                "<" + gender + ">";
    }

    public String getLastName() {
        return lastName;
    }
}