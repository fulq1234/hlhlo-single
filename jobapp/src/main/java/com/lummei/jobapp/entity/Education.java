package com.lummei.jobapp.entity;


import java.io.Serializable;
import java.util.Date;

//@Data
//@ApiModel(value = "教育经历实体类")
public class Education implements Serializable {

    private static final long serialVersionUID = 5173726951991980460L;

   // @ApiModelProperty(value = "教育标识")
    private Long id;

    //@NotNull(message = "简历标识不能为空")
    //@ApiModelProperty(value = "简历标识")
    private Long resumeId;

   // @JsonFormat(pattern = "yyyy-MM-dd")
    //@NotNull(message = "开始日期不能为空")
    //@ApiModelProperty(value = "开始日期")
    private Date startDate;

//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @NotNull(message = "结束日期不能为空")
//    @ApiModelProperty(value = "结束日期")
    private Date endDate;

//    @NotNull(message = "学校名称不能为空")
//    @ApiModelProperty(value = "学校名称")
    private String school;

//    @NotNull(message = "专业名称不能为空")
//    @ApiModelProperty(value = "专业名称")
    private String major;

//    @NotNull(message = "学历不能为空")
//    @ApiModelProperty(value = "学历")
    private String degree;

//    @ApiModelProperty(value = "教育类型")
    private String eduType;

//    @ApiModelProperty(value = "在校经历")
    private String schoolExp;

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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEduType() {
        return eduType;
    }

    public void setEduType(String eduType) {
        this.eduType = eduType;
    }

    public String getSchoolExp() {
        return schoolExp;
    }

    public void setSchoolExp(String schoolExp) {
        this.schoolExp = schoolExp;
    }
}
