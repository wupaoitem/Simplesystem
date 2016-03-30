/**
 * Created by Administrator on 2016/3/30.
 */
public class user {
    private String name;
    private String sex;
    private String signName;
    private String password;
    private int number;

    public user(String name, String sex, String signName, String password, int number) {
        this.name = name;
        this.sex = sex;
        this.signName = signName;
        this.password = password;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
