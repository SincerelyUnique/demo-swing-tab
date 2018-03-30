package com.example.toast;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jb2011.ninepatch4j.NinePatch;
import com.example.utils.DragToMove;

public class ToastPane extends JPanel {

	private NinePatch npBackground = null;
	private JComponent content = null;
	
	public ToastPane() {
		super(new BorderLayout());
		initGUI();
	}

	@Override
	public void paintChildren(Graphics g) {
		if(npBackground == null)
			// load the nine patch .PNG
			npBackground = NPIconFactory.getInstance().getToastBg();
		if(npBackground != null)
			// paint background with ninepath
			npBackground.draw((Graphics2D)g, 0, 0, this.getWidth(), this.getHeight());
		super.paintChildren(g);
	}
	
	protected void initGUI() {
		this.setOpaque(false);
		
		content = createContent();
		// drag to move
		DragToMove.apply(new Component[]{content});
		
		this.add(content, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createEmptyBorder(19,20,28,20));
	}

	protected JComponent createContent() {
		JLabel lb = new JLabel("");
		lb.setForeground(new Color(230,230,230));
		return lb;
	}

	public void setMessage(String message) {
		((JLabel)content).setText(message);
	}
	
	public JComponent getContent() {
		return content;
	}
}
