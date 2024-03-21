package com.example.mytakeout.controller;

import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class R<T> {
    public boolean state;
    public T data;
    public String msg;

    public static <T> R<T> success(T data, String msg) {
        return new R<T>(true, data, msg);
    }

    public static <T> R<T> success(T data) {
        return new R<T>(true, data, null);
    }

    public static <T> R<T> fail(T data, String msg) {
        return new R<T>(false, data, msg);
    }

    public static <T> R<T> fail(T data) {
        return new R<T>(false, data, null);
    }
    public static <T> R<T> fail(String msg) {
        return new R<T>(false, null, msg);
    }

    public static <T extends Object> R<List<T>> buildList(List<T> data) {
        if (data == null) {
            List<T> empty = Collections.emptyList();
            return R.fail(empty);
        } else
            return R.success(data);
    }

    static R<String> buildString(String data) {
        if (data == null) {
            String empty = new String();
            return R.fail(empty);
        } else
            return R.success(data);
    }

}
