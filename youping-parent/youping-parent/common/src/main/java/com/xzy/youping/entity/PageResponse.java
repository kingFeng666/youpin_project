package com.xzy.youping.entity;

import lombok.Data;

@Data
public class PageResponse extends Response {
    private Long current;//当前页码
    private Long size;//每页大小
    private Long total;//总条数


    public PageResponse current(Long current) {
        this.current = current;
        return this;
    }

    public PageResponse size(Long size) {
        this.size = size;
        return this;
    }

    public PageResponse total(Long total) {
        this.total = total;
        return this;
    }
}
