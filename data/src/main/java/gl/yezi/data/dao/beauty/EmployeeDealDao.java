package gl.yezi.data.dao.beauty;

import gl.yezi.data.mapper.beauty.EmployeeDealMapper;
import gl.yezi.data.model.beauty.EmployeeDeal;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDealDao {

    @Resource
    EmployeeDealMapper employeedealMapper;

    public int create(EmployeeDeal employeedeal) {
        return employeedealMapper.create(employeedeal);
    }

    public EmployeeDeal get(int id) {
        return employeedealMapper.get(id);
    }

    public void update(EmployeeDeal employeedeal) {
        employeedealMapper.update(employeedeal);
    }
}