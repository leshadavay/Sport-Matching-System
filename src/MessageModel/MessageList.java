package MessageModel;

import java.util.ArrayList;

public class MessageList {
	private ArrayList<String> messageList = new ArrayList<String>();

	public String[] getMessageList() {
		return messageList.toArray(new String[messageList.size()]);
	}

	public void setMessageList(ArrayList<String> messageList) {
		this.messageList = messageList;
	}
	
	public int getListSize() {
		return messageList.size();
	}
}
