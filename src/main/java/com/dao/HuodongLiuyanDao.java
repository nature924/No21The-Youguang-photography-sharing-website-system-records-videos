package com.dao;

import com.entity.HuodongLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuodongLiuyanView;

/**
 * 活动留言 Dao 接口
 *
 * @author 
 */
public interface HuodongLiuyanDao extends BaseMapper<HuodongLiuyanEntity> {

   List<HuodongLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
