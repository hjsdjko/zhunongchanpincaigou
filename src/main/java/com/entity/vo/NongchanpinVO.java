package com.entity.vo;

import com.entity.NongchanpinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("nongchanpin")
public class NongchanpinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商家
     */

    @TableField(value = "shangjia_id")
    private Integer shangjiaId;


    /**
     * 商品名称
     */

    @TableField(value = "nongchanpin_name")
    private String nongchanpinName;


    /**
     * 商品编号
     */

    @TableField(value = "nongchanpin_uuid_number")
    private String nongchanpinUuidNumber;


    /**
     * 商品照片
     */

    @TableField(value = "nongchanpin_photo")
    private String nongchanpinPhoto;


    /**
     * 商品类型
     */

    @TableField(value = "nongchanpin_types")
    private Integer nongchanpinTypes;


    /**
     * 商品库存
     */

    @TableField(value = "nongchanpin_kucun_number")
    private Integer nongchanpinKucunNumber;


    /**
     * 商品原价
     */

    @TableField(value = "nongchanpin_old_money")
    private Double nongchanpinOldMoney;


    /**
     * 现价
     */

    @TableField(value = "nongchanpin_new_money")
    private Double nongchanpinNewMoney;


    /**
     * 购买获得积分
     */

    @TableField(value = "nongchanpin_price")
    private Integer nongchanpinPrice;


    /**
     * 拼团限制/人
     */

    @TableField(value = "nongchanpin_pintuan")
    private Integer nongchanpinPintuan;


    /**
     * 商品热度
     */

    @TableField(value = "nongchanpin_clicknum")
    private Integer nongchanpinClicknum;


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
     * 商品介绍
     */

    @TableField(value = "nongchanpin_content")
    private String nongchanpinContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "nongchanpin_delete")
    private Integer nongchanpinDelete;


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
	 * 设置：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 获取：商家
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 设置：商品名称
	 */
    public String getNongchanpinName() {
        return nongchanpinName;
    }


    /**
	 * 获取：商品名称
	 */

    public void setNongchanpinName(String nongchanpinName) {
        this.nongchanpinName = nongchanpinName;
    }
    /**
	 * 设置：商品编号
	 */
    public String getNongchanpinUuidNumber() {
        return nongchanpinUuidNumber;
    }


    /**
	 * 获取：商品编号
	 */

    public void setNongchanpinUuidNumber(String nongchanpinUuidNumber) {
        this.nongchanpinUuidNumber = nongchanpinUuidNumber;
    }
    /**
	 * 设置：商品照片
	 */
    public String getNongchanpinPhoto() {
        return nongchanpinPhoto;
    }


    /**
	 * 获取：商品照片
	 */

    public void setNongchanpinPhoto(String nongchanpinPhoto) {
        this.nongchanpinPhoto = nongchanpinPhoto;
    }
    /**
	 * 设置：商品类型
	 */
    public Integer getNongchanpinTypes() {
        return nongchanpinTypes;
    }


    /**
	 * 获取：商品类型
	 */

    public void setNongchanpinTypes(Integer nongchanpinTypes) {
        this.nongchanpinTypes = nongchanpinTypes;
    }
    /**
	 * 设置：商品库存
	 */
    public Integer getNongchanpinKucunNumber() {
        return nongchanpinKucunNumber;
    }


    /**
	 * 获取：商品库存
	 */

    public void setNongchanpinKucunNumber(Integer nongchanpinKucunNumber) {
        this.nongchanpinKucunNumber = nongchanpinKucunNumber;
    }
    /**
	 * 设置：商品原价
	 */
    public Double getNongchanpinOldMoney() {
        return nongchanpinOldMoney;
    }


    /**
	 * 获取：商品原价
	 */

    public void setNongchanpinOldMoney(Double nongchanpinOldMoney) {
        this.nongchanpinOldMoney = nongchanpinOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getNongchanpinNewMoney() {
        return nongchanpinNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setNongchanpinNewMoney(Double nongchanpinNewMoney) {
        this.nongchanpinNewMoney = nongchanpinNewMoney;
    }
    /**
	 * 设置：购买获得积分
	 */
    public Integer getNongchanpinPrice() {
        return nongchanpinPrice;
    }


    /**
	 * 获取：购买获得积分
	 */

    public void setNongchanpinPrice(Integer nongchanpinPrice) {
        this.nongchanpinPrice = nongchanpinPrice;
    }
    /**
	 * 设置：拼团限制/人
	 */
    public Integer getNongchanpinPintuan() {
        return nongchanpinPintuan;
    }


    /**
	 * 获取：拼团限制/人
	 */

    public void setNongchanpinPintuan(Integer nongchanpinPintuan) {
        this.nongchanpinPintuan = nongchanpinPintuan;
    }
    /**
	 * 设置：商品热度
	 */
    public Integer getNongchanpinClicknum() {
        return nongchanpinClicknum;
    }


    /**
	 * 获取：商品热度
	 */

    public void setNongchanpinClicknum(Integer nongchanpinClicknum) {
        this.nongchanpinClicknum = nongchanpinClicknum;
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
	 * 设置：商品介绍
	 */
    public String getNongchanpinContent() {
        return nongchanpinContent;
    }


    /**
	 * 获取：商品介绍
	 */

    public void setNongchanpinContent(String nongchanpinContent) {
        this.nongchanpinContent = nongchanpinContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getNongchanpinDelete() {
        return nongchanpinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setNongchanpinDelete(Integer nongchanpinDelete) {
        this.nongchanpinDelete = nongchanpinDelete;
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
