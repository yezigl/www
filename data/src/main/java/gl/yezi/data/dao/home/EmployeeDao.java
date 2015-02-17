package gl.yezi.data.dao.home;

import gl.yezi.data.mapper.home.EmployeeMapper;
import gl.yezi.data.model.home.Employee;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    @Resource
    EmployeeMapper employeeMapper;

    public int create(Employee employee) {
        return employeeMapper.create(employee);
    }

    public Employee get(int id) {
        return employeeMapper.get(id);
    }

    public void update(Employee employee) {
        employeeMapper.update(employee);
    }
}