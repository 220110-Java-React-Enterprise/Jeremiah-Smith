import java.sql.*;

public class UserRepo implements DataSourceCRUD<UserModel>{
    private final Connection connection;

    public UserRepo() {
        connection = ConnectionManager.getConnection();
    }

    @Override
    public UserModel create(UserModel userModel) throws SQLException {
        try {
            String sql = "INSERT INTO users (user_username, user_password) VALUES (?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, userModel.getUser_username());
            pstmt.setString(2, userModel.getUser_password());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            userModel.setUser_id(rs.getInt(1));
        }
        catch (SQLException e) {
            throw e;
        }

        return userModel;
    }

    // tester method - will not be used in p0
    // see overloaded method below
    @Override
    public UserModel read(Integer id) {
        try {

            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            UserModel model = new UserModel();
            while (rs.next()) {
                model.setUser_id(rs.getInt("user_id"));
                model.setUser_username(rs.getString("user_username"));
                model.setUser_password(rs.getString("user_password"));
            }

            return model;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // overloaded read method, taking user_username as an input parameter, instead of user_id
    // will be used to check login credentials
    // usernames must be unique
    public UserModel read(String username) {
        try {
            String sql = "SELECT * FROM users WHERE user_username = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            UserModel model = new UserModel();
            while (rs.next()) {
                model.setUser_id(rs.getInt("user_id"));
                model.setUser_username(rs.getString("user_username"));
                model.setUser_password(rs.getString("user_password"));
            }

            return model;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // will not be updating user profiles for p0
    @Override
    public UserModel update(UserModel userModel) {
        return null;
    }

    // will not be deleting user profiles for p0
    @Override
    public void delete(Integer id) {

    }
}