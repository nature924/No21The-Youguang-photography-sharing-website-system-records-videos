package com.entity.model;

import com.entity.HuodongYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 活动报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuodongYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String huodongYuyueUuidNumber;


    /**
     * 活动
     */
    private Integer huodongId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 报名理由
     */
    private String huodongYuyueText;


    /**
     * 报名状态
     */
    private Integer huodongYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String huodongYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huodongYuyueShenheTime;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
