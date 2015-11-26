package com.my.quickstart.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Alan
 * 
 * @param <T>
 */
public class DefaultResult<T> extends ErrorResult{
	private static final long serialVersionUID = 7795741065346690715L;
	private T module; // 实际的返回结果
    private Map<String, Object> otherResult;
    public void addResult(String bizKey, Object o) {
        if (otherResult == null) {
            otherResult = new HashMap<String, Object>();
        }
        otherResult.put(bizKey, o);
    }

    public T getModule() {
        return module;
    }

    public void setModule(T module) {
        this.module = module;
    }
    
    public DefaultResult() {
        super();
    }

    public DefaultResult(T module) {
        super();
        this.module = module;
    }
}
