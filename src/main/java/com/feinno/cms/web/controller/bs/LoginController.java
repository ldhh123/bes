package com.feinno.cms.web.controller.bs;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.feinno.cms.security.domain.SysUser;
import com.feinno.cms.security.service.SysUserService;
import com.feinno.cms.web.controller.common.CommonController;

@Controller
@RequestMapping(value="/bs")
public class LoginController extends CommonController {

	@Autowired
	private SysUserService sysUserService;
	/**
	 * 跳转到注册
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/register")
	public String toReg() throws IOException {
		return "/admin/register";
	}
	/**
	 * 跳转到登录页面
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/login")
	public String toLogin() throws IOException {
		return "/admin/login";
	}
	/**
	 * 真正的登录验证页面
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/flogin")
	public String Login() throws IOException {
		
		//验证通过跳转到主页面，据不同的身份跳转到不同的主页面
		return "/admin/main";
	}
	
	

	/**
	 * 注册动作
	 * 
	 * @return
	 */
	@RequestMapping(value="/registeradd")
	public String register(HttpServletRequest request, ModelMap model) {
		SysUser user = new SysUser();
		try {
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setStatus(1);// 直接启用
			user.setUsertype(Integer.valueOf(request.getParameter("type")));// 3为业主，4为租房用户
			// 保存起来，并跳转到登录页面

			sysUserService.save(user);
		} catch (Exception e) {
			model.addAttribute("errmsg", "注册失败，请检查！");
			return "/bs/register";
		}
		return "bs/login";
	}
}
