package com.my.quickstart.repository.mybatis.impl;

import java.util.List;
import java.util.Map;

import com.my.quickstart.base.MyBatisSqlSessionTemplate;
import com.my.quickstart.entity.UserAccount;
import com.my.quickstart.repository.mybatis.UserAccountRepositoryMybatis;
/**
 * 处理UserAccount的实现类
 * @author Alan
 *
 */
public class UserAccountRepositoryImpl extends MyBatisSqlSessionTemplate implements UserAccountRepositoryMybatis {
	private static final String namespace="UserAccountRepositoryMybatis.";
	@Override
	public UserAccount findByIdAndUsername(Long id) {
		UserAccount u=sqlSessionTemplate.selectOne("UserAccountRepositoryMybatis.findByIdAndAccount", id);
		return u;
	}

	@Override
	public List<UserAccount> findPageData(Map<String, Object> map) {
		return sqlSessionTemplate.selectList(namespace+"findPageData",map);
	}

	@Override
	public int findPageCount(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne(namespace+"findPageCount", map);
	}

}
