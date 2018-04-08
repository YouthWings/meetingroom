package cn.meeting.controller.business;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thoughtworks.xstream.XStream;



@Controller
/**
 * @author linzj
 * @Description: 接受wx的xml响应及回调
 * @date 2018年4月8日 下午2:36:55
 */   
@RequestMapping("/index")
public class IndexController{
	/**
	 * 
	 * @author linzj
	 * @Description: 用于接受微信的回调  
	 * @param @return 
	 * @return String 
	 * @date 2018年4月8日 下午4:46:56     
	 * @throws
	 */
	@RequestMapping(value = "/key", method = RequestMethod.POST, produces = "application/xml;charset=utf-8")
	@ResponseBody
	public String key() {
		/**
		 * 将xml字符串转化为对象 
		 * 将xml转化为对象 XStream xs =
		 * SerializeXmlUtil.createXstream(); xs.processAnnotations(WxAll.class);
		 * xs.alias("xml", WxAll.class); 
		 * final WxAll content =(WxAll) xs.fromXML(xml);
		 */
		
		/**
		 * 将对象转化为xml
		 * XStream xs = SerializeXmlUtil.createXstream();
		 * xs.processAnnotations(WxImageAndTextMessage.class);
		 * xs.alias("xml", WxImageAndTextMessage.class);
		 * String xml = xs.toXML(newsDo);
		 */
		return null;
	}
}
