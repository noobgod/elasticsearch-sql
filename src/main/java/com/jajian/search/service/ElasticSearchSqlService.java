package com.jajian.search.service;

import com.jajian.search.dto.SearchResultDTO;

/**
 * @Auther: JaJIan
 * @Date: 2018/12/09 13:53
 */

public interface ElasticSearchSqlService {

    SearchResultDTO search(String sql);

    String explain(String sql);

    SearchResultDTO query(String sql, String index);
}
