package com.my.quickstart.web.supervisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.quickstart.async.TestAsync1;
import com.my.quickstart.base.BaseController;
import com.my.quickstart.sequence.Sequence;
import com.my.quickstart.util.UserContextHolder;
/**
 * 首页处理
 * @author Alan
 *
 */
@Controller
@RequestMapping(value="/supervisor")
public class SupervisorController extends BaseController {
	
	@Autowired
	private TestAsync1 testAsync1;
	
	@Autowired
	private Sequence globalSequence;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	@ExceptionHandler
	public String login(Model model){
		if(UserContextHolder.isLogin()){
			return "redirect:/supervisor/index";
		}
		return "/supervisor/login";
	}
	
	@RequestMapping(value="/index")
	public String index() throws InterruptedException{
		/*long v=globalSequence.nextValue();
		System.out.println("v="+v);*/
		//TODO  获取菜单权限信息
		
		return "/supervisor/index";
	}
	
	@RequestMapping(value="/home")
	public String home(){
		//展示首页信息
		System.out.println("显示首页信息");
		return "/supervisor/home";
	}
}
