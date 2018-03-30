package com.example.photoframe;

import org.jb2011.ninepatch4j.NinePatch;
import com.example.utils.NPHelper;
import com.example.utils.RawCacheRoot;

import java.net.URL;

public class NPIconFactory extends RawCacheRoot<NinePatch> {

	private final static String IMAGE_PATH = "/photoframe/imgs/np";
	private final static String IMAGE_NAME = "/photoframe_bg2.9.png";

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

	public NinePatch getPhotoframeBg() {
		return getRaw(IMAGE_PATH+IMAGE_NAME);
	}

	public NinePatch getRaw(String path) {
		return getRaw(path,IMAGE_NAME,this.getClass());
	}

	public static void main(String[] args) {
		NPIconFactory npi = new NPIconFactory();
		System.out.println(npi.getClass().getName());
		System.out.println(npi.getClass().getResource("/").getPath());
	}
}