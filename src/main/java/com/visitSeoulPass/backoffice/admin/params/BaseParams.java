package com.visitSeoulPass.backoffice.admin.params;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseParams {
    private Integer page = 1;
    private Integer size = 10;
    private String sortBy;
    private String sortOrder;
    private String keyword;

    public static String toString(Object obj) {
        return obj != null ? obj.toString() : null;
    }

    public static String[] toStringArray(Object[] objs) {
        if (objs == null) return null;
        String[] result = new String[objs.length];
        for (int i = 0; i < objs.length; i++) {
            result[i] = toString(objs[i]);
        }
        return result;
    }
}
