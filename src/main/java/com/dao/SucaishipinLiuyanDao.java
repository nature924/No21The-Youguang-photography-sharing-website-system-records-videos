package com.dao;

import com.entity.SucaishipinLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SucaishipinLiuyanView;

/**
 * 视频素材留言 Dao 接口
 *
 * @author 
 */
public interface SucaishipinLiuyanDao extends BaseMapper<SucaishipinLiuyanEntity> {

   List<SucaishipinLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
