package gl.yezi.data.dao.beauty;

import gl.yezi.data.mapper.beauty.EmployeeMapper;
import gl.yezi.data.model.beauty.Employee;

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