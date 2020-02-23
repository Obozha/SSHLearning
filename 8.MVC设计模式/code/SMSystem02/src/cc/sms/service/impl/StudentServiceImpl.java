package cc.sms.service.impl;

import java.sql.SQLException;
import java.util.List;

import cc.sms.bean.Student;
import cc.sms.dao.Page;
import cc.sms.dao.StudentDao;
import cc.sms.dao.Impl.StudentDaoImpl;
import cc.sms.params.Params;
import cc.sms.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao dao = StudentDaoImpl.getStudentDaoImpl();

	@Override
	public List<Student> findAllStu() throws SQLException {
		return dao.findAllStu();
	}

	@Override
	public Student findStuByID(String sid) throws SQLException {
		return dao.findStuByID(sid);
	}

	@Override
	public boolean updateStuByID(Student stu) throws SQLException {
		return dao.updateStuByID(stu);
	}

	@Override
	public boolean insertStu(Student stu) throws SQLException {
		return dao.insertStu(stu);
	}

	@Override
	public boolean deleteStuByID(int sid) throws SQLException {
		return dao.deleteStuByID(sid);
	}

	@Override
	public List<Student> findPartStuByFuzzy(String sname, String gender) throws SQLException {
		return dao.findPartStuByFuzzy(sname, gender);
	}

	@Override
	public Page findStuByCurrentPage(int currentPage) throws SQLException {

		// 所有学生数目
		int stuCount = dao.findStuCount();

		int pageSize = Params.pageSize;

		// 总共页数
		int totalPage = stuCount % pageSize == 0 ? stuCount / pageSize : stuCount / pageSize + 1;

		// 当前页数的学生数据
		List<Student> stuDataList = dao.findStuByCurrentPage(currentPage, pageSize);

		return new Page(stuCount, currentPage, totalPage, stuDataList, pageSize);
	}
}
