package cn.meeting.system.dao.base;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface RoleMapper {
	/**
	 * 
	 * @Description:根据roleid获得对应的角色名
	 * @param id
	 * @return
	 */
	String getRoleByRoleId(Integer id);
	
}
