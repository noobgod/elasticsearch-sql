package com.jajian.search.dto;

import java.util.LinkedHashMap;

public class IndexRowData extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 4040420174717552587L;

    public IndexRowData build(String filedName, Object filedValue) {
        this.put(filedName, filedValue);
        return this;
    }
}
