package cn.wmyskxz.springboot.Controller;


import cn.wmyskxz.springboot.DAO.EmployeeMapper;
import cn.wmyskxz.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;




// 人员管理Controller

@Controller
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;

    //删除功能
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestBody JSONObject params) {
        String name = params.getString("name");
//        System.out.println(name);
        Map<String, Object> map = new HashMap<>();
        map.put("success",true);
        employeeMapper.deleteempID(name);
        return map;
    }

    //新增功能
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Object insert(@RequestBody JSONObject params) {
//        Integer id= params.getInteger("id");
        String name = params.getString("name");
        String position = params.getString("position");
        String power = params.getString("power");
        String password = params.getString("password");
        System.out.println(name +" "+ position +" "+ power +" "+ password);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("success", true);
        Employee employee = new Employee( position, power, password,name);

        employeeMapper.insertall(employee);
        return map1;
    }



//修改
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public  Object update(@RequestBody JSONObject params){
//        Integer id= params.getInteger("id");
        String name = params.getString("name");
        String position = params.getString("position");
        String power = params.getString("power");
        String password = params.getString("password");
//        System.out.println(name);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("success", true);
//        Employee employee = new Employee( position,power, password, name);
        Employee employee = new Employee(power,position, password,name);
        System.out.println("update .. emp is "+employee);
        employeeMapper.updateall(employee);
        return map2;
   }
}











