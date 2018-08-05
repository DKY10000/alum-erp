package com.dky.eureka.domain.user.entity;

        import io.swagger.annotations.ApiModel;
        import io.swagger.annotations.ApiModelProperty;
        import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ChanceMaster")
@Table(name = "sys_user")
public class User {
    @Id
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "登陆人编号")
    @Column(name = "fCode")
    private String fcode;

    @ApiModelProperty(value = "登陆人名称")
    @Column(name = "fName")
    private String fname;
}