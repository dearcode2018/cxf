/**
 * 描述: 
 * BaseControllerTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.common;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hua.util.StringUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * BaseControllerTest
 */
/*
 * 
 * @SpringJUnit4ClassRunner 运行器负责拉起 spring 环境
 * @ContextConfiguration 指定 spring配置文件，若不指定，则使用默认配置.
 */
@WebAppConfiguration(value = "src/main/webapp")
//@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext.xml"})
/*
 * dispatcher-servlet.xml 放在目标项目的src/main/webapp/WEB-INF目录下
 * 无法直接放到当前项目的classpath目录下，因此需要在dispatcher-servlet.xml
 * 发生变化时，将此文件拷贝到conf/xml 目录下，所有的spring配置文件包括mvc部分，
 * 都在此处标示出来，才能正常启动mvc环境
 */
@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext-jaxrs.xml", "classpath:conf/xml/spring-context.xml"})
public class BaseControllerTest extends BaseSpringTest {

	
	
	/**
	 * 引当前项目用其他项目之后，然后可以使用
	 * SpringJunitTest模板测试的其他项目
	 * 
	 * 可以使用所引用目标项目的所有资源
	 * 若引用的项目的配置与本地的冲突或无法生效，需要
	 * 将目标项目的配置复制到当前项目同一路径下
	 * 
	 */
	
	@Resource
    protected WebApplicationContext webApplicationContext; 
	
	/**
	 * 
	 * @description POST 请求
	 * @param url 服务相对url
	 * @return
	 * @author qianye.zheng
	 */
	protected MockHttpServletRequestBuilder post(final String url)
	{
		final MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
		requestBuilder.header("Content-Type", "application/json;charset=UTF-8");
		requestBuilder.header("Accept", "application/json");
		// 构建公共参数
		buildCommonParam(requestBuilder);
		
		return requestBuilder;
	}
	
	/**
	 * 
	 * @description GET 请求
	 * @param url 服务相对url
	 * @return
	 * @author qianye.zheng
	 */
	protected MockHttpServletRequestBuilder get(final String url)
	{
		final MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
		requestBuilder.header("Accept", "application/json");
		// 构建公共参数
		buildCommonParam(requestBuilder);
		
		return requestBuilder;
	}
	
	/**
	 * 
	 * @description POST 请求
	 * @param url 服务相对url
	 * @return
	 * @author qianye.zheng
	 */
	protected MockHttpServletRequestBuilder options(final String url)
	{
		final MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.options(url);
		// 构建公共参数
		buildCommonParam(requestBuilder);
		
		return requestBuilder;
	}
	
	/**
	 * 
	 * @description 文件上传请求
	 * @param url 服务相对url
	 * @return
	 * @author qianye.zheng
	 */
	protected MockMultipartHttpServletRequestBuilder fileUpload(final String url)
	{
		final MockMultipartHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.fileUpload(url);
		// 构建公共参数
		buildCommonParam(requestBuilder);
		
		return requestBuilder;
	}
	
	/**
	 * 
	 * @description 执行(模拟)请求
	 * @param requestBuilder
	 * @return 返回模拟http请求对象
	 * @author qianye.zheng
	 */
	protected MockHttpServletResponse perform(final RequestBuilder requestBuilder)
	{
		// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
		final MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
		// 响应对象
		MockHttpServletResponse response = null;
		try
		{
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			mvcResult.getResponse().setContentType("application/json;charset=UTF-8");
			// 异常对象
			final Exception exception = mvcResult.getResolvedException();
			if (null != exception && StringUtil.isNotEmpty(exception.getMessage()))
			{
				log.warn("异常信息: " + exception.getMessage());
			}
			response = mvcResult.getResponse();
		} catch (final Exception e)
		{
			log.error("perform =====> ", e);
		}
		
		return response;
	}
	
	/**
	 * 
	 * @description 构建公共参数
	 * @param requestBuilder
	 * @author qianye.zheng
	 */
	private void buildCommonParam(final MockHttpServletRequestBuilder requestBuilder)
	{
		// token 令牌
		//token = null;
		//requestBuilder.param("tk", token);
		// 客户端类型0：android 1：ios
		//requestBuilder.param("ct", "1");
		// 客户端版本, 要验证签名值时 需要填写正确的版本数
		//requestBuilder.param("v", "18");
		// 时间戳
		//requestBuilder.param("t", String.valueOf(new Date().getTime()));
		token = "634968cc798b47e39eb332817f5b7757";
		// 超级管理员
		token = "8ac7b79f75124743b8d6177a398fbe91";
		token = "fc6dc225927442d2abf595ed75950211";
		token = "e6229a9cd5034734ab81c9f039db2158";
		token = "2fb9136127f740469e53fb6cbc990254";
		//token = "cb32711f46ca4738a51757fff3dd3c34";
		token = "8ac7b79f75124743b8d6177a398fbe91";
		token = "0edf86b7c4ac40289d79adf4a873b2d6";
		token = "7f66d5a9e01f4d1e87aa654ffab0d951";
		token = "36e109320746425ba92266719d4cb246";
		token = "1c80c0946bbc459582cb63dc4ae17acf";
		token = "cebb18b18ed34434ab8e642c7a968983";
		token = "a08a1e03056f4617adc01c458779c46c";
		token = "7836cf86613940a087f664fdbb8fdaf4";
		token = "b0d459e1adab4ca4886147f6b0c4c2f3";
		token = "89a25c30cc3c499f8b5dda2644cfd8d2";
		token = "cba89fbd89814f6483921623981e1330";
		//token = "10a10879ee10462a868e48c2f44dfe7d";
		// 普通管理员
		//token = "b72db1be0a9a4f0eb67c9c5e68d224ff";
		//token = "11";
		// 添加cookie
		//final Cookie cookie = new Cookie(Constant.ADMIN_AUTH_HEADER_KEY, token);
		//requestBuilder.cookie(cookie);
		// 设备号
		//requestBuilder.param("m", "");
		// 10位随机数
		//requestBuilder.param("r", "");
		// 签名值
		//requestBuilder.param("s", "");
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
