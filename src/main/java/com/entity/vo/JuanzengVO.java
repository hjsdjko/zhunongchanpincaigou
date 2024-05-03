package com.entity.vo;

import com.entity.JuanzengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 捐赠项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("juanzeng")
public class JuanzengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 捐赠项目标题
     */

    @TableField(value = "juanzeng_name")
    private String juanzengName;


    /**
     * 捐赠项目封面
     */

    @TableField(value = "juanzeng_photo")
    private String juanzengPhoto;


    /**
     * 捐赠项目类型
     */

    @TableField(value = "juanzeng_types")
    private Integer juanzengTypes;


    /**
     * 已捐金额
     */

    @TableField(value = "juanzeng_new_money")
    private Double juanzengNewMoney;


    /**
     * 捐赠项目介绍
     */

    @TableField(value = "juanzeng_content")
    private String juanzengContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "juanzeng_delete")
    private Integer juanzengDelete;


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
	 * 设置：捐赠项目标题
	 */
    public String getJuanzengName() {
        return juanzengName;
    }


    /**
	 * 获取：捐赠项目标题
	 */

    public void setJuanzengName(String juanzengName) {
        this.juanzengName = juanzengName;
    }
    /**
	 * 设置：捐赠项目封面
	 */
    public String getJuanzengPhoto() {
        return juanzengPhoto;
    }


    /**
	 * 获取：捐赠项目封面
	 */

    public void setJuanzengPhoto(String juanzengPhoto) {
        this.juanzengPhoto = juanzengPhoto;
    }
    /**
	 * 设置：捐赠项目类型
	 */
    public Integer getJuanzengTypes() {
        return juanzengTypes;
    }


    /**
	 * 获取：捐赠项目类型
	 */

    public void setJuanzengTypes(Integer juanzengTypes) {
        this.juanzengTypes = juanzengTypes;
    }
    /**
	 * 设置：已捐金额
	 */
    public Double getJuanzengNewMoney() {
        return juanzengNewMoney;
    }


    /**
	 * 获取：已捐金额
	 */

    public void setJuanzengNewMoney(Double juanzengNewMoney) {
        this.juanzengNewMoney = juanzengNewMoney;
    }
    /**
	 * 设置：捐赠项目介绍
	 */
    public String getJuanzengContent() {
        return juanzengContent;
    }


    /**
	 * 获取：捐赠项目介绍
	 */

    public void setJuanzengContent(String juanzengContent) {
        this.juanzengContent = juanzengContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJuanzengDelete() {
        return juanzengDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJuanzengDelete(Integer juanzengDelete) {
        this.juanzengDelete = juanzengDelete;
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
