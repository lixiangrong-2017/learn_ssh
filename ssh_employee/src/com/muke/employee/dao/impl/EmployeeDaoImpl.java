package com.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.domain.Employee;
/**
 * 员工管理的DAO的实现类
 * @author sean
 *
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{

	/**
	 * 根据用户名和密码查询用户的方法
	 */
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username = ? and password = ? ";
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public int findByCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	//DAO中保存员工的方法
	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	//DAO层根据员工ID查询员工的方法
	@Override
	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	//DAO层修改员工的执行的方法
	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}

	//DAO层删除员工的执行的方法
	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}

}
