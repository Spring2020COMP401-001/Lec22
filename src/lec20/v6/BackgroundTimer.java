package lec20.v6;

import javax.swing.SwingUtilities;

public class BackgroundTimer extends Thread {
	private boolean done;
	private TimerWidget tw;
	
	public BackgroundTimer(TimerWidget tw) {
		this.tw = tw;
		done = false;
	}

	public void halt() {
		done = true;
	}
	
	public void run() {
		long start = System.currentTimeMillis();
		
		while (!done) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
			long end = System.currentTimeMillis();
			final double delta = ((double) (end-start) / 1000.0);
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					tw.updateElapsed(delta);
				}
			});
			start = end;
		}
		long end = System.currentTimeMillis();
		final double delta = ((double) (end-start) / 1000.0);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				tw.updateElapsed(delta);
			}
		});
		start = end;
	}
}