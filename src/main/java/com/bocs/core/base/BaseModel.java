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
}
