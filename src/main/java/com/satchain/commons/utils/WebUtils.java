package com.satchain.commons.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class WebUtils {

	/**
	 * IP校验正则串
	 */
	public static final String IP_REGEX="^((([1-9]|[1-9][0-9]|1\\d\\d|2[0-4]\\d|25[0-5])))\\.((([0-9]|[1-9][0-9]|1\\d\\d|2[0-4]\\d|25[0-5])))\\.((([0-9]|[1-9][0-9]|1\\d\\d|2[0-4]\\d|25[0-5]))|\\*)\\.((([0-9]|[1-9][0-9]|1\\d\\d|2[0-4]\\d|25[0-5]))|\\*)$";


	public static Map<String, Object> parseParameterMap(HttpServletRequest request) {
		Map<String, String[]> paraMap = request.getParameterMap();
		Map<String, Object> rslt = new HashMap<String, Object>();

		if(paraMap == null || paraMap.size() == 0) {
			return rslt;
		}

		for( Entry<String, String[]> entry : paraMap.entrySet() ) {
			String key = entry.getKey();
			String[] value = entry.getValue();

			if( value == null ) {
				rslt.put(key, value);
			} else if( value.length == 0 ) {
				rslt.put(key, "");
			} else if( value.length == 1 ) {
				rslt.put(key, value[0]);
			} else {
				rslt.put(key, value);
			}
		}

		return rslt;
	}


	/**
	 * 创建UUID
	 */
	public static String createUUID(){
		String s = UUID.randomUUID().toString();
		String temp = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
		return temp;
	}

	/**
	 * 创建各表的主键ID
	 * @param tableName
	 * @return id<br/>
	 *     依照获取的表名拼装主键ID为：“2-5位表名简称”+yyyyMMddhhmmss+"5位随机数"
	 */
	public static String createPrimaryId(String tableName){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String dateTime = sdf.format(date);
		String rd = getRandomStr(5);
		return tableName+dateTime+rd;
	}

	/**
	 * 获取制定位数的随机字符串
	 * @param length
	 * @return String
	 */
	public static String getRandomStr(int length){
		String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for(int i = 0 ; i < length; ++i){
			int number = random.nextInt(62);//[0,62)
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 将一个 JavaBean 对象转化为一个  Map
	 * @param bean 要转化的JavaBean 对象
	 * @return 转化出来的  Map 对象
	 * @throws IntrospectionException 如果分析类属性失败
	 * @throws IllegalAccessException 如果实例化 JavaBean 失败
	 * @throws InvocationTargetException 如果调用属性的 setter 方法失败
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map convertBean(Object bean)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
		for (int i = 0; i< propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}

	/**
	 * 将一个 Map 对象转化为一个 JavaBean
	 * @param type 要转化的类型
	 * @param map 包含属性值的 map
	 * @return 转化出来的 JavaBean 对象
	 * @throws IntrospectionException 如果分析类属性失败
	 * @throws IllegalAccessException 如果实例化 JavaBean 失败
	 * @throws InstantiationException 如果实例化 JavaBean 失败
	 * @throws InvocationTargetException 如果调用属性的 setter 方法失败
	 */
	@SuppressWarnings("rawtypes")
	public static Object convertMap(Class type, Map map)
			throws IntrospectionException, IllegalAccessException,
			InstantiationException, InvocationTargetException {
		BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
		Object obj = type.newInstance(); // 创建 JavaBean 对象

		// 给 JavaBean 对象的属性赋值
		PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
		for (int i = 0; i< propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();

			if (map.containsKey(propertyName)) {
				// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
				Object value = map.get(propertyName);

				Object[] args = new Object[1];
				args[0] = value;

				descriptor.getWriteMethod().invoke(obj, args);
			}
		}
		return obj;
	}


	public  static boolean isEmpty(String str){
		return str==null || "".equals(str.trim());
	}

	public  static boolean isNotEmpty(String str){
		return str!=null && !"".equals(str.trim());
	}


	/**
	 * @description:获取请求ip(注意不能异步使用)
	 * @param:
	 * @Date:2016年5月3日上午9:18:43
	 * @author xiaoyong
	 */
	public static String getRemoteIp(HttpServletRequest request) {
		String ip=request.getHeader("x-forwarded-for");

		if(ip==null || "".equals(ip.trim()) || "unknown".equalsIgnoreCase(ip.trim())) {
			ip=request.getHeader("Proxy-Client-IP");
		}else{
			ip=ip.trim().replaceAll("\\s", "");

			String[] ipList=ip.split(",");

			for(int i=0;i<ipList.length;i++){
				if(!ipList[i].equalsIgnoreCase("unknown") && ipList[i].matches(IP_REGEX)) {
					ip=ipList[i];
					break;
				}
			}
		}

		if(ip==null || "".equals(ip.trim()) || "unknown".equalsIgnoreCase(ip.trim())) {
			ip=request.getHeader("WL-Proxy-Client-IP");
		}

		if(ip==null || "".equals(ip.trim()) || "unknown".equalsIgnoreCase(ip.trim())) {
			ip=request.getRemoteAddr();
		}

		return ip;
	}


	/**
	 * @description:判断是否get请求
	 * @author pengcc
	 */
	public static boolean isGet(HttpServletRequest request){
		return "GET".equalsIgnoreCase(request.getMethod());
	}

	/**
	 * @description:判断是否微信浏览器
	 * @author pengcc
	 */
	public static boolean isWeixinBrowser(HttpServletRequest request){
		String userAgent=request.getHeader("user-agent");
		if(userAgent!=null && userAgent.toLowerCase().indexOf("micromessenger")>0){
			return true;
		}
		return false;
	}

	/**
	 * @description:是否ajax请求
	 * @param:
	 * @author pengcc
	 */
	public static boolean isAjax(HttpServletRequest request){
		return request.getHeader("x-requested-with")!=null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest");
	}

	public static void writeToPage(String content, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/javascript;charset=UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(content);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (pw != null) {
				pw.flush();
				pw.close();
			}
		}
	}


	public static void writeHTMLToPage(String html, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(html);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (pw != null) {
				pw.flush();
				pw.close();
			}
		}
	}


}
