package com.muke.employee.service;

import java.util.List;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;

/**
 * 部门管理的业务层接口
 * @author sean
 *
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
