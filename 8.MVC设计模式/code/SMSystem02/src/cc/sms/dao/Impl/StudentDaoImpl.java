package cc.sms.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cc.sms.bean.Student;
import cc.sms.dao.StudentDao;
import cc.sms.utils.JDBCUtils;

public class StudentDaoImpl implements StudentDao {
	
	/**
	 * 这里千万不要用动态的连接池，因为动态的连接池，每new一个新的实例就会
	 */
	static QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	private static StudentDaoImpl instance;

	public static StudentDaoImpl getStudentDaoImpl() {
		if (instance == null) {
			instance = new StudentDaoImpl();
		}
		return instance;
	}

	public StudentDaoImpl() {
		System.out.println("实例初始化");
	}

	@Override
	public List<Student> findAllStu() throws SQLException {
		return runner.query("select * from t_student", new BeanListHandler<Student>(Student.class));
	}

	@Override
	public List<Student> findPartStuByFuzzy(String sname, String gender) throws SQLException {
		String sql = "select * from t_student where 1=1";
		List<String> list = new ArrayList<String>();

		System.out.println(sname + "---" + gender);

		if (!sname.equals("") && sname != null) {
			sql = sql + " and sname like ?";
			list.add("%" + sname + "%");
		}
		if (gender != null && !gender.equals("")) {
			sql = sql + " and gender = ?";
			list.add(gender);
		}

		return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
	}

	@Override
	public List<Student> findStuByCurrentPage(int currentPage, int pageSize) throws SQLException {
		return runner.query("select * from t_student limit ? offset ?", new BeanListHandler<Student>(Student.class),
				pageSize, (currentPage - 1) * pageSize);
	}

	@Override
	public Student findStuByID(String sid) throws SQLException {
		return runner.query("select * from t_student where sid=?", new BeanHandler<Student>(Student.class), sid);
	}

	@Override
	public int findStuCount() throws SQLException {
		// new ScalarHandler<Long>() 这里的泛型一定要指定Long 类型，因为指定了Integer和Long是无法转换的
		return runner.query("select count(sid) from t_student ;", new ScalarHandler<Long>()).intValue();
	}

	@Override
	public boolean updateStuByID(Student stu) throws SQLException {
		return runner.update("update t_student set sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid=?",
				stu.getSname(), stu.getGender(), stu.getPhone(), stu.getBirthday(), stu.getHobby(), stu.getInfo(),
				stu.getSid()) == 1 ? true : false;
	}

	@Override
	public boolean insertStu(Student stu) throws SQLException {
		return runner.update("insert into t_student values(null,?,?,?,?,?,?)", stu.getSname(), stu.getGender(),
				stu.getPhone(), stu.getBirthday(), stu.getHobby(), stu.getInfo()) == 1 ? true : false;
	}

	@Override
	public boolean deleteStuByID(int sid) throws SQLException {
		return runner.update("delete from t_student where sid=?", sid) == 1 ? true : false;
	}

}
