package gl.yezi.data.dao.beauty;

import gl.yezi.data.mapper.beauty.EmployeeTimeMapper;
import gl.yezi.data.model.beauty.EmployeeTime;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeTimeDao {

    @Resource
    EmployeeTimeMapper employeetimeMapper;

    public int create(EmployeeTime employeetime) {
        return employeetimeMapper.create(employeetime);
    }

    public EmployeeTime get(int id) {
        return employeetimeMapper.get(id);
    }

    public void update(EmployeeTime employeetime) {
        employeetimeMapper.update(employeetime);
    }
}