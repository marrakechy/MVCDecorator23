import javax.imageio.spi.ImageInputStreamSpi;

public class Main {
    public static void main(String[] args) {
//        Message m = new Message("Hello World.  this is fun!");
//        System.out.println(m.getTheMsg());
//        m = new AngryMessageDecorator(m);
//        System.out.println(m.getTheMsg());
//        m = new SMSDecorator(m);
//        System.out.println(m.getTheMsg());
//        m = new EncryptedMessage(m,1);
//        System.out.print(m.getTheMsg());
//        m = new BinaryMessage(m);
//        System.out.print(m.getTheMsg());

        MessageModel m = new MessageModel();
        m.toggle(MessageModel.ANGRY);
        m.toggle(MessageModel.BINARY);
        m.setMessage("abc");
        System.out.println(m.getMessage());
        m.toggle(MessageModel.ANGRY);
        System.out.println(m.getMessage());
        m.toggle(MessageModel.BINARY);
        m.toggle(MessageModel.ANGRY);
        System.out.println(m.getMessage());

    }
}