package com.sweet.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sweet.bean.SysResponse;
import com.sweet.util.SysException;

public abstract class BaseController {
	
	/**
	 * 全局捕获异常
	 */
	@ExceptionHandler
	public SysResponse<Void> handlerException(Exception e,HttpServletRequest request) {
		SysResponse<Void> rr = new SysResponse<Void>();
		e.printStackTrace();
		if(e instanceof BindException) {//校验框架
			BindingResult bindingResult = ((BindException) e).getBindingResult();
	        StringBuffer errorMesssage = new StringBuffer();
	        for (FieldError fieldError : bindingResult.getFieldErrors()) {
	            errorMesssage .append(fieldError.getDefaultMessage() + ",");
	        }
			rr.setMessage(errorMesssage.substring(0, errorMesssage.lastIndexOf(",")).toString());
		}else if(e instanceof SysException) {//业务提示
			rr.setMessage(e.getMessage());
		}else {
			rr.setMessage("发生了意想不到的错误");
		}
		rr.setState(SysResponse.STATE_ERROR);
		return rr;
	}


}
