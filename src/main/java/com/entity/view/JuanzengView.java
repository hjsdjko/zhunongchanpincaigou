package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JuanzengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 捐赠项目
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("juanzeng")
public class JuanzengView extends JuanzengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 捐赠项目类型的值
	*/
	@ColumnInfo(comment="捐赠项目类型的字典表值",type="varchar(200)")
	private String juanzengValue;




	public JuanzengView() {

	}

	public JuanzengView(JuanzengEntity juanzengEntity) {
		try {
			BeanUtils.copyProperties(this, juanzengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "JuanzengView{" +
			", juanzengValue=" + juanzengValue +
			"} " + super.toString();
	}
}
