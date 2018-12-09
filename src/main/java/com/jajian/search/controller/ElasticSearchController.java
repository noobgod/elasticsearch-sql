package com.jajian.search.controller;

import com.jajian.search.common.CommonResult;
import com.jajian.search.dto.QueryDto;
import com.jajian.search.dto.SearchResultDTO;
import com.jajian.search.service.ElasticSearchSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: JaJIan
 * @Date: 2018/12/09 13:53
 */
@RestController
@RequestMapping("/es/data")
public class ElasticSearchController {

    @Autowired
    private ElasticSearchSqlService elasticSearchSqlService;

    @PostMapping(value = "/search")
    public CommonResult search(@RequestBody QueryDto queryDto) {
        SearchResultDTO resultDTO = elasticSearchSqlService.search(queryDto.getSql());
        return CommonResult.success(resultDTO.getResult());
    }

    @PostMapping(value = "/query")
    public CommonResult query(@RequestBody QueryDto queryDto) {
        SearchResultDTO resultDTO = elasticSearchSqlService.query(queryDto.getSql(), queryDto.getIndex());
        return CommonResult.success(resultDTO.getResult());
    }

    @PostMapping(value = "/explain")
    public CommonResult explain(@RequestBody QueryDto queryDto) {
        return CommonResult.success(elasticSearchSqlService.explain(queryDto.getSql()));
    }

}
