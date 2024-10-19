package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SucaiLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 图片素材留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("sucai_liuyan")
public class SucaiLiuyanView extends SucaiLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 图片素材
		/**
		* 图片素材编号
		*/

		@ColumnInfo(comment="图片素材编号",type="varchar(200)")
		private String sucaiUuidNumber;
		/**
		* 图片素材名称
		*/

		@ColumnInfo(comment="图片素材名称",type="varchar(200)")
		private String sucaiName;
		/**
		* 图片素材照片
		*/

		@ColumnInfo(comment="图片素材照片",type="varchar(200)")
		private String sucaiPhoto;
		/**
		* 图片素材
		*/

		@ColumnInfo(comment="图片素材",type="varchar(200)")
		private String sucaiFile;
		/**
		* 图片素材类型
		*/
		@ColumnInfo(comment="图片素材类型",type="int(11)")
		private Integer sucaiTypes;
			/**
			* 图片素材类型的值
			*/
			@ColumnInfo(comment="图片素材类型的字典表值",type="varchar(200)")
			private String sucaiValue;
		/**
		* 图片素材热度
		*/

		@ColumnInfo(comment="图片素材热度",type="int(11)")
		private Integer sucaiClicknum;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 图片素材介绍
		*/

		@ColumnInfo(comment="图片素材介绍",type="longtext")
		private String sucaiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer sucaiDelete;
	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public SucaiLiuyanView() {

	}

	public SucaiLiuyanView(SucaiLiuyanEntity sucaiLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, sucaiLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 图片素材

		/**
		* 获取： 图片素材编号
		*/
		public String getSucaiUuidNumber() {
			return sucaiUuidNumber;
		}
		/**
		* 设置： 图片素材编号
		*/
		public void setSucaiUuidNumber(String sucaiUuidNumber) {
			this.sucaiUuidNumber = sucaiUuidNumber;
		}

		/**
		* 获取： 图片素材名称
		*/
		public String getSucaiName() {
			return sucaiName;
		}
		/**
		* 设置： 图片素材名称
		*/
		public void setSucaiName(String sucaiName) {
			this.sucaiName = sucaiName;
		}

		/**
		* 获取： 图片素材照片
		*/
		public String getSucaiPhoto() {
			return sucaiPhoto;
		}
		/**
		* 设置： 图片素材照片
		*/
		public void setSucaiPhoto(String sucaiPhoto) {
			this.sucaiPhoto = sucaiPhoto;
		}

		/**
		* 获取： 图片素材
		*/
		public String getSucaiFile() {
			return sucaiFile;
		}
		/**
		* 设置： 图片素材
		*/
		public void setSucaiFile(String sucaiFile) {
			this.sucaiFile = sucaiFile;
		}
		/**
		* 获取： 图片素材类型
		*/
		public Integer getSucaiTypes() {
			return sucaiTypes;
		}
		/**
		* 设置： 图片素材类型
		*/
		public void setSucaiTypes(Integer sucaiTypes) {
			this.sucaiTypes = sucaiTypes;
		}


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

		/**
		* 获取： 图片素材热度
		*/
		public Integer getSucaiClicknum() {
			return sucaiClicknum;
		}
		/**
		* 设置： 图片素材热度
		*/
		public void setSucaiClicknum(Integer sucaiClicknum) {
			this.sucaiClicknum = sucaiClicknum;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 图片素材介绍
		*/
		public String getSucaiContent() {
			return sucaiContent;
		}
		/**
		* 设置： 图片素材介绍
		*/
		public void setSucaiContent(String sucaiContent) {
			this.sucaiContent = sucaiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getSucaiDelete() {
			return sucaiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setSucaiDelete(Integer sucaiDelete) {
			this.sucaiDelete = sucaiDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "SucaiLiuyanView{" +
			", sucaiUuidNumber=" + sucaiUuidNumber +
			", sucaiName=" + sucaiName +
			", sucaiPhoto=" + sucaiPhoto +
			", sucaiFile=" + sucaiFile +
			", sucaiClicknum=" + sucaiClicknum +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", sucaiContent=" + sucaiContent +
			", sucaiDelete=" + sucaiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
