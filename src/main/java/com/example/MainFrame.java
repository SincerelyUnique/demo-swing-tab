package com.example;

import com.example.utils.PropertyUtils;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {

	private JPanel mainPane = new JPanel(new BorderLayout());
	
	public MainFrame(String path) throws HeadlessException {
		super (PropertyUtils.
				getValue("title",PropertyUtils.SYSTEM_PATH));
		initGUI();
		setSize(900, 680);
	}
	
	private void initGUI() {
		this.mainPane.add(createMainTabs(), BorderLayout.CENTER);
		this.getContentPane().add(mainPane);
		this.setJMenuBar(createMenuBar());
	}
	
	private JComponent createMainTabs() {
		JTabbedPane tbs = new JTabbedPane();
		
		tbs.add(new com.example.popup.Demo(), "Cool tooltip");
		tbs.add(new com.example.fixtip.Demo(), "Cool fix tip");
		tbs.add(new com.example.photoframe.Demo(), "Photo frame");
		tbs.add(new JPanel(), "Cool border demo");
		tbs.add(new JPanel(), PropertyUtils.
				getValue("mainFrame.panel.label1",PropertyUtils.SYSTEM_PATH));
		tbs.add(new JPanel(), PropertyUtils.
				getValue("mainFrame.panel.label2",PropertyUtils.SYSTEM_PATH));
		tbs.add(new com.example.toast.Demo(), "Toast");
		
		tbs.setToolTipTextAt(0, "Cool tooltip");
		tbs.setToolTipTextAt(1, "Cool fix tip");
		tbs.setToolTipTextAt(2, "Photo frame");
		tbs.setToolTipTextAt(3, "Cool border demo");
		tbs.setToolTipTextAt(4, PropertyUtils.
				getValue("mainFrame.panel.label1",PropertyUtils.SYSTEM_PATH));
		tbs.setToolTipTextAt(5, "Cool 名片");
		tbs.setToolTipTextAt(3, "Toast");
		
		return tbs;
	}
	
	private JMenuBar createMenuBar() {

		// 菜单栏MenuDemo1
		JMenu fileMenu = new JMenu("MenuDemo1");
		JMenuItem openMenuItem = new JMenuItem("Menu item 1");
		JMenuItem saveMenuItem = new JMenuItem("Menu item 2");
		JMenuItem exitMenuItem = new JMenuItem("Menu item 3");
		fileMenu.add(openMenuItem);
		saveMenuItem.setEnabled(false);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);

		// 菜单栏MenuDemo2
		JMenu fileMenu2 = new JMenu("MenuDemo2");
		fileMenu2.add(new JMenuItem("Menu item 1"));
		fileMenu2.add(new JMenuItem("Menu item 2"));
		fileMenu2.addSeparator();
		fileMenu2.add(new JMenuItem("Menu item 3"));
		fileMenu2.add(new JMenuItem("Menu item 4"));
		fileMenu2.addSeparator();
		fileMenu2.add(new JMenuItem("Menu item 5"));
		fileMenu2.add(new JMenuItem("Menu item 6"));
		fileMenu2.add(new JMenuItem("Menu item 7"));
		fileMenu2.add(new JMenuItem("Menu item 8"));

		JMenu aboutMenu = new JMenu(PropertyUtils.
				getValue("mainFrame.about",PropertyUtils.SYSTEM_PATH));
		JMenuItem aboutMenuItem = new JMenuItem(PropertyUtils.
				getValue("mainFrame.aboutProject",PropertyUtils.SYSTEM_PATH));
		aboutMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(rootPane, "Swing9patch" +
						"\n - "+ PropertyUtils.getValue("mainFrame.about.line1",PropertyUtils.SYSTEM_PATH) +
						"\n - "+ PropertyUtils.getValue("mainFrame.about.line2",PropertyUtils.SYSTEM_PATH) +
						"\n - "+ PropertyUtils.getValue("mainFrame.about.line3",PropertyUtils.SYSTEM_PATH) +
						"\n");
			}
		});
		aboutMenu.add(aboutMenuItem);
		
		JMenuBar menuBar = new JMenuBar();
		//menuBar.add(fileMenu);
		//menuBar.add(fileMenu2);
		menuBar.add(aboutMenu);
		
		return menuBar;
	}
}
