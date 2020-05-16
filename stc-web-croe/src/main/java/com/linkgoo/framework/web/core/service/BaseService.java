package com.linkgoo.framework.web.core.service;



import com.linkgoo.framework.web.core.Repository.SearchCriteria;
import com.linkgoo.framework.web.core.interceptor.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<ID extends Serializable,ENTITY> {

    /**
     * 通过id获取对象
     * @param id
     * @return
     */
    ENTITY get(ID id);
    /**
     * 通过类查询对象
     * @param entity
     * @return
     */
    ENTITY get(ENTITY entity);

    /**
     * 通过类查询对象
     * @param field,value
     * @return
     */
    ENTITY getByField(String field,Object value);

    /**
     * 保存对象
     * @param entity
     * @return
     */
    ENTITY save(ENTITY entity);
    /**
     * 保存集合
     * @param entities
     * @return
     */
    Iterable<ENTITY> saveList(Iterable<ENTITY> entities);

    /**
     * 分批保存
     * @param entities
     * @return
     */
    Iterable<ENTITY> saveList(Iterable<ENTITY> entities,Integer rowCount);

    /**
     * 判断id所属对象是否存在
     * @param id
     * @return
     */
     boolean existsById(ID id);
    /**
     * 查询所有对象
     * @return
     */
    List<ENTITY> findAll();
    /**
     * 返回id数组的类
     * @param ids
     * @return
     */
     List<ENTITY> findByIds(List<ID> ids);
    /**
     * 批量删除
     * @param ids
     * @return
     */
     int remove(List<ID> ids);
    /**
     * 全部删除
     * @return
     */
    int removeAll();
    /**
     *
     * 删除id的对象
     * @param id
     * @return
     */
     int remove(ID id);
    /**
     * 删除实体
     * @param entities
     * @return
     */
    <S extends ENTITY> int remove(S entities);

    /**
     * 统计数量
     * @return
     */
    int count();
    /**
     * 分页查询
     * @param parameter
     * @return
     */
    Page<ENTITY> page(List<SearchCriteria> parameter);
    /**
     * 分页查询
     * @param parameter
     * @return
     */
    <S extends ENTITY> Page<ENTITY> page(S parameter);
    /**
     * 分页查询
     * @param parameter
     * @return
     */
    Page<ENTITY> page(Map<String, Object> parameter);

    /**
     * 动态查询不分页
     * @param parameter
     * @return
     */
    List<ENTITY> find(List<SearchCriteria> parameter);
    /**
     * 不分页动态条件查询
     * @param parameter
     * @return
     */
    List<ENTITY> find(Map<String, Object> parameter);
    /**
     * 不分页查询
     * @param parameter
     * @return
     */
    <S extends ENTITY> List<ENTITY> find(S parameter);
    /**
     * 通过类属性查询
     * @param field
     * @param value
     * @return
     */
    List<ENTITY> findByField(String field, Object value);
    /**
     * 统计查询条件的数量
     * @param parameter
     * @return
     */
    <S extends ENTITY> int count(S parameter);

    <S extends ENTITY> int countMap(Map<String, List<?>> map, S parameter);

    <S extends ENTITY> int countMap(Map<String, List<?>> map);
    /**
     * 更新实体
     * @param entity
     * @return
     */
    int update(ENTITY entity);
    int updateAllProperties(ENTITY entity, ID id, boolean allwoNull);
    int updateAllProperties(ENTITY entity);

    void updateList(Iterable<ENTITY> entities);

    /**
     * 更新实体
     * @param oldEntity 实体旧的状态
     * @param newEntity 实体新的状态
     * @return
     */
    int update(ENTITY oldEntity, ENTITY newEntity);

    /**
     * 充正交易
     * @param json
     * @param optype
     * @param map
     */
    void rollback(String json, String optype, Map<String, String> map);




    /**
     * 导出必须重写
     * @param param
     * @return
     */
    List<Map<String, Object>> exportData(Map<String, Object> param);







}
