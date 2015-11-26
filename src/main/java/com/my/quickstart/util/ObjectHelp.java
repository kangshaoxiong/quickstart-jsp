package com.my.quickstart.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("all")
public class ObjectHelp {

	private final static boolean isEmptyImpl(Object obj) {
		if (obj == null)
			return true;
		if (obj instanceof String)
			return "".equals(((String) obj).trim());
		if (obj instanceof Map)
			return ((Map<?, ?>) obj).isEmpty();
		if (obj instanceof Collection)
			return ((Collection<?>) obj).isEmpty();
		if (obj instanceof Set)
			return ((Set<?>) obj).isEmpty();
		if (obj instanceof Object[])
			return ((Object[]) obj).length == 0;
		return false;
	}

	/**
	 * <B> 判断对象是否为空. <br/><B>
	 * @return
	 */
	public static boolean isEmpty(Object... objects) {
		boolean result = false;
		if (isEmptyImpl(objects)) {
			result = true;
		} else {
			for (Object object : objects) {
				if (isEmptyImpl(object)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * <B>  对象不为空  <br/><B>
	 * @param objects
	 * @return
	 */
	public static boolean isNotEmpty(Object... objects) {
		return !isEmpty(objects);
	}

	public static <KEY, VALUE> HashMap<KEY, VALUE> objectToMap(Object obj)
			throws Exception {
		if (obj == null) {
			throw new Exception("对象为空");
		}

		Class<?> clazz = obj.getClass();
		HashMap<KEY, VALUE> map = new HashMap<KEY, VALUE>();
		getClass(clazz, map, obj);
		HashMap<KEY, VALUE> newMap = convertHashMap(map);
		return newMap;
	}

	public final static <KEY, VALUE> String getPropertyValueFormObject(Object obj,
			String strProperty) throws Exception {
		if (!isNotEmpty(strProperty)) {
			return "";
		}
		if (obj == null) {
			return "";
		}
		Class<?> clazz = obj.getClass();
		HashMap<KEY, VALUE> map = new HashMap<KEY, VALUE>();
		getClass(clazz, map, obj);
		HashMap<KEY, VALUE> newMap = convertHashMap(map);

		if (newMap == null) {
			return "";
		}
		Object objReturn = newMap.get(strProperty);
		if (objReturn == null) {
			return "";
		}
		return objReturn.toString();
	}

	private final static void getClass(Class<?> clazz, HashMap map, Object obj)
			throws Exception {
		if (clazz.getSimpleName().equals("Object")) {
			return;
		}

		Field[] fields = clazz.getDeclaredFields();
		if ((fields == null) || (fields.length <= 0)) {
			throw new Exception("当前对象中没有任何属性值");
		}
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			String name = fields[i].getName();
			Object value = fields[i].get(obj);
			map.put(name, value);
		}

		Class<?> superClzz = clazz.getSuperclass();
		getClass(superClzz, map, obj);
	}

	private final static <KEY, VALUE> HashMap<KEY, VALUE> convertHashMap(
			HashMap<KEY, VALUE> map) throws Exception {
		HashMap<KEY, VALUE> newMap = new HashMap<KEY, VALUE>();
		Set<KEY> keys = map.keySet();
		Iterator<KEY> it = keys.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			convertToString(map.get(key), newMap, key);
		}

		return newMap;
	}
	
	private static void convertToString(Object value, HashMap newMap, Object key) {
		if (value != null) {
			final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Class<?> clazz = value.getClass();
			if (isBaseType(clazz)) {
				newMap.put(key, value.toString());
			} else if (clazz == String.class) {
				newMap.put(key, value.toString());
			} else if (clazz == java.util.Date.class) {
				java.util.Date date = (java.util.Date) value;
				newMap.put(key, SDF.format(date));
			} else if (clazz == Timestamp.class) {
				Timestamp timestamp = (Timestamp) value;
				long times = timestamp.getTime();
				java.util.Date date = new java.util.Date(times);
				newMap.put(key, SDF.format(date));
			} else if (clazz == java.sql.Date.class) {
				java.sql.Date sqlDate = (java.sql.Date) value;
				newMap.put(key, SDF.format(sqlDate));
			} else {
				newMap.put(key, value);
			}
		} else {
			newMap.put(key, value);
		}
	}

	private static boolean isBaseType(Class<?> clazz) {
		if (clazz == Integer.class) {
			return true;
		}
		if (clazz == Long.class) {
			return true;
		}
		if (clazz == Double.class) {
			return true;
		}
		if (clazz == Byte.class) {
			return true;
		}
		if (clazz == Float.class) {
			return true;
		}
		if (clazz == Short.class) {
			return true;
		}

		return clazz == Boolean.class;
	}
	
	public static <T,TC> Class<TC> getTClass(Class<T> clazz) {
		Class<TC> result = null;
		result =(Class<TC>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
		return result;
	}
	
	
}
