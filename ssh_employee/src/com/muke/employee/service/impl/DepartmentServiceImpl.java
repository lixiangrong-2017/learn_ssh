package com.muke.employee.service.impl;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
/**
 * 部门管理的业务层实现类
 * @author sean
 *
 */
import com.muke.employee.service.DepartmentService;
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	//注入部门管理的DAO层
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	//分页查询部门的方法
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每夜显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数;
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数;
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的页数
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层保存部门的方法
	@Override
	public void save(Department department) {
		departmentDao.save(department);
		
	}

	//业务层中根据部门的ID查询部门的方法
	@Override
	public Department findById(Integer did) {
		return departmentDao.findById(did);
	}

	//业务层中修改部门的方法
	@Override
	public void update(Department department) {
		departmentDao.update(department);
		
	}

	//业务层中删除部门的方法
	@Override
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	//业务层中查询所有部门的方法
	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
}
