package com.example.toast;

import org.jb2011.ninepatch4j.NinePatch;
import com.example.utils.NPHelper;
import com.example.utils.RawCacheRoot;

public class NPIconFactory extends RawCacheRoot<NinePatch> {

	private final static String IMGS_ROOT="toast/imgs/np";

	private static NPIconFactory instance = null;

	public static NPIconFactory getInstance() {
		if(instance==null)
			instance = new NPIconFactory();
		return instance;
	}

	@Override
	protected NinePatch getResource(String relativePath, Class baseClass) {
		return NPHelper.createNinePatch(baseClass.getResource(relativePath), false);
	}

	private NinePatch getRaw(String relativePath) {
		return getRaw(relativePath,this.getClass());
	}

	public NinePatch getToastBg() {
		return getRaw(IMGS_ROOT+"/toast_bg.9.png");
	}
	
}