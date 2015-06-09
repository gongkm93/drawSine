package drawsine.views;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;

import drawsine.PointPaintListener;
import drawsine.SettingData;

public class PictureView extends ViewPart {
private Label Amplitude,Frequency,Length,Zoom;
private Text textAmplitude,textFrequency,textLength;
private Button draw;
private Scale scale;
public int sizeX  ,sizeY ,SizeX ,SizeY  ;
public boolean first = true;
	public void createPartControl(Composite parent) {
		GridLayout gridlayout = new GridLayout();
		gridlayout.numColumns = 5;// 设置为3列
		gridlayout.makeColumnsEqualWidth = true;// 强制列宽相等
		parent.setLayout(gridlayout);
		Amplitude = new Label(parent, SWT.None);
		Amplitude.setText("Amplitude");
		textAmplitude = new Text(parent, SWT.BORDER);
		textAmplitude.setEditable(true);
		textAmplitude.getBorderWidth();
		Frequency = new Label(parent, SWT.None);
		Frequency.setText("Frequency");
		textFrequency = new Text(parent, SWT.BORDER);
		textFrequency.setEditable(true);
		draw = new Button(parent, SWT.None);
		draw.setText("darw");
		Length = new Label(parent, SWT.None);
		Length.setText("Length");
		textLength = new Text(parent, SWT.BORDER);
		textLength.setEditable(true);
		Zoom = new Label(parent,SWT.None);
		Zoom.setText("Zoom");
		scale = new Scale(parent,SWT.None);
		scale.setMaximum(2);
		scale.setMinimum(0);
		scale.setPageIncrement(1);
		scale.setSelection(2);
		
		Canvas canvas = new Canvas(parent, SWT.H_SCROLL);
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
	    gridData.verticalSpan = 4;
	    gridData.horizontalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 4;
	    gridData.grabExcessVerticalSpace = true;
		canvas.setLayoutData(gridData);
		draw.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				SettingData.setAmplitude(textAmplitude.getText());
				SettingData.setFrequency(textFrequency.getText());
				SettingData.setLength(textLength.getText());

				canvas.addPaintListener(new PointPaintListener());
				canvas.redraw();
			}
		});
		scale.addListener(SWT.Selection,new Listener() {

			@Override
			public void handleEvent(Event event) {
				if(first) {
					SizeX = canvas.getSize().x;
					SizeY = canvas.getSize().y; 
					}
					sizeX = SizeX;
					if (scale.getSelection() == 2 ){
						canvas.setSize(SizeX,SizeY);
					}else if (scale.getSelection() == 1) {					
						canvas.setSize(sizeX/2, SizeY);
						first = false;
					}else if (scale.getSelection() == 0){
						canvas.setSize(SizeX/3, SizeY);
						first = false;
					
					}
			}
			
		});
	}

	public void setFocus() {
	}
}