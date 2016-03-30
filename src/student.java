/**
 * Created by Administrator on 2016/3/30.
 */
public class student extends user{

    private int mark;
    private int rank;
    private int classnumber;

    public student(String name, String sex, String signName, String password, int number, int mark, int rank, int classnumber) {
        super(name, sex, signName, password, number);
        this.mark = mark;
        this.rank = rank;
        this.classnumber = classnumber;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(int classnumber) {
        this.classnumber = classnumber;
    }

}
