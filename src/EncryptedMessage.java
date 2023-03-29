public class EncryptedMessage extends MessageDecorator {
	private int key;
	public EncryptedMessage(Message m, int key) {
		super(m);
		this.key = key;
	}

	@Override
	public String getMessage() {
		return encrypt(m.getMessage());
	}

	private String encrypt(String msg){
		String newMsg = "";

		for (int i = 0; i < msg.length(); i++){
			char letter = msg.charAt(i);
			newMsg += (char)((int)letter + key);
		}
		return newMsg;
	}
}



