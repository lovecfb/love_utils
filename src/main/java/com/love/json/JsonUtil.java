package com.love.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: XX科技有限公司<p>
 *
 * @author ${lisheng}
 * @since 2019/1/9 11:38
 */

public final class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final Gson GSON_PRETTY = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();


    private JsonUtil() {
        throw new RuntimeException("can't initialize JsonUtil ... ");
    }

    private static final Gson gson = new GsonBuilder()
            .disableHtmlEscaping()
            .serializeNulls()
            .registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
                @Override
                public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                    if (src == src.longValue()) {
                        return new JsonPrimitive(src.longValue());
                    }
                    return new JsonPrimitive(src);
                }
            }).create();


    /**
     * java bean transfer to json
     *
     * @param data
     * @return
     */
    public static String object2Json(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            logger.error("Object transfer to Json error: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param data
     * @return
     */
    public static String toGsonPretty(Object data) {
        return GSON_PRETTY.toJson(data);
    }

    /**
     * java bean transfer to json by gson
     *
     * @param data
     * @return
     */
    public static String object2JsonByGson(Object data) {
        return gson.toJson(data);
    }

    /**
     * json transfer to java bean by gson
     *
     * @param json
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> T json2ObjByGson(String json, Class<T> obj) {
        return gson.fromJson(json, obj);
    }


    /**
     * Json transfer to Java bean
     *
     * @param jsonData
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> T json2Pojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            logger.error("Json transfer to Java bean error: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Json transfer to list of Java bean
     *
     * @param jsonData josn
     * @param beanType javaBean
     * @param <T>
     * @return
     */
    public static <T> List<T> json2List(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            logger.error("Json transfer to list of Java bean error: {}", e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    /**
     * json transfer to JsonNode
     *
     * @param jsonData
     * @return
     */
    public static JsonNode json2Node(String jsonData) {
        try {
            JsonNode node = MAPPER.readTree(jsonData);
            return node;
        } catch (Exception e) {
            logger.error("Json transfer to JsonNode error: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


}
