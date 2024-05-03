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
 * 商品
 *
 * @author 
 * @email
 */
@TableName("nongchanpin")
public class NongchanpinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NongchanpinEntity() {

	}

	public NongchanpinEntity(T t) {
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
     * 商家
     */
    @ColumnInfo(comment="商家",type="int(11)")
    @TableField(value = "shangjia_id")

    private Integer shangjiaId;


    /**
     * 商品名称
     */
    @ColumnInfo(comment="商品名称",type="varchar(200)")
    @TableField(value = "nongchanpin_name")

    private String nongchanpinName;


    /**
     * 商品编号
     */
    @ColumnInfo(comment="商品编号",type="varchar(200)")
    @TableField(value = "nongchanpin_uuid_number")

    private String nongchanpinUuidNumber;


    /**
     * 商品照片
     */
    @ColumnInfo(comment="商品照片",type="varchar(200)")
    @TableField(value = "nongchanpin_photo")

    private String nongchanpinPhoto;


    /**
     * 商品类型
     */
    @ColumnInfo(comment="商品类型",type="int(11)")
    @TableField(value = "nongchanpin_types")

    private Integer nongchanpinTypes;


    /**
     * 商品库存
     */
    @ColumnInfo(comment="商品库存",type="int(11)")
    @TableField(value = "nongchanpin_kucun_number")

    private Integer nongchanpinKucunNumber;


    /**
     * 商品原价
     */
    @ColumnInfo(comment="商品原价",type="decimal(10,2)")
    @TableField(value = "nongchanpin_old_money")

    private Double nongchanpinOldMoney;


    /**
     * 现价
     */
    @ColumnInfo(comment="现价",type="decimal(10,2)")
    @TableField(value = "nongchanpin_new_money")

    private Double nongchanpinNewMoney;


    /**
     * 购买获得积分
     */
    @ColumnInfo(comment="购买获得积分",type="int(11)")
    @TableField(value = "nongchanpin_price")

    private Integer nongchanpinPrice;


    /**
     * 拼团限制/人
     */
    @ColumnInfo(comment="拼团限制/人",type="int(11)")
    @TableField(value = "nongchanpin_pintuan")

    private Integer nongchanpinPintuan;


    /**
     * 商品热度
     */
    @ColumnInfo(comment="商品热度",type="int(11)")
    @TableField(value = "nongchanpin_clicknum")

    private Integer nongchanpinClicknum;


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
     * 商品介绍
     */
    @ColumnInfo(comment="商品介绍",type="text")
    @TableField(value = "nongchanpin_content")

    private String nongchanpinContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "nongchanpin_delete")

    private Integer nongchanpinDelete;


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
	 * 获取：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }
    /**
	 * 设置：商家
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 获取：商品名称
	 */
    public String getNongchanpinName() {
        return nongchanpinName;
    }
    /**
	 * 设置：商品名称
	 */

    public void setNongchanpinName(String nongchanpinName) {
        this.nongchanpinName = nongchanpinName;
    }
    /**
	 * 获取：商品编号
	 */
    public String getNongchanpinUuidNumber() {
        return nongchanpinUuidNumber;
    }
    /**
	 * 设置：商品编号
	 */

    public void setNongchanpinUuidNumber(String nongchanpinUuidNumber) {
        this.nongchanpinUuidNumber = nongchanpinUuidNumber;
    }
    /**
	 * 获取：商品照片
	 */
    public String getNongchanpinPhoto() {
        return nongchanpinPhoto;
    }
    /**
	 * 设置：商品照片
	 */

    public void setNongchanpinPhoto(String nongchanpinPhoto) {
        this.nongchanpinPhoto = nongchanpinPhoto;
    }
    /**
	 * 获取：商品类型
	 */
    public Integer getNongchanpinTypes() {
        return nongchanpinTypes;
    }
    /**
	 * 设置：商品类型
	 */

    public void setNongchanpinTypes(Integer nongchanpinTypes) {
        this.nongchanpinTypes = nongchanpinTypes;
    }
    /**
	 * 获取：商品库存
	 */
    public Integer getNongchanpinKucunNumber() {
        return nongchanpinKucunNumber;
    }
    /**
	 * 设置：商品库存
	 */

    public void setNongchanpinKucunNumber(Integer nongchanpinKucunNumber) {
        this.nongchanpinKucunNumber = nongchanpinKucunNumber;
    }
    /**
	 * 获取：商品原价
	 */
    public Double getNongchanpinOldMoney() {
        return nongchanpinOldMoney;
    }
    /**
	 * 设置：商品原价
	 */

    public void setNongchanpinOldMoney(Double nongchanpinOldMoney) {
        this.nongchanpinOldMoney = nongchanpinOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getNongchanpinNewMoney() {
        return nongchanpinNewMoney;
    }
    /**
	 * 设置：现价
	 */

    public void setNongchanpinNewMoney(Double nongchanpinNewMoney) {
        this.nongchanpinNewMoney = nongchanpinNewMoney;
    }
    /**
	 * 获取：购买获得积分
	 */
    public Integer getNongchanpinPrice() {
        return nongchanpinPrice;
    }
    /**
	 * 设置：购买获得积分
	 */

    public void setNongchanpinPrice(Integer nongchanpinPrice) {
        this.nongchanpinPrice = nongchanpinPrice;
    }
    /**
	 * 获取：拼团限制/人
	 */
    public Integer getNongchanpinPintuan() {
        return nongchanpinPintuan;
    }
    /**
	 * 设置：拼团限制/人
	 */

    public void setNongchanpinPintuan(Integer nongchanpinPintuan) {
        this.nongchanpinPintuan = nongchanpinPintuan;
    }
    /**
	 * 获取：商品热度
	 */
    public Integer getNongchanpinClicknum() {
        return nongchanpinClicknum;
    }
    /**
	 * 设置：商品热度
	 */

    public void setNongchanpinClicknum(Integer nongchanpinClicknum) {
        this.nongchanpinClicknum = nongchanpinClicknum;
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
	 * 获取：商品介绍
	 */
    public String getNongchanpinContent() {
        return nongchanpinContent;
    }
    /**
	 * 设置：商品介绍
	 */

    public void setNongchanpinContent(String nongchanpinContent) {
        this.nongchanpinContent = nongchanpinContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getNongchanpinDelete() {
        return nongchanpinDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setNongchanpinDelete(Integer nongchanpinDelete) {
        this.nongchanpinDelete = nongchanpinDelete;
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
        return "Nongchanpin{" +
            ", id=" + id +
            ", shangjiaId=" + shangjiaId +
            ", nongchanpinName=" + nongchanpinName +
            ", nongchanpinUuidNumber=" + nongchanpinUuidNumber +
            ", nongchanpinPhoto=" + nongchanpinPhoto +
            ", nongchanpinTypes=" + nongchanpinTypes +
            ", nongchanpinKucunNumber=" + nongchanpinKucunNumber +
            ", nongchanpinOldMoney=" + nongchanpinOldMoney +
            ", nongchanpinNewMoney=" + nongchanpinNewMoney +
            ", nongchanpinPrice=" + nongchanpinPrice +
            ", nongchanpinPintuan=" + nongchanpinPintuan +
            ", nongchanpinClicknum=" + nongchanpinClicknum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", nongchanpinContent=" + nongchanpinContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", nongchanpinDelete=" + nongchanpinDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
