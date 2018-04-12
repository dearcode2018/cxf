/**
 * @filename JaxrsJacksonJsonObjectMapper.java
 * @author  qianye.zheng
 * 	@version 1.0
 */
package com.hua.mapper;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @type JaxrsJacksonJsonObjectMapper
 * @description  
 * @author qianye.zheng
 */
public class JaxrsJacksonJsonObjectMapper extends ObjectMapper
{
	
	/**
	 * @constructor
	 * @description  
	 * @author qianye.zheng
	 */
	public JaxrsJacksonJsonObjectMapper()
	{
		super();
		super.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, false);
		super.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, false);
		super.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		super.setSerializationInclusion(JsonSerialize.Inclusion.ALWAYS);
		super.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}
}
