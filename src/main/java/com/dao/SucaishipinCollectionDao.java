package com.dao;

import com.entity.SucaishipinCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SucaishipinCollectionView;

/**
 * 视频素材收藏 Dao 接口
 *
 * @author 
 */
public interface SucaishipinCollectionDao extends BaseMapper<SucaishipinCollectionEntity> {

   List<SucaishipinCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
