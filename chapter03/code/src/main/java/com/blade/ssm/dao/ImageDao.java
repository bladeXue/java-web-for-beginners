package com.blade.ssm.dao;

import com.blade.ssm.model.Image;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ImageDao {

    // extra methods
    public int saveIgnorePK(Image image);

    public int saveIgnoreAndReturnPK(Image image);

    // basic methods of 12
    public int save(Image image);

    public int saveBatch(List list);

    public int update(Image image);

    public int updateIgnoreNull(Image image);

    public int updateBatch(List list);

    public int delete(Image image);

    public int deleteBatch(List list);

    public int deleteByPK(Long id);

    public int deleteAll();

    public long count();

    public Image findByPK(Long id);

    public List find(Map<String, Object> paramMap, PageBounds pageBounds);

}
