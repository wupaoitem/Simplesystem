/**
 * Created by Administrator on 2016/3/30.
 */
import java.util.Scanner;

public class managementuser {
    private user []u = new user[100];
    private int flag=0;

    //计数器累加
    public void Flagsum() {
        flag++;
    }

    //测试
    public void showFlag() {
        System.out.println("test!"+flag);
    }

    //初始化
    public void newuser(){
        u[flag] = new user(null, null, null, null, 0);
//		System.out.println("test!"+flag);
    }

    //判断用户名是否存在
    public int searchsn(String sn){
        int pp = -1;//标志该用户信息在数组中的位置,若为-1则找不到
        String ss;
//		System.out.println("flag"+flag);
        for(int i = 0;i < flag;i++){
            ss=u[i].getSignName();
            if(ss.equals(sn)){
                pp = i;
            }
        }
        return pp;
    }

    // 注册
    public void regist(){
        newuser();
        Scanner scan = new Scanner(System.in);
        String sn = null;
        int t=0;
        System.out.println("请输入新用户名 ：");
        while(t!=-1){
            sn = scan.next();
            t=this.searchsn(sn);
            if(t!=-1){
                System.out.println("用户名已被使用！");
                System.out.println("请重新入用户名：");
            }
            else{
                System.out.println("用户名可以使用！");
            }
        }
        u[flag].setSignName(sn);
        System.out.println("请输入密码 ：");
        sn = scan.next();
        u[flag].setPassword(sn);
        System.out.println("请输入姓名 ：");
        sn = scan.next();
        u[flag].setName(sn);
        System.out.println("请输入性别 ：(M/F)");
        sn = scan.next();
        u[flag].setSex(sn);
        int n;
        System.out.println("请输入编号 ：");
        n = scan.nextInt();
        u[flag].setNumber(n);
        System.out.println("注册成功！");
//		System.out.println("请输入“1”来登录  或者“2”注册一个新用户  或者“3”退出该程序！");
    }

    // 显示消息U
    public void showif(int i){
        System.out.println("您的信息如下：");
        System.out.println("账号：“u”"+u[i].getSignName());
        System.out.println("权限：*****普通用户*****");
        System.out.println("姓名："+u[i].getName());
        System.out.println("编号："+u[i].getNumber());
        System.out.println("性别："+u[i].getSex());
        System.out.println();

        System.out.println("如需显示密码请输入“1”，显示结束输入“2”!");
        Scanner scan = new Scanner(System.in);
        int j = 0;
        j=scan.nextInt();
        if(j==1){
            System.out.println("密码："+u[i].getPassword());
        }
    }

    //登录
    public void sign(){
        System.out.println("请输入用户名：");
        Scanner scan = new Scanner(System.in);
        String sn;
        sn = scan.next();
//		System.out.println("sn"+sn);
        int p;
        p=this.searchsn(sn);
        if(p==-1){
            System.out.println("该用户不存在！");
//			System.out.println("请输入“1”重新登录  或者“2”注册一个新用户  或者“3”退出该程序！");
        }
        else{
            System.out.println("请输入密码：");
            sn = scan.next();
            if(u[p].getPassword().equals(sn)){
                System.out.println("登录成功！");
                signWindow(p);
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
                    if(u[p].getPassword().equals(sn)){
                        k=0;
                        System.out.println("登录成功！");
                        signWindow(p);
                    }
                }
            }
        }
//		return p;
    }

    //user登录界面
    public void signWindow(int p){
        System.out.println("********************欢迎登录********************");
        System.out.println("亲爱的用户："+u[p].getName()+"您好！");
        System.out.println("输入“1”可以显示您的用户信息，输入“2”来修改密码，输入“3”可以退出登录！");
        Scanner scan = new Scanner(System.in);
        for(int i = 0;i < 100;i++){
            int m;
            m = scan.nextInt();
            switch(m){
                case 1:showif(p);break;
                case 2:changePassword(p);break;
                case 3:break;
            }
            if(m==3){
                System.out.println("注销登录成功！欢迎下次使用！");
                System.out.println();
//		    	System.out.println("请输入“1”来登录  或者“2”注册一个新用户  或者“3”退出该程序！");
                break;
            }
            System.out.println("输入“1”可以显示您的用户信息，输入“2”来修改密码，输入“3”可以退出登录！");
        }
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
            u[p].setPassword(s1);
            System.out.println("修改密码成功！");
//			System.out.println("输入“1”可以显示您的用户信息，输入“2”来重新修改密码，输入“3”可以退出登录！");
        }
        else{
            System.out.println("两次输入密码不同！");
//			System.out.println("输入“1”可以显示您的用户信息，输入“2”来重新修改密码，输入“3”可以退出登录！");
        }
    }

    //getter and setter
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

