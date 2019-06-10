package com.newtouch.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
@Component
@Table(name="employee")
public class Employee {
    @Id
    @Column(name = "emp_id")
    private Integer empId;

   @Column(name="emp_name")
   @Excel(name = "姓名", orderNum = "0")
    private String empName;
    @Column(name="gender")
    @Excel(name = "性别", orderNum = "1")
    private String gender;

    @Column(name="email")
    @Excel(name = "邮箱", orderNum = "2")
    private String email;
    @Column(name="d_id")
    private Integer dId;

    @Column(name="state")
    private  Integer state;


    public Employee(Integer empId) {
        this.empId = empId;
    }

    @Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", gender=" + gender + ", email=" + email + ", dId=" + dId
				+ "]";
	}

	public Employee() {
		super();
	}

	public Employee(Integer empId, String empName, String gender, String email,
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
}