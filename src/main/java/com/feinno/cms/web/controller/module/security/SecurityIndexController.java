package com.feinno.cms.web.controller.module.security;

import com.feinno.cms.security.domain.SysUser;
import com.feinno.cms.security.service.SysUserService;
import com.feinno.cms.web.common.SessionFace;
import com.feinno.cms.web.controller.common.CommonController;
import com.feinno.module.security2.shiro.realm.SampleRealm;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * @author junsansi
 * Date: 2015-3-3
 */
@Controller
@RequestMapping("/module/security")
public class SecurityIndexController extends CommonController {

	@Autowired
	private  SysUserService sysUserService;

    @Autowired
    private SampleRealm sampleRealm;


	@RequestMapping("index")
	public String index(HttpServletRequest request, Map<String, Object> map){
		SysUser user = sysUserService.findByUsername(SessionFace.getSessionUser(request).getUsername());
		//默认显示登陆用户的帐户信息
		map.put("item", user);


        sampleRealm.clearCachedAuthorizationInfo("");
        for(Iterator it = SecurityUtils.getSubject().getPrincipals().iterator(); it.hasNext();){
            System.out.println(it.next());
        }

		return "module.security.index";
	}
}
