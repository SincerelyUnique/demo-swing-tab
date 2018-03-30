package com.example.fixtip;

import org.jb2011.ninepatch4j.NinePatch;
import com.example.utils.NPHelper;
import com.example.utils.RawCacheRoot;

import java.net.URL;

public class NPIconFactory extends RawCacheRoot<NinePatch> {

	public final static String IMGS_ROOT="fixtip/imgs/np";

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

	public NinePatch getFixTipBg() {
		return getRaw(getFixTipBg_PATH());
	}

	public String getFixTipBg_PATH()
	{
		return "fixtip/imgs/np/fixtip_bg.9.png";
	}
}