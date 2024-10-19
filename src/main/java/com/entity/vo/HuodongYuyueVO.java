package com.entity.vo;

import com.entity.HuodongYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 活动报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huodong_yuyue")
public class HuodongYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "huodong_yuyue_uuid_number")
    private String huodongYuyueUuidNumber;


    /**
     * 活动
     */

    @TableField(value = "huodong_id")
    private Integer huodongId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报名理由
     */

    @TableField(value = "huodong_yuyue_text")
    private String huodongYuyueText;


    /**
     * 报名状态
     */

    @TableField(value = "huodong_yuyue_yesno_types")
    private Integer huodongYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "huodong_yuyue_yesno_text")
    private String huodongYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "huodong_yuyue_shenhe_time")
    private Date huodongYuyueShenheTime;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：报名编号
	 */
    public String getHuodongYuyueUuidNumber() {
        return huodongYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setHuodongYuyueUuidNumber(String huodongYuyueUuidNumber) {
        this.huodongYuyueUuidNumber = huodongYuyueUuidNumber;
    }
    /**
	 * 设置：活动
	 */
    public Integer getHuodongId() {
        return huodongId;
    }


    /**
	 * 获取：活动
	 */

    public void setHuodongId(Integer huodongId) {
        this.huodongId = huodongId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：报名理由
	 */
    public String getHuodongYuyueText() {
        return huodongYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setHuodongYuyueText(String huodongYuyueText) {
        this.huodongYuyueText = huodongYuyueText;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getHuodongYuyueYesnoTypes() {
        return huodongYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setHuodongYuyueYesnoTypes(Integer huodongYuyueYesnoTypes) {
        this.huodongYuyueYesnoTypes = huodongYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getHuodongYuyueYesnoText() {
        return huodongYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setHuodongYuyueYesnoText(String huodongYuyueYesnoText) {
        this.huodongYuyueYesnoText = huodongYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getHuodongYuyueShenheTime() {
        return huodongYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setHuodongYuyueShenheTime(Date huodongYuyueShenheTime) {
        this.huodongYuyueShenheTime = huodongYuyueShenheTime;
    }
    /**
	 * 设置：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
