package com.techiekunal.codepractice.designpatterns;

public class PrototypePatternExample {

	public static void main(String[] args) {
		// original object
		Student student = new Student();
		student.setId(100);
		student.setName("Kunal");
		System.out.println("Original object" + student);
		
		// prototype object
		try {
			Student studentProto = (Student) student.clone();
			System.out.println("Prototype object" + studentProto);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}
}


class Student implements Cloneable {
	
	private int id;
	private String name;
	
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

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student studentClone =  new Student();
		studentClone.id = this.id;
		studentClone.name = this.name;
		return studentClone;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}