package com.lummei.jobapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
//@ApiModel(value = "求职者信息实体类")
public class JobSeeker implements Serializable {

    private static final long serialVersionUID = -6294282571824555959L;

    //@ApiModelProperty(value = "求职者信息标识")
    private Long id;

    //@ApiModelProperty(value = "参加工作时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startWorkTime;

    //@ApiModelProperty(value = "婚姻状况")
    private String marriage;

    //@ApiModelProperty(value = "学历")
    private String degree;

   // @ApiModelProperty(value = "求职状态")
    private String jobStatus;

    //@ApiModelProperty(value = "现居住城市")
    private String city;
}
