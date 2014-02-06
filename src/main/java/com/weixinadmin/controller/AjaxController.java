package com.weixinadmin.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.weixinadmin.service.ArithmeticService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AjaxController {
	protected static Logger logger = Logger.getLogger("controller");

	@Resource(name = "arithmeticService")
	private ArithmeticService arithmeticService;

	/**
	 * 根据映射跳转到指定的页面
	 */
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ModelAndView getAjaxAddPage() {
		System.out.println("Received request to show AJAX, add page");
		return new ModelAndView("login", "message", "Spring MVC Demo");
	}

	/**
	 * 提交表单并进行运算.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody
	String login(
			@RequestParam String username,
			@RequestParam String password) {
		logger.info("Received request to add two numbers");
		System.out.println("Received request to add two numbers");
		System.out.println(username);
		System.out.println(password);
		// @ResponseBody 会自动的将返回值转换成JSON格式
		// 但是你必须添加jackson的jar包!!!
		return username+":"+password;
	}
}
