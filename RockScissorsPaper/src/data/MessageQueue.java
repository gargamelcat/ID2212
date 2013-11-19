package data;

import java.util.LinkedList;

public class MessageQueue {

	private static MessageQueue instance = null;
	private LinkedList<String> queue = null;
	
	private MessageQueue(){
		queue = new LinkedList<String>();
	}
	
	public synchronized static MessageQueue getInstance(){
		if(instance == null){
			instance = new MessageQueue();
		}
		return instance;
	}
	
	public synchronized void addNewMessage(String newMessage){
		queue.add(newMessage);
	}
	
	public synchronized String getOldestEntry(){
		return queue.removeFirst();
	}
	
	public synchronized int getSize(){
		return queue.size();
	}
}
