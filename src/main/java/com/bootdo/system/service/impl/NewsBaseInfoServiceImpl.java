package com.bootdo.system.service.impl;

import com.bootdo.system.dao.NewsBaseInfoDao;
import com.bootdo.system.domain.NewsBaseInfoDO;
import com.bootdo.system.service.NewsBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class NewsBaseInfoServiceImpl implements NewsBaseInfoService {
	@Autowired
	private NewsBaseInfoDao newsBaseInfoDao;
	
	@Override
	public NewsBaseInfoDO get(String id){
		return newsBaseInfoDao.get(id);
	}
	
	@Override
	public List<NewsBaseInfoDO> list(Map<String, Object> map){
		return newsBaseInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return newsBaseInfoDao.count(map);
	}
	
	@Override
	public int save(NewsBaseInfoDO newsBaseInfo){
		return newsBaseInfoDao.save(newsBaseInfo);
	}
	
	@Override
	public int update(NewsBaseInfoDO newsBaseInfo){
		return newsBaseInfoDao.update(newsBaseInfo);
	}
	
	@Override
	public int remove(String id){
		return newsBaseInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return newsBaseInfoDao.batchRemove(ids);
	}

	@Override
	public int operatNewsBaseInfo(String id, String operate) {
		Map map=new HashMap();
		map.put("id",id);
		if("subBef".equals(operate)){
			map.put("isBefTop","Y");
			map.put("isBefTopDate",new Date());
		}else if("calBef".equals(operate)){
			map.put("isBefTop","N");
		}else if("subHight".equals(operate)){
			map.put("isHightQuality","Y");
		}else if("calHight".equals(operate)){
			map.put("isHightQuality","N");
		}
		return newsBaseInfoDao.operatNewsBaseInfo(map);
	}

}
