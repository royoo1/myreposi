package service.usermanage;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

import data.SelectData;

public class SolveLogInOut {
	public void solveLogIn(PrintStream output,DataInputStream in){
		URLDecoder ud = new URLDecoder();
		try {
			String id =ud.decode(in.readLine(), "utf-8");
			String password=ud.decode(in.readLine(), "utf-8");
			String getPass;
			SelectData selectdata=new SelectData();
			if(selectdata.judgeId(id)){
				getPass=selectdata.getPassword(id);
				if(getPass.equals(password)){
					output.println(URLEncoder.encode("success", "utf-8"));
				}
				else{
					output.println(URLEncoder.encode("wrongPassword", "utf-8"));
				}
			}
			else{
				output.println(URLEncoder.encode("noId", "utf-8"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
