package com.atguigu.rest.crud.vo;

import com.atguigu.rest.crud.bean.Employee;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * 接收前端请求参数的 VO（新增/修改员工共用）
 */


@Schema(description = "前端传递到后端的对象")
@Data
public class EmployeeRequestVO {
    /** 修改时必传，新增时可以不传 */
    @Schema(description = "Request新增的时候会用到这个id")
    private Long id;
    @NotBlank(message = "姓名不能为空")
    private String name;
    private Integer age;
    @Email(message = "邮箱格式不正确")
    private String email;

    @Schema(description = "性别, 只能是男/女/保密")
    private String gender;
    private String address;
    private BigDecimal salary;
    private String dept;

    /** 转成数据库实体 */
    public Employee toEmployee() {
        Employee employee = new Employee();
        BeanUtils.copyProperties(this, employee);
        return employee;
    }
}
