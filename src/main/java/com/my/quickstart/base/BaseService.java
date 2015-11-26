package com.my.quickstart.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.my.quickstart.util.JsonUtil;

public class BaseService extends BaseLogger {
    
    /**
     * 获取分页数据，提供默认排序（order by id desc ）
     * @param javaBean 调用方法的Bean
     * @param query 查询参数对象
     * @param page 分页对象
     * @param ICount 查询总记录数javaBean的接口方法名称（亦可以理解为对应的sql查询的Id名称）
     * @param IData 查询分页数据javaBean的接口方法（亦可以理解为对应的sql查询的Id名称）
     * @return Page<T>
     */
    protected <T> void setPageData(Object javaBean, T query, Page<T> page,String ICount, String IData){
        setPageData(javaBean, query,null, page, ICount, IData);
    }
    /**
     * 获取分页数据，提供默认排序（order by id desc ）
     * @param javaBean
     * @param map
     * @param page
     * @param ICount
     * @param IData
     * @return
     */
    protected <T> void setPageData(Object javaBean,Map<String,Object> map, Page<T> page,String ICount, String IData) {
    	setPageData(javaBean, null,map, page,ICount, IData);
	}
    /**
     * 统一获取分页数据方法
     * @param javaBean 调用方法的Beant
     * @param query 查询参数对象
     * @param page 分页对象
     * @param ICount 查询总记录数javaBean的接口方法名称（亦可以理解为对应的sql查询的Id名称）
     * @param IData 查询分页数据javaBean的接口方法（亦可以理解为对应的sql查询的Id名称）
     * @return Page<T>
     */
    @SuppressWarnings("unchecked")
	protected <T> void setPageData(Object javaBean, T query,Map<String,Object> map, Page<T> page,String ICount, String IData) {
        Map<String, Object> mapQuery = new HashMap<String, Object>();
        if(query!=null){
        	mapQuery.putAll(JsonUtil.json2Object(JsonUtil.object2Json(query), Map.class));
        }
        if(map!=null){
        	mapQuery.putAll(map);
        }
        mapQuery.putAll(JsonUtil.json2Object(JsonUtil.object2Json(page), Map.class));
        try {
            Method mCount = javaBean.getClass().getMethod(ICount, Map.class);
            Method mData = javaBean.getClass().getMethod(IData, Map.class);
            int count = (int) mCount.invoke(javaBean, mapQuery);
            if (count <= 0) {
                return;
            }
            page.setTotal(count);
            List<T> list = (List<T>) mData.invoke(javaBean, mapQuery);
            page.setResult(list);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    /**
     * 从集合中获取第一个数值
     * @param list
     * @return
     */
    protected <T> T getOne(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

}
