package com.my.quickstart.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.quickstart.base.BaseController;
import com.my.quickstart.base.DefaultResult;
import com.my.quickstart.base.Page;
import com.my.quickstart.base.Sort;
import com.my.quickstart.constants.Constant;
import com.my.quickstart.constants.ExceptionConstant;
import com.my.quickstart.entity.UserAccount;
import com.my.quickstart.service.UserAccountService;
import com.my.quickstart.util.Servlets;
/**
 * 账户处理controller，主要用户账户信息访问
 * @author Alan
 *
 */
@Controller
@RequestMapping(value="/userAccount")
public class AccountController extends BaseController {

	@Autowired
	private UserAccountService userAccountService;
	/**
	 * 查询所有用户
	 * @param model
	 * @return
	 */
	@RequestMapping(value="list")
	String listAll(Page<UserAccount> page,Model model,HttpServletRequest request){
		Map<String,Object> searchParams = Servlets.getParametersStartingWith(request,Constant.QUERY_PRFIX);
		if(searchParams.get("sortBy")!=null&&searchParams.get("sortType")!=null){
			Sort s=new Sort(searchParams.get("sortBy").toString(),searchParams.get("sortType").toString());
			page.setSort(s);
		}
		userAccountService.queryByPage(page,searchParams);
		model.addAttribute("page", page);
		model.addAllAttributes(searchParams);
		// 将搜索条件编码成字符串，用于排序，分页的URL
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams,Constant.QUERY_PRFIX));
		return "userAccount/list";
	}
	
	@RequestMapping(value="/allUser")
	String allUser(Model model){
		List<UserAccount> allUser=userAccountService.findAll();
		model.addAttribute("all", allUser);
		return "userAccount/allUser";
	}
	/**
	 * 添加账号信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="add",method=RequestMethod.GET)
	String add(Model model){
		if(!model.containsAttribute("userAccountValid")){
			model.addAttribute("userAccountValid",new UserAccount());
		}
		return "userAccount/add";
	}
	/**
	 * 保存数据
	 * @return
	 */
	@RequestMapping(value="save",method=RequestMethod.POST)
	String save(Model model,@Valid @ModelAttribute("userAccountValid") UserAccount userAccount,BindingResult result){
		
		if(result.hasErrors()){
			return add(model);
		}
		DefaultResult<UserAccount> defaultResult=userAccountService.addUserAccount(userAccount);
		if(defaultResult.isFailure()){
			return "redirect:"+ExceptionConstant.PAGE_400;
		}
		return "redirect:/userAccount/list";
	}
}
