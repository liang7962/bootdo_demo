package com.bootdo.common.utils;

import com.bootdo.common.dao.DictDao;
import com.bootdo.common.domain.DictDO;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hello on 2018/12/7.
 */
@SuppressWarnings("all")
public class DictUtils {
    private static DictDao dictDao = SpringContextHolder.getBean(DictDao.class);

    public static final String CACHE_DICT_MAP = "dictMap";


    public List<DictDO> getDictList(String type){
        Map<String, List<DictDO>> dictMap = (Map<String, List<DictDO>>)CacheUtils.get(CACHE_DICT_MAP);
        if (dictMap==null){
            dictMap = new HashMap<>();
            Map<String, Object> param = new HashMap<>(16);
            for (DictDO dict : dictDao.list(param)){
                List<DictDO> dictList = dictMap.get(dict.getType());
                if (dictList != null){
                    dictList.add(dict);
                }else{
                    dictMap.put(dict.getType(), Lists.newArrayList(dict));
                }

            }
            CacheUtils.put(CACHE_DICT_MAP, dictMap);
        }
        List<DictDO> dictList = dictMap.get(type);
        if (dictList == null){
            dictList = new ArrayList<>();
        }
        return dictList;
    }

    public static List<DictDO> getDictListSt(String type){
        Map<String, List<DictDO>> dictMap = (Map<String, List<DictDO>>)CacheUtils.get(CACHE_DICT_MAP);
        if (dictMap==null){
            dictMap = new HashMap<>();
            Map<String, Object> param = new HashMap<>(16);
            for (DictDO dict : dictDao.list(param)){
                List<DictDO> dictList = dictMap.get(dict.getType());
                if (dictList != null){
                    dictList.add(dict);
                }else{
                    dictMap.put(dict.getType(), Lists.newArrayList(dict));
                }

            }
            CacheUtils.put(CACHE_DICT_MAP, dictMap);
        }
        List<DictDO> dictList = dictMap.get(type);
        if (dictList == null){
            dictList = new ArrayList<>();
        }
        return dictList;
    }


    public static String getDictLabel(String value, String type, String defaultValue){
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
            for (DictDO dict : getDictListSt(type)){
                if (type.equals(dict.getType()) && value.equals(dict.getValue())){
                    return dict.getName();
                }
            }
        }
        return defaultValue;
    }

    public static Object getDictValue(String label, String type, String defaultLabel) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
            for (DictDO dict : getDictListSt(type)){
                if (type.equals(dict.getType()) && label.equals(dict.getName())){
                    return dict.getValue();
                }
            }
        }
        return defaultLabel;
    }
}
