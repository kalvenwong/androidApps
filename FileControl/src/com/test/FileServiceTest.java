package com.test;

import android.test.AndroidTestCase;
import android.util.Log;

import com.service.FileService;

public class FileServiceTest extends AndroidTestCase {
	FileService service = new FileService(this.getContext());
	private static final String tag="FileServiceTest";
	
	public void testRead() throws Exception {
		String result = service.read("kalven.txt");
		Log.i(tag, result);
	}
}
