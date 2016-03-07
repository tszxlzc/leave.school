package cn.edu.sdwu.common.web;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


@SuppressWarnings("deprecation")
public class BaseControlLer {
	
	private static ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.getSerializationConfig().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));  
	}

	/**
	 * 输出文本字符串
	 * @param data
	 */
	public void printText(HttpServletResponse response, String data){
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(data);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 输出文本字符串
	 * @param data
	 */
	public void printText(HttpServletResponse response, Object data){
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		try {
			mapper.writeValue(response.getWriter(), data);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 输出JSON字符串
	 * @param data
	 */
	public void printJson(HttpServletResponse response, final String data){
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");  
		try {
			response.getWriter().write(data);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	/**
	 * 输出JSON字符串
	 * @param data
	 */
	public void printJson(HttpServletResponse response, final Object data){
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		try {
			mapper.writeValue(response.getWriter(), data);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
