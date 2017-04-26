package parttimejob;

import java.util.Date;
import java.text.SimpleDateFormat;

import commonSocekt.ConnectServer;

import java.net.Socket;
import java.net.URLEncoder;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
public class SendJobInfo {
	String jobname;
	String jobcontent;
	String pushdate;
	String deadline;
	String excutedate;
	String cash;
	String jobtype;
	String sexrequire;
	String adress;
	String phone;
	String userid;
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public void setJobcontent(String content) {
		this.jobcontent=content;
	}
	public void setPushdate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		pushdate=df.format(new Date());// new Date()为获取当前系统时间
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public void setExcutedate(String excutedate) {
		this.excutedate = excutedate;
	}
	public void setCash(String cash) {
		this.cash = cash;
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public void setSexrequire(String sexrequire) {
		this.sexrequire = sexrequire;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void sendJobInfo(){
		ConnectServer cons=new ConnectServer();
		Socket socket=cons.getSocket();
		PrintStream out=cons.getPrintStream();
		out.println("pushjob");
		try {
			out.println(URLEncoder.encode(jobname, "utf-8"));
			out.println(URLEncoder.encode(jobcontent, "utf-8"));
			out.println(URLEncoder.encode(pushdate, "utf-8"));
			out.println(URLEncoder.encode(deadline, "utf-8"));
		    out.println(URLEncoder.encode(excutedate, "utf-8"));
		    out.println(URLEncoder.encode(cash, "utf-8"));
		    out.println(URLEncoder.encode(jobtype, "utf-8"));
		    out.println(URLEncoder.encode(sexrequire, "utf-8"));
		    out.println(URLEncoder.encode(adress, "utf-8"));
		    out.println(URLEncoder.encode(phone, "utf-8"));
		    out.println(URLEncoder.encode(userid, "utf-8"));
		    out.println("finish");
		    
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
