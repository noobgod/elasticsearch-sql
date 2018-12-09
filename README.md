# elasticsearch-sql
通过 SQL 查询 elasticsearch，快捷简单。

本项目主要依赖 [elasticsearch-sql](https://github.com/NLPchina/elasticsearch-sql)插件。

# 简介

本项目是在 Elasticsearch 5.6.0的基础上搭建的，如果你使用的 ES 不是该版本，API可能会有一些变化，可以自己修改下。

# 配置
在配置文件中需要如下的配置，修改为你自己的ES地址，如果是集群的形式，以逗号分隔即可。
```xml
server.port=8080
#elasticSearch 配置
elasticSearch.host=localhost:9200
elasticSearch.sql.host=localhost:9300
elasticSearch.maxRetryTimeout=10000
elasticSearch.httpScheme=http
```

# 主要接口

项目中提供了三个接口，具体内容在类ElasticSearchController中。

1.通过 API 的方式查询
```http
http://localhost:8080/es/data/search
```
2.通过 JDBC 的方式查询
```http
http://localhost:8080/es/data/query
```

2.expain sql，将SQL解释成DSL语言
```http
http://localhost:8080/es/data/expain
```


