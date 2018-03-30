package com.example.photoframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import com.example.Launch;
import com.example.utils.DragToMove;
import com.example.utils.NPComponentUtils;
import com.example.utils.NPHelper;
import com.example.widget.NinePatchBorder;

import com.sun.awt.AWTUtilities;

public class Demo extends JPanel
{
	private JDialog dialogForShowingPhoto = null;
	private JPanel panePhotoframe = null;

	private JTextField txtPhotoframeDialogWidth = null;
	private JTextField txtPhotoframeDialogHeight = null;
	private JButton btnShowInFrame = null;
	private JButton btnHideTheFrame = null;

	/**
	 * 构造器
	 */
	public Demo() {
		super(new BorderLayout());
		initGUI();
		initListeners();
	}

	/**
	 * 页面及组件初始化
	 */
	private void initGUI() {
		// 组件初始化
		txtPhotoframeDialogWidth = new JTextField();
		txtPhotoframeDialogHeight = new JTextField();
		txtPhotoframeDialogWidth.setText("530");
		txtPhotoframeDialogHeight.setText("450");
		txtPhotoframeDialogWidth.setColumns(10);
		txtPhotoframeDialogHeight.setColumns(10);
		
		btnShowInFrame = new JButton("Show in new frame...");
		btnShowInFrame.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
		btnShowInFrame.setForeground(Color.white);
		btnHideTheFrame = new JButton("Hide the frame");
		btnHideTheFrame.setEnabled(false);
		
		panePhotoframe = createPhotoframe();
		panePhotoframe.add(
				new JLabel(new ImageIcon(Demo.class.getResource("/photoframe/imgs/girl.png"))),
				BorderLayout.CENTER);
		
		// 布局Layout初始化
		JPanel paneBtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		paneBtn.setBorder(BorderFactory.createEmptyBorder(12,0,0,0));
		paneBtn.add(new JLabel("Frame width:"));
		paneBtn.add(txtPhotoframeDialogWidth);
		paneBtn.add(new JLabel("Frame height:"));
		paneBtn.add(txtPhotoframeDialogHeight);
		paneBtn.add(btnShowInFrame);
		paneBtn.add(btnHideTheFrame);
		
		this.setBorder(BorderFactory.createEmptyBorder(12,20,10,20));
		this.add(panePhotoframe, BorderLayout.CENTER);
		this.add(paneBtn, BorderLayout.SOUTH);
		
		// 从父窗口中移动图片
		DragToMove.apply(new Component[]{panePhotoframe});
	}

	/**
	 * 事件
	 */
	private void initListeners() {

		btnShowInFrame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				showNewFrame();
			}
		});

		btnHideTheFrame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				hideTheFrame();
			}
		});
	}

	/**
	 * 照片面板
	 */
	private JPanel createPhotoframe() {
		//JPanel pf = new JPanel();// TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!
		JPanel pf = NPComponentUtils.createPanel_root(
				NPIconFactory.getInstance().getPhotoframeBg(),
				new Insets(13,15,15,15) );
		pf.setLayout(new BorderLayout());
		pf.setOpaque(false);
		
		//pf.setBorder(new AABorder());
		return pf;
	}
	
	private void showNewFrame() {
		if(dialogForShowingPhoto == null) {
			dialogForShowingPhoto = new JDialog(
					// bug of JDK1.7: can't repaint!
					//SwingUtilities.getWindowAncestor(org.jb2011.ninepatch4j.demos.photoframe.Demo.this)
					);
			// set dialog full transparent
			dialogForShowingPhoto.setUndecorated(true);
			AWTUtilities.setWindowOpaque(dialogForShowingPhoto, false);
			// contentPane default is opaque in Java1.7+
			((JComponent)(dialogForShowingPhoto.getContentPane())).setOpaque(false);
			dialogForShowingPhoto.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
			dialogForShowingPhoto.setLocation(100,100);
			//dialogForShowingPhoto.setLocationRelativeTo(null);
			dialogForShowingPhoto.setAlwaysOnTop(true);//
		}
		
		dialogForShowingPhoto.setSize(Integer.parseInt(txtPhotoframeDialogWidth.getText().trim())
				, Integer.parseInt(txtPhotoframeDialogHeight.getText().trim()));
		//this.remove(panePhotoframe);
		dialogForShowingPhoto.add(panePhotoframe);
		
		dialogForShowingPhoto.setVisible(true);
		btnHideTheFrame.setEnabled(true);
		btnShowInFrame.setEnabled(false);
	}
	
	private void hideTheFrame() {
		dialogForShowingPhoto.setVisible(false);
		btnHideTheFrame.setEnabled(false);
		btnShowInFrame.setEnabled(true);

		//dialogForShowingPhoto.remove(panePhotoframe);

		// 重新嵌入到父窗体
		this.add(panePhotoframe, BorderLayout.CENTER);
	}
	
	class AABorder extends NinePatchBorder {
		private final static int TOP = 17,LEFT = 27,RIGHT = 27,BOTTOM = 37;

		public AABorder() {
			super( new Insets(TOP, LEFT, BOTTOM, RIGHT),
					NPHelper.createNinePatch(Launch.class.getResource("/imgs/np/225.9.png"), false));
		}
	}
}
