package cn.meeting.system.dao.base;

import cn.meeting.system.model.UserDO;

public interface UserMapper {
	/**
	 * @Description: 得到学号
	 * @param account
	 * @return
	 */
	String getAccountByOpenId(String OpenId);

	/**
	 * 
	 * @Description:得到用户数据库对象
	 * @param account
	 * @return
	 */
	UserDO getUserDOByAccount(String account);
}
