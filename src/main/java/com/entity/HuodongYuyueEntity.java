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
 * 活动报名
 *
 * @author 
 * @email
 */
@TableName("huodong_yuyue")
public class HuodongYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuodongYuyueEntity() {

	}

	public HuodongYuyueEntity(T t) {
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
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "huodong_yuyue_uuid_number")

    private String huodongYuyueUuidNumber;


    /**
     * 活动
     */
    @ColumnInfo(comment="活动",type="int(11)")
    @TableField(value = "huodong_id")

    private Integer huodongId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "huodong_yuyue_text")

    private String huodongYuyueText;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "huodong_yuyue_yesno_types")

    private Integer huodongYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "huodong_yuyue_yesno_text")

    private String huodongYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "huodong_yuyue_shenhe_time")

    private Date huodongYuyueShenheTime;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：报名编号
	 */
    public String getHuodongYuyueUuidNumber() {
        return huodongYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setHuodongYuyueUuidNumber(String huodongYuyueUuidNumber) {
        this.huodongYuyueUuidNumber = huodongYuyueUuidNumber;
    }
    /**
	 * 获取：活动
	 */
    public Integer getHuodongId() {
        return huodongId;
    }
    /**
	 * 设置：活动
	 */

    public void setHuodongId(Integer huodongId) {
        this.huodongId = huodongId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：报名理由
	 */
    public String getHuodongYuyueText() {
        return huodongYuyueText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setHuodongYuyueText(String huodongYuyueText) {
        this.huodongYuyueText = huodongYuyueText;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getHuodongYuyueYesnoTypes() {
        return huodongYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setHuodongYuyueYesnoTypes(Integer huodongYuyueYesnoTypes) {
        this.huodongYuyueYesnoTypes = huodongYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getHuodongYuyueYesnoText() {
        return huodongYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setHuodongYuyueYesnoText(String huodongYuyueYesnoText) {
        this.huodongYuyueYesnoText = huodongYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getHuodongYuyueShenheTime() {
        return huodongYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setHuodongYuyueShenheTime(Date huodongYuyueShenheTime) {
        this.huodongYuyueShenheTime = huodongYuyueShenheTime;
    }
    /**
	 * 获取：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "HuodongYuyue{" +
            ", id=" + id +
            ", huodongYuyueUuidNumber=" + huodongYuyueUuidNumber +
            ", huodongId=" + huodongId +
            ", yonghuId=" + yonghuId +
            ", huodongYuyueText=" + huodongYuyueText +
            ", huodongYuyueYesnoTypes=" + huodongYuyueYesnoTypes +
            ", huodongYuyueYesnoText=" + huodongYuyueYesnoText +
            ", huodongYuyueShenheTime=" + DateUtil.convertString(huodongYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
