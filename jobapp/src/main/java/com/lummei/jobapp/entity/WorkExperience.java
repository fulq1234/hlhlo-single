package com.lummei.jobapp.entity;

import java.io.Serializable;
import java.util.Date;

//@Data
//@ApiModel(value = "工作经验实体类")
public class WorkExperience implements Serializable {

    private static final long serialVersionUID = 392628438902119973L;

    //@ApiModelProperty(value = "工作经验标识")
    private Long id;

    //@NotNull(message = "简历标识不能为空")
    //@ApiModelProperty(value = "简历标识")
    private Long resumeId;

    //@JsonFormat(pattern = "yyyy-MM-dd")
    //@NotNull(message = "开始日期不能为空")
    //@ApiModelProperty(value = "开始日期")
    private Date startDate;

//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @NotNull(message = "结束日期不能为空")
    //@ApiModelProperty(value = "结束日期")
    private Date endDate;

//    @NotNull(message = "公司名称不能为空")
    //@ApiModelProperty(value = "公司名称")
    private String companyName;

    //@NotNull(message = "所属部门不能为空")
   // @ApiModelProperty(value = "所属部门")
    private String department;

    //@NotNull(message = "职位名称不能为空")
    //@ApiModelProperty(value = "职位名称")
    private String position;

//    @NotNull(message = "薪资待遇不能为空")
   // @ApiModelProperty(value = "薪资待遇")
    private String salary;

   // @ApiModelProperty(value = "离职原因")
    private String leaveReason;

   // @ApiModelProperty(value = "工作经历")
    private String jobExp;

   // @ApiModelProperty(value = "所属行业")
    private String industry;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getJobExp() {
        return jobExp;
    }

    public void setJobExp(String jobExp) {
        this.jobExp = jobExp;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
