package com.dao;

import com.entity.SucaiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SucaiCollectionView;

/**
 * 图片素材收藏 Dao 接口
 *
 * @author 
 */
public interface SucaiCollectionDao extends BaseMapper<SucaiCollectionEntity> {

   List<SucaiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
