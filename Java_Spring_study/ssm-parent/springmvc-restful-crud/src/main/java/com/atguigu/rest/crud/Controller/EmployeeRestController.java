package com.atguigu.rest.crud.Controller;

import com.atguigu.rest.crud.Service.EmplayeeService;
import com.atguigu.rest.crud.bean.R;
import com.atguigu.rest.crud.vo.EmployeeRequestVO;
import com.atguigu.rest.crud.vo.EmployeeResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;




@Tag(name = "员工管理")
@CrossOrigin//允许跨域, 不同源无所谓
@RequestMapping("/api/v1")
@RestController
public class EmployeeRestController {
    @Autowired
    private EmplayeeService es;

    //id查单个员工
    @Parameters({
            @Parameter(name = "id", description = "查询的员工id", in = ParameterIn.PATH, required = true),
    })
    @Operation(summary = "按照id查询单个员工")
    @GetMapping (value = "/employee/{id}")
    public R<EmployeeResponseVO> get(@PathVariable("id") Long iddd) throws FileNotFoundException {
        //System.out.println(1/0);
        //FileInputStream fis = new FileInputStream("");
        System.out.println("查询单个员工");
        return R.ok(EmployeeResponseVO.from(es.getEmployee(iddd)));
    }

    /*@ExceptionHandler(ArithmeticException.class)
    public R math(ArithmeticException ae){
        System.out.println("数字异常");
        return R.error(300, "执行异常 " + ae.getMessage());
    }
    @ExceptionHandler(FileNotFoundException.class)
    public R File_E(FileNotFoundException fe){
        System.out.println("文件io异常");
        return R.error(99999, "执行异常 " + fe.getMessage());
    }*/


    //查所有员工
    @Operation(summary = "查询所有员工")
    @GetMapping("/employees")
    public R<List<EmployeeResponseVO>> getAll(){
        List<EmployeeResponseVO> list = es.getAllEmployees().stream()
                .map(EmployeeResponseVO::from)
                .toList();
        return R.ok(list);
    }


    //增加员工
    @Operation(summary = "增加员工")
    @PostMapping("/employee")
    public R add(@Valid @RequestBody EmployeeRequestVO vo){
        System.out.println("新增员工");
        es.addEmployee(vo.toEmployee());
        return R.ok();
    }

    //删除
    @Operation(summary = "删除员工")
    @DeleteMapping("/employee/{id}")
    public R delete(@PathVariable Long id){
        System.out.println("删除员工");
        es.deleteEmployee(id);
        return R.ok();
    }

    //更改
    @Operation(summary = "更改员工")
    @PutMapping("/employee")
    public R update(@Valid @RequestBody EmployeeRequestVO vo){
        System.out.println("更改员工");
        if(vo.getId() == null){
            System.out.println("id就是空的");
            //抛异常
            //throw new BizException(BizExceptionEnum.ORDER_1);
        }

        es.updateEmployee(vo.toEmployee());
        return R.ok();
    }

    public void test(){
        System.out.println("这个是EmployeeRestController的测试方法, 没啥用");
    }




}
