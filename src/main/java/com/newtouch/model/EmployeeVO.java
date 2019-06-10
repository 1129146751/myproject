package com.newtouch.model;

import cn.afterturn.easypoi.excel.annotation.Excel;

import cn.afterturn.easypoi.excel.annotation.Excel;


public class EmployeeVO {

    private Integer empId;


   @Excel(name = "姓名", orderNum = "0")
    private String empName;

    private String gender;


    @Excel(name = "邮箱", orderNum = "1")
    private String email;

    private Integer dId;


    private  Integer state;


    public EmployeeVO(Integer empId) {
        this.empId = empId;
    }

    @Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", gender=" + gender + ", email=" + email + ", dId=" + dId
				+ "]";
	}

	public EmployeeVO() {
		super();
	}

	public EmployeeVO(Integer empId, String empName, String gender, String email,
                      Integer dId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.email = email;
		this.dId = dId;
	}



	public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public EmployeeVO(String empName, String email) {
        this.empName = empName;
        this.email = email;
    }
}