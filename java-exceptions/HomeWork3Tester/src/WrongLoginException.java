class WrongLoginException extends Exception {

    public WrongLoginException() {
        super("Логин должен содержать только латинские буквы, цифры и знаки подчеркивания и быть длиной меньше 20 символов");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
