package cn.wmyskxz.springboot.DAO;

import cn.wmyskxz.springboot.model.Employee;
import java.util.List;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

//这是一个操作数据库的mapper；Mybatis 注解版 通过写入SQL语句操作数据库
@Mapper
@Repository
public interface EmployeeMapper {

    //查找全部人员
    @Select("select * from person")
    public List<Employee> getAll();
    //删除
    @Delete("delete from person where name=#{name}")
    public void deleteempID(String name);
    //增添
    @Insert({"insert into person (position,power,password,name) values (#{position},#{power},#{password},#{name})"
    })
    public void insertall(Employee employee);
    //改变
    @Update({"update person set position=#{position}, power=#{power}, password=#{password} where name=#{name}"})
    public void updateall(Employee employee);


    //根据用户名查找密码
    @Select("select password from person where name = #{name}")
    public String Verification(String name);


//    权限
    @Select("select power from person where name = #{name}")
    public String Permit(String name);

}



//    public int insert(Employee employee);
//
//    public int delete(Employee employee);
//
//    public int update(Employee employee);
//
//    public Employee selectById(Long id);
//
//    public List<Employee> selectAll();




//              自动生成test
//    long countByExample(EmployeeExample example);
//
//    int deleteByExample(EmployeeExample example);
//
//    int deleteByPrimaryKey(Integer id);
//
//int insert(Employee record);
//
//    int insertSelective(Employee record);
//
//    List<Employee> selectByExample(EmployeeExample example);
//
//    Employee selectByPrimaryKey(Integer id);
//
//    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);
//
//    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);
//
//    int updateByPrimaryKeySelective(Employee record);
//
//    int updateByPrimaryKey(Employee record);