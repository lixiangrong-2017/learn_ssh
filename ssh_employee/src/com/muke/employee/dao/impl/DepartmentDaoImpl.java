package com.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;
/**
 * 部门管理的DAO层的实现类
 * @author sean
 *
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	//获取记录总数
	@Override
	public int findCount() {
		String hql = "select count(*) from Department ";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//分页查询部门
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	//DAO中保存部门的方法
	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
		
	}

	//DAO层中根据部门的ID查询部门的方法
	@Override
	public Department findById(Integer did) {
		return this.getHibernateTemplate().get(Department.class, did);
	}

	//DAO层中修改部门的方法
	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

	//DAO层中删除部门的方法
	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	//DAO层中查询所有部门的方法
	@Override
	public List<Department> findAll() {
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}

}
