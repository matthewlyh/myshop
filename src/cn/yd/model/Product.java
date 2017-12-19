package cn.yd.model;

// java model：实体<-->表   属性-->字段   对象-->记录
public class Product {

	private Integer id;

	private String name;

	private String picPath;

	private Double price;

	private String remark;

	private Integer storage;
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", picPath=" + picPath
				+ ", price=" + price + ", remark=" + remark + ", storage="
				+ storage + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStorage() {
		return storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

}
