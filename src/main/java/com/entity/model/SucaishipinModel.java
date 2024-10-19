package com.entity.model;

import com.entity.SucaishipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 视频素材
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SucaishipinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 视频素材编号
     */
    private String sucaishipinUuidNumber;


    /**
     * 视频素材名称
     */
    private String sucaishipinName;


    /**
     * 视频素材封面
     */
    private String sucaishipinPhoto;


    /**
     * 视频
     */
    private String sucaishipinVideo;


    /**
     * 视频素材
     */
    private String sucaishipinFile;


    /**
     * 视频素材类型
     */
    private Integer sucaishipinTypes;


    /**
     * 视频素材热度
     */
    private Integer sucaishipinClicknum;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 视频素材介绍
     */
    private String sucaishipinContent;


    /**
     * 逻辑删除
     */
    private Integer sucaishipinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
