package com.my.quickstart.base;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
/**
 * 自定义基础Repository接口，暴露需要的公共接口
 * @author Alan
 *
 */
@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends CrudRepository<T, ID> {
	
}
