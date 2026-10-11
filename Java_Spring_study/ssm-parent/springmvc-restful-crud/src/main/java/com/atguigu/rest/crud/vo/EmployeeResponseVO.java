package com.atguigu.rest.crud.vo;

import com.atguigu.rest.crud.bean.Employee;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * 返回给前端的员工信息 VO
 */
@Schema(description = "后端响应给前端的对象")
@Data
public class EmployeeResponseVO {
    @Schema(description = "Response查询的时候会用到这个id")
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
    private String dept;

    /** 从数据库实体转换 */
    public static EmployeeResponseVO from(Employee employee) {
        EmployeeResponseVO vo = new EmployeeResponseVO();
        BeanUtils.copyProperties(employee, vo);
        return vo;
    }
}
