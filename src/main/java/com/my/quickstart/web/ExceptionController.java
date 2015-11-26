package com.my.quickstart.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.quickstart.base.BaseController;
import com.my.quickstart.constants.ExceptionConstant;
import com.my.quickstart.constants.SystemConstant;
@Controller
public class ExceptionController extends BaseController { 
	private static final String prefix="exception";
	
	@Value("${custom.profiles.active}")
	private String environment;
	
	//是否是开发环境，如果是开发环境将在页面打印错误信息
	private static boolean IS_DEV=true;
	/**
	 * 前置异常处理
	 * @param model
	 */
	private void beforDeal(Model model){
		IS_DEV=environment.equals(SystemConstant.ENVIRONMENT_DEV)?true:false;
		model.addAttribute("is_dev", IS_DEV);
	}
	@RequestMapping(value="/400")
	String page400(HttpServletRequest request,Model model){
		beforDeal(model);
		return prefix+ExceptionConstant.PAGE_400;
	}
	@RequestMapping(value="/401")
	String page401(HttpServletRequest request,Model model){
		beforDeal(model);
		return prefix+ExceptionConstant.PAGE_401;
	}
	@RequestMapping(value="/402")
	String page402(HttpServletRequest request,Model model){
		beforDeal(model);
		return prefix+ExceptionConstant.PAGE_402;
	}
	@RequestMapping(value="/403")
	String page403(HttpServletRequest request,Model model){
		beforDeal(model);
		return prefix+ExceptionConstant.PAGE_403;
	}
	@RequestMapping(value="/404")
	String page404(HttpServletRequest request,Model model){
		beforDeal(model);
		return prefix+ExceptionConstant.PAGE_404;
	}
	@RequestMapping(value="/405")
	String page405(HttpServletRequest request,Model model){
		beforDeal(model);
		return prefix+ExceptionConstant.PAGE_405;
	}
	@RequestMapping(value="/500")
	String page500(HttpServletRequest request,Model model){
		beforDeal(model);
		return prefix+ExceptionConstant.PAGE_500;
	}
	@RequestMapping(value="/504")
	String page504(HttpServletRequest request,Model model){
		beforDeal(model);
		return prefix+ExceptionConstant.PAGE_504;
	}
}
