package com.bootdo.system.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.NewsBaseInfoDO;
import com.bootdo.system.service.NewsBaseInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 新闻
 * 
 * @author xzx
 * @email 1995xxzx@163.com
 * @date 2019-03-08 13:48:18
 */
 
@Controller
@RequestMapping("/system/newsBaseInfo")
public class NewsBaseInfoController {
	@Autowired
	private NewsBaseInfoService newsBaseInfoService;
	
	@GetMapping()
	@RequiresPermissions("system:newsBaseInfo:newsBaseInfo")
	String NewsBaseInfo(){
	    return "system/newsBaseInfo/newsBaseInfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:newsBaseInfo:newsBaseInfo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<NewsBaseInfoDO> newsBaseInfoList = newsBaseInfoService.list(query);
		int total = newsBaseInfoService.count(query);
		PageUtils pageUtils = new PageUtils(newsBaseInfoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:newsBaseInfo:add")
	String add(){
	    return "system/newsBaseInfo/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:newsBaseInfo:edit")
	String edit(@PathVariable("id") String id,Model model){
		NewsBaseInfoDO newsBaseInfo = newsBaseInfoService.get(id);
		model.addAttribute("newsBaseInfo", newsBaseInfo);
	    return "system/newsBaseInfo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:newsBaseInfo:add")
	public R save(NewsBaseInfoDO newsBaseInfo){
		newsBaseInfo.preInsert();
		if(newsBaseInfoService.save(newsBaseInfo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:newsBaseInfo:edit")
	public R update(NewsBaseInfoDO newsBaseInfo){
		newsBaseInfo.preUpdate();
		newsBaseInfoService.update(newsBaseInfo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:newsBaseInfo:remove")
	public R remove(String id){
		if(newsBaseInfoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:newsBaseInfo:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		newsBaseInfoService.batchRemove(ids);
		return R.ok();
	}


	@GetMapping("/details/{id}")
	@RequiresPermissions("system:newsBaseInfo:details")
	String details(@PathVariable("id") String id, Model model) {
		NewsBaseInfoDO newsBaseInfoDO = newsBaseInfoService.get(id);

		model.addAttribute("newsBaseInfo", newsBaseInfoDO);
		return "system/newsBaseInfo/details";
	}

	/**
	 * @Param:
	 * @return:  发布
	 * @Author: liang
	 * @Date: 2019/3/8
	 */
	@RequestMapping(value = "/release")
	@ResponseBody
	public R release(String id, String state) {
		if ("release".equals(state)) {
			//发布
			NewsBaseInfoDO newsBaseInfoDO = new NewsBaseInfoDO();
			newsBaseInfoDO.setId(id);
			newsBaseInfoDO.setRealseFlag("Y");
			if (newsBaseInfoService.update(newsBaseInfoDO) > 0) {
				return R.ok();
			} else {
				return R.error();
			}

		} else if ("notRelease".equals(state)) {
			//取消发布
			NewsBaseInfoDO newsBaseInfoDO = new NewsBaseInfoDO();
			newsBaseInfoDO.setId(id);
			newsBaseInfoDO.setRealseFlag("N");
			if (newsBaseInfoService.update(newsBaseInfoDO) > 0) {
				return R.ok();
			} else {
				return R.error();
			}
		} else {
			return R.error();
		}
	}

	/**
	 * 对机构进行相关操作，subBef-推荐，calBef-取消推荐
	 */
	@PostMapping("/operate")
	@ResponseBody
	public R operate(String id, String operate) {

		if (newsBaseInfoService.operatNewsBaseInfo(id, operate) > 0) {
			return R.ok();
		}
		return R.error();
	}


}
