package com.jkxy.car.api.pojo;


import javax.validation.constraints.NotNull;

public class PageBean {
    @NotNull
    private Integer pageNum=1;
    @NotNull
    private Integer pageSize=10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
