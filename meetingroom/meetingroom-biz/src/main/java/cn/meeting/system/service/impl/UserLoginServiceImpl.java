package cn.meeting.system.service.impl;

import java.util.List;

import org.apache.ibatis.jdbc.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.meeting.system.dao.base.PermissionMapper;
import cn.meeting.system.dao.base.RoleMapper;
import cn.meeting.system.dao.base.RolePermissionMapper;
import cn.meeting.system.dao.base.UserMapper;
import cn.meeting.system.dao.base.UserRoleMapper;
import cn.meeting.system.model.PermissionDO;
import cn.meeting.system.model.UserDO;
import cn.meeting.system.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	UserRoleMapper userRoleMapper;
	@Autowired
	RolePermissionMapper rolePermissionMapper;
	@Autowired
	PermissionMapper permissionMapper;
	@Autowired
	RoleMapper roleMapper;

	@Override
	public String getAccountByOpenId(String openId) {
		if (openId == null) {
			return null;
		}
		String account = userMapper.getAccountByOpenId(openId);
		return account;
	}

	// 得到放入session中的user对象
	@Override
	public UserDO getUserDOToSessionByAccount(String account) {
		if (account == null) {
			return null;
		}
		return userMapper.getUserDOByAccount(account);
	}

	@Override
	public Integer getRoleIdByUserId(int id) {
		Integer roleid = userRoleMapper.GetRoleIdByUserId(id);
		return roleid;
	}

	@Override
	public List<PermissionDO> listPermissionByRoleId(int roleId) {
		List<PermissionDO> list = permissionMapper.listPermissionByRole(roleId);
		return list;
	}

	@Override
	// @Transactional(isolation = Isolation.REPEATABLE_READ, propagation =
	// Propagation.REQUIRED, readOnly = false)
	public String getRoleByUserId(int userId) {
		int roleId = userRoleMapper.GetRoleIdByUserId(userId);
		String role = roleMapper.getRoleByRoleId(roleId);
		return role;
	}

}
