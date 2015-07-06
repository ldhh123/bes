package com.feinno.cms.web.controller.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.feinno.cms.security.domain.SysUser;
import com.feinno.cms.security.service.SysUserService;

/**
 * com.feinno.cms.web.controller. User: wangyx Date: 14-11-7 Time: 下午4:25
 */
@Controller
public class IndexController extends CommonController {

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	/**
	 * 前台用户浏览和发布的登陆页
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/login")
	public String login() throws IOException {
		return "admin/login";
	}

	/**
	 * 后台管理登陆
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/manalogin")
	public String manaLogin() throws IOException {
		return "login";
	}
	


}
