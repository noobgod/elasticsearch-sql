package com.jajian.search.dto;

import java.util.List;
import java.util.Set;

public class SearchResultDTO {

    /**
     * 查询结果总数
     */
    private long total;

    /**
     * 查询耗时
     */
    private long time;

    /**
     * 返回结果大小
     */
    private long resultSize;

    /**
     * 数据
     */
    private List<IndexRowData> result;

    /**
     * 结果列
     */
    private Set<String> resultColumns;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getResultSize() {
        return resultSize;
    }

    public void setResultSize(long resultSize) {
        this.resultSize = resultSize;
    }

    public List<IndexRowData> getResult() {
        return result;
    }

    public void setResult(List<IndexRowData> result) {
        this.result = result;
    }

    public Set<String> getResultColumns() {
        return resultColumns;
    }

    public void setResultColumns(Set<String> resultColumns) {
        this.resultColumns = resultColumns;
    }
}
