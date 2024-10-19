package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SucaishipinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 视频素材
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("sucaishipin")
public class SucaishipinView extends SucaishipinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 视频素材类型的值
	*/
	@ColumnInfo(comment="视频素材类型的字典表值",type="varchar(200)")
	private String sucaishipinValue;




	public SucaishipinView() {

	}

	public SucaishipinView(SucaishipinEntity sucaishipinEntity) {
		try {
			BeanUtils.copyProperties(this, sucaishipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 视频素材类型的值
	*/
	public String getSucaishipinValue() {
		return sucaishipinValue;
	}
	/**
	* 设置： 视频素材类型的值
	*/
	public void setSucaishipinValue(String sucaishipinValue) {
		this.sucaishipinValue = sucaishipinValue;
	}




	@Override
	public String toString() {
		return "SucaishipinView{" +
			", sucaishipinValue=" + sucaishipinValue +
			"} " + super.toString();
	}
}
