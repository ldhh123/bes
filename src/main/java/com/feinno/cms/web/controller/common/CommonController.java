package com.feinno.cms.web.controller.common;

import com.feinno.cms.core.service.CmsAttachmentServiceFacade;
import com.feinno.cms.web.common.Constant;
import com.feinno.framework.common.dao.support.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * com.feinno.eord.web.controller. User: wangyx Date: 14-11-22 Time: 上午10:33
 */
public class CommonController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	protected CmsAttachmentServiceFacade attachService;

	/**
	 * 初始化绑定数据，加入字符串转日期
	 * 
	 * @param request
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor dateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	/**
	 * 分页
	 * 
	 * @param request
	 * @param pageSize
	 * @return
	 */
	protected PageInfo getPageInfo(HttpServletRequest request, int pageSize) {
		int currentPage = 1;
		if (StringUtils.isNotBlank(request.getParameter("pageNo"))) {
			try {
				currentPage = Integer.parseInt(request.getParameter("pageNo"));
			} catch (Exception ex) {
			}
		}
		PageInfo pageInfo = new PageInfo(pageSize, currentPage);
		return pageInfo;
	}

	/**
	 * 分页
	 * 
	 * @param request
	 * @return
	 */
	protected PageInfo getPageInfo(HttpServletRequest request) {
		return getPageInfo(request, 10);
	}

	/**
	 * <p>
	 * Description: 分页对象
	 * </p>
	 * 
	 * @param request
	 * @param pageSize
	 * @return
	 */
	protected Pageable getPageable(HttpServletRequest request, int pageSize) {
		int currentPage = 1;
		if (StringUtils.isNotBlank(request.getParameter("pageNo"))) {
			try {
				currentPage = Integer.parseInt(request.getParameter("pageNo"));
			} catch (Exception ex) {
			}
		}
		return new PageRequest((currentPage - 1), pageSize);
	}

	/**
	 * <p>
	 * Description:分页对象
	 * </p>
	 * 
	 * @param request
	 * @return
	 */
	protected Pageable getPageable(HttpServletRequest request) {
		return getPageable(request, 10);
	}

	protected <T> PageInfo<T> asPageInfo(Page<T> page) {
		PageInfo<T> pageInfo = new PageInfo<T>();
		pageInfo.setCountOfCurrentPage(page.getSize());
		pageInfo.setCurrentPage(page.getNumber() + 1);
		pageInfo.setTotalCount(page.getTotalElements());
		pageInfo.setPageResults(page.getContent());
		return pageInfo;
	}

	/**
	 * 操作成功提示
	 * 
	 * @param msg
	 *            - 提示信息
	 * @param location
	 *            - 跳转页面
	 * @param map
	 * @return
	 */
	protected String operSuccess(String msg, String location, Map<String, Object> map) {
		map.put("alertinfo", Constant.Application.COMMON_SUCCESS_ALERTINFO);
		map.put("msg", msg);
		map.put("location", location);
		return "module.common.message";
	}

	/**
	 * 操作失败提示
	 * 
	 * @param msg
	 *            - 提示信息
	 * @param map
	 * @return
	 */
	protected String operFailure(String msg, Map<String, Object> map) {
		map.put("alertinfo", Constant.Application.COMMON_DANGER_ALERTINFO);
		map.put("msg", msg);
		return "module.common.message";
	}

}
