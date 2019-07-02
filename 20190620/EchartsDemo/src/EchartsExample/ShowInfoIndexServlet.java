package EchartsExample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ShowInfoIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 设定客户端提交给servlet的内容按UTF-8编码
		response.setCharacterEncoding("UTF-8"); // 设定servlet传回给客户端的内容按UTF-8编码
		response.setContentType("text/html;charset=UTF-8"); // 告知浏览器用UTF-8格式解析内容
		String name = request.getParameter("name"); // 获取台站名参数
		// 获取当天在内的五天以前的0点格式字符串（用于数据库查询）
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -8); // 获取当天在内的五天以前的日期时间
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00"); // 设定日期格式
		String fiveDaysAgoStr = sdf1.format(cal.getTime()); // 将五天前的日期时间按指定格式转换成字符串
		// 获取当前时间并将其转换成指定格式的字符串（用于数据库查询）
		Date now = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowStr = sdf2.format(now);
		// ======================================连接数据库操作============================================================================================
		/*
		 * 连接数据库并获取五天内该名称的气象站的所有采集数据
		 */
		List<Record> records = new ArrayList<Record>(); // 用一个ArrayList来盛装封装了各气象数据的对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection(); // 获取与数据库的连接
			String sql = "select * from alldata where data_taizhan_num = ? and data_date >= ? and data_date <= ? order by data_date asc"; // 初始化SQL查询语句
			pstmt = conn.prepareStatement(sql); // 创建preparedStatement语句对象
			pstmt.setString(1, name); // 设定查询参数
			pstmt.setString(2, fiveDaysAgoStr);
			pstmt.setString(3, nowStr);
			rs = pstmt.executeQuery(); // 获取查询到的结果集
			while (rs.next()) {
				// 封装Record对象
				Record r = new Record();
				r.setTaizhan_num(rs.getString("data_taizhan_num"));
				r.setDate(rs.getTimestamp("data_date"));
				r.setTem(rs.getString("tem"));
				r.setHum(rs.getString("hum"));
				r.setPa(rs.getString("pa"));
				r.setRain(rs.getString("rain"));
				r.setWin_dir(rs.getString("win_dir"));
				r.setWin_sp(rs.getString("win_sp"));
				// 将时间转换成给定格式便于echarts的X轴日期坐标显示
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String str = sdf.format(rs.getTimestamp("data_date"));
				r.setDateStr(str);
				records.add(r); // 将封装好的Record对象放入列表容器中
			}

		} catch (SQLException e) {
			System.out.println("查询出错，操作未完成!");
			e.printStackTrace();
		} finally {
			// 查询结束后释放资源
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		// ======================================连接数据库操作（完）============================================================================================

		// 将list中的对象转换为Json格式的数组
		Gson gson = new Gson();
		String json = gson.toJson(records);
		System.out.println(json);
		// 将json数据返回给客户端
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().write(json);
	}
}
