package com.example.popup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import com.example.Launch;
import com.example.fixtip.FixtipPane;
import com.example.fixtip.FloatableDialog;
import com.example.utils.NPComponentUtils;
import com.example.utils.NPHelper;

public class Demo extends JPanel {

	private JButton btnShow = new JButton("Rover here to show toolTipText!");

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
		btnShow.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
		btnShow.setForeground(Color.white);
		btnShow.setToolTipText(
				"<html>\n" +
					"<body>\n" +
						"This message just used for demo, cool tool tip!\n" +
						"<br>\n" +
						"Ni hao Jack Jiang.\n" +
					"</body>\n" +
				"</html>\n");

		JPanel btnPane = NPComponentUtils.createPanel_root(
				NPHelper.createNinePatch( Launch.class.getResource("/imgs/np/cool_tool_tip_demo_bg.9.png"), false),
				new Insets(150,50,50,50) );
		btnPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnPane.add(btnShow);

		this.add(btnPane, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
	}

	/**
	 * 事件
	 */
	private void initListeners() {
		btnShow.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				FloatableDialog fixtipDialog = FloatableDialog.createDialog(
						new FixtipPane().setTiptext("Hay, rover here!"),
						SwingUtilities.getWindowAncestor(Demo.this),
						btnShow);
				fixtipDialog.display();
			}
		});
	}
}