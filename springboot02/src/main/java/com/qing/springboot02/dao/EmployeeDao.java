package com.qing.springboot02.dao;

import com.qing.springboot02.pojo.Department;
import com.qing.springboot02.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees=null;

    @Autowired
    private  DepartmentDao departmentDao;

    static {
        employees=new HashMap<Integer, Employee>();//创建一个部门表

        employees.put(1001,new Employee(1001,"AA","A2323232@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","B2323232@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","C2323232@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","D2323232@qq.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","E2323232@qq.com",0,new Department(105,"后勤部")));

    }
//    //获得所有部门信息
//    public Collection<Department> getDepartments(){
//        return employees.values();
//    }
//
//    //通过id
//    public  Department getDepartments(Integer id){
//        return  employees.get(id);
//    }
    private  static Integer initId=1006;
    //增加一个员工
    public void save (Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartments(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return  employees.values();
    }
    //通过id查询员工
    public  Employee getEmployeeById(Integer id){
        return  employees.get(id);
    }

    //删除
    public void  delete(Integer id){
       employees.remove(id);
    }
}
