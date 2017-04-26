package test;

import java.util.ArrayList;
import java.util.List;

import parttimejob.GetJobInfo;
import parttimejob.JobInfo;
import parttimejob.SendJobInfo;
import userManage.GetUserInfo;
import userManage.SetUserInfo;

public class TestJob {
	public static void main(String[] args){
		//setuserinfo();
		//sendjobinfo();
		getJobInfo();
	}
	public static void setuserinfo(){
		
		SetUserInfo setuserinfo=new SetUserInfo();
		setuserinfo.setUserid("14301042");
		setuserinfo.setUsername("卢海龙");
		setuserinfo.setNikename("royoo1");
		setuserinfo.setSex("男");
		setuserinfo.setSchool("软件学院");
		setuserinfo.setPassword("012345");
		setuserinfo.setPhonenumber("18401605971");
		setuserinfo.sendInfo();
		
		/**SetUserInfo setuserinfo=new SetUserInfo();
		setuserinfo.setUserid("14301041");
		setuserinfo.setUsername("刘琛");
		setuserinfo.setNikename("demien糖");
		setuserinfo.setSex("男");
		setuserinfo.setSchool("软件学院");
		setuserinfo.setPassword("012345");
		setuserinfo.setPhonenumber("13241828119");
		setuserinfo.sendInfo();**/
	}
	public static void getuserinfo(){
		GetUserInfo getuserinfo=new GetUserInfo("14301042","123456");
		System.out.println(getuserinfo.getUsername());
	}
	public static void sendjobinfo(){
		/**SendJobInfo send=new SendJobInfo();
		send.setAdress("16号公寓506宿舍");
		send.setCash("50");
		send.setDeadline("2017-4-19 12:00:00");
		send.setExcutedate("2017-4-18 12:00:00");
		send.setJobcontent("去学活下沉广场买一瓶洗衣液");
		send.setJobname("买洗衣液");
		send.setJobtype("买生活品");
		send.setPhone("18401605971");
		send.setPushdate();
		send.setSexrequire("男");
		send.setUserid("14301041");
		send.sendJobInfo();**/
		
		SendJobInfo send=new SendJobInfo();
		send.setAdress("16号公寓506宿舍");
		send.setCash("10");
		send.setDeadline("2017-4-24 12:00:00");
		send.setExcutedate("2017-4-23 12:00:00");
		send.setJobcontent("去南门中通快递6号柜13号");
		send.setJobname("取快递");
		send.setJobtype("生活");
		send.setPhone("18401605971");
		send.setPushdate();
		send.setSexrequire("男");
		send.setUserid("14301042");
		send.sendJobInfo();
	}
	
	
	public static void getJobInfo(){
		List<JobInfo> joblist=new ArrayList<JobInfo>();
		JobInfo job=new JobInfo();
		GetJobInfo getjobinfo=new GetJobInfo();
		joblist=getjobinfo.getBytype("pushtime", 1);
		for(int i=0;i<joblist.size();i++){
			job=joblist.get(i);
			System.out.println(job.getJobname());
			System.out.println(job.getPushdate());
			System.out.println(job.getAdress());
			System.out.println(job.getCash());
			System.out.println(job.getDeadline());
			System.out.println(job.getExcutedate());
			System.out.println(job.getJobcontent());
			System.out.println(job.getJobtype());
			System.out.println(job.getPhone());
			System.out.println(job.getSexrequire());
			System.out.println(job.getUserid());
			
			
		}
	}
	
	public static void setApply(){
		
	}
}
