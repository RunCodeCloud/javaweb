package com.offcn.utils;

import org.apache.commons.beanutils.Converter;

public class MyDateConverter implements Converter {

	@Override
	public Object convert(Class arg0, Object arg1) {
		
		String str = (String)arg1;
		
		if(str==null || "".equals(str)){
			return null;
		}else{	
			return DateUtil.stringToDate(str);
		}
	}
}
