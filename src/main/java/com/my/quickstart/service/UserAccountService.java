package com.my.quickstart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.my.quickstart.base.BaseService;
import com.my.quickstart.base.DefaultResult;
import com.my.quickstart.base.Page;
import com.my.quickstart.constants.Constant;
import com.my.quickstart.entity.UserAccount;
import com.my.quickstart.repository.UserAccountRepository;

@Service
public class UserAccountService extends BaseService{
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	/**
	 * 根据登录信息查询
	 * @param username
	 * @return
	 */
	@Cacheable(value="commonCache",key="#username")
	public UserAccount findByAccount(String username){
		return userAccountRepository.findByUsername(username);
	}
	/**
	 * 分页查询
	 * @return
	 */
	public void queryByPage(Page<UserAccount> page,Map<String, Object> searchParams){
		setPageData(userAccountRepository, searchParams, page, "findPageCount", "findPageData");
	}
	/**
	 * 查询所有数据
	 * @return
	 */
	@Cacheable(value="commonCache",key="#this='cache_users'")
	public List<UserAccount> findAll(){
		return (List<UserAccount>) userAccountRepository.findAll();
	}

	/**
	 * 添加用户登录信息
	 * @param entity
	 */
	@CacheEvict(value="commonCache",allEntries=true)
	public DefaultResult<UserAccount> addUserAccount(UserAccount entity){
		DefaultResult<UserAccount> result=new DefaultResult<UserAccount>();
		try {
			entryptPassword(entity);
			userAccountRepository.save(entity);
			result.setModule(entity);
		} catch (Exception e) {
			logger.error("用户注册失败！", e);
			result.addErrorMsg("-1", "保存失败");
		}
		return result;
	}
	/**
	 * 查询对应的用户登录信息
	 * @param id
	 * @return
	 */
	public UserAccount getUserAccountById(Long id){
		return userAccountRepository.findOne(id);
	}
	
	public UserAccount getUserByIdAndUsername(Long id){
		return userAccountRepository.findByIdAndUsername(id);
	}
	
	/**
	 * 设置安全密码，采用bcrypt加密算法
	 */
	private void entryptPassword(UserAccount user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(Constant.BCRYPT_LENGTH);
		String encoderpassword = encoder.encode(user.getPlainPassword());
		user.setPassword(encoderpassword);
	}
}
