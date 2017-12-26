package org.spring.simplemail.service;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;



public class SpringMail {
	
	public String sendHost = "smtp.163.com"; // 邮箱发送服务器  
	public String sendUser = "18256075451@163.com"; // 用户名  
	public String sendPassword = "214219bjx"; // 密码  
	public String fromMail = "18256075451@163.com";// 发送方邮箱地址  
	public String toMail = "baijx@eastcom-sw.com"; // 接收方邮箱地址  
	public String CCMail = sendUser; // 抄送方邮箱地址  
	public String BCCMail = sendUser; // 密送方邮箱地址    
	public String encode = "UTF-8";  
	
	public void sendAttachmentMail() throws Exception {    
	        // spring提供的邮件实现类  
	        JavaMailSenderImpl send = new JavaMailSenderImpl();  
	        Properties prop = new Properties();  
	        prop.setProperty("mail.transport.protocol", "smtp"); // 设置邮件发送协议  
	        prop.setProperty("mail.host", sendHost); // 邮件服务器地址  
	        prop.setProperty("mail.smtps.ssl.enable", "true"); // 邮件ssl验证  
	        prop.setProperty("mail.smtp.auth", "true"); // 邮件服务身份验证  	  
	        send.setUsername(sendUser); // 设置用户名  
	        send.setPassword(sendPassword); // 设置密码  
	        send.setJavaMailProperties(prop);  	  
	        MimeMessage msg = send.createMimeMessage();  
	        // 指定HTML编码，参数true表示为multipart  
	        MimeMessageHelper helper = new MimeMessageHelper(msg, true, encode);  
	        helper.setFrom(fromMail); // 发送者邮箱  
	        helper.setTo(toMail); // 接收者邮箱  
	        helper.setReplyTo(fromMail); // 回复邮箱  
	        helper.setCc(CCMail); // 抄送邮箱  
	        helper.setBcc(BCCMail); // 密送邮箱  
	        helper.setSentDate(new Date()); // 发送日期  
	        helper.setSubject("发送带有附件的邮件");  
	        String html = "<h3><center>性能管理系统ESB规约接收情况统计</center></h3>\n" + 
	        		"<p><font face=\"楷体\" size=\"4\">郑春:<br>\n" + 
	        		"&nbsp&nbsp;&nbsp;&nbsp;您好!<br>\n" + 
	        		"&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;性能管理系统对12月24号所有采集的ESB规约进行了统计:<br>\n" + 
	        		"<center>\n" + 
	        		"<table border = \"1\" >\n" + 
	        		"  <colgroup>\n" + 
	        		"    <col span=\"1\" style=\"background-color:green\">\n" + 
	        		"    <col style=\"background-color:yellow\">\n" + 
	        		"	<col style=\"background-color:red\">\n" + 
	        		"  </colgroup>\n" + 
	        		"<thead>\n" + 
	        		"  <tr>\n" + 
	        		"    <th>规约总数</th>\n" + 
	        		"    <th>问题规约</th>\n" + 
	        		"	<th>低于80%规约</th>\n" + 
	        		"  </tr>\n" + 
	        		"</thead>\n" + 
	        		"</tbody>\n" + 
	        		"  <tr>\n" + 
	        		"    <td>822</td>\n" + 
	        		"    <td>236</td>\n" + 
	        		"	<td>128</td>\n" + 
	        		"  </tr>\n" + 
	        		"</tbody>  \n" + 
	        		"</table>\n" + 
	        		"</center><br>\n" + 
	        		"&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;详情请看性能管理系统ESB规约接收情况汇总表。\n" + 
	        		"</font></p>\n" + 
	        		"<p><font color=\"#6699CC\">____________________________</font></p>\n" + 
	        		"<p><font color=\"#C0C0C0\">江悦<br>\n" + 
	        		"技术支持工程师<br>\n" + 
	        		"杭州东方通信软件技术有限公司/技术支持部/上海<br>\n" + 
	        		"13764307542<br>\n" + 
	        		"杭州市文三路398号东方通信大厦9楼</font></P>";  
	        helper.setText(html, true); // 邮件内容，参数true表示是html代码  
	        String filename = "../mail/mail.txt";
	        File file = new File(filename);
	        DataSource resource = new FileDataSource(file);
	        helper.addAttachment(MimeUtility.encodeWord(filename.substring(filename.lastIndexOf("/")+1,filename.length())), resource); // 如果文件是中文名，需要转码。         
	        send.send(msg); // 发送邮件  
	        System.out.println("Successfully  send mail to the user");  
	    }  
	  
	  public static void main(String[] args) throws Exception {
		  SpringMail springMail = new SpringMail();
		  springMail.sendAttachmentMail();
		  
	}

}
