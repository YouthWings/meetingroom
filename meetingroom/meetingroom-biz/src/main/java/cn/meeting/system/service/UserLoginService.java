package cn.meeting.system.service;

import java.util.List;

import cn.meeting.system.model.PermissionDO;
import cn.meeting.system.model.UserDO;


public interface UserLoginService {

	String getAccountByOpenId(String OpenId);

	// 得到放入session中的user对象
	UserDO getUserDOToSessionByAccount(String account);

	Integer getRoleIdByUserId(int id);

	List<PermissionDO> listPermissionByRoleId(int roleId);

	String getRoleByUserId(int userId);
}