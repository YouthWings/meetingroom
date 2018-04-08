package cn.meeting.system.service.base;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.meeting.system.model.PermissionDO;
import cn.meeting.system.model.UserDO;
import cn.meeting.system.service.UserLoginService;

/**
 * @author linzj
 * @Description: shiro 不根据密码根据是否有进行认证，并关闭密码加密模块
 * @date 2018年4月6日 上午10:15:40
 */
public class LoginRealm extends AuthorizingRealm {
	@Autowired
	UserLoginService userLoginService;

	// 清除缓存
	public void clearCache() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principalCollection);
	}

	// 认证
	// 传入的令牌前一个是account后一个是password
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String openId = (String) token.getPrincipal();
		String account = userLoginService.getAccountByOpenId(openId);	
		if (account == null || "".equals(account)) {
			return null;
		}
		UserDO userDO = userLoginService.getUserDOToSessionByAccount(openId);
		if (!userDO.getEnabled().equals("Y")) {
			throw new LockedAccountException();
		}
		userDO.setAccount(account);
		userDO.setOpenId(openId);
		// 数据库加密,需要在shiro中开启凭证解析器的配置
		// return new SimpleAuthenticationInfo(userDO, dbpassword,
		// ByteSource.Util.bytes(userDO.getSalt()),
		// this.getName());

		// 需要在上传时，上传account（学号）为account
		return new SimpleAuthenticationInfo(userDO, "account", this.getName());
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		UserDO userDO = (UserDO) principals.getPrimaryPrincipal();
		Integer roleId = userLoginService.getRoleIdByUserId(userDO.getId());
		if (roleId == null) {
			return null;
		}
		List<PermissionDO> list = userLoginService.listPermissionByRoleId(roleId);
		int length = list.size();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for (int i = 0; i < length; i++) {
			String temp = list.get(i).getEnabled();
			if (temp.equals("Y")) {
				simpleAuthorizationInfo.addStringPermission(list.get(i).getRemark());
			}
		}
		return simpleAuthorizationInfo;
	}

}
