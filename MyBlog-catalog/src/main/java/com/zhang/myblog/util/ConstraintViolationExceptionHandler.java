/**
 * 
 */
package com.zhang.myblog.util;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/11/2
 * @备注 处理Bean验证，如果验证过程中有问题，可以抛出多个异常。
 * 条件通过Bean中注解
 **/
public class ConstraintViolationExceptionHandler {

	/**
	 * 获取批量异常信息
	 * @param e
	 * @return
	 */
	public static String getMessage(ConstraintViolationException e) {
		List<String> msgList = new ArrayList<>();
		for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
			msgList.add(constraintViolation.getMessage());
        }
		String messages = StringUtils.join(msgList.toArray(), ";");
		return messages;
	}

}
