package com.blade.ssm.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.HashMap;
import java.util.List;

public interface BaseDao<T> {
    // 插入数据
    public int save(T t);
    public int saveBatch(List list);

    // 更新数据
    public int update(T t);
    public int updateIgnoreNull(T t);
    public int updateBatch(List list);

    // 删除数据
    public int delete(T t);
    public int deleteBatch(List list);
    public int deleteByPK(Long id);
    public int deleteAll();

    // 查询数据
    public long count();
    public T findByPK(Long id);
    public List find(HashMap<String, Object> paramMap, PageBounds pageBounds);
}
