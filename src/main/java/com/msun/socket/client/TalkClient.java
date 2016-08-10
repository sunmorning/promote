/**
 * @describe 
 * @date 2016年8月1日
 * @author msun
 * @version 1.0
 * @class com.msun.socket.client.TalkClient.java
 */
package com.msun.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class TalkClient {
	public static void main(String[] arg0){
		
		Socket client = null;
		try {
			client = new Socket("127.0.0.1", 8000);
		} catch (UnknownHostException e) {
			System.out.println("获取主机信息失败！");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("连接服务器失败！");
			e.printStackTrace();
		}
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(client.getOutputStream());
			BufferedReader server = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			String line = "";
			System.out.println("client 输入: ");
			line = reader.readLine();
			while(!line.equals("bye")){
				writer.println(line);
				writer.flush();
				
				System.out.println("server: " + server.readLine());
				
				System.out.println("client 输入: ");
				line = reader.readLine();
			}
			
			writer.close();
			reader.close();
			client.close();;
			
		} catch (IOException e) {
			System.out.println("客户端交互失败!");
			e.printStackTrace();
		}
	}
}
