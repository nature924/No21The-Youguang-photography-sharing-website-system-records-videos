package com.dao;

import com.entity.HuodongCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuodongCollectionView;

/**
 * 活动收藏 Dao 接口
 *
 * @author 
 */
public interface HuodongCollectionDao extends BaseMapper<HuodongCollectionEntity> {

   List<HuodongCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
