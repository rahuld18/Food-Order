package model;

public class Subcategory {

	private int subcategoryid;
	private int categoryid;
	private String subcategoryname;

	private String subcategorydescrition;

	private String subcategoryicon;

	public int getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(int subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public String getSubcategoryname() {
		return subcategoryname;
	}

	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}

	public String getSubcategorydescrition() {
		return subcategorydescrition;
	}

	public void setSubcategorydescrition(String subcategorydescrition) {
		this.subcategorydescrition = subcategorydescrition;
	}

	public String getSubcategoryicon() {
		return subcategoryicon;
	}

	public void setSubcategoryicon(String subcategoryicon) {
		this.subcategoryicon = subcategoryicon;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	
}
