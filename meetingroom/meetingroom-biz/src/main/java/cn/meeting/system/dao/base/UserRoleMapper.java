package cn.meeting.system.dao.base;

public interface UserRoleMapper {
	/**
	 * 
	 *@Description: 得到用户对应的角色
	 * @param id
	 * @return
	 */
	Integer GetRoleIdByUserId(int id);
}
