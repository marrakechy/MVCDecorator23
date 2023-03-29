import java.util.Locale;

public class AngryMessageDecorator extends MessageDecorator{
    private Message m;
    public AngryMessageDecorator(Message m){
        super(m);
        this.m = m;
    }

    @Override
    public String getTheMsg() {
        return m.getTheMsg().toUpperCase();
    }
}

