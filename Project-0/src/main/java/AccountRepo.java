import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRepo implements DataSourceCRUD<AccountModel>{
    private final Connection connection;

    public AccountRepo() { connection = ConnectionManager.getConnection(); }

    @Override
    public AccountModel create(AccountModel accountModel) {
        try {
            String sql = "INSERT INTO accounts (user_id, account_name, amount) VALUES (?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, accountModel.getUser_id());
            pstmt.setString(2, accountModel.getAccount_name());
            pstmt.setDouble(3, accountModel.getAmount());

            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return accountModel;
    }

    // will not be used in p0
    // see overloaded method below
    @Override
    public AccountModel read(Integer id) {
        return null;
    }

    public AccountModel read(String account_name) {
        return null;
    }

    @Override
    public AccountModel update(AccountModel accountModel) {
        return null;
    }

    // will not be deleting accounts for p0
    @Override
    public void delete(Integer id) {

    }
}
