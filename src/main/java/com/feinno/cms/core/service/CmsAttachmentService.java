package com.feinno.cms.core.service;

import com.feinno.cms.core.domain.CmsAttachment;
import com.feinno.framework.common.service.EntityService;

/**
 * 附件列表 Service
 *
 * Date: 2014-12-02 13:39:36
 *
 * @author Feinno Code Generator
 *
 */
public interface CmsAttachmentService extends EntityService<CmsAttachment> {

    CmsAttachment getByAttachUrl(String attachUrl);
}
