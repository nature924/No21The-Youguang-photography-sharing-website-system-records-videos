package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SucaiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 图片素材
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("sucai")
public class SucaiView extends SucaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 图片素材类型的值
	*/
	@ColumnInfo(comment="图片素材类型的字典表值",type="varchar(200)")
	private String sucaiValue;




	public SucaiView() {

	}

	public SucaiView(SucaiEntity sucaiEntity) {
		try {
			BeanUtils.copyProperties(this, sucaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 图片素材类型的值
	*/
	public String getSucaiValue() {
		return sucaiValue;
	}
	/**
	* 设置： 图片素材类型的值
	*/
	public void setSucaiValue(String sucaiValue) {
		this.sucaiValue = sucaiValue;
	}




	@Override
	public String toString() {
		return "SucaiView{" +
			", sucaiValue=" + sucaiValue +
			"} " + super.toString();
	}
}
