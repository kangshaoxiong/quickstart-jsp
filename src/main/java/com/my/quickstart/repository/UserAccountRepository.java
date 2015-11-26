package com.my.quickstart.repository;

import com.my.quickstart.base.BaseRepository;
import com.my.quickstart.entity.UserAccount;
import com.my.quickstart.repository.mybatis.UserAccountRepositoryMybatis;

public interface UserAccountRepository extends BaseRepository<UserAccount,Long>,UserAccountRepositoryMybatis{
	
	public UserAccount findByUsername(String account);
}
