class WrongPasswordException extends Exception {

    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException() {
        super("Пароль должен содержать только латинские буквы, цифры и знаки подчеркивания и быть длиной меньше 20 символов");
    }
}
