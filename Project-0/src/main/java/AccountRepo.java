import java.sql.*;

public class AccountRepo implements DataSourceCRUD<AccountModel>{
    private final Connection connection;

    public AccountRepo() { connection = ConnectionManager.getConnection(); }

    @Override
    public AccountModel create(AccountModel accountModel) throws SQLException {
        try {
            String sql = "INSERT INTO accounts (user_id, account_name, amount) VALUES (?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, accountModel.getUser_id());
            pstmt.setString(2, accountModel.getAccount_name());
            pstmt.setDouble(3, accountModel.getAmount());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            accountModel.setAccount_id(rs.getInt(1));
        }
        catch (SQLException e) {
            throw e;
        }

        return accountModel;
    }

    // will not be used in p0
    // see overloaded method below
    @Override
    public AccountModel read(Integer id) {
        return null;
    }

    // account names must be unique
    public AccountModel read(String account_name) {
        try {
            String sql = "SELECT * FROM accounts WHERE account_name = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, account_name);

            ResultSet rs = pstmt.executeQuery();

            AccountModel model = new AccountModel();
            while (rs.next()) {
                model.setAccount_id(rs.getInt("account_id"));
                model.setUser_id(rs.getInt("user_id"));
                model.setAccount_name(rs.getString("account_name"));
                model.setAmount(rs.getDouble("amount"));
            }

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // updating the amount only, after a withdraw or deposit
    @Override
    public AccountModel update(AccountModel accountModel) {
        try {
            String sql = "UPDATE accounts SET amount = ? WHERE account_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, accountModel.getAmount());
            pstmt.setInt(2, accountModel.getAccount_id());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountModel;
    }

    // will not be deleting accounts for p0
    @Override
    public void delete(Integer id) {

    }

    // returns accounts by username, to store in a list
    public void storeAccounts() {
        try {
            String sql = "SELECT * FROM accounts WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, DataStore.loggedInUser.getUser_id());

            ResultSet rs = pstmt.executeQuery();

            AccountModel model = new AccountModel();
            while (rs.next()) {
                model.setAccount_id(rs.getInt("account_id"));
                model.setUser_id(rs.getInt("user_id"));
                model.setAccount_name(rs.getString("account_name"));
                model.setAmount(rs.getDouble("amount"));

                DataStore.loggedInUserAccounts.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
