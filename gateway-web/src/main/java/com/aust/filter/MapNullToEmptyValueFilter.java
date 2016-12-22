package com.aust.filter;

import com.alibaba.fastjson.serializer.ValueFilter;

import java.util.Map;

public class MapNullToEmptyValueFilter implements ValueFilter {
    @Override
    public Object process(Object object, String name, Object value) {

        if (null == value && object instanceof Map)
            return ""; // 如果值为null，返回空字符串
        else
            return value;
    }
}
