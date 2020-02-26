package com.store.pojo;

public class Building {
	private   int  id;
	private  String buildingName;
	//标记删除
	private   int  del;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}  
}
