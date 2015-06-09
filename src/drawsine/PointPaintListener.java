package drawsine;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;

public class PointPaintListener implements PaintListener {
	public double amplitude;
	public double frequency;
	public int length;
	@Override
	public void paintControl(PaintEvent e) {
		// Get the canvas and its dimensions
		Canvas canvas = (Canvas) e.widget;
		int maxX = canvas.getSize().x;
		int maxY = canvas.getSize().y;

		// Calculate the middle
		int halfX = (int) maxX / 2;
		int halfY = (int) maxY / 2;

		// Set the line color and draw a horizontal axis
		e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_BLACK));
		e.gc.drawLine(0, halfY, maxX, halfY);
		e.gc.drawLine(20, 85, maxX, 85);
		//get settingdata
		
	    amplitude = Double.valueOf(SettingData.getAmplitude());
		frequency = Double.valueOf(SettingData.getFrequency());
		length = Integer.valueOf(SettingData.getLength());
//		System.out.println(amplitude + frequency + length);
		// Draw the sine wave
		for (int i = 0; i < length; i++) {
			e.gc.drawPoint(i, getNormalizedSine(i, halfY, frequency));
		}

	}

	private int getNormalizedSine(int x, int halfY, double maxX) {
		double piDouble = 2 * Math.PI;
		double factor = piDouble / maxX;
		return (int) (Math.sin(x * factor) * amplitude + halfY);
	}

}