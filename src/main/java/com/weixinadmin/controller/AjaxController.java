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

@Controller  
@RequestMapping("/main/ajax") 
public class AjaxController {
	protected static Logger logger = Logger.getLogger("controller");  
	  
    @Resource(name = "arithmeticService")  
    private ArithmeticService arithmeticService;  
  
    /** 
     * 根据映射跳转到指定的页面 
     */  
    @RequestMapping(value = "/add", method = RequestMethod.GET)  
    public String getAjaxAddPage() {  
        logger.debug("Received request to show AJAX, add page");  
  
        // 解析 /WEB-INF/jsp/ajax-add-page.jsp  
        return "ajax-add-page";  
    }  
  
    /** 
     * 提交表单并进行运算. 
     */  
    @RequestMapping(value = "/add", method = RequestMethod.POST)  
    public @ResponseBody  
    Integer add(  
            @RequestParam(value = "inputNumber1", required = true) Integer inputNumber1,  
            @RequestParam(value = "inputNumber2", required = true) Integer inputNumber2,  
            Model model) {  
        logger.debug("Received request to add two numbers");  
  
        // 实现运算  
        Integer sum = arithmeticService.add(inputNumber1, inputNumber2);  
  
        // @ResponseBody 会自动的将返回值转换成JSON格式  
        // 但是你必须添加jackson的jar包!!!  
        return sum;  
    }  
}
