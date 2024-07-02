package com.kh.Test240201;

public class FileController {
	private FileDAO fd = new FileDAO();
	
	public boolean checkName(String file) {
		
		return fd.checkName(file);
	}
	
	public void fileSave(String file, StringBuilder sb) {
		String str = String.valueOf(sb);
		fd.fileSave(file, str);
	}
	
	public StringBuilder fileOpen(String file) {
		return fd.fileOpen(file);
	}
	
	public void fileEdit(String file, StringBuilder sb) {
		String str = String.valueOf(sb); // 또는 toString
		fd.fileEdit(file, str);
	}

	
}
