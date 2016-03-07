package cn.edu.sdwu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.sdwu.common.web.BaseControlLer;

@Controller
public class IndexController extends BaseControlLer{
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(){
		ModelAndView mav = new ModelAndView("logout");
		return mav;
	}
}