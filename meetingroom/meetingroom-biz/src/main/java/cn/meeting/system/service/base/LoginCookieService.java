package cn.meeting.system.service.base;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import cn.meeting.system.model.dto.UserLoginDTO;

public interface LoginCookieService {
	void addLoginCookie(UserLoginDTO userLoginDTO, HttpServletResponse response,boolean isSave) throws IOException;

	UserLoginDTO getUserFromCookies(Cookie[] cookies) throws ClassNotFoundException;
}