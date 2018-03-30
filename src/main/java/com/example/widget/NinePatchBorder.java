package com.example.widget;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.border.AbstractBorder;

import org.jb2011.ninepatch4j.NinePatch;

/**
 * 一个利用NinePatch图实现边框的border实现类.
 * <p>
 * 本类可以很好地被重用于NinePatch图作为border实现的场景哦.
 */
public class NinePatchBorder extends AbstractBorder {
	
	// 插图
	private Insets insets = null;
	
	// 九宫
	private NinePatch np = null;

	public NinePatchBorder(Insets insets, NinePatch np) {
		this.insets = insets;
		this.np = np;
	}

	public Insets getBorderInsets(Component c) {
		return insets;
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		return insets;
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		this.np.draw((Graphics2D)g, x, y, width, height);
	}
}
