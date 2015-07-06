package com.feinno.cms.security.service.impl;


import com.feinno.cms.security.dao.SysOlogDao;
import com.feinno.cms.security.domain.SysOlog;
import com.feinno.cms.security.service.SysOlogService;
import com.feinno.framework.common.service.EntityServiceImpl;
import org.springframework.stereotype.Service;

@Service("sysOlogService")
public class SysOlogServiceImpl extends EntityServiceImpl<SysOlog, SysOlogDao> implements SysOlogService {


}
