package com.bowen.architecture.architecture1.goodsmgr.vo;

import com.bowen.architecture.architecture1.common.vo.BaseModel;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof GoodsModel)) return false;
		if (!super.equals(o)) return false;
		GoodsModel that = (GoodsModel) o;
		return Objects.equals(getName(), that.getName()) &&
				Objects.equals(getImagePath(), that.getImagePath()) &&
				Objects.equals(getDescription(), that.getDescription());
	}

	@Override
	public int hashCode() {

		return Objects.hash(super.hashCode(), getName(), getImagePath(), getDescription());
	}

	@Override
	public String toString(){
		return "Model"+this.getClass().getName()+"[name=" + this.getName() + ",imagePath=" + this.getImagePath() + ",description=" + this.getDescription() + ",]";
	}	
}
