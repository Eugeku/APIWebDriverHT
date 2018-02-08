package com.epam.kuzora.hometask.service.util;

import com.epam.kuzora.hometask.core.util.Logger;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class JsonParser {
    public <T> List<T> parseJsonIntoList(String json, Class<T> klass) {
        Logger.logInConsole(String.format("Parse json into list of %s objects\n\r", klass.getClass().getName()));
        Gson gson = new Gson();
        return gson.fromJson(json, new ListOfSomething<T>(klass));
    }

    public <T> String parseListIntoJson(List<T> json, Class<T> klass) {
        Logger.logInConsole(String.format("Parse list of %s objects into json\n\r", klass.getClass().getName()));
        Gson gson = new Gson();
        return gson.toJson(json, new ListOfSomething<T>(klass));
    }

    public <T> T parseJsonIntoObject(String json, Class<T> klass) {
        Logger.logInConsole(String.format("Parse json into object of %s\n\r", klass.getName()));
        Gson gson = new Gson();
        return gson.fromJson(json, klass);
    }

    public <T> String parseObjectIntoJson(T json, Class<T> klass) {
        Logger.logInConsole(String.format("Parse object of %s into json\n\r", klass.getName()));
        Gson gson = new Gson();
        return gson.toJson(json, klass);
    }

    class ListOfSomething<T> implements ParameterizedType {
        private Class<?> wrapped;

        public ListOfSomething(Class<T> wrapped) {
            this.wrapped = wrapped;
        }

        public Type[] getActualTypeArguments() {
            return new Type[] {wrapped};
        }

        public Type getRawType() {
            return List.class;
        }

        public Type getOwnerType() {
            return null;
        }
    }
}
