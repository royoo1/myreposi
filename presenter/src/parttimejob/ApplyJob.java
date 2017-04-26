package parttimejob;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import commonSocekt.ConnectServer;

public class ApplyJob {
	String jobid;
	String workerid;
	String content;
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public void sendApply(){
		ConnectServer cons=new ConnectServer();
		PrintStream out=cons.getPrintStream();
		
		try {
			out.println(URLEncoder.encode("applyinfo", "utf-8"));
			out.println(URLEncoder.encode(jobid, "utf-8"));
			out.println(URLEncoder.encode(workerid, "utf-8"));
			out.println(URLEncoder.encode(content, "utf-8"));
			out.println(URLEncoder.encode("finish", "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
