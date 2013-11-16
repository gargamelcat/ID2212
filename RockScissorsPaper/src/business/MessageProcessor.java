package business;

import data.MessageQueue;

public class MessageProcessor extends Thread {

	public MessageProcessor() {

	}

	public void run() {
		while (true) {

			String message = null;
			while (MessageQueue.getInstance().getSize() == 0) {
			}
			
			message = MessageQueue.getInstance().getOldestEntry();
			System.out.println(message);

		}
	}

}
