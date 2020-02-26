package com.store.pojo;
/**
 * 实体类
 * @author Administrator
 *
 */

import java.util.Date;

public class Equipment {

	
	private  int id;
	private  String  equipment_id;
	private  String  equipment_name;
	private  String  equipment_type;
	private  String  createtime;
	private  String  responsible_person;
	private  String  remark;
	private  int     del;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEquipment_id() {
		return equipment_id;
	}
	public void setEquipment_id(String equipment_id) {
		this.equipment_id = equipment_id;
	}
	public String getEquipment_name() {
		return equipment_name;
	}
	public void setEquipment_name(String equipment_name) {
		this.equipment_name = equipment_name;
	}
	public String getEquipment_type() {
		return equipment_type;
	}
	public void setEquipment_type(String equipment_type) {
		this.equipment_type = equipment_type;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getResponsible_person() {
		return responsible_person;
	}
	public void setResponsible_person(String responsible_person) {
		this.responsible_person = responsible_person;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	
	
	
	
}
