package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.NongchanpinCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 商品收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("nongchanpin_collection")
public class NongchanpinCollectionView extends NongchanpinCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String nongchanpinCollectionValue;

	//级联表 商品
					 
		/**
		* 商品 的 商家
		*/
		@ColumnInfo(comment="商家",type="int(11)")
		private Integer nongchanpinShangjiaId;
		/**
		* 商品名称
		*/

		@ColumnInfo(comment="商品名称",type="varchar(200)")
		private String nongchanpinName;
		/**
		* 商品编号
		*/

		@ColumnInfo(comment="商品编号",type="varchar(200)")
		private String nongchanpinUuidNumber;
		/**
		* 商品照片
		*/

		@ColumnInfo(comment="商品照片",type="varchar(200)")
		private String nongchanpinPhoto;
		/**
		* 商品类型
		*/
		@ColumnInfo(comment="商品类型",type="int(11)")
		private Integer nongchanpinTypes;
			/**
			* 商品类型的值
			*/
			@ColumnInfo(comment="商品类型的字典表值",type="varchar(200)")
			private String nongchanpinValue;
		/**
		* 商品库存
		*/

		@ColumnInfo(comment="商品库存",type="int(11)")
		private Integer nongchanpinKucunNumber;
		/**
		* 商品原价
		*/
		@ColumnInfo(comment="商品原价",type="decimal(10,2)")
		private Double nongchanpinOldMoney;
		/**
		* 现价
		*/
		@ColumnInfo(comment="现价",type="decimal(10,2)")
		private Double nongchanpinNewMoney;
		/**
		* 购买获得积分
		*/

		@ColumnInfo(comment="购买获得积分",type="int(11)")
		private Integer nongchanpinPrice;
		/**
		* 拼团限制/人
		*/

		@ColumnInfo(comment="拼团限制/人",type="int(11)")
		private Integer nongchanpinPintuan;
		/**
		* 商品热度
		*/

		@ColumnInfo(comment="商品热度",type="int(11)")
		private Integer nongchanpinClicknum;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 商品介绍
		*/

		@ColumnInfo(comment="商品介绍",type="text")
		private String nongchanpinContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer nongchanpinDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 总积分
		*/
		@ColumnInfo(comment="总积分",type="decimal(10,2)")
		private Double yonghuSumJifen;
		/**
		* 会员等级
		*/
		@ColumnInfo(comment="会员等级",type="int(11)")
		private Integer huiyuandengjiTypes;
			/**
			* 会员等级的值
			*/
			@ColumnInfo(comment="会员等级的字典表值",type="varchar(200)")
			private String huiyuandengjiValue;



	public NongchanpinCollectionView() {

	}

	public NongchanpinCollectionView(NongchanpinCollectionEntity nongchanpinCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, nongchanpinCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getNongchanpinCollectionValue() {
		return nongchanpinCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setNongchanpinCollectionValue(String nongchanpinCollectionValue) {
		this.nongchanpinCollectionValue = nongchanpinCollectionValue;
	}


	//级联表的get和set 商品
		/**
		* 获取：商品 的 商家
		*/
		public Integer getNongchanpinShangjiaId() {
			return nongchanpinShangjiaId;
		}
		/**
		* 设置：商品 的 商家
		*/
		public void setNongchanpinShangjiaId(Integer nongchanpinShangjiaId) {
			this.nongchanpinShangjiaId = nongchanpinShangjiaId;
		}

		/**
		* 获取： 商品名称
		*/
		public String getNongchanpinName() {
			return nongchanpinName;
		}
		/**
		* 设置： 商品名称
		*/
		public void setNongchanpinName(String nongchanpinName) {
			this.nongchanpinName = nongchanpinName;
		}

		/**
		* 获取： 商品编号
		*/
		public String getNongchanpinUuidNumber() {
			return nongchanpinUuidNumber;
		}
		/**
		* 设置： 商品编号
		*/
		public void setNongchanpinUuidNumber(String nongchanpinUuidNumber) {
			this.nongchanpinUuidNumber = nongchanpinUuidNumber;
		}

		/**
		* 获取： 商品照片
		*/
		public String getNongchanpinPhoto() {
			return nongchanpinPhoto;
		}
		/**
		* 设置： 商品照片
		*/
		public void setNongchanpinPhoto(String nongchanpinPhoto) {
			this.nongchanpinPhoto = nongchanpinPhoto;
		}
		/**
		* 获取： 商品类型
		*/
		public Integer getNongchanpinTypes() {
			return nongchanpinTypes;
		}
		/**
		* 设置： 商品类型
		*/
		public void setNongchanpinTypes(Integer nongchanpinTypes) {
			this.nongchanpinTypes = nongchanpinTypes;
		}


			/**
			* 获取： 商品类型的值
			*/
			public String getNongchanpinValue() {
				return nongchanpinValue;
			}
			/**
			* 设置： 商品类型的值
			*/
			public void setNongchanpinValue(String nongchanpinValue) {
				this.nongchanpinValue = nongchanpinValue;
			}

		/**
		* 获取： 商品库存
		*/
		public Integer getNongchanpinKucunNumber() {
			return nongchanpinKucunNumber;
		}
		/**
		* 设置： 商品库存
		*/
		public void setNongchanpinKucunNumber(Integer nongchanpinKucunNumber) {
			this.nongchanpinKucunNumber = nongchanpinKucunNumber;
		}

		/**
		* 获取： 商品原价
		*/
		public Double getNongchanpinOldMoney() {
			return nongchanpinOldMoney;
		}
		/**
		* 设置： 商品原价
		*/
		public void setNongchanpinOldMoney(Double nongchanpinOldMoney) {
			this.nongchanpinOldMoney = nongchanpinOldMoney;
		}

		/**
		* 获取： 现价
		*/
		public Double getNongchanpinNewMoney() {
			return nongchanpinNewMoney;
		}
		/**
		* 设置： 现价
		*/
		public void setNongchanpinNewMoney(Double nongchanpinNewMoney) {
			this.nongchanpinNewMoney = nongchanpinNewMoney;
		}

		/**
		* 获取： 购买获得积分
		*/
		public Integer getNongchanpinPrice() {
			return nongchanpinPrice;
		}
		/**
		* 设置： 购买获得积分
		*/
		public void setNongchanpinPrice(Integer nongchanpinPrice) {
			this.nongchanpinPrice = nongchanpinPrice;
		}

		/**
		* 获取： 拼团限制/人
		*/
		public Integer getNongchanpinPintuan() {
			return nongchanpinPintuan;
		}
		/**
		* 设置： 拼团限制/人
		*/
		public void setNongchanpinPintuan(Integer nongchanpinPintuan) {
			this.nongchanpinPintuan = nongchanpinPintuan;
		}

		/**
		* 获取： 商品热度
		*/
		public Integer getNongchanpinClicknum() {
			return nongchanpinClicknum;
		}
		/**
		* 设置： 商品热度
		*/
		public void setNongchanpinClicknum(Integer nongchanpinClicknum) {
			this.nongchanpinClicknum = nongchanpinClicknum;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 商品介绍
		*/
		public String getNongchanpinContent() {
			return nongchanpinContent;
		}
		/**
		* 设置： 商品介绍
		*/
		public void setNongchanpinContent(String nongchanpinContent) {
			this.nongchanpinContent = nongchanpinContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getNongchanpinDelete() {
			return nongchanpinDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setNongchanpinDelete(Integer nongchanpinDelete) {
			this.nongchanpinDelete = nongchanpinDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 总积分
		*/
		public Double getYonghuSumJifen() {
			return yonghuSumJifen;
		}
		/**
		* 设置： 总积分
		*/
		public void setYonghuSumJifen(Double yonghuSumJifen) {
			this.yonghuSumJifen = yonghuSumJifen;
		}
		/**
		* 获取： 会员等级
		*/
		public Integer getHuiyuandengjiTypes() {
			return huiyuandengjiTypes;
		}
		/**
		* 设置： 会员等级
		*/
		public void setHuiyuandengjiTypes(Integer huiyuandengjiTypes) {
			this.huiyuandengjiTypes = huiyuandengjiTypes;
		}


			/**
			* 获取： 会员等级的值
			*/
			public String getHuiyuandengjiValue() {
				return huiyuandengjiValue;
			}
			/**
			* 设置： 会员等级的值
			*/
			public void setHuiyuandengjiValue(String huiyuandengjiValue) {
				this.huiyuandengjiValue = huiyuandengjiValue;
			}


	@Override
	public String toString() {
		return "NongchanpinCollectionView{" +
			", nongchanpinCollectionValue=" + nongchanpinCollectionValue +
			", nongchanpinName=" + nongchanpinName +
			", nongchanpinUuidNumber=" + nongchanpinUuidNumber +
			", nongchanpinPhoto=" + nongchanpinPhoto +
			", nongchanpinKucunNumber=" + nongchanpinKucunNumber +
			", nongchanpinOldMoney=" + nongchanpinOldMoney +
			", nongchanpinNewMoney=" + nongchanpinNewMoney +
			", nongchanpinPrice=" + nongchanpinPrice +
			", nongchanpinPintuan=" + nongchanpinPintuan +
			", nongchanpinClicknum=" + nongchanpinClicknum +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", nongchanpinContent=" + nongchanpinContent +
			", nongchanpinDelete=" + nongchanpinDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuSumJifen=" + yonghuSumJifen +
			"} " + super.toString();
	}
}
