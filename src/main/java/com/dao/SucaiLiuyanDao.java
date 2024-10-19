package com.dao;

import com.entity.SucaiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SucaiLiuyanView;

/**
 * 图片素材留言 Dao 接口
 *
 * @author 
 */
public interface SucaiLiuyanDao extends BaseMapper<SucaiLiuyanEntity> {

   List<SucaiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
