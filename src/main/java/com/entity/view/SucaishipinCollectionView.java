package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SucaishipinCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 视频素材收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("sucaishipin_collection")
public class SucaishipinCollectionView extends SucaishipinCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String sucaishipinCollectionValue;

	//级联表 视频素材
		/**
		* 视频素材编号
		*/

		@ColumnInfo(comment="视频素材编号",type="varchar(200)")
		private String sucaishipinUuidNumber;
		/**
		* 视频素材名称
		*/

		@ColumnInfo(comment="视频素材名称",type="varchar(200)")
		private String sucaishipinName;
		/**
		* 视频素材封面
		*/

		@ColumnInfo(comment="视频素材封面",type="varchar(200)")
		private String sucaishipinPhoto;
		/**
		* 视频
		*/

		@ColumnInfo(comment="视频",type="varchar(200)")
		private String sucaishipinVideo;
		/**
		* 视频素材
		*/

		@ColumnInfo(comment="视频素材",type="varchar(200)")
		private String sucaishipinFile;
		/**
		* 视频素材类型
		*/
		@ColumnInfo(comment="视频素材类型",type="int(11)")
		private Integer sucaishipinTypes;
			/**
			* 视频素材类型的值
			*/
			@ColumnInfo(comment="视频素材类型的字典表值",type="varchar(200)")
			private String sucaishipinValue;
		/**
		* 视频素材热度
		*/

		@ColumnInfo(comment="视频素材热度",type="int(11)")
		private Integer sucaishipinClicknum;
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
		* 视频素材介绍
		*/

		@ColumnInfo(comment="视频素材介绍",type="longtext")
		private String sucaishipinContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer sucaishipinDelete;
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



	public SucaishipinCollectionView() {

	}

	public SucaishipinCollectionView(SucaishipinCollectionEntity sucaishipinCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, sucaishipinCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getSucaishipinCollectionValue() {
		return sucaishipinCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setSucaishipinCollectionValue(String sucaishipinCollectionValue) {
		this.sucaishipinCollectionValue = sucaishipinCollectionValue;
	}


	//级联表的get和set 视频素材

		/**
		* 获取： 视频素材编号
		*/
		public String getSucaishipinUuidNumber() {
			return sucaishipinUuidNumber;
		}
		/**
		* 设置： 视频素材编号
		*/
		public void setSucaishipinUuidNumber(String sucaishipinUuidNumber) {
			this.sucaishipinUuidNumber = sucaishipinUuidNumber;
		}

		/**
		* 获取： 视频素材名称
		*/
		public String getSucaishipinName() {
			return sucaishipinName;
		}
		/**
		* 设置： 视频素材名称
		*/
		public void setSucaishipinName(String sucaishipinName) {
			this.sucaishipinName = sucaishipinName;
		}

		/**
		* 获取： 视频素材封面
		*/
		public String getSucaishipinPhoto() {
			return sucaishipinPhoto;
		}
		/**
		* 设置： 视频素材封面
		*/
		public void setSucaishipinPhoto(String sucaishipinPhoto) {
			this.sucaishipinPhoto = sucaishipinPhoto;
		}

		/**
		* 获取： 视频
		*/
		public String getSucaishipinVideo() {
			return sucaishipinVideo;
		}
		/**
		* 设置： 视频
		*/
		public void setSucaishipinVideo(String sucaishipinVideo) {
			this.sucaishipinVideo = sucaishipinVideo;
		}

		/**
		* 获取： 视频素材
		*/
		public String getSucaishipinFile() {
			return sucaishipinFile;
		}
		/**
		* 设置： 视频素材
		*/
		public void setSucaishipinFile(String sucaishipinFile) {
			this.sucaishipinFile = sucaishipinFile;
		}
		/**
		* 获取： 视频素材类型
		*/
		public Integer getSucaishipinTypes() {
			return sucaishipinTypes;
		}
		/**
		* 设置： 视频素材类型
		*/
		public void setSucaishipinTypes(Integer sucaishipinTypes) {
			this.sucaishipinTypes = sucaishipinTypes;
		}


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

		/**
		* 获取： 视频素材热度
		*/
		public Integer getSucaishipinClicknum() {
			return sucaishipinClicknum;
		}
		/**
		* 设置： 视频素材热度
		*/
		public void setSucaishipinClicknum(Integer sucaishipinClicknum) {
			this.sucaishipinClicknum = sucaishipinClicknum;
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
		* 获取： 视频素材介绍
		*/
		public String getSucaishipinContent() {
			return sucaishipinContent;
		}
		/**
		* 设置： 视频素材介绍
		*/
		public void setSucaishipinContent(String sucaishipinContent) {
			this.sucaishipinContent = sucaishipinContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getSucaishipinDelete() {
			return sucaishipinDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setSucaishipinDelete(Integer sucaishipinDelete) {
			this.sucaishipinDelete = sucaishipinDelete;
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
		return "SucaishipinCollectionView{" +
			", sucaishipinCollectionValue=" + sucaishipinCollectionValue +
			", sucaishipinUuidNumber=" + sucaishipinUuidNumber +
			", sucaishipinName=" + sucaishipinName +
			", sucaishipinPhoto=" + sucaishipinPhoto +
			", sucaishipinVideo=" + sucaishipinVideo +
			", sucaishipinFile=" + sucaishipinFile +
			", sucaishipinClicknum=" + sucaishipinClicknum +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", sucaishipinContent=" + sucaishipinContent +
			", sucaishipinDelete=" + sucaishipinDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
