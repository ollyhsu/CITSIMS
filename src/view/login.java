package view;

import java.util.Scanner;

import model.User;
import service.MangerService;
import service.UserService;

public class login {
	public static void main(String[] args) {
		// welcome();
		login();
	}

	public static void welcome() {
		System.out.println("***********欢迎使用CIT学生信息管理系统***********");
		System.out.println("使用声明:");
		System.out.println("1.欢迎您选择CIT学生信息管理系统");
		System.out.println("2.使用本系统前请先创建MySQL数据库");
		System.out.println("3.导入database目录下的SQL脚本");
		System.out.println("4.更多说明请查阅README.md");
		System.out.println("5.尊重原创，严禁倒卖");
		// System.out.println("设计者:KimiX 时间:2020年7月");
	}

	public static void login() {
		UserService uService = new UserService();
		MangerService mService = new MangerService();
		// 输入
		Scanner scan = new Scanner(System.in);
		// 判断退出条件
		while (true) {
			System.out.println("***********欢迎使用CIT学生信息管理系统***********");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.登录\t2.注册\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 用户登录
				User user = uService.login();
				if (user != null) {
					// System.out.println("用户登录成功:"+user);
					if (user.getuType() == 0) {
						// System.out.println("普通用户");
						uService.customer(user);
					} else {
						// System.out.println("管理员");
						mService.manger();
					}
				} else {
					System.out.println("用户登录失败，请检查用户名和密码!");
				}
				break;
			case "2":
				// 用户注册
				uService.userRegist();
				break;
			case "Q":
			case "q":
				System.out.println("退出成功,欢迎下次使用~");
				System.exit(0);
				break;
			default:
				System.out.println("您的输入有误！");
				break;
			}
		}
	}
}
