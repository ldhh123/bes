package com.feinno.cms.core.dao;

import com.feinno.cms.core.domain.CmsAttachment;
import com.feinno.framework.common.dao.jpa.EntityJpaDao;
import org.springframework.data.jpa.repository.Query;

/**
 * 附件列表 JPA Dao
 *
 * Date: 2014-12-02 13:39:35
 *
 * @author Feinno Code Generator
 *
 */
public interface CmsAttachmentDao extends EntityJpaDao<CmsAttachment, Long> {

    @Query("from CmsAttachment where attachUrl = ?1")
    CmsAttachment getByAttachUrl(String attachUrl);

}
