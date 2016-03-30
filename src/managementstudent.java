/**
 * Created by Administrator on 2016/3/30.
 */
import java.util.Scanner;

public class managementstudent {
    private student []s = new student[100];
    private int flags=0;

    //计数器累加
    public void Flagssum() {
        flags++;
    }

    //测试
    public void showFlag() {
        System.out.println("test!"+flags);
    }

    //初始化
    public void newstudent(){
        s[flags] = new student(null, null, null, null, 0, 0, 0, 0);
//		System.out.println("test!"+flag);
    }

    //判断用户名是否存在
    public int searchsn(String sn){
        int pp = -1;//标志该用户信息在数组中的位置,若为-1则找不到
        String ss;
//		System.out.println("flag"+flag);
        for(int i = 0;i < flags;i++){
            ss=s[i].getSignName();
            if(ss.equals(sn)){
                pp = i;
            }
        }
        return pp;
    }

    // 注册
    public void regist(){
        newstudent();
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
        s[flags].setSignName(sn);
        System.out.println("请输入密码 ：");
        sn = scan.next();
        s[flags].setPassword(sn);
        System.out.println("请输入姓名 ：");
        sn = scan.next();
        s[flags].setName(sn);
        System.out.println("请输入性别 ：(M/F)");
        sn = scan.next();
        s[flags].setSex(sn);
        int n;
        System.out.println("请输入班级号（纯数字1-8)：");
        n = scan.nextInt();
        s[flags].setClassnumber(n);;
        System.out.println("请输入学号 ：");
        n = scan.nextInt();
        s[flags].setNumber(n);
        System.out.println("注册成功！");
//		System.out.println("请输入“1”来登录  或者“2”注册一个新用户  或者“3”退出该程序！");
    }

    // 显示消息S
    public void showifs(int i){
        System.out.println("您的信息如下：");
        System.out.println("账号：“s”"+s[i].getSignName());
        System.out.println("权限：*****学生*****");
        System.out.println("姓名："+s[i].getName());
        System.out.println("班级："+s[i].getClassnumber()+"班");
        System.out.println("学号："+s[i].getNumber());
        System.out.println("性别："+s[i].getSex());
        System.out.println();

        System.out.println("如需显示密码请输入“1”，显示结束输入“2”!");
        Scanner scan = new Scanner(System.in);
        int j = 0;
        j=scan.nextInt();
        if(j==1){
            System.out.println("密码："+s[i].getPassword());
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
        }
        else{
            System.out.println("请输入密码：");
            sn = scan.next();
            if(s[p].getPassword().equals(sn)){
                System.out.println("登录成功！");
                signWindows(p);
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
                    if(s[p].getPassword().equals(sn)){
                        k=0;
                        System.out.println("登录成功！");
                        signWindows(p);
                    }
                }
            }
        }
//		return p;
    }

    //student登录界面
    public void signWindows(int p){
        System.out.println("********************欢迎登录********************");
        System.out.println("亲爱的同学："+s[p].getName()+"您好！");
        System.out.println("输入“1”可以显示您的用户信息，输入“2”来修改密码!");
        System.out.println("输入“3”来查询课程成绩，输入“4”可以退出登录！");
        Scanner scan = new Scanner(System.in);
        for(int i = 0;i < 100;i++){
            int m;
            m = scan.nextInt();
            switch(m){
                case 1:showifs(p);break;
                case 2:changePassword(p);break;
                case 3:seekmark(p);break;
                case 4:break;
            }
            if(m==4){
                System.out.println("注销登录成功！欢迎下次使用！");
                System.out.println();
//		    	System.out.println("请输入“1”来登录  或者“2”注册一个新用户  或者“3”退出该程序！");
                break;
            }
            System.out.println("输入“1”可以显示您的用户信息，输入“2”来修改密码!");
            System.out.println("输入“3”来查询课程成绩，输入“4”可以退出登录！");
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
            s[p].setPassword(s1);
            System.out.println("修改密码成功！");
//			System.out.println("输入“1”可以显示您的用户信息，输入“2”来重新修改密码，输入“3”可以退出登录！");
        }
        else{
            System.out.println("两次输入密码不同！");
//			System.out.println("输入“1”可以显示您的用户信息，输入“2”来重新修改密码，输入“3”可以退出登录！");
        }
    }

    //成绩查询
    public void seekmark(int p){
        if(s[p].getRank()!=0){
            System.out.println("您的成绩为："+s[p].getMark());
            System.out.println("您在班级中的排名为："+s[p].getRank());
        }
        else{
            System.out.println("对不起您的老师还未输入成绩，请稍后查询！");
        }
    }

    //寻找同一个班级的学生并输出学生姓名//输入参数a是为了提高方法的复用性(a=0则进行输出，a=1则不输出）
    public void findclassmate(int cn/*,int a*/){
        int classmeatenumber = 0;//  记录班级人数
        System.out.println("班级序号："+cn);
        for(int i = 0;i < flags;i++){
            if(cn==s[i].getClassnumber()){
				/*if(a==0){*/
                System.out.println("学生姓名："+s[i].getName());
				/*}*/
                classmeatenumber++;
            }
        }
        if(classmeatenumber!=0){
            System.out.println("总人数："+classmeatenumber);
        }
        else{
            System.out.println("该班级还没有同学注册！");
        }
    }

    //输入一个班的成绩
    public  void inputclassmatemark(int cn){
        int classmeatenumber = 0;//  记录班级人数
        int []a= new int[100];//用于存放班级人员在数组中的位置
        int j = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("班级序号："+cn);
        for(int i = 0;i < flags;i++){
            if(cn==s[i].getClassnumber()){
                System.out.println("学生姓名："+s[i].getName());
                System.out.println("请输入该名学生成绩");
                s[i].setMark(scan.nextInt());
                a[j]=i;
                j++;
                classmeatenumber++;
            }
        }
//		System.out.println("test1");
        giverank(cn,a,j,classmeatenumber);
        if(classmeatenumber!=0){
            System.out.println("总人数："+classmeatenumber);
        }
        else{
            System.out.println("该班级还没有同学注册！");
        }
    }

    //班级学生成绩排名
    public void giverank(int cn,int[] a,int j,int classmeatenumber){
        int mflag=0;//标志成绩
        int []b= new int[100];
        int []c= new int[100];

//		b数组把原来的班级所有成绩取出

        for(int x = 0 ;x < j ; x++){
            b[x]=s[a[x]].getMark();
        }

//		System.out.println("test2");

//		c数组加上标记
        for(int y = 0 ;y <j ; y++){
            c[y]=s[a[y]].getMark()*100+y;
        }

//		System.out.println("test3");

//		冒泡排序1
        for(int i = 0 ;i < j ; i++){
            for(int k = 1 ; k < j ; k++){
                if(c[k]<c[k-1]){
                    mflag = c[k];
                    c[k] = c[k-1];
                    c[k-1] = mflag;
                }
            }
        }

//		冒泡排序2
        for(int e = 0 ;e < j ; e++){
            for(int r = 1 ; r < j ; r++){
                if(b[r]<b[r-1]){
                    mflag = b[r];
                    b[r] = b[r-1];
                    b[r-1] = mflag;
                }
            }
        }

//		System.out.println("test4");

//		还原排名
        for(int z = 0 ; z < j ; z++){
            c[z]=c[z]-b[z]*100;
        }

        //测试循环
//		for(int l=0 ; l < j ; l++){
//			System.out.println(c[l]);
//		}
//		System.out.println("test5");

//		给予排名
        for(int q = 0 ; q < j ; q++){
            s[c[q]].setRank(classmeatenumber);
            classmeatenumber--;
//			System.out.println("rank:"+s[c[q]].getRank());
        }

//		System.out.println("test6");

    }

    //查看一个班的成绩并输出平均分
    public void outclassmark(int cn){
        int classmeatenumber = 0;//  记录班级人数
        int classmark = 0;//记录班级总分
        int em;//储存平均分
        System.out.println("班级序号："+cn);
        for(int i = 0;i < flags;i++){
            if(cn==s[i].getClassnumber()){
                System.out.print("学生姓名："+s[i].getName());
                System.out.print("     成绩"+s[i].getMark());
                System.out.println("     名次"+s[i].getRank());
                classmark=classmark+s[i].getMark();
                classmeatenumber++;
            }
        }
        if(classmeatenumber!=0){
            System.out.println("总人数："+classmeatenumber);
            em=classmark/classmeatenumber;
            System.out.println("平均成绩（舍去小数）："+em);
        }
        else{
            System.out.println("该班级还没有同学注册！");
        }
    }

    //getter and setter
    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public student[] getS() {
        return s;
    }

    public void setS(student[] s) {
        this.s = s;
    }
}
