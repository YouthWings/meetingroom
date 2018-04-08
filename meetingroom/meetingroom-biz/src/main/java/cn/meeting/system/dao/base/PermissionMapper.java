package cn.meeting.system.dao.base;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import cn.meeting.system.model.PermissionDO;

/**
 * @author linzj
 * @Description: 2表联合判断id是否exist
 * @date 2018年3月17日 下午4:01:19
 */
public interface PermissionMapper {
	/**
	 * @Description: 依据角色id获取所有权限，推荐使用此api
	 * @param roleid
	 * @return
	 */
	List<PermissionDO> listPermissionByRole(int roleid);
}
