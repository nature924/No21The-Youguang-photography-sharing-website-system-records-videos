package com.entity.vo;

import com.entity.SucaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 图片素材
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("sucai")
public class SucaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 图片素材编号
     */

    @TableField(value = "sucai_uuid_number")
    private String sucaiUuidNumber;


    /**
     * 图片素材名称
     */

    @TableField(value = "sucai_name")
    private String sucaiName;


    /**
     * 图片素材照片
     */

    @TableField(value = "sucai_photo")
    private String sucaiPhoto;


    /**
     * 图片素材
     */

    @TableField(value = "sucai_file")
    private String sucaiFile;


    /**
     * 图片素材类型
     */

    @TableField(value = "sucai_types")
    private Integer sucaiTypes;


    /**
     * 图片素材热度
     */

    @TableField(value = "sucai_clicknum")
    private Integer sucaiClicknum;


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
     * 图片素材介绍
     */

    @TableField(value = "sucai_content")
    private String sucaiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "sucai_delete")
    private Integer sucaiDelete;


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
	 * 设置：图片素材编号
	 */
    public String getSucaiUuidNumber() {
        return sucaiUuidNumber;
    }


    /**
	 * 获取：图片素材编号
	 */

    public void setSucaiUuidNumber(String sucaiUuidNumber) {
        this.sucaiUuidNumber = sucaiUuidNumber;
    }
    /**
	 * 设置：图片素材名称
	 */
    public String getSucaiName() {
        return sucaiName;
    }


    /**
	 * 获取：图片素材名称
	 */

    public void setSucaiName(String sucaiName) {
        this.sucaiName = sucaiName;
    }
    /**
	 * 设置：图片素材照片
	 */
    public String getSucaiPhoto() {
        return sucaiPhoto;
    }


    /**
	 * 获取：图片素材照片
	 */

    public void setSucaiPhoto(String sucaiPhoto) {
        this.sucaiPhoto = sucaiPhoto;
    }
    /**
	 * 设置：图片素材
	 */
    public String getSucaiFile() {
        return sucaiFile;
    }


    /**
	 * 获取：图片素材
	 */

    public void setSucaiFile(String sucaiFile) {
        this.sucaiFile = sucaiFile;
    }
    /**
	 * 设置：图片素材类型
	 */
    public Integer getSucaiTypes() {
        return sucaiTypes;
    }


    /**
	 * 获取：图片素材类型
	 */

    public void setSucaiTypes(Integer sucaiTypes) {
        this.sucaiTypes = sucaiTypes;
    }
    /**
	 * 设置：图片素材热度
	 */
    public Integer getSucaiClicknum() {
        return sucaiClicknum;
    }


    /**
	 * 获取：图片素材热度
	 */

    public void setSucaiClicknum(Integer sucaiClicknum) {
        this.sucaiClicknum = sucaiClicknum;
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
	 * 设置：图片素材介绍
	 */
    public String getSucaiContent() {
        return sucaiContent;
    }


    /**
	 * 获取：图片素材介绍
	 */

    public void setSucaiContent(String sucaiContent) {
        this.sucaiContent = sucaiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getSucaiDelete() {
        return sucaiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setSucaiDelete(Integer sucaiDelete) {
        this.sucaiDelete = sucaiDelete;
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
