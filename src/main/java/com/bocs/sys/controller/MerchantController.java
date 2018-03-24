package com.bocs.sys.controller;/**
 * Created by wangpd on 2018/3/20.
 */

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.bocs.core.support.ExecuteResult;
import com.bocs.core.support.PageInfo;
import com.bocs.sys.model.Merchant;
import com.bocs.sys.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 商户Controller
 *
 * @author Wangpeidong
 * @create 2018-03-20 20:10
 **/
@Controller
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping("/tolist")
    public ModelAndView toList() {
        ModelAndView modelAndView = new ModelAndView("merchant/merchant_list");
        modelAndView.addObject("merchant", new Merchant());
        return modelAndView;
    }

    @RequestMapping("/list")
    @ResponseBody
    public ExecuteResult list(Merchant merchant) {
        PageInfo<Merchant> merchantPage = new PageInfo<>(merchant.getPage(), merchant.getRows());
        EntityWrapper<Merchant> wrapper = new EntityWrapper<>();
        if (!ObjectUtils.isEmpty(merchant.getMerchantName())) {
            wrapper.like("merchant_name", merchant.getMerchantName());
        }
        return ExecuteResult.successResult(merchantService.selectMapsPage(merchantPage, wrapper));
    }

    /**
     * @description :
     * @return : org.springframework.web.servlet.ModelAndView
     * @author : Wangpeidong
     * @create : 2018-03-23 20:40:49
     */
    @RequestMapping("/toadd")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView("merchant/merchant_add");
        modelAndView.addObject("merchant", new Merchant());
        return modelAndView;
    }

    /**
     * @description :
     * @param merchant :
     * @return : com.bocs.core.support.ExecuteResult
     * @author : Wangpeidong
     * @create : 2018-03-23 21:53:51
     */
    @RequestMapping(value = "/add", method= RequestMethod.POST )
    @ResponseBody
    public ExecuteResult add(@ModelAttribute(value = "merchant") @Valid Merchant merchant, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errorList = result.getAllErrors();
            return ExecuteResult.errorResult(errorList.get(0).getDefaultMessage());
        }

        String userId = merchant.getUserId();
        EntityWrapper<Merchant> wrapper = new EntityWrapper<>();
        wrapper.where("user_id={0}", userId);
        Merchant query = merchantService.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(query)) {
            return ExecuteResult.errorResult("该商户支付宝PID已存在");
        }
        merchantService.insert(merchant);
        return ExecuteResult.successResult();
    }

    @RequestMapping("/toedit/{id}")
    public ModelAndView toEdit(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("merchant/merchant_edit");
        Merchant merchant = merchantService.selectById(id);
        modelAndView.addObject("merchant", merchant);
        return modelAndView;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public ExecuteResult edit(@ModelAttribute("merchant") @Valid Merchant merchant, BindingResult result) {
        if (result.hasErrors()) {
            return ExecuteResult.errorResult(result.getAllErrors().get(0).getDefaultMessage());
        }

        EntityWrapper<Merchant> wrapper = new EntityWrapper<>();
        wrapper.where("user_id = {0} and id != {1}", merchant.getUserId(),merchant.getId());
//        wrapper.where("user_id = {0}", merchant.getUserId()).and("id != {0}", merchant.getId());
        Merchant query = merchantService.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(query)) {
            return ExecuteResult.errorResult("该商户支付宝PID已存在");
        }
        if (!merchantService.updateById(merchant)) {
            return ExecuteResult.errorResult("操作失败");
        }
        return ExecuteResult.successResult();
    }

    /**
     * @description :
     * @param ids :
     * @return : com.bocs.core.support.ExecuteResult
     * @author : Wangpeidong
     * @create : 2018-03-24 09:14:45
     */
    @RequestMapping("/del/{ids}")
    @ResponseBody
    public ExecuteResult del(@PathVariable("ids") String ids) {
        boolean flag = false;
        if (!ObjectUtils.isEmpty(ids)) {
            if (ids.contains(",")) {
                String[] idsArr = ids.split(",");
                if (idsArr != null && idsArr.length > 0) {
                    flag = merchantService.deleteBatchIds(Arrays.asList(idsArr));
                }
            } else{
                flag = merchantService.deleteById(Long.valueOf(ids));
            }
        }
        if (flag) {
            return ExecuteResult.successResult();
        }
        return ExecuteResult.errorResult("操作失败");
    }

}
