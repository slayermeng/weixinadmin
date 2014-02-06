package com.weixinadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;


@Controller
public class HelloWorldController {
	@RequestMapping("/hello")
	  public ModelAndView helloWorld() {
	    return new ModelAndView("hello", "message", "Spring MVC Demo");
	  }

	  @RequestMapping(value = "/time", method = RequestMethod.GET)
	  public @ResponseBody String getTime(@RequestParam String name) {
	    String result = "Time for " + name + " is " + new Date().toString();
	    return result;
	  }

}
