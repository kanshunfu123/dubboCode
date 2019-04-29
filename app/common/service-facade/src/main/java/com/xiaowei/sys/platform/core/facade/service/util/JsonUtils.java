package com.xiaowei.sys.platform.core.facade.service.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fuzl
 */
public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private final static Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static Gson getInstance() {
        return GSON;
    }

    private static ObjectMapper mapper = new ObjectMapper();

    public static Map<String, Object> jsonToMap(String json)
    {
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        Map result = null;
        try {
            result = (Map)mapper.readValue(json, HashMap.class);
        } catch (JsonParseException e) {
            logger.error("json解释错误", e);
        } catch (JsonMappingException e) {
            logger.error("json映射错误", e);
        } catch (IOException e) {
            logger.error("json转换是发生IO异常", e);
        }
        return result;
    }

    public static String toJson(Object obj) {
        StringWriter writer = new StringWriter();
        try {
            mapper.writeValue(writer, obj);
        } catch (JsonGenerationException e) {
            logger.error("json生成出错", e);
        } catch (JsonMappingException e) {
            logger.error("json映射错误", e);
        } catch (IOException e) {
            logger.error("json转换是发生IO异常", e);
        }
        return writer.toString();
    }

    /***
     * List 转为 JSON
     * @param list
     * @return
     */
    public static <T> String list2Json(List<T> list) {
        if (null != list && list.size() > 0) {
            JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
            return jsonArray.toString();
        }
        return "";
    }


    /***
     * JSON 转换为 List
     * @param jsonStr
     * @param objectClass
     * @return
     */
    public static <T> List<T> json2List(String jsonStr, Class<T> objectClass) {
        if (StringUtils.isNotBlank(jsonStr)) {
            JSONArray jsonArray = JSONArray.parseArray(jsonStr);
            List<T> list = (List<T>) JSON.parseArray(jsonArray.toJSONString(), objectClass);
            return list;
        }
        return null;
    }


    /***
     * Object 转为  JSON
     * @param object
     * @return
     */
    public static String object2Json(Object object) {
        if (null != object) {
            JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(object),JSONObject.class);
            return jsonObject.toString();
        }
        return "";
    }

    /***
     *
     * JSON 转 Object
     *
     * @param jsonStr
     *         [{"age":12,"createTime":null,"id":"","name":"wxw","registerTime":null,"sex":1}]
     * @param objectClass
     * @return
     */
    public static <T> T json2Ojbect(String jsonStr, Class<T> objectClass) {
        if (null != jsonStr) {
            String leftStr = jsonStr.substring(0, 2);
            String rightStr = jsonStr.substring(jsonStr.length() - 2, jsonStr.length());
            if ("[{".equals(leftStr)) {
                jsonStr = jsonStr.substring(1, jsonStr.length());
            }
            if ("}]".equals(rightStr)) {
                jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
            }
            JSONObject jsonStu = JSONObject.parseObject(jsonStr);
            return (T) JSON.parseObject(JSON.toJSONString(jsonStu), objectClass);
        }
        return null;
    }

    /**
     * JSON转OBJ 支持转成list
     *
     * @param jsonStr
     * @param cl
     * @return
     */
    public static Object jsonToBean(String jsonStr, Class<?> cl) {
        Object obj = null;
        try {
            ObjectMapper mapper = new ObjectMapper(); //转换器
            //测试01：对象--json
            obj = mapper.readValue(jsonStr, cl); //json转换成map
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return obj;
    }

    /***
     * JsonArray 转为 JSON
     * @param jsonArray
     * @return
     */
    public static String jsonArrayToJSONString(JSONArray jsonArray) {
        if (null != jsonArray) {
            return jsonArray.toString();
        }
        return "";
    }

    /***
     * JsonObject 转为  JSON
     * @param jsonObject
     * @return
     */
    public static String jsonObjectToJSONString(JSONObject jsonObject) {
        if (null != jsonObject) {
            return jsonObject.toString();
        }
        return "";
    }

    /***
     * 将Object转换为JsonObject
     * @param object
     * @return
     */
    public static JSONObject object2JsonObject(Object object) {
        if (null != object) {
            return JSONObject.parseObject(JSON.toJSONString(object));
        }
        return null;
    }


}
