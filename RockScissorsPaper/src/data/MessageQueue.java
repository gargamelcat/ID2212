package data;

import java.util.LinkedList;

public class MessageQueue {

	private static MessageQueue instance = null;
	private LinkedList<String> queue = null;
	
	public MessageQueue(){
		queue = new LinkedList<String>();
	}
	
	public static MessageQueue getInstance(){
		if(instance == null){
			instance = new MessageQueue();
		}
		return instance;
	}
	
	public void addNewMessage(String newMessage){
		queue.add(newMessage);
	}
	
	public String getOldestEntry(){
		return queue.removeFirst();
	}
	
	public int getSize(){
		return queue.size();
	}
}
