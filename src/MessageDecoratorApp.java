import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MessageDecoratorApp {

    private MessageModel model;
    private MessageView view;

    public MessageDecoratorApp(MessageModel model, MessageView view) {
        this.model = model;
        this.view = view;
        view.setController(new MessageController());
        view.update(model);
    }

    class MessageController implements ActionListener, DocumentListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox checkBox = (JCheckBox) e.getSource();
            String command = checkBox.getActionCommand();
            int state = Integer.parseInt(command);
            model.toggle(state);
            view.update(model);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            model.setMessage(view.getOriginalMessage());
            view.update(model);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            model.setMessage(view.getOriginalMessage());
            view.update(model);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            model.setMessage(view.getOriginalMessage());
            view.update(model);
        }
    }
}
