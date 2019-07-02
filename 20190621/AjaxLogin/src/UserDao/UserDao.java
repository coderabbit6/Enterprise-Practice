package UserDao;

import java.sql.ResultSet;

public interface UserDao {
	public ResultSet findByNameAndPassword(String username, String password);
}
