package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 图片素材
 *
 * @author 
 * @email
 */
@TableName("sucai")
public class SucaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SucaiEntity() {

	}

	public SucaiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 图片素材编号
     */
    @ColumnInfo(comment="图片素材编号",type="varchar(200)")
    @TableField(value = "sucai_uuid_number")

    private String sucaiUuidNumber;


    /**
     * 图片素材名称
     */
    @ColumnInfo(comment="图片素材名称",type="varchar(200)")
    @TableField(value = "sucai_name")

    private String sucaiName;


    /**
     * 图片素材照片
     */
    @ColumnInfo(comment="图片素材照片",type="varchar(200)")
    @TableField(value = "sucai_photo")

    private String sucaiPhoto;


    /**
     * 图片素材
     */
    @ColumnInfo(comment="图片素材",type="varchar(200)")
    @TableField(value = "sucai_file")

    private String sucaiFile;


    /**
     * 图片素材类型
     */
    @ColumnInfo(comment="图片素材类型",type="int(11)")
    @TableField(value = "sucai_types")

    private Integer sucaiTypes;


    /**
     * 图片素材热度
     */
    @ColumnInfo(comment="图片素材热度",type="int(11)")
    @TableField(value = "sucai_clicknum")

    private Integer sucaiClicknum;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 图片素材介绍
     */
    @ColumnInfo(comment="图片素材介绍",type="longtext")
    @TableField(value = "sucai_content")

    private String sucaiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "sucai_delete")

    private Integer sucaiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：图片素材编号
	 */
    public String getSucaiUuidNumber() {
        return sucaiUuidNumber;
    }
    /**
	 * 设置：图片素材编号
	 */

    public void setSucaiUuidNumber(String sucaiUuidNumber) {
        this.sucaiUuidNumber = sucaiUuidNumber;
    }
    /**
	 * 获取：图片素材名称
	 */
    public String getSucaiName() {
        return sucaiName;
    }
    /**
	 * 设置：图片素材名称
	 */

    public void setSucaiName(String sucaiName) {
        this.sucaiName = sucaiName;
    }
    /**
	 * 获取：图片素材照片
	 */
    public String getSucaiPhoto() {
        return sucaiPhoto;
    }
    /**
	 * 设置：图片素材照片
	 */

    public void setSucaiPhoto(String sucaiPhoto) {
        this.sucaiPhoto = sucaiPhoto;
    }
    /**
	 * 获取：图片素材
	 */
    public String getSucaiFile() {
        return sucaiFile;
    }
    /**
	 * 设置：图片素材
	 */

    public void setSucaiFile(String sucaiFile) {
        this.sucaiFile = sucaiFile;
    }
    /**
	 * 获取：图片素材类型
	 */
    public Integer getSucaiTypes() {
        return sucaiTypes;
    }
    /**
	 * 设置：图片素材类型
	 */

    public void setSucaiTypes(Integer sucaiTypes) {
        this.sucaiTypes = sucaiTypes;
    }
    /**
	 * 获取：图片素材热度
	 */
    public Integer getSucaiClicknum() {
        return sucaiClicknum;
    }
    /**
	 * 设置：图片素材热度
	 */

    public void setSucaiClicknum(Integer sucaiClicknum) {
        this.sucaiClicknum = sucaiClicknum;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：图片素材介绍
	 */
    public String getSucaiContent() {
        return sucaiContent;
    }
    /**
	 * 设置：图片素材介绍
	 */

    public void setSucaiContent(String sucaiContent) {
        this.sucaiContent = sucaiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getSucaiDelete() {
        return sucaiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setSucaiDelete(Integer sucaiDelete) {
        this.sucaiDelete = sucaiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Sucai{" +
            ", id=" + id +
            ", sucaiUuidNumber=" + sucaiUuidNumber +
            ", sucaiName=" + sucaiName +
            ", sucaiPhoto=" + sucaiPhoto +
            ", sucaiFile=" + sucaiFile +
            ", sucaiTypes=" + sucaiTypes +
            ", sucaiClicknum=" + sucaiClicknum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", sucaiContent=" + sucaiContent +
            ", sucaiDelete=" + sucaiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
