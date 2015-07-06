package com.feinno.cms.core.dao;

import org.springframework.data.jpa.repository.Query;

import com.feinno.cms.core.domain.Comments;
import com.feinno.framework.common.dao.jpa.EntityJpaDao;

public interface CommentsDao extends EntityJpaDao<Comments,Long> {
    @Query("from Comments where hotel_id = ?1")
    Comments getByhotel_id(int hotel_id);
}
