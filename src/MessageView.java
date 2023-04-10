import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MessageView {
    private JFrame frame;
    private JPanel panel;
    private JTextArea originalTextArea;
    private JTextArea decoratedTextArea;
    private JCheckBox angryCheckBox;
    private JCheckBox binaryCheckBox;
    private JCheckBox encryptedCheckBox;
    private JCheckBox smsCheckBox;

    public MessageView() {
        // Create the frame and panel
        frame = new JFrame("Message Decorator");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create the original text area
        originalTextArea = new JTextArea();
        originalTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateDecoratedText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateDecoratedText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateDecoratedText();
            }
        });

        // Create the decorated text area
        decoratedTextArea = new JTextArea();
        decoratedTextArea.setEditable(false);

        // Create the checkbox panel
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new GridLayout(4, 1));

        // Create the angry checkbox
        angryCheckBox = new JCheckBox("Angry");
        angryCheckBox.addActionListener(new DecorationListener());

        // Create the binary checkbox
        binaryCheckBox = new JCheckBox("Binary");
        binaryCheckBox.addActionListener(new DecorationListener());

        // Create the encrypted checkbox
        encryptedCheckBox = new JCheckBox("Encrypted");
        encryptedCheckBox.addActionListener(new DecorationListener());

        // Create the SMS checkbox
        smsCheckBox = new JCheckBox("SMS");
        smsCheckBox.addActionListener(new DecorationListener());

        // Add the checkboxes to the checkbox panel
        checkboxPanel.add(angryCheckBox);
        checkboxPanel.add(binaryCheckBox);
        checkboxPanel.add(encryptedCheckBox);
        checkboxPanel.add(smsCheckBox);

        // Add the components to the panel
        panel.add(originalTextArea, BorderLayout.NORTH);
        panel.add(decoratedTextArea, BorderLayout.CENTER);
        panel.add(checkboxPanel, BorderLayout.WEST);

        // Add the panel to the frame
        frame.add(panel);

        // Set the frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void updateDecoratedText() {
        String originalText = originalTextArea.getText();
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(originalText);
        if (angryCheckBox.isSelected()) {
            messageModel.toggle(MessageModel.ANGRY);
        }
        if (binaryCheckBox.isSelected()) {
            messageModel.toggle(MessageModel.BINARY);
        }
        if (encryptedCheckBox.isSelected()) {
            messageModel.toggle(MessageModel.ENCRYPTED);
        }
        if (smsCheckBox.isSelected()) {
            messageModel.toggle(MessageModel.SMS);
        }
        decoratedTextArea.setText(messageModel.getMessage());
    }

    private class DecorationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateDecoratedText();
        }
    }
}

