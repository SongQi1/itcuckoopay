package com.bocs.core.base;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:<p>Model基类</p>
 * Created by songqi on 2017/7/25.
 */
@JsonIgnoreProperties(ignoreUnknown = true,value = {"createBy","updateBy","updateTime"})
public class BaseModel extends Model implements Serializable{

    @TableField(exist = false)
    private Integer page = 1; // 当前页

    @TableField(exist = false)
    private Integer rows = 10; // 每页大小

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    /** 指定主键 */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
