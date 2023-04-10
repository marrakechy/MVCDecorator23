class MessageModel {

    private String message;
    private boolean angry;
    private boolean binary;
    private boolean encrypted;
    private boolean sms;

    public static final int ANGRY = 1;
    public static final int BINARY = 2;
    public static final int ENCRYPTED = 3;
    public static final int SMS = 4;

    public MessageModel() {
        message = "";
    }

    public void toggle(int state) {
        switch (state) {
            case ANGRY:
                angry = !angry;
                break;
            case BINARY:
                binary = !binary;
                break;
            case ENCRYPTED:
                encrypted = !encrypted;
                break;
            case SMS:
                sms = !sms;
                break;
            default:
                break;
        }
    }

    public boolean isAngry() {
        return angry;
    }

    public boolean isBinary() {
        return binary;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public boolean isSms() {
        return sms;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDecoratedMessage() {
        String decorated = message;

        if (angry) {
            decorated = new AngryMessageDecorator(new Message(decorated)).getTheMsg();
        }
        if (binary) {
            decorated = new BinaryMessage(new Message(decorated)).getTheMsg();
        }
        if (encrypted) {
            decorated = new EncryptedMessage(new Message(decorated), 5).getTheMsg();
        }
        if (sms) {
            decorated = new SMSDecorator(new Message(decorated)).getTheMsg();
        }

        return decorated;
    }

    public static String getMessage() {
        System.out.print("Enter a message: ");
        String message = scanner.nextLine();
        return message;
    }
}
