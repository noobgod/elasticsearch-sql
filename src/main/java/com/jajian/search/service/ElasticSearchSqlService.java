package com.jajian.search.service;

import com.jajian.search.dto.SearchResultDTO;

public interface ElasticSearchSqlService {

    SearchResultDTO search(String sql);

    String explain(String sql);

    SearchResultDTO query(String sql, String index);
}
