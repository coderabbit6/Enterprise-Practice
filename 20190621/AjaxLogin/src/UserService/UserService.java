package UserService;

import java.sql.ResultSet;

public interface UserService {
	public ResultSet loginUser(String userName, String password);
}
