package com.muke.employee.action;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.muke.employee.service.impl.DepartmentServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	//模型驱动使用的对象
	private Department department = new Department();
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}

	//接收当前页数
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	//注入部门管理的Service层
	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}


	//提供一个查询的方法
	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//跳转到添加部门页面的方法
	public String save_UI() {
		return "saveUI";
	}
	
	//添加部门的执行的方法
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}
	
	//编辑部门的执行的方法
	public String edit() {
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	//修改部门的执行的方法
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
	}
	
	//删除部门执行的方法
	public String delete() {
		//传对象的方法可以进行级联删除
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
