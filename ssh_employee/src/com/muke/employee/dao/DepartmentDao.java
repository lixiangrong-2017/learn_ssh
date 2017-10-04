package com.muke.employee.dao;

import java.util.List;

import com.muke.employee.domain.Department;

/**
 * 部门管理的DAO接口
 * @author sean
 *
 */
public interface DepartmentDao {

	List<Department> findByPage(int begin, int pageSize);

	int findCount();

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
