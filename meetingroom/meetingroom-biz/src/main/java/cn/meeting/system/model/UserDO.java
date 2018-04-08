package cn.meeting.system.model;

import java.io.Serializable;

/**
 * @author linzj
 * @Description: 用户实体类
 * @date 2018年3月17日 下午4:29:16
 */
public class UserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String account;
	private String openId;
	private String username;
	private String enabled;
	private String remark;
	private String agency;
	private String stringId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getStringId() {
		return stringId;
	}

	public void setStringId(String stringId) {
		this.stringId = stringId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	@Override
	public String toString() {
		return "UserDO [id=" + id + ", account=" + account + ", openId=" + openId + ", username=" + username
				+ ", enabled=" + enabled + ", remark=" + remark + ", agency=" + agency + ", stringId=" + stringId + "]";
	}

}
