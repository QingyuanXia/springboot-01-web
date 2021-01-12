package com.xia.dao;

//部门Dao

import com.xia.pojo.Department;
import com.xia.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        //创建表格
        employees = new HashMap<Integer, Employee>();
        employees.put(1011, new Employee(1001, "A1", "4585@qq.com", 1, new Department(1001, "后勤部")));
        employees.put(1012, new Employee(1002, "A2", "4586@qq.com", 0, new Department(1002, "后勤部")));
        employees.put(1013, new Employee(1003, "A3", "4587@qq.com", 0, new Department(1003, "后勤部")));
        employees.put(1014, new Employee(1004, "A4", "4588@qq.com", 1, new Department(1004, "后勤部")));

    }

    //自动创建测试
    private static Integer initID = 1005;

    //增加员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initID++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }

    //查询员工
    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    //删除
    public void deleteEmployee(Integer id) {
        employees.remove(id);
    }



}


