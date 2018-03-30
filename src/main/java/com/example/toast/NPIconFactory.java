package com.example.toast;

import org.jb2011.ninepatch4j.NinePatch;
import com.example.utils.NPHelper;
import com.example.utils.RawCacheRoot;

import java.net.URL;

public class NPIconFactory extends RawCacheRoot<NinePatch> {

	private final static String IMAGE_PATH = "toast/imgs/np";
	private final static String IMAGE_NAME = "/toast_bg.9.png";

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

	public NinePatch getToastBg() {
		return getRaw(IMAGE_PATH + IMAGE_NAME );
	}

	private NinePatch getRaw(String path) {
		return getRaw(path, IMAGE_NAME, this.getClass());
	}
}