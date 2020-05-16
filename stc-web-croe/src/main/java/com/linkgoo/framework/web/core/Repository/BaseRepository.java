package com.linkgoo.framework.web.core.Repository;

import com.linkgoo.framework.web.core.interceptor.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * BaseRepository class
 *
 * @description: 基础的dao层 定义基本的增删改查功能
 *
 * @author qixiao.bi
 * @date 2020-01-07  16:23
 */
public interface BaseRepository<T> {

	void save(T entity);

	void saveList(@Param("list") Iterable<T> entities);

	/**
	 * 更新实体
	 *
	 * @return
	 */
	int update(T entity);

	/**
	 * 更新实体，包括所有参数
	 *
	 * @return
	 */
    int updateAll(T entity);

	/**
	 * 更新实体集合
	 *
	 * @return
	 */
	int updateList(Iterable<T> entities);

	/**
	 * 更新实体集合，包括所有参数
	 *
	 * @return
	 */
	int updateAllList(Iterable<T> entities);

	/**
	 * 以oldEntity作为条件修改
	 *
	 * @return
	 */
	int modify(@Param("old") T oldEntity, @Param("myNew") T newEntity);

	<S extends T> int remove(S entity);

	/**
	 * 删除所有实体
	 *
	 * @return
	 */
	int removeAll();

	/**
	 * 传入主键删除实体
	 *
	 * @param id
	 * @return
	 */
	int deleteById(Object id);

	/**
	 * 传入主键数组删除实体
	 *
	 * @param ids
	 * @return
	 */
	int deleteByIds(@Param("ids") List<?> ids);

	/**
	 * 传入主键查询实体
	 *
	 * @param id
	 * @return
	 */
	T getById(Object id);

	/**
	 * 传人实体查询实体
	 *
	 * @param entity
	 * @return
	 */
	<S extends T> T getOne(S entity);

	<S extends T> int count(S parameter);
	/**
	 * 计算实体的总数
	 *
	 * @return
	 */
	int countAll();

	boolean existsById(Object id);

	List<T> findAll();

	<S extends T> List<T> find(S parameter);

	List<T> findByMap(@Param("map") Map<String, Object> parameter);

	List<T> findByIds(@Param("ids") List<?> ids);

	List<T> findByCriteria(@Param("list") List<SearchCriteria> parameter);

	<S extends T> Page<T> page(S parameter);

	Page<T> pageByMap(@Param("map") Map<String, Object> parameter);

	Page<T> pageByCriteria(@Param("list") List<SearchCriteria> parameter);

    <S extends T> int countMap(@Param("entity") S parameter, @Param("map") Map<String, List<?>> map);

}
