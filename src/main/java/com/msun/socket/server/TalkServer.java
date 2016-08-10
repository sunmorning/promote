/**
 * @describe socket服务端
 * @date 2016年8月1日
 * @author msun
 * @version 1.0
 * @class com.msun.socket.server.ServerSocket.java
 */
package com.msun.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {
public static void main(String[] arg0){
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(8000);
		} catch (IOException e) {
			System.out.println("端口8000已被占用，请重新选择其他端口!");
			e.printStackTrace();
		}
		
		Socket socket = null;
		
		try {
			socket = server.accept();
		} catch (IOException e) {
			System.out.println("接收客户端消息失败！");
			e.printStackTrace();
		}
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			PrintWriter witer = new PrintWriter(socket.getOutputStream());
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			String line;
			
			System.out.println("client: " + reader.readLine());
			System.out.println("请输入：");
			line = in.readLine();
			while(!line.endsWith("bye")){
				witer.println(line);
				witer.flush();
				
				System.out.println("client: " + reader.readLine());
				System.out.println("server输入：");
				line = in.readLine();
				
			}
			
			witer.close();
			reader.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			System.out.println("读取客户端信息失败!");
			e.printStackTrace();
		}
	}
}
