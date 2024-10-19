package com.dao;

import com.entity.HuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuodongView;

/**
 * 活动 Dao 接口
 *
 * @author 
 */
public interface HuodongDao extends BaseMapper<HuodongEntity> {

   List<HuodongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
