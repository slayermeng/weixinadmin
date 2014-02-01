package com.weixinadmin.service;

import org.apache.log4j.Logger;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;

@Service("arithmeticService")
@Transactional
public class ArithmeticService {
	protected static Logger logger = Logger.getLogger("service");

	/**
	 * 实现一个加法运算
	 */
	public Integer add(Integer operand1, Integer operand2) {
		logger.debug("Adding two numbers");
		return operand1 + operand2;
	}
}
