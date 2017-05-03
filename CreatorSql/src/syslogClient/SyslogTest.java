package syslogClient;

import java.net.URLDecoder;
import java.util.Date;

import org.productivity.java.syslog4j.Syslog;
import org.productivity.java.syslog4j.SyslogIF;

public class SyslogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 获取syslog的操作类，使用udp协议。syslog支持"udp", "tcp", "unix_syslog",
			// "unix_socket"协议
			SyslogIF syslog = Syslog.getInstance("udp");
			// 设置syslog服务器端地址
			syslog.getConfig().setHost("10.221.247.12");
			// 设置syslog接收端口，默认514
			syslog.getConfig().setPort(10086);
			// 拼接syslog日志，这个日志是自己定义的，通常我们定义成符合公司规范的格式就行，方便查询。例如 操作时间：2014年8月1日
			// 操作者ID:张三 等。信息就是一个字符串。
			StringBuffer buffer = new StringBuffer();
//			buffer.append("操作时间：" + new Date().toString().substring(4, 20) + ";");
//			buffer.append("操作者ID:" + "张三" + ";");
//			buffer.append("操作时间:" + new Date() + ";");
//			buffer.append("日志类别:" + "22" + ";");
//			buffer.append("执行动作:" + "动作" + ";");
			buffer.append("STREAM_ALARM|2016-01-20 15:55:00|重要区域|2015-外滩|TCP下行乱序率|3.7699554|%|3|| |STATIC|3%|5%");
			/*
			 * 发送信息到服务器，2表示日志级别 范围为0~7的数字编码，表示了事件的严重程度。0最高，7最低
			 * syslog为每个事件赋予几个不同的优先级： LOG_EMERG：紧急情况，需要立即通知技术人员。
			 * LOG_ALERT：应该被立即改正的问题，如系统数据库被破坏，ISP连接丢失。
			 * LOG_CRIT：重要情况，如硬盘错误，备用连接丢失。 LOG_ERR：错误，不是非常紧急，在一定时间内修复即可。
			 * LOG_WARNING：警告信息，不是错误，比如系统磁盘使用了85%等。 LOG_NOTICE：不是错误情况，也不需要立即处理。
			 * LOG_INFO：情报信息，正常的系统消息，比如骚扰报告，带宽数据等，不需要处理。
			 * LOG_DEBUG：包含详细的开发情报的信息，通常只在调试一个程序时使用。
			 */
//			syslog.log(7, URLDecoder.decode(buffer.toString(), "utf-8"));
			syslog.log(6, buffer.toString());
//			syslog.debug("STREAM_ALARM|2016-01-20 15:55:00|重要区域|2015-外滩|TCP下行乱序率|3.7699554|%|3|| |STATIC|3%|5%");
		} catch (Exception e) {
		}
	}

}
