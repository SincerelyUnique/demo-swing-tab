package com.example.fixtip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

public class Demo extends JPanel {

	private JTextArea txtMsg = new JTextArea(5,5);
	private JTextField txtDeltaX = new JTextField();
	private JTextField txtDeltaY = new JTextField();
	
	private JButton btnShow = new JButton("Show fix tip!"), btnHide = new JButton("Hide it");
	
	private FixtipPane fixtipPane = new FixtipPane();
	private FloatableDialog fixtipDialog = null;

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
		// 初始化子组件
		txtMsg.setText(
				"<html>\n" +
					"<body>\n" +
						"This message just used for demo, <b>enjoy it</b>!\n" +
						"<br>\n" +
						"Have a good day.\n" +
					"</body>\n" +
				"</html>\n");
		txtDeltaX.setText("-15");
		txtDeltaY.setText("10");
		txtDeltaX.setColumns(10);
		txtDeltaY.setColumns(10);
		btnShow.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
		btnShow.setForeground(Color.white);

		// 初始化按钮面板
		JPanel btnPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPane.add(new JLabel("delta x:"));
		btnPane.add(txtDeltaX);
		btnPane.add(new JLabel("  delta y:"));
		btnPane.add(txtDeltaY);
		btnPane.add(btnShow);
		btnPane.add(btnHide);
		
		// 初始化主界面
		this.add(btnPane, BorderLayout.SOUTH);
		this.add(new JScrollPane(txtMsg), BorderLayout.CENTER);
		this.add(new JLabel("单击Fixtip组件即可退出显示哦."), BorderLayout.NORTH);
		this.setBorder(BorderFactory.createEmptyBorder(80,20,20,20));
	}

	/**
	 * 事件监听
	 */
	private void initListeners() {
		// “Show fix tip”按钮事件
		btnShow.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				fixtipPane.setTiptext(txtMsg.getText());
				if(fixtipDialog == null)
				{
					fixtipDialog = FloatableDialog.createDialog(fixtipPane
							, SwingUtilities.getWindowAncestor(Demo.this)
							, txtMsg);
					fixtipDialog.setInvisibleOnDispose(true);
				}
					
				fixtipDialog.setDeltaX(Integer.parseInt(txtDeltaX.getText().trim()));
				fixtipDialog.setDeltaY(Integer.parseInt(txtDeltaY.getText().trim()));
				fixtipDialog.display();
				
				/*String ninePatchFilePath = NPIconFactory.getInstance().getFixTipBg_PATH();
				CommonUtils.previewNinePatchWithDraw9PatchTool(
						// getResourceAsStream can load resource from JAR
						NPIconFactory.class.getResourceAsStream(ninePatchFilePath)
						, CommonUtils.getFilename(ninePatchFilePath));*/
			}
		});

		// “Hide it”按钮事件
		btnHide.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				fixtipDialog.exit();
			}
		});
	}
}
