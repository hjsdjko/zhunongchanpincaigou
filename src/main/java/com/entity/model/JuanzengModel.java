package com.entity.model;

import com.entity.JuanzengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 捐赠项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JuanzengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 捐赠项目标题
     */
    private String juanzengName;


    /**
     * 捐赠项目封面
     */
    private String juanzengPhoto;


    /**
     * 捐赠项目类型
     */
    private Integer juanzengTypes;


    /**
     * 已捐金额
     */
    private Double juanzengNewMoney;


    /**
     * 捐赠项目介绍
     */
    private String juanzengContent;


    /**
     * 逻辑删除
     */
    private Integer juanzengDelete;


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
	 * 获取：捐赠项目标题
	 */
    public String getJuanzengName() {
        return juanzengName;
    }


    /**
	 * 设置：捐赠项目标题
	 */
    public void setJuanzengName(String juanzengName) {
        this.juanzengName = juanzengName;
    }
    /**
	 * 获取：捐赠项目封面
	 */
    public String getJuanzengPhoto() {
        return juanzengPhoto;
    }


    /**
	 * 设置：捐赠项目封面
	 */
    public void setJuanzengPhoto(String juanzengPhoto) {
        this.juanzengPhoto = juanzengPhoto;
    }
    /**
	 * 获取：捐赠项目类型
	 */
    public Integer getJuanzengTypes() {
        return juanzengTypes;
    }


    /**
	 * 设置：捐赠项目类型
	 */
    public void setJuanzengTypes(Integer juanzengTypes) {
        this.juanzengTypes = juanzengTypes;
    }
    /**
	 * 获取：已捐金额
	 */
    public Double getJuanzengNewMoney() {
        return juanzengNewMoney;
    }


    /**
	 * 设置：已捐金额
	 */
    public void setJuanzengNewMoney(Double juanzengNewMoney) {
        this.juanzengNewMoney = juanzengNewMoney;
    }
    /**
	 * 获取：捐赠项目介绍
	 */
    public String getJuanzengContent() {
        return juanzengContent;
    }


    /**
	 * 设置：捐赠项目介绍
	 */
    public void setJuanzengContent(String juanzengContent) {
        this.juanzengContent = juanzengContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJuanzengDelete() {
        return juanzengDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setJuanzengDelete(Integer juanzengDelete) {
        this.juanzengDelete = juanzengDelete;
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
