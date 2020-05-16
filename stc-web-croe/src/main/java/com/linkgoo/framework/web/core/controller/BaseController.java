package com.linkgoo.framework.web.core.controller;

import com.linkgoo.framework.web.core.Repository.SearchCriteria;
import com.linkgoo.framework.web.core.constant.MsgConstant;
import com.linkgoo.framework.web.core.exception.ParamException;
import com.linkgoo.framework.web.core.interceptor.Page;
import com.linkgoo.framework.web.core.response.RestResponse;
import com.linkgoo.framework.web.core.service.BaseService;
import com.linkgoo.framework.web.core.util.BeanValidator;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@Data
public abstract class BaseController<ID extends Serializable, ENTITY, SERVICE extends BaseService<ID, ENTITY>> {

    @Autowired
    public SERVICE service;

    @Autowired
    public HttpServletRequest request;

    public ENTITY entityValid;

    @GetMapping(value = "{id}")
    public RestResponse get(@PathVariable ID id) {
        return RestResponse.success(service.get(id));
    }

    @GetMapping(value = "list")
    public RestResponse find(@RequestParam Map<String, Object> params) {
        List<SearchCriteria> searchCriteria = SearchCriteria.toList(params);
        List<ENTITY> entityPage = service.find(searchCriteria);
        return RestResponse.success(entityPage);
    }

    @GetMapping(value = "page")
    public RestResponse page(@RequestParam Map<String, Object> params) {
        List<SearchCriteria> searchCriteria = SearchCriteria.toList(params);
        Page<ENTITY> page= service.page(searchCriteria);
        return RestResponse.success(page);
    }


    @PostMapping("")
    public  RestResponse save(@RequestBody ENTITY entity) {
        entity = savePrev(entity);
        entity = service.save(entity);
        return RestResponse.success(MsgConstant.saveSuccess,entity);
    }

    @PutMapping("modify")
    public RestResponse modify(@RequestBody ENTITY entity) {
        entity = modifyPrev(entity);
        service.update(entity);
        return RestResponse.success(MsgConstant.updateSuccess);
    }

    @PutMapping(value = "")
    public  RestResponse update(@RequestBody ENTITY entity) {
        entity = updatePrev(entity);
        service.updateAllProperties(entity);
        entity = updatePost(entity);
        return RestResponse.success(MsgConstant.updateSuccess,entity);
    }

    @DeleteMapping(value = "{id}")
    public RestResponse remove(@PathVariable ID id) {
        service.remove(id);
        return RestResponse.success(MsgConstant.deleteSuccess);
    }



    @DeleteMapping(value = "")
    public RestResponse removeByIds(@RequestBody List<ID> ids) {
        if (null == ids || ids.size() == 0) {
            throw new ParamException("不能为空");
        }
        return RestResponse.success(MsgConstant.deleteSuccess);
    }

    public ENTITY savePrev(ENTITY entity) {
        validate(entity,entityValid);
        return entity;
    }

    public ENTITY modifyPrev(ENTITY entity) {
        validate(entity,entityValid);
        return entity;
    }

    public ENTITY updatePrev(ENTITY entity) {
        validate(entity,entityValid);
        return entity;
    }

    public ENTITY updatePost(ENTITY entity) {
        return entity;
    }

    private <S extends T,T> T validate(T entity,S obj){
        if (obj == null ){
            return entity;
        }
        BeanUtils.copyProperties(entity,obj);
        BeanValidator.validate(obj);
        return obj;
    }

}
