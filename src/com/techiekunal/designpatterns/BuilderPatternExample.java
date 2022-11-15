package com.techiekunal.designpatterns;

public class BuilderPatternExample {
	
	public static void main(String[] args) {
		Employee employee = new Employee.Builder(101, "Kunal").setJoiningYear(2018).build();
		System.out.println(employee);
	}
	
}

class Employee {
	
	private int id;
	private String name;
	private boolean isGymMember;
	private int joiningYear;
	
	public Employee(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.isGymMember = builder.isGymMember;
		this.joiningYear = builder.joiningYear;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isGymMember() {
		return isGymMember;
	}

	public int getJoiningYear() {
		return joiningYear;
	}

	public static class Builder {
		
		private int id;
		private String name;
		private boolean isGymMember;
		private int joiningYear;
		
		public Builder(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public Builder setIsGymMember(boolean isGymMemeber) {
			this.isGymMember = isGymMemeber;
			return this;
		}
		
		public Builder setJoiningYear(int joiningYear) {
			this.joiningYear = joiningYear;
			return this;
		}
		
		public Employee build() {
			return new Employee(this);
		}
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", isGymMember=" + isGymMember + ", joiningYear=" + joiningYear
				+ "]";
	}

}
