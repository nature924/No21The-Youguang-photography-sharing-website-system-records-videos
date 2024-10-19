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
 * 视频素材
 *
 * @author 
 * @email
 */
@TableName("sucaishipin")
public class SucaishipinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SucaishipinEntity() {

	}

	public SucaishipinEntity(T t) {
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
     * 视频素材编号
     */
    @ColumnInfo(comment="视频素材编号",type="varchar(200)")
    @TableField(value = "sucaishipin_uuid_number")

    private String sucaishipinUuidNumber;


    /**
     * 视频素材名称
     */
    @ColumnInfo(comment="视频素材名称",type="varchar(200)")
    @TableField(value = "sucaishipin_name")

    private String sucaishipinName;


    /**
     * 视频素材封面
     */
    @ColumnInfo(comment="视频素材封面",type="varchar(200)")
    @TableField(value = "sucaishipin_photo")

    private String sucaishipinPhoto;


    /**
     * 视频
     */
    @ColumnInfo(comment="视频",type="varchar(200)")
    @TableField(value = "sucaishipin_video")

    private String sucaishipinVideo;


    /**
     * 视频素材
     */
    @ColumnInfo(comment="视频素材",type="varchar(200)")
    @TableField(value = "sucaishipin_file")

    private String sucaishipinFile;


    /**
     * 视频素材类型
     */
    @ColumnInfo(comment="视频素材类型",type="int(11)")
    @TableField(value = "sucaishipin_types")

    private Integer sucaishipinTypes;


    /**
     * 视频素材热度
     */
    @ColumnInfo(comment="视频素材热度",type="int(11)")
    @TableField(value = "sucaishipin_clicknum")

    private Integer sucaishipinClicknum;


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
     * 视频素材介绍
     */
    @ColumnInfo(comment="视频素材介绍",type="longtext")
    @TableField(value = "sucaishipin_content")

    private String sucaishipinContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "sucaishipin_delete")

    private Integer sucaishipinDelete;


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
	 * 获取：视频素材编号
	 */
    public String getSucaishipinUuidNumber() {
        return sucaishipinUuidNumber;
    }
    /**
	 * 设置：视频素材编号
	 */

    public void setSucaishipinUuidNumber(String sucaishipinUuidNumber) {
        this.sucaishipinUuidNumber = sucaishipinUuidNumber;
    }
    /**
	 * 获取：视频素材名称
	 */
    public String getSucaishipinName() {
        return sucaishipinName;
    }
    /**
	 * 设置：视频素材名称
	 */

    public void setSucaishipinName(String sucaishipinName) {
        this.sucaishipinName = sucaishipinName;
    }
    /**
	 * 获取：视频素材封面
	 */
    public String getSucaishipinPhoto() {
        return sucaishipinPhoto;
    }
    /**
	 * 设置：视频素材封面
	 */

    public void setSucaishipinPhoto(String sucaishipinPhoto) {
        this.sucaishipinPhoto = sucaishipinPhoto;
    }
    /**
	 * 获取：视频
	 */
    public String getSucaishipinVideo() {
        return sucaishipinVideo;
    }
    /**
	 * 设置：视频
	 */

    public void setSucaishipinVideo(String sucaishipinVideo) {
        this.sucaishipinVideo = sucaishipinVideo;
    }
    /**
	 * 获取：视频素材
	 */
    public String getSucaishipinFile() {
        return sucaishipinFile;
    }
    /**
	 * 设置：视频素材
	 */

    public void setSucaishipinFile(String sucaishipinFile) {
        this.sucaishipinFile = sucaishipinFile;
    }
    /**
	 * 获取：视频素材类型
	 */
    public Integer getSucaishipinTypes() {
        return sucaishipinTypes;
    }
    /**
	 * 设置：视频素材类型
	 */

    public void setSucaishipinTypes(Integer sucaishipinTypes) {
        this.sucaishipinTypes = sucaishipinTypes;
    }
    /**
	 * 获取：视频素材热度
	 */
    public Integer getSucaishipinClicknum() {
        return sucaishipinClicknum;
    }
    /**
	 * 设置：视频素材热度
	 */

    public void setSucaishipinClicknum(Integer sucaishipinClicknum) {
        this.sucaishipinClicknum = sucaishipinClicknum;
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
	 * 获取：视频素材介绍
	 */
    public String getSucaishipinContent() {
        return sucaishipinContent;
    }
    /**
	 * 设置：视频素材介绍
	 */

    public void setSucaishipinContent(String sucaishipinContent) {
        this.sucaishipinContent = sucaishipinContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getSucaishipinDelete() {
        return sucaishipinDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setSucaishipinDelete(Integer sucaishipinDelete) {
        this.sucaishipinDelete = sucaishipinDelete;
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
        return "Sucaishipin{" +
            ", id=" + id +
            ", sucaishipinUuidNumber=" + sucaishipinUuidNumber +
            ", sucaishipinName=" + sucaishipinName +
            ", sucaishipinPhoto=" + sucaishipinPhoto +
            ", sucaishipinVideo=" + sucaishipinVideo +
            ", sucaishipinFile=" + sucaishipinFile +
            ", sucaishipinTypes=" + sucaishipinTypes +
            ", sucaishipinClicknum=" + sucaishipinClicknum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", sucaishipinContent=" + sucaishipinContent +
            ", sucaishipinDelete=" + sucaishipinDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
