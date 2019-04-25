package com.xishanqu.springdata.common.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public ListUtils() {
    }

    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }

    public static <T> List<T> single(T value) {
        List<T> list = new ArrayList();
        list.add(value);
        return list;
    }
}
