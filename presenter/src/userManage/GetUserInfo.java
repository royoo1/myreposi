package userManage;


import java.net.Socket;
import java.net.URLDecoder;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;

import commonSocekt.ConnectServer;

public class GetUserInfo {
	String userid;
	String username;
	String nikename;
	String sex;
	String school;
	String password;
	String phonenumber;
	public GetUserInfo(String id,String pass){
		ConnectServer cons=new ConnectServer();
		Socket socket=cons.getSocket();
		PrintStream out=cons.getPrintStream();
		DataInputStream in=cons.getDataInputStream();
		if(socket!=null){
			out.println("getuserinfo");
			out.println(id);
			out.println(pass);
			try {
				String[] info=new String[7];
				String read=in.readLine();
				URLDecoder ud = new URLDecoder();
				for(int i=0;!read.equals("finish");i++){
					info[i]=ud.decode(read, "utf-8");
					read=in.readLine();
				}
				userid=info[0];
				username=info[1];
				nikename=info[2];
				sex=info[3];
				school=info[4];
				password=info[5];
				phonenumber=info[6];
				out.println("bye");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String getUserid() {
		return userid;
	}
	public String getUsername() {
		return username;
	}
	public String getNikename() {
		return nikename;
	}
	public String getSex() {
		return sex;
	}
	public String getSchool() {
		return school;
	}
	public String getPassword() {
		return password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	
}
