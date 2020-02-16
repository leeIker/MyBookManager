package org.huijingyuan.entity;
/**
 * 图书的实体类
 * @author Administrator
 *
 */
public class Book {
	private int id;
	private String name;
	private String type;
	private String auther;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book( String name, String type, String auther) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.auther = auther;
	}
	
	
}
