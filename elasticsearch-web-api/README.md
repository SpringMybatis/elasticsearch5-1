
## 创建索引文档 - PUT shops
```json
{
  "settings": {
    "analysis": {
      "analyzer": {
        "my_custom_analyzer": {
          "type": "custom",
          "tokenizer": "ik_max_word"
        }
      }
    }
  },
  "mappings": {
    "shop": {
      "properties": {
        "id": {
          "type": "text",
          "store": true
        },
        "cname": {
          "type": "text",
          "analyzer": "ik_max_word",
          "search_analyzer": "ik_max_word",
          "index": true,
          "store": true
        },
        "areaTag": {
          "type": "text",
          "analyzer": "ik_max_word",
          "search_analyzer": "ik_max_word",
          "index": true,
          "store": true
        },
        "provinceName": {
          "type": "text",
          "analyzer": "ik_max_word",
          "search_analyzer": "ik_max_word",
          "index": true,
          "store": true
        },
        "cityName": {
          "type": "text",
          "analyzer": "ik_max_word",
          "search_analyzer": "ik_max_word",
          "index": true,
          "store": true
        },
        "districtName": {
          "type": "text",
          "analyzer": "ik_max_word",
          "search_analyzer": "ik_max_word",
          "index": true,
          "store": true
        },
        "field1": {
          "type": "text",
          "analyzer": "ik_max_word",
          "search_analyzer": "ik_max_word",
          "index": true,
          "store": true
        },
        "field2": {
          "type": "text",
          "analyzer": "ik_max_word",
          "search_analyzer": "ik_max_word",
          "index": true,
          "store": true
        },
        "category": {
          "type": "text",
          "analyzer": "ik_max_word",
          "search_analyzer": "ik_max_word",
          "index": true,
          "store": true
        },
        "location": {
          "type": "geo_point",
          "index": true,
          "store": true
        },
        "isRebate": {
          "type": "integer",
          "store": true,
          "index": true
        },
        "returnRatio": {
          "type": "double",
          "index": true,
          "store": true
        }
      }
    }
  }
}

```


## API

1. 查询根据关键字和经纬度查询店铺

```
http://{{host}}:{{port}}/shops/美业/34.323612/116.570805/?pageNo=2&pageSize=30
```

2. total count
eg:

    

