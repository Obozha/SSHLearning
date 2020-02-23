package cc.sms.service;

import java.sql.SQLException;
import java.util.List;

import cc.sms.bean.Student;
import cc.sms.dao.Page;

public interface StudentService {

	/**
	 * 查询所有学生的数据
	 * 
	 * @return List<Student> 返回学生的List数据集合
	 * @throws SQLException
	 */
	List<Student> findAllStu() throws SQLException;

	/**
	 * 通过ID来查找学生
	 * 
	 * @return Student
	 * @throws SQLException
	 */
	Student findStuByID(String sid) throws SQLException;

	/**
	 * 模糊查找学生的数据
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Student> findPartStuByFuzzy(String sname, String gender) throws SQLException;

	/**
	 * 每页pageSize条，当前currentPage页
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	Page findStuByCurrentPage(int currentPage) throws SQLException;

	/**
	 * 通过id来更新某个学生数据
	 * 
	 * @param sid
	 * @return boolean
	 * @throws SQLException
	 */
	boolean updateStuByID(Student stu) throws SQLException;

	/**
	 * 插入学生数据
	 * 
	 * @param stu
	 * @return boolean
	 * @throws SQLException
	 */
	boolean insertStu(Student stu) throws SQLException;

	/**
	 * 通过sid来删除某个学生数据
	 * 
	 * @param sid
	 * @return boolean
	 * @throws SQLException
	 */
	boolean deleteStuByID(int sid) throws SQLException;
}
