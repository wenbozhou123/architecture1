package com.bowen.architecture.architecture1.goodsmgr.vo;

import com.bowen.architecture.architecture1.common.vo.BaseModel;

public class GoodsModel extends BaseModel{
	private String name;
	private String imagePath;
	private String description;
	
	public void setName(String obj){
		this.name = obj;
	}
	public String getName(){
		return this.name;
	}
	
	public void setImagePath(String obj){
		this.imagePath = obj;
	}
	public String getImagePath(){
		return this.imagePath;
	}
	
	public void setDescription(String obj){
		this.description = obj;
	}
	public String getDescription(){
		return this.description;
	}
	
	
	
	public String toString(){
		return "Model"+this.getClass().getName()+"[name=" + this.getName() + ",imagePath=" + this.getImagePath() + ",description=" + this.getDescription() + ",]";
	}	
}
