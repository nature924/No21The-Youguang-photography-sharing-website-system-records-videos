package com.dao;

import com.entity.SucaishipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SucaishipinView;

/**
 * 视频素材 Dao 接口
 *
 * @author 
 */
public interface SucaishipinDao extends BaseMapper<SucaishipinEntity> {

   List<SucaishipinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
