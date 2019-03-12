package com.bootdo.system.dao;

import com.bootdo.system.domain.NewsBaseInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 新闻
 * @author xzx
 * @email 1995xxzx@163.com
 * @date 2019-03-08 13:48:18
 */
@Mapper
public interface NewsBaseInfoDao {

	NewsBaseInfoDO get(String id);
	
	List<NewsBaseInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(NewsBaseInfoDO newsBaseInfo);
	
	int update(NewsBaseInfoDO newsBaseInfo);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	int operatNewsBaseInfo(Map map);
}
