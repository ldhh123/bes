package com.feinno.cms.core.service.impl;

import com.feinno.cms.core.dao.CmsAttachmentDao;
import com.feinno.cms.core.domain.CmsAttachment;
import com.feinno.cms.core.service.CmsAttachmentService;
import com.feinno.framework.common.service.EntityServiceImpl;
import org.springframework.stereotype.Service;

@Service("cmsAttachmentService")
public class CmsAttachmentServiceImpl extends EntityServiceImpl<CmsAttachment, CmsAttachmentDao> implements CmsAttachmentService {

    @Override
    public CmsAttachment getByAttachUrl(String attachUrl) {
        return getEntityDao().getByAttachUrl(attachUrl);
    }
}
