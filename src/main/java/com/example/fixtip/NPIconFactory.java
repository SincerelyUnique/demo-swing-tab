package com.example.fixtip;

import org.jb2011.ninepatch4j.NinePatch;
import com.example.utils.NPHelper;
import com.example.utils.RawCacheRoot;

import java.net.URL;

public class NPIconFactory extends RawCacheRoot<NinePatch> {

	private final static String IMAGE_PATH = "fixtip/imgs/np";
	private final static String IMAGE_NAME9 = "/fixtip_bg.9.png";

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

	public NinePatch getFixTipBg() {
		return getRaw( IMAGE_PATH + IMAGE_NAME9 );
	}

	public NinePatch getRaw(String path) {
		return  getRaw(path, IMAGE_NAME9, this.getClass());
	}
}