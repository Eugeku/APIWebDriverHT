package com.epam.kuzora.hometask.tests.common.util.api;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GsonParser<T> {
    public List<T> parseGsonIntoList(String json, Class<T> klass) {
        Gson gson = new Gson();
        return gson.fromJson(json, new ListOfSomething<T>(klass));
    }

    public T parseGsonIntoObject(String json, Class<T> klass) {
        Gson gson = new Gson();
        return gson.fromJson(json, klass);
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
