package com.muke.employee.service;

import com.muke.employee.domain.Employee;
import com.muke.employee.domain.PageBean;

/**
 * 员工管理的业务层的接口
 * @author sean
 *
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
