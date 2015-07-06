package com.feinno.cms.core.domain;

import java.util.Date;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import com.feinno.framework.common.domain.AbstractEntity;
@Entity
@Table(name = "comments")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Comments extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;// INT UNSIGNED NOT NULL,
	private Date createtime;// TIMESTAMP NOT NULL,
	private String commcontent;// BLOB,
	private int hotel_id;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Lob
	@Basic(fetch = FetchType.LAZY) 
	public String getCommcontent() {
		return commcontent;
	}
	public void setCommcontent(String commcontent) {
		this.commcontent = commcontent;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}// INT,

	
}
