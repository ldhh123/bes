package com.feinno.cms.web.controller.bs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.feinno.cms.security.domain.SysUser;
import com.feinno.cms.security.service.SysUserService;
import com.feinno.cms.web.controller.common.CommonController;

/**
 * 评论和回复
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/bs")
public class CommentsController extends CommonController {
	@Autowired
	private SysUserService sysUserService;

}
