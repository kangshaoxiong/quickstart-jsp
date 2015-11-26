/**
 * 
 */
package com.my.quickstart.util;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.my.quickstart.base.MappingConfig;

public class JsonUtil {

    public static String toJson(Object o) {
        return JSON.toJSONString(o);
    }

    public static <T> List<T> parseJsonToList(String jsonStr, Class<T> clazz) {
        return JSON.parseArray(jsonStr, clazz);
    }
    
    /**
     * @Description : json序列化带类名.
     * @param object
     * @return
     */
    public static String object2JsonSerializer(Object object) {
        String result = null;
        if (!ObjectHelp.isEmpty(object)) {
            result = JSON
                    .toJSONString(object, SerializerFeature.WriteClassName);
        }
        return result;
    }

    /**
     * @Description : json反序列化带类名.
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T json2ObjectSerializer(String json) {
        T result = null;
        if (ObjectHelp.isNotEmpty(json)) {
            result = (T) JSON.parse(json);
        }
        return result;
    }

    /**
     * @Description : 标准 json 格式
     * @param object
     * @return
     */
    public static String object2Json(Object object) {
        String result = null;
        if (!ObjectHelp.isEmpty(object)) {
            result = JSON.toJSONString(object);
        }
        return result;
    }

    /**
     * @Description : 标准 json
     * @param object
     * @return
     */
    public static <T> T json2Object(String json, Class<T> clazz) {
        T result = null;
        if (!ObjectHelp.isEmpty(json)) {
            result = JSON.parseObject(json, clazz);
        }
        return result;
    }

    /**
     * 标准 json 反转成实体，多用于集合框架 <br/>
     * @param <T>
     * @param json
     * @param type
     * @return
     */
    public static <T> T json2Object(String json, TypeReference<T> type) {
        T result = null;
        if (!ObjectHelp.isEmpty(json)) {
            result = JSON.parseObject(json, type);
        }
        return result;
    }

    /**
     * 批量转Json <br/>
     * @param <T>
     * @param apiTradeLst
     * @return
     */
    public static <T extends Serializable> String list2Json(List<T> apiTradeLst) {
        String jsonText = null;
        if (null != apiTradeLst) {
            jsonText = object2Json(apiTradeLst);
        }
        return jsonText;
    }

    /**
     * 批量反转Json <br/>
     * @param <T>
     * @param apiTradeLst
     * @return
     */
    public static <T extends Serializable> List<T> json2List(String jsonText,
            Class<T> dataClazz) {
        return JSON.parseArray(jsonText, dataClazz);
    }

    /**
     * 对象转化工具 <br/>
     * @param <T>
     * @param dstClazz
     * @param srcObject
     * @return
     */
    public static <T> T transform(final Object srcObject,
            final MappingConfig<T> config) {
        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        NameFilter nameFilter = config.getNameFilter();
        if (null != nameFilter) {
            serializer.getNameFilters().add(nameFilter);
        }
        T result = null;
        if (null != srcObject) {
            serializer.write(srcObject);
            String json = out.toString();
            result = json2Object(json, config.getDstClazz());
        }
        return result;
    }
}
