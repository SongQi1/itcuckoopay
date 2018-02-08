package com.bocs.sys.mapper;

import com.bocs.core.base.BaseMapper;
import com.bocs.sys.model.SysSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysSessionMapper extends BaseMapper<SysSession> {

    void deleteBySessionId(String sessionId);

    Long queryBySessionId(String sessionId);

    List<String> querySessionIdByAccount(String account);
}