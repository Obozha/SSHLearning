package cc.sms.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cc.sms.bean.Student;
import cc.sms.dao.Page;
import cc.sms.dao.Impl.StudentDaoImpl;
import cc.sms.service.impl.StudentServiceImpl;

public class JunitTest {

	@Test
	public void test() {
		try {
			Student stu = StudentDaoImpl.getStudentDaoImpl().findStuByID("1");
			System.out.println(stu.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
