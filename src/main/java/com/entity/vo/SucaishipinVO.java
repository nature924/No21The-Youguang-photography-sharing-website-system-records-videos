package com.entity.vo;

import com.entity.SucaishipinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 视频素材
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("sucaishipin")
public class SucaishipinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 视频素材编号
     */

    @TableField(value = "sucaishipin_uuid_number")
    private String sucaishipinUuidNumber;


    /**
     * 视频素材名称
     */

    @TableField(value = "sucaishipin_name")
    private String sucaishipinName;


    /**
     * 视频素材封面
     */

    @TableField(value = "sucaishipin_photo")
    private String sucaishipinPhoto;


    /**
     * 视频
     */

    @TableField(value = "sucaishipin_video")
    private String sucaishipinVideo;


    /**
     * 视频素材
     */

    @TableField(value = "sucaishipin_file")
    private String sucaishipinFile;


    /**
     * 视频素材类型
     */

    @TableField(value = "sucaishipin_types")
    private Integer sucaishipinTypes;


    /**
     * 视频素材热度
     */

    @TableField(value = "sucaishipin_clicknum")
    private Integer sucaishipinClicknum;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 视频素材介绍
     */

    @TableField(value = "sucaishipin_content")
    private String sucaishipinContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "sucaishipin_delete")
    private Integer sucaishipinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：视频素材编号
	 */
    public String getSucaishipinUuidNumber() {
        return sucaishipinUuidNumber;
    }


    /**
	 * 获取：视频素材编号
	 */

    public void setSucaishipinUuidNumber(String sucaishipinUuidNumber) {
        this.sucaishipinUuidNumber = sucaishipinUuidNumber;
    }
    /**
	 * 设置：视频素材名称
	 */
    public String getSucaishipinName() {
        return sucaishipinName;
    }


    /**
	 * 获取：视频素材名称
	 */

    public void setSucaishipinName(String sucaishipinName) {
        this.sucaishipinName = sucaishipinName;
    }
    /**
	 * 设置：视频素材封面
	 */
    public String getSucaishipinPhoto() {
        return sucaishipinPhoto;
    }


    /**
	 * 获取：视频素材封面
	 */

    public void setSucaishipinPhoto(String sucaishipinPhoto) {
        this.sucaishipinPhoto = sucaishipinPhoto;
    }
    /**
	 * 设置：视频
	 */
    public String getSucaishipinVideo() {
        return sucaishipinVideo;
    }


    /**
	 * 获取：视频
	 */

    public void setSucaishipinVideo(String sucaishipinVideo) {
        this.sucaishipinVideo = sucaishipinVideo;
    }
    /**
	 * 设置：视频素材
	 */
    public String getSucaishipinFile() {
        return sucaishipinFile;
    }


    /**
	 * 获取：视频素材
	 */

    public void setSucaishipinFile(String sucaishipinFile) {
        this.sucaishipinFile = sucaishipinFile;
    }
    /**
	 * 设置：视频素材类型
	 */
    public Integer getSucaishipinTypes() {
        return sucaishipinTypes;
    }


    /**
	 * 获取：视频素材类型
	 */

    public void setSucaishipinTypes(Integer sucaishipinTypes) {
        this.sucaishipinTypes = sucaishipinTypes;
    }
    /**
	 * 设置：视频素材热度
	 */
    public Integer getSucaishipinClicknum() {
        return sucaishipinClicknum;
    }


    /**
	 * 获取：视频素材热度
	 */

    public void setSucaishipinClicknum(Integer sucaishipinClicknum) {
        this.sucaishipinClicknum = sucaishipinClicknum;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：视频素材介绍
	 */
    public String getSucaishipinContent() {
        return sucaishipinContent;
    }


    /**
	 * 获取：视频素材介绍
	 */

    public void setSucaishipinContent(String sucaishipinContent) {
        this.sucaishipinContent = sucaishipinContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getSucaishipinDelete() {
        return sucaishipinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setSucaishipinDelete(Integer sucaishipinDelete) {
        this.sucaishipinDelete = sucaishipinDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
