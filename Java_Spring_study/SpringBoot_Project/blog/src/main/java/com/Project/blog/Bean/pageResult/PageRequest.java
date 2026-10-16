package com.Project.blog.Bean.pageResult;

import lombok.Data;


//创建一个分页类, 返回需要分页的数据
//也就是需要分页返回的数据都用这个类包装返回
@Data
public class PageRequest<T> {
    private int page;
    private int size;
    private boolean hasMore;
    private T data;

}
