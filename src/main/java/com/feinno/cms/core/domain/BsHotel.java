package com.feinno.cms.core.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.feinno.framework.common.domain.AbstractEntity;

@Entity
@Table(name = "bs_hotel")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BsHotel extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;// int unsigned not null,
	private String hotelName;// varchar(100) unsigned not null,
	private String hotelMeasure;// varchar(20),
	private String hotelLayout;// varchar(20),
	private String hotelSupport;// varchar(20),
	private String hotelUrl;// varchar(150) comment '实景图片的展示，url以分号隔开',
	private String hotelNote;// varchar(500) comment '汉字不能超过250',
	private Date creat_time;// timestamp,
	private int status;// int comment '1.是正常发布状态，2是逻辑删除状态',

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelMeasure() {
		return hotelMeasure;
	}

	public void setHotelMeasure(String hotelMeasure) {
		this.hotelMeasure = hotelMeasure;
	}

	public String getHotelLayout() {
		return hotelLayout;
	}

	public void setHotelLayout(String hotelLayout) {
		this.hotelLayout = hotelLayout;
	}

	public String getHotelSupport() {
		return hotelSupport;
	}

	public void setHotelSupport(String hotelSupport) {
		this.hotelSupport = hotelSupport;
	}

	public String getHotelUrl() {
		return hotelUrl;
	}

	public void setHotelUrl(String hotelUrl) {
		this.hotelUrl = hotelUrl;
	}

	public String getHotelNote() {
		return hotelNote;
	}

	public void setHotelNote(String hotelNote) {
		this.hotelNote = hotelNote;
	}

	public Date getCreat_time() {
		return creat_time;
	}

	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
