package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JuanzengYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 捐赠记录
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("juanzeng_yuyue")
public class JuanzengYuyueView extends JuanzengYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 捐赠项目
		/**
		* 捐赠项目标题
		*/

		@ColumnInfo(comment="捐赠项目标题",type="varchar(200)")
		private String juanzengName;
		/**
		* 捐赠项目封面
		*/

		@ColumnInfo(comment="捐赠项目封面",type="varchar(200)")
		private String juanzengPhoto;
		/**
		* 捐赠项目类型
		*/
		@ColumnInfo(comment="捐赠项目类型",type="int(11)")
		private Integer juanzengTypes;
			/**
			* 捐赠项目类型的值
			*/
			@ColumnInfo(comment="捐赠项目类型的字典表值",type="varchar(200)")
			private String juanzengValue;
		/**
		* 已捐金额
		*/
		@ColumnInfo(comment="已捐金额",type="decimal(10,2)")
		private Double juanzengNewMoney;
		/**
		* 捐赠项目介绍
		*/

		@ColumnInfo(comment="捐赠项目介绍",type="text")
		private String juanzengContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer juanzengDelete;
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



	public JuanzengYuyueView() {

	}

	public JuanzengYuyueView(JuanzengYuyueEntity juanzengYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, juanzengYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 捐赠项目

		/**
		* 获取： 捐赠项目标题
		*/
		public String getJuanzengName() {
			return juanzengName;
		}
		/**
		* 设置： 捐赠项目标题
		*/
		public void setJuanzengName(String juanzengName) {
			this.juanzengName = juanzengName;
		}

		/**
		* 获取： 捐赠项目封面
		*/
		public String getJuanzengPhoto() {
			return juanzengPhoto;
		}
		/**
		* 设置： 捐赠项目封面
		*/
		public void setJuanzengPhoto(String juanzengPhoto) {
			this.juanzengPhoto = juanzengPhoto;
		}
		/**
		* 获取： 捐赠项目类型
		*/
		public Integer getJuanzengTypes() {
			return juanzengTypes;
		}
		/**
		* 设置： 捐赠项目类型
		*/
		public void setJuanzengTypes(Integer juanzengTypes) {
			this.juanzengTypes = juanzengTypes;
		}


			/**
			* 获取： 捐赠项目类型的值
			*/
			public String getJuanzengValue() {
				return juanzengValue;
			}
			/**
			* 设置： 捐赠项目类型的值
			*/
			public void setJuanzengValue(String juanzengValue) {
				this.juanzengValue = juanzengValue;
			}

		/**
		* 获取： 已捐金额
		*/
		public Double getJuanzengNewMoney() {
			return juanzengNewMoney;
		}
		/**
		* 设置： 已捐金额
		*/
		public void setJuanzengNewMoney(Double juanzengNewMoney) {
			this.juanzengNewMoney = juanzengNewMoney;
		}

		/**
		* 获取： 捐赠项目介绍
		*/
		public String getJuanzengContent() {
			return juanzengContent;
		}
		/**
		* 设置： 捐赠项目介绍
		*/
		public void setJuanzengContent(String juanzengContent) {
			this.juanzengContent = juanzengContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJuanzengDelete() {
			return juanzengDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJuanzengDelete(Integer juanzengDelete) {
			this.juanzengDelete = juanzengDelete;
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
		return "JuanzengYuyueView{" +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuSumJifen=" + yonghuSumJifen +
			", juanzengName=" + juanzengName +
			", juanzengPhoto=" + juanzengPhoto +
			", juanzengNewMoney=" + juanzengNewMoney +
			", juanzengContent=" + juanzengContent +
			", juanzengDelete=" + juanzengDelete +
			"} " + super.toString();
	}
}
