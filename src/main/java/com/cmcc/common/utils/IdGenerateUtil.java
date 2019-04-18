package com.cmcc.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;

/**
 * 
 * ClassName: IdGenerateUtil 
 * @Description 封装各种生成唯一性ID算法的工具类.
 * @author zengzhibin
 * @date 2017年9月25日
 */
public class IdGenerateUtil {

	private static SecureRandom random = new SecureRandom();

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间有-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid2() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 使用SecureRandom随机生成Long.
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	public static String uuid3(){
		return uuid3(null,3);
	}

	public static String uuid3(String datepattern,int uuidlength){
		if(datepattern==null){
			datepattern="yyyyMMddHHmmssSSS";
		}
		String str=DateFormatUtils.format(new Date(), datepattern);
		if(uuidlength>0){
			str=str+UUID.randomUUID().toString().replaceAll("-", "").substring(0, uuidlength);
		}
		return str;
	}
}
