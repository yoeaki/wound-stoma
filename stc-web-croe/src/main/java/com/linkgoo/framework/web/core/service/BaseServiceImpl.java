package com.linkgoo.framework.web.core.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.linkgoo.framework.web.core.Repository.BaseRepository;
import com.linkgoo.framework.web.core.Repository.SearchCriteria;
import com.linkgoo.framework.web.core.exception.BusinessException;
import com.linkgoo.framework.web.core.interceptor.Page;
import com.linkgoo.framework.web.core.util.BeanPropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


@Transactional
public class BaseServiceImpl<ID extends Serializable,ENTITY,REPOSITORY extends BaseRepository<ENTITY>>
        implements BaseService<ID,ENTITY> {

    @Autowired
    protected REPOSITORY repository;

    protected final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 通过实体id获取对象
     */
    @Override
    public  ENTITY get(ID id) {
        return repository.getById(id);
    }
    /**
     * 获取实体对象
     */
    @Override
    public ENTITY get(ENTITY entity) {
        return repository.getOne(entity);
    }

    @Override
    public ENTITY getByField(String field, Object value) {
        List<ENTITY> entities = findByField(field, value);
        if (null != entities && entities.size() > 1) {
            throw new BusinessException("本应该读取到一条数据，实际上读取到了多条数据");
        }
        return entities == null || entities.size() == 0 ? null : entities.get(0);
    }

    @Override
    @Transactional(readOnly = false)
    public ENTITY save(ENTITY entity) {
        repository.save(entity);
        return entity;
    }


    @Override
    @Transactional(readOnly = false)
    public Iterable<ENTITY> saveList(Iterable<ENTITY> entities){
        saveList(entities,30);
        return entities;
    }

    @Override
    public Iterable<ENTITY> saveList(Iterable<ENTITY> entities, Integer rowCount) {
        saveList(entities);
        Iterator<ENTITY> it = entities.iterator();
        ArrayList<ENTITY> list = new ArrayList<>();
        while (it.hasNext()) {
            list.add(it.next());
        }

        if ( list.size() == 0) {
            return entities;
        }
        if (rowCount <= 0) {
            rowCount = 50;
        }
        for (int i = 0; i < list.size(); i += rowCount) {
            int end = i+rowCount;
            if (list.size() - i < rowCount) {
                end = list.size();
            }
            repository.saveList(list.subList(i,end));

        }
        return entities;
    }

    @Override
    public  boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public List<ENTITY> findAll() {
        return repository.findAll();
    }


    public  List<ENTITY> findByIds(List<ID> ids) {
        return repository.findByIds(ids);
    }

    @Override
    @Transactional(readOnly = false)
    public  int remove(List<ID> ids) {
        return repository.deleteByIds(ids);
    }

    @Override
    @Transactional(readOnly = false)
    public int removeAll() {
        return repository.removeAll();
    }

    @Override
    @Transactional(readOnly = false)
    public  int remove(ID id) {
        return repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public <S extends ENTITY> int remove(S entities) {
        return repository.remove(entities);
    }


    @Override
    public int count() {
        return repository.countAll();
    }

    @Override
    public Page<ENTITY> page(List<SearchCriteria> parameter) {
        return repository.pageByCriteria(parameter);
    }


    @Override
    public <S extends ENTITY> Page<ENTITY> page(S parameter) {
        return repository.page(parameter);
    }


    @Override
    public Page<ENTITY> page(Map<String, Object> parameter) {
        return repository.pageByMap(parameter);
    }
    @Override
    public List<ENTITY> find(List<SearchCriteria> parameter) {
        return repository.findByCriteria(parameter);
    }
    @Override
    //分页动态查询
    public List<ENTITY> find(Map<String, Object> parameter) {
        return repository.findByMap(parameter);
    }

    @Override
    public <S extends ENTITY> List<ENTITY> find(S parameter) {
        return repository.find(parameter);
    }

    @Override
    public List<ENTITY> findByField(String field, Object value) {
        HashMap<String, Object> map = new HashMap<>();
        if (value == null || (value instanceof String && StringUtils.isBlank((String) value))) {
            throw new BusinessException("字段"+field+" 的 value 为空或为空字符串");
        }
        map.put(field,value);
        return repository.findByMap(map);
    }

    @Override
    public <S extends ENTITY> int count(S parameter) {
        return repository.count(parameter);
    }
    @Override
    public <S extends ENTITY> int countMap(Map<String, List<?>> map, S parameter) {
        return repository.countMap(parameter, map);
    }

    @Override
    public <S extends ENTITY> int countMap(Map<String, List<?>> map) {
        return repository.countMap(null, map);
    }

    @Override
    @Transactional(readOnly = false)
    public int update(ENTITY entity) {
        try {
            MethodUtils.invokeMethod(entity, "preUpdate");
        } catch (NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
            log.error(e.getMessage(),e);
        }
        return repository.update(entity);
    }

    @Override
    @Transactional
    public  int updateAllProperties(ENTITY entity,ID id ,boolean allwoNull) {
        try {
            MethodUtils.invokeMethod(entity, "preUpdate");
        } catch (NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
            log.error(e.getMessage(),e);
        }
        ENTITY nextEntity = get(id);
        String[] nullPropertyNames = null;
        if (allwoNull != true) {

            nullPropertyNames = BeanPropertyUtils.getNullPropertyNames(entity);
        }
        BeanUtils.copyProperties(entity,nextEntity,nullPropertyNames);
        return repository.updateAll(nextEntity);
    }

    @Override
    public int updateAllProperties(ENTITY entity) {
        try {
            MethodUtils.invokeMethod(entity, "preUpdate");
        } catch (NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
            log.error(e.getMessage(),e);
        }
        return repository.updateAll(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public int update(ENTITY oldEntity, ENTITY newEntity) {
        try {
            MethodUtils.invokeMethod(newEntity, "preUpdate");
        } catch (NoSuchMethodException | IllegalAccessException
                | InvocationTargetException e) {
            log.error(e.getMessage(),e);
        }
        return repository.modify(oldEntity, newEntity);
    }

    @Override
    public void rollback(String json, String optype, Map<String, String> map) {
        ENTITY entity = JSON.parseObject(json, new TypeReference<ENTITY>() {
        });
        if ("add".equals(optype)) {
            repository.save(entity);
        } else if ("update".equals(optype)) {
            repository.update(entity);
        } else if ("delete".equals(optype)) {
            repository.remove(entity);
        }
    }




    @Override
    public List<Map<String, Object>> exportData(Map<String, Object> param) {
        return null;
    }
    @Override
    public void updateList(Iterable<ENTITY> entities) {
        repository.updateList(entities);
    }

}
