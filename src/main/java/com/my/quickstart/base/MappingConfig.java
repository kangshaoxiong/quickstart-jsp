package com.my.quickstart.base;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.serializer.NameFilter;
import com.my.quickstart.util.ObjectHelp;

public class MappingConfig<T> {
	Class<T> dstClazz; 
	Map<String, String> nameMapping;
	boolean debug = false;

	public MappingConfig(Class<T> dstClazz) {
		this.dstClazz = dstClazz;
	}

	public MappingConfig(Class<T> dstClazz, Map<String, String> nameMapping) {
		this.dstClazz = dstClazz;
		this.nameMapping = nameMapping;
	}

	public MappingConfig(Class<T> dstClazz, boolean debug) {
		super();
		this.dstClazz = dstClazz;
		this.debug = debug;
	}

	public MappingConfig(Class<T> dstClazz, Map<String, String> nameMapping,
			boolean debug) {
		this.dstClazz = dstClazz;
		this.nameMapping = nameMapping;
		this.debug = debug;
	}

	public Map<String, String> getNameMapping() {
		return nameMapping;
	}

	public void setNameMapping(Map<String, String> nameMapping) {
		this.nameMapping = nameMapping;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public Class<T> getDstClazz() {
		return dstClazz;
	}

	public void setDstClazz(Class<T> dstClazz) {
		this.dstClazz = dstClazz;
	}

	public void nameMapping(String... args) {
		if (null == nameMapping) {
			nameMapping = new HashMap<String, String>();
		}
		int len = args.length;
		for (int i = 0; i < len; i++) {
			nameMapping.put(args[i], args[++i]);
		}
	}

	public static Map<String, Object> parseValueMapping(Object... args) {
		Map<String, Object> valueMapping = new HashMap<String, Object>();
		int len = args.length;
		for (int i = 0; i < len; i++) {
			valueMapping.put(args[i] + "", args[++i]);
		}
		return valueMapping;
	}
	
	public NameFilter getNameFilter() {
		if (ObjectHelp.isNotEmpty(nameMapping)) {
			NameFilter nameFilter = new NameFilter() {
				public String process(Object source, String name, Object value) {
					if (null != source) {
						String key = source.getClass().getSimpleName() + "."
								+ name;
						String nameTmp = nameMapping.get(key);
						if (debug) {
							debug("NameFilter", key, ObjectHelp
									.isNotEmpty(nameTmp) ? nameTmp : name,
									value);
						}
						if (ObjectHelp.isNotEmpty(nameTmp)) {
							return nameTmp;
						}
					}
					return name;
				}
			};
			return nameFilter;
		}
		return null;
	}

	public void debug(String filterName, String key, String name, Object value) {
		System.out.println(filterName + "[debug] key[" + key + "] name[" + name
				+ "] value[" + value + "]");
	}
}
