package parttimejob;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import commonSocekt.ConnectServer;

public class GetApplyInfo {
	List<ApplyJob> alist=null;
	ConnectServer cons;
	DataInputStream in;
	PrintStream out;
	public GetApplyInfo(){
		cons=new ConnectServer();
		in=cons.getDataInputStream();
		out=cons.getPrintStream();
	}
	public List<ApplyJob> getApplyInfoByJobid(int jobid){
		out.println("getapplyinfo");
		out.println(String.valueOf(jobid));
		URLDecoder ud = new URLDecoder();
		String get;
		ApplyJob ajob;
		try {
			get=ud.decode(in.readLine(), "utf-8");
			while(!get.equals("finish")){
				ajob=new ApplyJob();
				ajob.setJobid(get);
				ajob.setWorkerid(ud.decode(in.readLine(), "utf-8"));
				ajob.setContent(ud.decode(in.readLine(), "utf-8"));
				alist.add(ajob);
				get=ud.decode(in.readLine(), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alist;
	}
}
