public abstract class MessageDecorator extends Message{

    private Message m;
    public MessageDecorator( Message theMsg) {
        super(theMsg.getTheMsg());
        m =  theMsg;
    }

    @Override
    public String getTheMsg() {
        return m.getTheMsg();
    }
}
