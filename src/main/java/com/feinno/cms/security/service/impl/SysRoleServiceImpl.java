package com.feinno.cms.security.service.impl;


import com.feinno.cms.security.cache.SecurityCache;
import com.feinno.cms.security.dao.SysRoleDao;
import com.feinno.cms.security.domain.SysRole;
import com.feinno.cms.security.service.SysRoleService;
import com.feinno.framework.common.exception.BusinessException;
import com.feinno.framework.common.service.EntityServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysRoleService")
public class SysRoleServiceImpl extends EntityServiceImpl<SysRole, SysRoleDao> implements SysRoleService {

    private Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    private SecurityCache securityCache;

    @Override
    public void update(SysRole o) throws BusinessException {
        super.update(o);
        securityCache.clearAllAuthorization();
        securityCache.clearMenu(o.getId());
    }
}
