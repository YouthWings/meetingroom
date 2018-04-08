package cn.meeting.system.model.dto;

import java.io.Serializable;

public class UserLoginDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String openId;
	private String account;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

}
