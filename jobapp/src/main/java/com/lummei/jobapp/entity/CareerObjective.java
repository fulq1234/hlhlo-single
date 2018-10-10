package com.lummei.jobapp.entity;

import java.io.Serializable;

//@Data
//@ApiModel(value = "求职意向实体类")
public class CareerObjective implements Serializable {

    private static final long serialVersionUID = 2023175762841519952L;

    //@ApiModelProperty(value = "意向标识")
    private Long id;

    //@NotNull(message = "简历标识不能为空")
    //@ApiModelProperty(value = "简历标识")
    private Long resumeId;

    //@ApiModelProperty(value = "工作性质")
    private String desiredType;

   // @ApiModelProperty(value = "期望职位")
    private String function;

   // @ApiModelProperty(value = "期望行业")
    private String industry;

    //@ApiModelProperty(value = "工作城市")
    private String location;

    //@ApiModelProperty(value = "薪资要求")
    private String salary;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResumeId() {
        return resumeId;
    }

    public void setResumeId(Long resumeId) {
        this.resumeId = resumeId;
    }

    public String getDesiredType() {
        return desiredType;
    }

    public void setDesiredType(String desiredType) {
        this.desiredType = desiredType;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
