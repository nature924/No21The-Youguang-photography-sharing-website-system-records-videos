package com.dao;

import com.entity.SucaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SucaiView;

/**
 * 图片素材 Dao 接口
 *
 * @author 
 */
public interface SucaiDao extends BaseMapper<SucaiEntity> {

   List<SucaiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
