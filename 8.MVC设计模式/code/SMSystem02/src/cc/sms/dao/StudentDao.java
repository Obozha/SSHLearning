package cc.sms.dao;

import java.sql.SQLException;
import java.util.List;

import cc.sms.bean.Student;

public interface StudentDao {

	/**
	 * 查询所有学生的数据
	 * 
	 * @return List<Student> 返回学生的List数据集合
	 * @throws SQLException
	 */
	List<Student> findAllStu() throws SQLException;

	/**
	 * 模糊查找学生的数据
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Student> findPartStuByFuzzy(String sname, String gender) throws SQLException;

	/**
	 * 每页显示pageSize条，当前是currentPage页
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return List<Student>
	 * @throws SQLException
	 */
	List<Student> findStuByCurrentPage(int currentPage,int pageSize) throws SQLException;

	/**
	 * 查询学生数量
	 * 
	 * @return int
	 */
	int findStuCount() throws SQLException;

	/**
	 * 通过id查找某个学生数据
	 * 
	 * @param sid 学生的sid
	 * @return Student
	 * @throws SQLException
	 */
	Student findStuByID(String sid) throws SQLException;

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
