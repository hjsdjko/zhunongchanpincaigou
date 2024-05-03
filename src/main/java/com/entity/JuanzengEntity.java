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
 * 捐赠项目
 *
 * @author 
 * @email
 */
@TableName("juanzeng")
public class JuanzengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JuanzengEntity() {

	}

	public JuanzengEntity(T t) {
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
     * 捐赠项目标题
     */
    @ColumnInfo(comment="捐赠项目标题",type="varchar(200)")
    @TableField(value = "juanzeng_name")

    private String juanzengName;


    /**
     * 捐赠项目封面
     */
    @ColumnInfo(comment="捐赠项目封面",type="varchar(200)")
    @TableField(value = "juanzeng_photo")

    private String juanzengPhoto;


    /**
     * 捐赠项目类型
     */
    @ColumnInfo(comment="捐赠项目类型",type="int(11)")
    @TableField(value = "juanzeng_types")

    private Integer juanzengTypes;


    /**
     * 已捐金额
     */
    @ColumnInfo(comment="已捐金额",type="decimal(10,2)")
    @TableField(value = "juanzeng_new_money")

    private Double juanzengNewMoney;


    /**
     * 捐赠项目介绍
     */
    @ColumnInfo(comment="捐赠项目介绍",type="text")
    @TableField(value = "juanzeng_content")

    private String juanzengContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "juanzeng_delete")

    private Integer juanzengDelete;


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
        return "Juanzeng{" +
            ", id=" + id +
            ", juanzengName=" + juanzengName +
            ", juanzengPhoto=" + juanzengPhoto +
            ", juanzengTypes=" + juanzengTypes +
            ", juanzengNewMoney=" + juanzengNewMoney +
            ", juanzengContent=" + juanzengContent +
            ", juanzengDelete=" + juanzengDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
