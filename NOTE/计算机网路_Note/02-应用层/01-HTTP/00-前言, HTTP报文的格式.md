```
GET /100012345678.html?sku=123 HTTP/1.1
Host: item.jd.com
User-Agent: Chrome
Accept: text/html

← 空行，下面没有任何请求体 -> GET报文基本都没有请求体
```

```
POST /test04 HTTP/1.1
Host: localhost:8080
Accept: */*
Content-Type: application/json
Content-Length: 42

← 空行，下面就是请求体
{
    "username":"zhangsan",
    "age":20
}
```
有了这个格式就能更清晰的看各个字段了

## HTTP报文格式
就形式而言, HTTP报文的格式就是

一行 请求行
一堆 请求头
空行
内容主体