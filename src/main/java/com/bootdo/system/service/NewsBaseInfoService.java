package com.bootdo.system.service;

import com.bootdo.system.domain.NewsBaseInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 新闻
 * 
 * @author xzx
 * @email 1995xxzx@163.com
 * @date 2019-03-08 13:48:18
 */
public interface NewsBaseInfoService {
	
	NewsBaseInfoDO get(String id);
	
	List<NewsBaseInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(NewsBaseInfoDO newsBaseInfo);
	
	int update(NewsBaseInfoDO newsBaseInfo);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	int operatNewsBaseInfo(String id, String operate);
}
