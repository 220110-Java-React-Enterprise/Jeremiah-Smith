// accounts POJO
public class AccountModel {
    private Integer account_id;
    private Integer user_id;
    private String account_name;
    private Double amount;

    public AccountModel() {
    }

    public AccountModel(Integer account_id, Integer user_id, String account_name, Double amount) {
        this.account_id = account_id;
        this.user_id = user_id;
        this.account_name = account_name;
        this.amount = amount;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
