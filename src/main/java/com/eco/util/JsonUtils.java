package com.eco.util;

import net.sf.json.JsonConfig;

/*
 * date:   2018年5月12日 下午3:21:05
 * author: Shixiaodong
 */
public class JsonUtils {

	public static JsonConfig JsonExclude(String... properties) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(properties);
		return jsonConfig;
	}
	
}
