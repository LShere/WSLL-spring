package spring.pojo;

public class User {
    private String openid;
    private String nickname;
    public User(){}
    public User(String openid, String nickname){
        this.openid = openid;
        this.nickname = nickname;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
