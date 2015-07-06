package com.feinno.cms.web.common.security;

import com.feinno.cms.security.domain.SysUser;
import com.feinno.cms.security.service.SysUserService;
import com.feinno.cms.web.common.Constant;
import com.feinno.cms.web.common.SessionFace;
import com.feinno.cms.web.common.SessionUser;
import com.feinno.module.security2.exception.AuthenticationException;
import com.feinno.module.security2.listener.LoginLogoutListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2015/5/26.
 */
public class LoginListener implements LoginLogoutListener {

    private Logger logger = LoggerFactory.getLogger(LoginListener.class);

    @Autowired
    private SysUserService sysUserService;

    @Override
    public void beforeLogin(String userName, HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        logger.debug("用户 {} 准备登陆", userName);
    }

    @Override
    public void onLoginSuccess(String userName, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("用户 {} 登陆成功", userName);
        afterRememberMe(userName, request, response);
    }

    @Override
    public void onLoginFailure(String userName, AuthenticationException e, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("loginError",
                ResourceBundle.getBundle("i18n/message", request.getLocale()).getString(Constant.I18nMessage.LOGIN_ERROR));
        logger.debug("用户 {} 登陆失败", userName);
    }

    @Override
    public void afterRememberMe(String userName, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("用户 {} 记住我 登陆", userName);
        //设置 sessionUser
        SysUser sysUser = sysUserService.findByUsername(userName);
        SessionFace.setSessionUser(request, SessionUser.bulider(sysUser));
    }

    @Override
    public void beforeLogout(String userName, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("用户 {} 注销", userName);
    }
}
