public class MessageModel {

    private String base;
    private Message m;
    private boolean angry;
    private boolean sms;
    private boolean binary;
    private boolean encrypted;

    public static final int ANGRY = 1;
    public static final int BINARY = 2;
    public static final int SMS = 3;
    public static final int ENCRYPTED  = 4;


    public MessageModel() {
        base = "";
        m = new Message(base);

        angry = false;
        sms = false;
        binary = false;
        encrypted = false;
    }

    public String getMessage() {
        m = new Message (base);
        decorate();
        return m.getTheMsg();
    }

    public void setMessage(String s) {
        base = s;
    }

    private void decorate(){

        if (angry){
            m = new AngryMessageDecorator(m);
        }
        if (sms){
            m = new SMSDecorator(m);
        }
        if (encrypted){
            m = new EncryptedMessage(m,5);
        }
        if (binary){
            m = new BinaryMessage(m);
        }
    }
    public void toggle(int state){
        switch (state){
            case ANGRY:
                angry = !angry;
                break;
            case SMS:
                sms = !sms;
                break;
            case BINARY:
                binary = !binary;
                break;
            case ENCRYPTED:
                encrypted = !encrypted;
                break;
        }

    }
}
