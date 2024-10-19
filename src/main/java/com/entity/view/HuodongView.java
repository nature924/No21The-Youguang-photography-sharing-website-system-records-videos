package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.HuodongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 活动
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("huodong")
public class HuodongView extends HuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 活动类型的值
	*/
	@ColumnInfo(comment="活动类型的字典表值",type="varchar(200)")
	private String huodongValue;




	public HuodongView() {

	}

	public HuodongView(HuodongEntity huodongEntity) {
		try {
			BeanUtils.copyProperties(this, huodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 活动类型的值
	*/
	public String getHuodongValue() {
		return huodongValue;
	}
	/**
	* 设置： 活动类型的值
	*/
	public void setHuodongValue(String huodongValue) {
		this.huodongValue = huodongValue;
	}




	@Override
	public String toString() {
		return "HuodongView{" +
			", huodongValue=" + huodongValue +
			"} " + super.toString();
	}
}
