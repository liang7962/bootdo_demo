package com.bootdo.system.domain;

import com.bootdo.common.utils.IdGen;
import com.bootdo.common.utils.ShiroUtils;

import java.io.Serializable;
import java.util.Date;


/**
 * 新闻
 * 
 * @author xzx
 * @email 1995xxzx@163.com
 * @date 2019-03-08 13:48:18
 */
public class NewsBaseInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//新闻表主键
	private String id;
	//新闻表标题
	private String newsTitle;
	//内容
	private String content;
	//政策类别
	private String newsCategory;
	//首页推荐时间
	private Date isBefTopDate;
	//首页推荐
	private String isBefTop;
	//是否发布
	private String realseFlag;
	//创建者
	private String createBy;
	//创建时间
	private Date createDate;
	//更新者
	private Long updateBy;
	//更新时间
	private Date updateDate;

	/**
	 * 设置：新闻表主键
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：新闻表主键
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：新闻表标题
	 */
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	/**
	 * 获取：新闻表标题
	 */
	public String getNewsTitle() {
		return newsTitle;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：政策类别
	 */
	public void setNewsCategory(String newsCategory) {
		this.newsCategory = newsCategory;
	}
	/**
	 * 获取：政策类别
	 */
	public String getNewsCategory() {
		return newsCategory;
	}
	/**
	 * 设置：首页推荐时间
	 */
	public void setIsBefTopDate(Date isBefTopDate) {
		this.isBefTopDate = isBefTopDate;
	}
	/**
	 * 获取：首页推荐时间
	 */
	public Date getIsBefTopDate() {
		return isBefTopDate;
	}
	/**
	 * 设置：首页推荐
	 */
	public void setIsBefTop(String isBefTop) {
		this.isBefTop = isBefTop;
	}
	/**
	 * 获取：首页推荐
	 */
	public String getIsBefTop() {
		return isBefTop;
	}
	/**
	 * 设置：是否发布
	 */
	public void setRealseFlag(String realseFlag) {
		this.realseFlag = realseFlag;
	}
	/**
	 * 获取：是否发布
	 */
	public String getRealseFlag() {
		return realseFlag;
	}
	/**
	 * 设置：创建者
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建者
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：更新者
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：更新者
	 */
	public Long getUpdateBy() {
		return updateBy;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

    public void preInsert() {
		this.id= IdGen.uuid();
		this.createBy= ShiroUtils.getUserId().toString();
		this.createDate=new Date();
    }

	public void preUpdate() {
		this.updateBy= ShiroUtils.getUserId();
		this.updateDate=new Date();
	}
}
