public class SMSDecorator extends MessageDecorator{
    private Message m;

    public SMSDecorator( Message m) {
        super(m);
        this.m = m;
    }

    @Override
    public String getTheMsg() {
        String newMessageTxt = "";
        for (int i = 0; i < m.getTheMsg().length(); i++){
            newMessageTxt += m.getTheMsg().charAt(i);
            if (i % 10 == 0 && i != 0){
                newMessageTxt += "...\n";
            }
        }

        return newMessageTxt;
    }
}
