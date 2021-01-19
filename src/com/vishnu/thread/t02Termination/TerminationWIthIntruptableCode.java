package com.vishnu.thread.t02Termination;

public class TerminationWIthIntruptableCode {
	public static void main(String[] args) {
		Thread thread = new Thread(new BlockingTask());

		thread.start();
		thread.interrupt();
	}

	private static class BlockingTask implements Runnable {

		@Override
		public void run() {
			// do things
			try {
				Thread.sleep(500000);
			} catch (InterruptedException e) {
				System.out.println("Existing blocking thread");
			}
		}
	}
}
