package com.example.popup;

import org.jb2011.ninepatch4j.NinePatch;
import com.example.utils.NPHelper;
import com.example.utils.RawCacheRoot;

import java.net.URL;

public class NPIconFactory extends RawCacheRoot<NinePatch> {

	public final static String IMGS_ROOT="popup/imgs/np";

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

	public NinePatch getRaw(String relativePath) {
		return  getRaw(relativePath,this.getClass());
	}

	public NinePatch getPopupBg() {
		return getRaw(IMGS_ROOT+"/shadow_bg_popup.9.png");
	}

	public NinePatch getTooltipBg() {
		return getRaw(IMGS_ROOT+"/shadow_bg_tooltip2.9.png");
	}

	public NinePatch getScrollPaneBorderBg() {
		return getRaw(IMGS_ROOT+"/scroll_pane_bg1.9.png");
	}
}