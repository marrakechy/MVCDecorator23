public class BinaryMessage extends MessageDecorator {
	private Message m;
	public BinaryMessage(Message m) {
		super(m);
		this.m = m;
	}

	@Override
	public String getTheMsg() {
		return encode(m.getTheMsg());
	}

	private String encode(String msg){
		String newMsg = "";

		for (int i = 0; i < msg.length(); i++){
			char letter = msg.charAt(i);
			String binStr = Integer.toBinaryString((int)letter);
			while (binStr.length() < 8){
				binStr = "0"+ binStr;
			}
			newMsg += binStr+ "\n";
		}
		return newMsg;
	}
}



