/**
 * Created by Administrator on 2016/3/30.
 */
public class teacher extends user {
    private String duty;
    //	private String course;
    private int teachclass;

    public teacher(String name, String sex, String signName, String password, int number, String duty ,int teachclass/*, String course*/) {
        super(name, sex, signName, password, number);
        this.duty = duty;
        this.teachclass = teachclass;
//		this.course = course;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public int getTeachclass() {
        return teachclass;
    }

    public void setTeachclass(int teachclass) {
        this.teachclass = teachclass;
    }

//	public String getCourse() {
//		return course;
//	}

//	public void setCourse(String course) {
//		this.course = course;
//	}


}
