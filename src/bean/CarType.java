package bean;

public class CarType {
	
	//车型编号，用于和车型的ID关联
	private int typeID;
	//汽车类型名称
	private String typeName;
	//品牌编号
	private int brandID;
	//汽车类型相关备注
	private String tcemarks;
	
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getBrandID() {
		return brandID;
	}
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	public String getTcemarks() {
		return tcemarks;
	}
	public void setTcemarks(String tcemarks) {
		this.tcemarks = tcemarks;
	}
	
	
	
}
