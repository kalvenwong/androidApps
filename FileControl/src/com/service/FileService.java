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
	 * �����ļ�
	 * @param filename �ļ�����
	 * @param filecontent �ļ�����
	 */
	public void save(String filename,String filecontent)throws Exception{
		//˽�в���ģʽ,�����������ļ�ֻ�ܱ���Ӧ�÷���,����Ӧ���޷����ʸ��ļ�,�������˽�в���ģʽ�������ļ�,д���ļ������ݻḲ��Դ�ļ�����
		FileOutputStream outStream=context.openFileOutput(filename,Context.MODE_PRIVATE);
		outStream.write(filecontent.getBytes());
		outStream.close();
	}
	
	/**
	 * ��ȡ�ļ�����
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public String read(String filename) throws Exception{
		FileInputStream inStream=context.openFileInput(filename);
		ByteArrayOutputStream outStream=new ByteArrayOutputStream();//���ڴ�����������
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=inStream.read(buffer))!=-1){
			outStream.write(buffer, 0, len);
		}
		byte[] data=outStream.toByteArray();//���data����save���������Ǹ�content.getByes()
		return	new String(data);
	}
}
