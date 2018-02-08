package com.epam.kuzora.hometask.service.util;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GsonParser {
    public <T> List<T> parseGsonIntoList(String json, Class<T> klass) {
        Gson gson = new Gson();
        return gson.fromJson(json, new ListOfSomething<T>(klass));
    }

    public <T> String parseListIntoJson(List<T> json, Class<T> klass) {
        Gson gson = new Gson();
        return gson.toJson(json, new ListOfSomething<T>(klass));
    }

    public <T> T parseGsonIntoObject(String json, Class<T> klass) {
        Gson gson = new Gson();
        return gson.fromJson(json, klass);
    }

    public <T> String parseObjectIntoJson(T json, Class<T> klass) {
        Gson gson = new Gson();
        return gson.toJson(json, klass);
    }

    class ListOfSomething<T> implements ParameterizedType {
        private Class<?> wrapped;

        public ListOfSomething(Class<T> wrapped) {
            this.wrapped = wrapped;
        }

        public Type[] getActualTypeArguments() {
            return new Type[]{wrapped};
        }

        public Type getRawType() {
            return List.class;
        }

        public Type getOwnerType() {
            return null;
        }
    }
}
