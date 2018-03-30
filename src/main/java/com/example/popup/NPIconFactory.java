package com.example.popup;

import org.jb2011.ninepatch4j.NinePatch;
import com.example.utils.NPHelper;
import com.example.utils.RawCacheRoot;

import java.net.URL;

public class NPIconFactory extends RawCacheRoot<NinePatch> {

	private final static String IMAGE_PATH = "popup/imgs/np";
	private final static String IMAGE_NAME9 = "/shadow_bg_popup.9.png";
	private final static String IMAGE_NAME29 = "/shadow_bg_tooltip2.9.png";
	private final static String IMAGE_NAME19 = "/scroll_pane_bg1.9.png";

	private static NPIconFactory instance = null;

	public static NPIconFactory getInstance() {
		if(instance==null)
			instance = new NPIconFactory();
		return instance;
	}

	@Override
	protected NinePatch getResource(URL url) {
		return NPHelper.createNinePatch(url, false);
	}

	public NinePatch getPopupBg() {
		return getRaw(IMAGE_PATH + IMAGE_NAME9 , IMAGE_NAME9);
	}

	public NinePatch getTooltipBg() {
		return getRaw(IMAGE_PATH + IMAGE_NAME29 , IMAGE_NAME29 );
	}

	public NinePatch getScrollPaneBorderBg() {
		return getRaw( IMAGE_PATH + IMAGE_NAME19 , null );
	}

	public NinePatch getRaw(String path , String imageName) {
		return  getRaw(path, imageName, this.getClass());
	}
}