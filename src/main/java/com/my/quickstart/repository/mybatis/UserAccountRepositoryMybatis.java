package com.my.quickstart.repository.mybatis;

import java.util.List;
import java.util.Map;

import com.my.quickstart.base.MyBatisRepository;
import com.my.quickstart.entity.UserAccount;

@MyBatisRepository
public interface UserAccountRepositoryMybatis {
	
	public UserAccount findByIdAndUsername(Long id);
	
	public List<UserAccount> findPageData(Map<String, Object> map);
	
	public int findPageCount(Map<String, Object> map);
}
