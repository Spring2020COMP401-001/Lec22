package lec20.v5;

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
		class WidgetUpdater implements Runnable {
			private double delta;
			public WidgetUpdater(double delta) {
				this.delta = delta;
			}

			@Override
			public void run() {
				tw.updateElapsed(delta);
			}
		}

		long start = System.currentTimeMillis();

		while (!done) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
			long end = System.currentTimeMillis();
			double delta = ((double) (end-start) / 1000.0);
			SwingUtilities.invokeLater(new WidgetUpdater(delta));
			start = end;
		}
		long end = System.currentTimeMillis();
		double delta = ((double) (end-start) / 1000.0);


		SwingUtilities.invokeLater(new WidgetUpdater(delta));
		start = end;
	}


}

