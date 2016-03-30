/**
 * Created by Administrator on 2016/3/30.
 */
//System.out.println("功能尚未开放，敬请期待！")
import java.util.Scanner;

public class maintest {
    //主界面
    public static void mainwindow(){
        System.out.println("********************欢迎使用********************");
        System.out.println("*                                              *");
        System.out.println("*     输入功能菜单： 1：登录                   *");
        System.out.println("*                    2：注册                   *");
        System.out.println("*                    3: 查看功能介绍           *");
        System.out.println("*                    4: 退出                   *");
        System.out.println("*                                              *");
        System.out.println("*          请继续输入指令来运行程序！          *");
        System.out.println("************************************************");
        managementuser mu = new managementuser();
        managementteacher mt = new managementteacher();
        managementstudent ms = new managementstudent();
        Scanner scan = new Scanner(System.in);
        int a ;//用户输入的标识符
//		int as=0;//用于储存登录成功后用户信息的位置(V.01)
        for(int i = 0; i < 100;i++){
            a = scan.nextInt();
            switch(a){
                case 1:/*m.showFlag();*/mainsignwindow(mu,mt,ms);break;
                case 2:/*mu.regist();mu.Flagsum()*/mainregistwindow(mu,mt,ms);break;
                case 3:justsoso();break;
                case 4:break;
            }
            if(a==4){
                System.out.println("********************感谢使用********************");
                System.out.println("                                    版本号：V.003");
                System.out.println("                                    作者：童天航 ");
                System.out.println("                                    QQ：530417595");
                break;
            }
        }
    }

    //用户主登录界面
    public static void mainsignwindow(managementuser mu,managementteacher mt,managementstudent ms){
//		managementuser mu = new managementuser();
//		managementteacher mt = new managementteacher();
//		managementstudent ms = new managementstudent();
        System.out.println("普通用户登录请输入“1”");
        System.out.println("教师用户登录请输入“2”");
        System.out.println("学生用户登录请输入“3”");
        System.out.println("取消登录请输入“4”");
        Scanner scan = new Scanner(System.in);
        int a;
        for(int i = 0; i < 100;i++){
            a = scan.nextInt();
            switch(a){
                case 1:mu.sign();a=4;break;
                case 2:mt.sign(ms);a=4;break;
                case 3:ms.sign();a=4;break;
                case 4:break;
            }
            if(a==4){
                System.out.println("请输入“1”来登录  或者“2”注册一个新用户  或者“3”来查看功能介绍 或者“4”退出该程序！");
                break;
            }
        }
    }

    //用户注册主界面
    public static void mainregistwindow(managementuser mu,managementteacher mt,managementstudent ms){
//		managementuser mu = new managementuser();
//		managementteacher mt = new managementteacher();
//		managementstudent ms = new managementstudent();
        System.out.println("普通用户注册请输入“1”");
        System.out.println("教师用户注册请输入“2”");
        System.out.println("学生用户注册请输入“3”");
        System.out.println("取消注册请输入“4”");
        Scanner scan = new Scanner(System.in);
        int a;
        for(int i = 0; i < 100;i++){
            a = scan.nextInt();
            switch(a){
                case 1:mu.regist();mu.Flagsum();a=4;break;
                case 2:mt.regist();mt.Flagtsum();;a=4;break;
                case 3:ms.regist();ms.Flagssum();a=4;break;
                case 4:break;
            }
            if(a==4){
                System.out.println("请输入“1”来登录  或者“2”注册一个新用户  或者“3”来查看功能介绍 或者“4”退出该程序！");
                break;
            }
        }
    }

    //功能介绍
    public static void justsoso(){
        System.out.println("此软件是作者用两个下午编写的第一个java程序其主要功能如下：");
        System.out.println("1:这是一个最简版的学生成绩管理系统，里面由普通用户，老师，学生三种类型的账户组成。（普通用户为最早测试使用和父类）");
        System.out.println("2：普通用户可以进行登录、注册、查看个人信息和修改密码。");
        System.out.println("3：学生用户可以进行上述功能外还能查询自己的成绩，排名。");
        System.out.println("4：教师用户登录后可以查看授课班级内的学生，输入班级学生的课程成绩，查看班级学生成绩并求平均分。");
        System.out.println("5：其他尚未开发功能！（一些细节上的输入判断还没做，图形界面敬请期待~~~）");
        System.out.println();
        System.out.println("请输入“1”来登录  或者“2”注册一个新用户  或者“3”来查看功能介绍 或者“4”退出该程序！");
    }
    public static void main(String[] args) {
        mainwindow();
    }

}
