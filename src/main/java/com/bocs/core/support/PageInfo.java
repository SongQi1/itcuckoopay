package com.bocs.core.support;/**
 * Created by wangpd on 2018/3/22.
 */

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * jqGrid分页封装
 *
 * @author Wangpeidong
 * @create 2018-03-22 20:37
 **/
public class PageInfo<T> extends Page {

    public PageInfo(){
        super();
    }

    public PageInfo(int current, int size){
        super(current, size);
    }

    /**
     * 当前页
     * @return
     */
    @JsonProperty(value = "page")
    public int getPageNum() {
        return super.getCurrent();
    }

    /**
     * 每页大小
     * @return
     */
    @JsonProperty(value = "pageSize")
    public int getPageSize() {
        return super.getSize();
    }

    /**
     * 总页数
     * @return
     */
    @Override
    @JsonProperty(value = "total")
    public int getPages() {
        return super.getPages();
    }

    /**
     * 总记录数
     * @return
     */
    @Override
    @JsonProperty(value = "records")
    public int getTotal() {
        return super.getTotal();
    }

    /**
     * 记录行
     * @return
     */
    @JsonProperty(value = "rows")
    public List<T> getList() {
        return super.getRecords();
    }
}
