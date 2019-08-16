package spring.dao;

public interface UserDao {
    void printfUser();
    void findUser();
    void add();
    void update();
    void delete();
    void transferAccounts(double money);
}
