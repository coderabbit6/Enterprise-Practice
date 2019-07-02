package com.stmcc.test.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stmcc.test.PageModel;
import com.stmcc.test.Student;

/*
 * 底层操作数据库执行SQL语句
 * 如下方法：
 * 1.查找记录返回结果集
 * 2.页面总记录数
 */
public class StuManager {

	private static StuManager instance = new StuManager();

	private StuManager() {

	}

	public static StuManager getInstance() {
		return instance;
	}

	// 返回分页的结果集

	public PageModel findStudentList(int pageNo, int pageSize) {
		PageModel pageModel = null;
		String sql = "select s_id,s_name,s_age,s_sex,s_class from t_student limit ?,?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Student> stulist;
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo - 1) * pageSize);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			stulist = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setS_id(rs.getString("s_id"));
				stu.setS_name(rs.getString("s_name"));
				stu.setS_age(rs.getString("s_age"));
				stu.setS_sex(rs.getString("s_sex"));
				stu.setS_class(rs.getString("s_class"));
				stulist.add(stu);
			}
			pageModel = new PageModel();
			pageModel.setList(stulist);
			pageModel.setTotalRecords(getTotalCount(conn));
			pageModel.setPageSize(pageSize);
			pageModel.setPageNo(pageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}

		return pageModel;
	}

	public int getTotalCount(Connection conn) {
		String sql = "select count(*) from t_student";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
		return count;

	}

}
