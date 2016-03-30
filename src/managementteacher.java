/**
 * Created by Administrator on 2016/3/30.
 */
import java.util.Scanner;

public class managementteacher {
    private teacher []t = new teacher[100];
    private int flagt=0;

    //计数器累加
    public void Flagtsum() {
        flagt++;
    }

    //测试
    public void showFlagt() {
        System.out.println("test!"+flagt);
    }

    //初始化
    public void newteacher(){
        t[flagt] = new teacher(null, null, null, null, 0, null, 0);
//		System.out.println("test!"+flagt);
    }

    //判断用户名是否存在
    public int searchsn(String sn){
        int pp = -1;//标志该用户信息在数组中的位置,若为-1则找不到
        String ss;
//		System.out.println("flag"+flag);
        for(int i = 0;i < flagt;i++){
            ss=t[i].getSignName();
            if(ss.equals(sn)){
                pp = i;
            }
        }
        return pp;
    }

    // 注册
    public void regist(){
        newteacher();
        Scanner scan = new Scanner(System.in);
        String sn = null;
        int s=0;
        System.out.println("请输入新用户名 ：");
        while(s!=-1){
            sn = scan.next();
            s=this.searchsn(sn);
            if(s!=-1){
                System.out.println("用户名已被使用！");
                System.out.println("请重新入用户名：");
            }
            else{
                System.out.println("用户名可以使用！");
            }
        }
        t[flagt].setSignName(sn);
        System.out.println("请输入密码 ：");
        sn = scan.next();
        t[flagt].setPassword(sn);
        System.out.println("请输入姓名 ：");
        sn = scan.next();
        t[flagt].setName(sn);
        System.out.println("请输入性别 ：(M/F)");
        sn = scan.next();
        t[flagt].setSex(sn);
        System.out.println("请输入职务 ：(教授/助教/讲师)");
        sn = scan.next();
        t[flagt].setDuty(sn);;
        int n;
        System.out.println("请输入教职员编号 ：");
        n = scan.nextInt();
        t[flagt].setNumber(n);
        System.out.println("请输入任课班级 ：");
        n = scan.nextInt();
        t[flagt].setTeachclass(n);
        System.out.println("注册成功！");
//		System.out.println("请输入“1”来登录  或者“2”注册一个新用户  或者“3”退出该程序！");
    }

    // 显示消息T
    public void showift(int i){
        System.out.println("您的信息如下：");
        System.out.println("账号：“t”"+t[i].getSignName());
        System.out.println("权限：*****教师*****");
        System.out.println("姓名："+t[i].getName());
        System.out.println("教职员编号："+t[i].getNumber());
        System.out.println("职务："+t[i].getDuty());
        System.out.println("任课班级："+t[i].getTeachclass());
        System.out.println("性别："+t[i].getSex());
        System.out.println();

        System.out.println("如需显示密码请输入“1”，显示结束输入“2”!");
        Scanner scan = new Scanner(System.in);
        int j = 0;
        j=scan.nextInt();
        if(j==1){
            System.out.println("密码："+t[i].getPassword());
        }
    }

    //登录(传递一个学生数组进去便于成绩输入和查询)
    public void sign(managementstudent ms){
        System.out.println("请输入用户名：");
        Scanner scan = new Scanner(System.in);
        String sn;
        sn = scan.next();
//		System.out.println("sn"+sn);
        int p;
        p=this.searchsn(sn);
        if(p==-1){
            System.out.println("该用户不存在！");
        }
        else{
            System.out.println("请输入密码：");
            sn = scan.next();
            if(t[p].getPassword().equals(sn)){
                System.out.println("登录成功！");
                signWindowt(p, ms);
            }
            else{
                int k=1;
                while(k!=0){
                    System.out.println("密码错误！请重新输入密码：或者输入“3”来取消登录");
                    sn = scan.next();
                    if(sn.equals("3")){
//						System.out.println("请输入“1”来登录  或者“2”注册一个新用户  或者“3”退出该程序！");
                        break;
                    }
                    if(t[p].getPassword().equals(sn)){
                        k=0;
                        System.out.println("登录成功！");
                        signWindowt(p,ms);
                    }
                }
            }
        }
//		return p;
    }

    //teacher登录界面
    public void signWindowt(int p,managementstudent ms){
        System.out.println("********************欢迎登录********************");
        System.out.println("亲爱的老师："+t[p].getName()+"您好！");
        System.out.println("输入“1”可以显示您的用户信息，输入“2”来修改密码!");
        System.out.println("输入“3”可以查看班级学生，输入“4”可以输入学生成绩，并排名!!");
        System.out.println("输入“5”可以查看班级成绩单和平均分，输入“6”可以退出登录！");
        Scanner scan = new Scanner(System.in);
        for(int i = 0;i < 100;i++){
            int m;
            m = scan.nextInt();
            switch(m){
                case 1:showift(p);break;
                case 2:changePassword(p);break;
                case 3:seekstudent(p,ms);break;
                case 4:inputstudentmark(p,ms);break;
                case 5:seeclassmark(p,ms);break;
                case 6:break;
            }
            if(m==6){
                System.out.println("注销登录成功！欢迎下次使用！");
                System.out.println();
//		    	System.out.println("请输入“1”来登录  或者“2”注册一个新用户  或者“3”退出该程序！");
                break;
            }
            System.out.println("输入“1”可以显示您的用户信息，输入“2”来修改密码!");
            System.out.println("输入“3”可以查看班级学生，输入“4”可以输入本班学生成绩，并排名!");
            System.out.println("输入“5”可以查看班级成绩单和平均分，输入“6”可以退出登录！");
        }
    }

    //查询本班学生姓名
    public void seekstudent(int p, managementstudent ms){
        ms.findclassmate(t[p].getTeachclass());
    }

    //输入本班学生成绩，并排名
    public void inputstudentmark(int p,managementstudent ms){
        ms.inputclassmatemark(t[p].getTeachclass());
    }

    //查看班级成绩单和平均分
    public void seeclassmark(int p,managementstudent ms){
        ms.outclassmark(t[p].getTeachclass());
    }

    //修改密码
    public void changePassword(int p){
        System.out.println("请输入新密码：");
        Scanner scan = new Scanner(System.in);
        String s1;
        s1=scan.next();
        System.out.println("请再次输入密码：");
        String s2;
        s2=scan.next();
        if(s1.equals(s2)){
            t[p].setPassword(s1);
            System.out.println("修改密码成功！");
//			System.out.println("输入“1”可以显示您的用户信息，输入“2”来重新修改密码，输入“3”可以退出登录！");
        }
        else{
            System.out.println("两次输入密码不同！");
//			System.out.println("输入“1”可以显示您的用户信息，输入“2”来重新修改密码，输入“3”可以退出登录！");
        }
    }

    //getter and setter
    public int getFlagt() {
        return flagt;
    }

    public void setFlagt(int flagt) {
        this.flagt = flagt;
    }
}
