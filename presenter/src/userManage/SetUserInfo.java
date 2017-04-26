package userManage;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URLEncoder;
import java.net.UnknownHostException;

public class SetUserInfo {
	String userid;
	String username;
	String nikename;
	String sex;
	String school;
	String password;
	String phonenumber;
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public void sendInfo(){
		try {
			Socket socket=new Socket("172.29.117.17",12345);
            PrintStream out = new PrintStream(socket.getOutputStream());   
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.println("registerinfo");
            out.println(URLEncoder.encode(userid, "utf-8"));
            out.println(URLEncoder.encode(username, "utf-8"));
            out.println(URLEncoder.encode(nikename, "utf-8"));
            out.println(URLEncoder.encode(sex, "utf-8"));
            out.println(URLEncoder.encode(school, "utf-8"));
            out.println(URLEncoder.encode(password, "utf-8"));
            out.println(URLEncoder.encode(phonenumber, "utf-8"));
            out.println("finish");
            out.println("bye");
            
            if((in.readLine()).equals("bye")){
            	
            	socket.close();
            }
            
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void login(){
		
	}
	
}
