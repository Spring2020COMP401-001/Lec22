package lec20.v1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerWidget extends JPanel implements ActionListener {

	private double elapsed;
	private JButton start_stop;
	private JLabel elapsed_display;
	
	public TimerWidget() {
		elapsed = 0.0;

		elapsed_display = new JLabel("XXX");
		elapsed_display.setPreferredSize(new Dimension(45,10));

		start_stop = new JButton("Start");
		start_stop.setActionCommand("start");
		start_stop.addActionListener(this);
		
		JButton reset = new JButton("Reset");
		reset.setActionCommand("reset");
		reset.addActionListener(this);
		
		add(elapsed_display);
		add(start_stop);
		add(reset);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("start")) {
			start_stop.setText("Stop");
			start_stop.setActionCommand("stop");
		} else if (cmd.equals("stop")) {
			start_stop.setText("Start");
			start_stop.setActionCommand("start");
		} else if (cmd.equals("reset")) {
			elapsed = 0.0;
			elapsed_display.setText("0.0");
		}
	}
}
