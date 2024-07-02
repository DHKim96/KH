package com.kh.Test240201;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDAO {
	
	public boolean checkName(String file) {
		
		return new File(file).exists();
	}
	
	public void fileSave(String file, String s) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file) ) ) {
//			new File(file).createNewFile(); // 왜 안해도 되는 걸까
			// FilerWriter 클래스는 해당 파일이 없을 시 새로 만들고 연결해주기에 create~ 필요없는듯
			bw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public StringBuilder fileOpen(String file) {
		/*
		 * StringBuilder
		 * 		효율적으로 문자열을 처리하기 위한 클래스.
		 * 		다양한 기능의 메소드 제공함.
		 * 		append(), insert(), delete(), replace()...
		 */
		
		StringBuilder sb = new StringBuilder();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String value;
			while( ( value = br.readLine() ) != null ) {
				sb.append(value).append("\n");
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb;
	
		
		
		
	}
	
	public void fileEdit(String file, String s) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true) ) ) {
//			new File(file).createNewFile(); // 왜 안해도 되는 걸까
			bw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
