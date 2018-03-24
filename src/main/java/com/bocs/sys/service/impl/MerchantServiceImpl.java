package com.bocs.sys.service.impl;/**
 * Created by wangpd on 2018/3/22.
 */

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bocs.sys.mapper.MerchantMapper;
import com.bocs.sys.model.Merchant;
import com.bocs.sys.service.MerchantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商户接口实现类
 *
 * @author Wangpeidong
 * @create 2018-03-22 21:11
 **/
@Transactional
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements MerchantService{
}
