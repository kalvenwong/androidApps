package com.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.content.Context;

public class FileService {
	private Context context;
	
	public FileService(Context context) {
		this.context = context;
	}

	/**
	 * 保存文件
	 * @param filename 文件名称
	 * @param filecontent 文件内容
	 */
	public void save(String filename,String filecontent)throws Exception{
		//私有操作模式,创建出来的文件只能被本应用访问,其他应用无法访问该文件,另外采用私有操作模式创建的文件,写入文件的内容会覆盖源文件内容
		FileOutputStream outStream=context.openFileOutput(filename,Context.MODE_PRIVATE);
		outStream.write(filecontent.getBytes());
		outStream.close();
	}
	
	/**
	 * 读取文件内容
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public String read(String filename) throws Exception{
		FileInputStream inStream=context.openFileInput(filename);
		ByteArrayOutputStream outStream=new ByteArrayOutputStream();//往内存输出的输出流
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=inStream.read(buffer))!=-1){
			outStream.write(buffer, 0, len);
		}
		byte[] data=outStream.toByteArray();//这个data就是save方法里面那个content.getByes()
		return	new String(data);
	}
}
