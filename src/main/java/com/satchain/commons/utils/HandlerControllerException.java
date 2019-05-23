package com.satchain.commons.utils;

import com.satchain.commons.myEnum.ResponseCodeEnum;
import com.satchain.commons.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class HandlerControllerException {

	/**
	 * 返回json
	 * @param request
	 * @param ex  异常信息，类头上必须加上@ControllerAdvice注解才能起作用，否则获取不到ex的message信息
	 * @return
	 */
	@ExceptionHandler(value = Throwable.class)
	public Object serverError(HttpServletRequest request,HttpServletResponse response,
	                          Throwable ex) {
		Result result = new Result();
		result.setCode(ResponseCodeEnum.ERROR.getCode());
		result.setMessage(ex.getMessage());
		WebUtils.writeToPage(JSONUtils.toJson(result), response);
		return null;
	}
}
