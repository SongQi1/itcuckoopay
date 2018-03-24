package com.bocs.sys.service;/**
 * Created by wangpd on 2018/3/22.
 */

import com.baomidou.mybatisplus.service.IService;
import com.bocs.core.base.BaseService;
import com.bocs.sys.model.Merchant;
import com.bocs.sys.model.Role;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商户service
 * @author Wangpeidong
 * @create 2018-03-22 21:00
 **/
public interface MerchantService extends IService<Merchant> {
}
