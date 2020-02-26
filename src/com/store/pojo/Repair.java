package com.store.pojo;

public class Repair {
	private  int 	id;
	
	private  int 	buildingId;
	
	//额外展示的属性
	private  String buildingName;
    private  String userName;
    private  String equipmentName;
    private  String assignName;
    
	
	private  String userId;
	private  int 	equipmentId;
	private  String content;
	private  String startTime;
	private  String endTime;
	private  String assignId;
	//表单状态 0 报修 1 受理  2 完成
	private  int    status;
	private  String  imgUrl;
	private  String  addr;
	private  String  acceptTime;
	private  String  repairContent;
	
	private  String  repairNo;




	public Repair() {
		super();
	}

	public Repair(int buildingid, String userid, String content, int equipmentid, String imgirl) {
		super();
		this.buildingId = buildingid;
		this.userId = userid;
		this.content = content;
		this.equipmentId = equipmentid;
		this.imgUrl = imgirl;
	}
	public  int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAssignId() {
		return assignId;
	}

	public void setAssignId(String assignId) {
		this.assignId = assignId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}

	public String getRepairContent() {
		return repairContent;
	}

	public void setRepairContent(String repairContent) {
		this.repairContent = repairContent;
	}

	public String getRepairNo() {
		return repairNo;
	}

	public void setRepairNo(String repairNo) {
		this.repairNo = repairNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getAssignName() {
		return assignName;
	}

	public void setAssignName(String assignName) {
		this.assignName = assignName;
	}

	@Override
	public String toString() {
		return "Repair [id=" + id + ", buildingId=" + buildingId + ", userId=" + userId + ", equipmentId=" + equipmentId
				+ ", content=" + content + ", startTime=" + startTime + ", endTime=" + endTime + ", assignId="
				+ assignId + ", status=" + status + ", imgUrl=" + imgUrl + ", addr=" + addr + ", acceptTime="
				+ acceptTime + ", repairContent=" + repairContent + ", repairNo=" + repairNo + "]";
	}  
	
	
	
	
	
	
	
}
