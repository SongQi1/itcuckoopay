package com.bocs.sys.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:<p> </p>
 * Created by songqi on 2017/8/26.
 */
@Repository
public interface SysAuthorizeMapper {

    List<String> queryPermissionByUserId(@Param("userId") Long userId);
}
