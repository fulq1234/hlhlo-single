package com.lummei.jobapp.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
//@ApiModel(value = "项目经验实体类")
public class Projects implements Serializable {

    private static final long serialVersionUID = -6286085324670470702L;

   // @ApiModelProperty(value = "项目经验标识")
    private Long id;

    @NotNull(message = "简历标识不能为空")
    //@ApiModelProperty(value = "简历标识")
    private Long resumeId;

    @NotNull(message = "项目名称不能为空")
   // @ApiModelProperty(value = "项目名称")
    private String projectName;

    @NotNull(message = "开始时间不能为空")
    //@ApiModelProperty(value = "开始时间")
    private Date startDate;

    @NotNull(message = "结束时间不能为空")
   // @ApiModelProperty(value = "结束时间")
    private Date endDate;

    //@ApiModelProperty(value = "项目URL")
    private String projectUrl;

    //@ApiModelProperty(value = "项目角色")
    private String projectRole;

    //@ApiModelProperty(value = "项目描述")
    private String projectExp;
}
