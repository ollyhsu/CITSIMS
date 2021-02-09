package service;

import java.util.List;
import java.util.Scanner;

import dao.ClassDao;
import dao.CourseDao;
import dao.DepartDao;
import dao.ScoreDao;
import dao.SpecDao;
import dao.StudentDao;
import dao.UserDao;
import model.Classes;
import model.Course;
import model.Depart;
import model.Score;
import model.Spec;
import model.Student;
import model.User;

public class UserService {
	// 用户注册
	public void userRegist() {
		UserDao userDao = new UserDao();
		// 输入
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("***********欢迎使用CIT学生信息管理系统***********");
			System.out.println("1.确认注册\t0.返回上一层");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				System.out.println("请输入用户名：");
				String uname = scan.next();
				System.out.println("请输入密码：");
				String upwd = scan.next();
				int num = userDao.addUser(uname, upwd);
				if (num > 0) {
					System.out.println("恭喜您注册成功~");
				} else {
					System.out.println("注册失败~");
				}
				break;
			case "0":
				flag = false;
				break;
			default:
				System.out.println("您的输入有误!");
				break;
			}
			break;
		}
	}

	// 用户登录
	public User login() {
		UserDao userDao = new UserDao();
		// 输入
		Scanner scan = new Scanner(System.in);
		System.out.println("***********欢迎使用CIT学生信息管理系统***********");
		System.out.print("请输入登录账号：");
		String uname = scan.next();
		System.out.print("请输入登录密码：");
		String upwd = scan.next();
		User user = userDao.selectUserByNamePwd(uname, upwd);
		return user;
	}

	// 普通用户后台管理界面
	public void customer(User user) {
		MangerService mService = new MangerService();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		// System.out.println(user);
		while (flag) {
			System.out.println("***********欢迎使用CIT学生信息管理系统***********");
			System.out.println("您未具有管理员权限，仅有查询权限!!!");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.查询院系\t2.查询专业\t3.查询班级");
			System.out.println("4.查询学生\t5.查询课程\t6.查询成绩");
			System.out.println("7.修改个人密码\t0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 查询院系
				userShowAllDeparts();
				break;
			case "2":
				// 查询专业
				userShowAllSpecs();
				break;
			case "3":
				// 查询班级
				userShowClasses();
				break;
			case "4":
				// 查询学生
				userShowStudents();
				break;
			case "5":
				// 查询课程
				userShowAllCourses();
				break;
			case "6":
				// 查询成绩
				userShowScores();
				break;
			case "7":
				// 修改个人密码
				modifyMyPwd(user);
				break;
			case "0":
				// 返回上一层
				flag = false;
				break;
			case "Q":
			case "q":
				System.out.println("退出成功,欢迎下次使用~");
				System.exit(0);
				break;
			default:
				System.out.println("您的输入有误");
				break;
			}
		}
	}

	// 查询成绩
	private void userShowScores() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("**************欢迎进入成绩查询模块**************");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.查看所有成绩\t2.按姓名查找成绩\t3.按课程查看成绩");
			System.out.println("4.按班级查看成绩\t5.按专业查看成绩");
			System.out.println("0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 查看所有成绩
				userShowAllScores();
				break;
			case "2":
				// 按姓名查找成绩
				userShowScoresByName();
				break;
			case "3":
				// 按课程查看成绩
				userShowScoresByCourse();
				break;
			case "4":
				// 按班级查看成绩
				userShowScoresByClass();
				break;
			case "5":
				// 按专业查看成绩
				userShowScoresBySpec();
				break;
			case "0":
				// 返回上一层
				flag = false;
				break;
			case "Q":
			case "q":
				// 退出系统
				System.out.println("退出成功,欢迎下次使用~");
				System.exit(0);
				break;
			default:
				System.out.println("您的输入有误!");
				break;
			}
		}
	}

	// 按专业查看成绩
	public void userShowScoresBySpec() {
		ScoreDao scoreDao = new ScoreDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有专业信息:");
		System.out.println("---------------------------------------------");
		userShowAllSpecs();
		System.out.println("---------------------------------------------");
		System.out.println("确认查询请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入专业ID:");
				int specID = scan.nextInt();
				System.out.print("请选择[1]降序输出 or [2]升序输出成绩:");
				String pxchoose = scan.next();
				switch (pxchoose) {
				case "1":
					// 降序输出专业成绩
					List<Score> scoList = scoreDao.selectScoresBySpecDesc(specID);
					for (Score sco : scoList) {
						System.out.println(sco);
					}
					System.out.println("请选择是否继续查询:1.是\t0.否");
					System.out.print("请选择您的操作：");
					String input = scan.next();
					switch (input) {
					case "1":
						break;
					case "0":
						flag = false;
						break;
					default:
						System.out.println("您的输入有误!");
						flag = false;
						break;
					}
					break;
				case "2":
					// 升序输出专业成绩
					List<Score> scoListAsc = scoreDao.selectScoresBySpecAsc(specID);
					for (Score sco : scoListAsc) {
						System.out.println(sco);
					}
					System.out.println("请选择是否继续查询:1.是\t0.否");
					System.out.print("请选择您的操作：");
					String inputasc = scan.next();
					switch (inputasc) {
					case "1":
						break;
					case "0":
						flag = false;
						break;
					default:
						System.out.println("您的输入有误!");
						flag = false;
						break;
					}
					break;
				default:
					System.out.println("您的输入有误!");
					break;
				}
			}
			break;
		case "0":
			System.out.println("您已取消查询!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 按班级查看成绩
	public void userShowScoresByClass() {
		ScoreDao scoreDao = new ScoreDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有班级信息:");
		System.out.println("---------------------------------------------");
		userShowAllClasses();
		System.out.println("---------------------------------------------");
		System.out.println("确认查询请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入班级ID:");
				int classID = scan.nextInt();
				System.out.print("请选择[1]降序输出 or [2]升序输出成绩:");
				String pxchoose = scan.next();
				switch (pxchoose) {
				case "1":
					// 降序输出班级成绩
					List<Score> scoList = scoreDao.selectScoresByClassDesc(classID);
					for (Score sco : scoList) {
						System.out.println(sco);
					}
					System.out.println("请选择是否继续查询:1.是\t0.否");
					System.out.print("请选择您的操作：");
					String input = scan.next();
					switch (input) {
					case "1":
						break;
					case "0":
						flag = false;
						break;
					default:
						System.out.println("您的输入有误!");
						flag = false;
						break;
					}
					break;
				case "2":
					// 升序输出班级成绩
					List<Score> scoListAsc = scoreDao.selectScoresByClassAsc(classID);
					for (Score sco : scoListAsc) {
						System.out.println(sco);
					}
					System.out.println("请选择是否继续查询:1.是\t0.否");
					System.out.print("请选择您的操作：");
					String inputasc = scan.next();
					switch (inputasc) {
					case "1":
						break;
					case "0":
						flag = false;
						break;
					default:
						System.out.println("您的输入有误!");
						flag = false;
						break;
					}
					break;
				default:
					System.out.println("您的输入有误!");
					break;
				}
			}
			break;
		case "0":
			System.out.println("您已取消查询!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 按课程查看成绩
	public void userShowScoresByCourse() {
		ScoreDao scoreDao = new ScoreDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有课程信息:");
		System.out.println("---------------------------------------------");
		userShowAllCourses();
		System.out.println("---------------------------------------------");
		System.out.println("确认查询请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入课程ID:");
				int courseID = scan.nextInt();
				System.out.print("请选择[1]降序输出 or [2]升序输出成绩:");
				String pxchoose = scan.next();
				switch (pxchoose) {
				case "1":
					// 降序输出课程成绩
					List<Score> scoList = scoreDao.selectScoresByCourseDesc(courseID);
					for (Score sco : scoList) {
						System.out.println(sco);
					}
					System.out.println("请选择是否继续查询:1.是\t0.否");
					System.out.print("请选择您的操作：");
					String input = scan.next();
					switch (input) {
					case "1":
						break;
					case "0":
						flag = false;
						break;
					default:
						System.out.println("您的输入有误!");
						flag = false;
						break;
					}
					break;
				case "2":
					// 升序输出成绩
					List<Score> scoListAsc = scoreDao.selectScoresByCourseAsc(courseID);
					for (Score sco : scoListAsc) {
						System.out.println(sco);
					}
					System.out.println("请选择是否继续查询:1.是\t0.否");
					System.out.print("请选择您的操作：");
					String inputasc = scan.next();
					switch (inputasc) {
					case "1":
						break;
					case "0":
						flag = false;
						break;
					default:
						System.out.println("您的输入有误!");
						flag = false;
						break;
					}
					break;
				default:
					System.out.println("您的输入有误!");
					break;
				}
			}
			break;
		case "0":
			System.out.println("您已取消查询!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}

	}

	// 按姓名查找成绩
	public void userShowScoresByName() {
		ScoreDao scoreDao = new ScoreDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("确认查询请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入学生姓名:");
				String stuName = scan.next();
				List<Score> scoList = scoreDao.selectScoresByName(stuName);
				for (Score sco : scoList) {
					System.out.println(sco);
				}
				System.out.println("请选择是否继续查询:1.是\t0.否");
				System.out.print("请选择您的操作：");
				String input = scan.next();
				switch (input) {
				case "1":
					break;
				case "0":
					flag = false;
					break;
				default:
					System.out.println("您的输入有误!");
					flag = false;
					break;
				}
			}
			break;
		case "0":
			System.out.println("您已取消查询!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 查看所有成绩
	public void userShowAllScores() {
		ScoreDao scoreDao = new ScoreDao();
		List<Score> scoList = scoreDao.selectAllScores();
		for (Score sco : scoList) {
			System.out.println(sco);
		}
	}

	// 查询课程
	private void userShowAllCourses() {
		CourseDao courseDao = new CourseDao();
		List<Course> courseList = courseDao.selectAllCourses();
		for (Course course : courseList) {
			System.out.println(course);
		}
	}

	// 查询学生
	private void userShowStudents() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("**************欢迎进入学生查询模块**************");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.查看所有学生\t2.按班级查看学生\t3.按专业查看学生");
			System.out.println("4.按学院查看学生\t5.按姓名查看学生\t6.按学号查看学生");
			System.out.println("0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 查看所有学生
				userShowAllStudents();
				break;
			case "2":
				// 按班级查看学生
				userShowStuByClass();
				break;
			case "3":
				// 按专业查看学生
				userShowStuBySpec();
				break;
			case "4":
				// 按学院查看学生
				userShowStuByDepart();
				break;
			case "5":
				// 按姓名查看学生
				userShowStuByName();
				break;
			case "6":
				// 按学号查看学生
				userShowStuByID();
				break;
			case "0":
				// 返回上一层
				flag = false;
				break;
			case "Q":
			case "q":
				// 退出系统
				System.out.println("退出成功,欢迎下次使用~");
				System.exit(0);
				break;
			default:
				System.out.println("您的输入有误!");
				break;
			}
		}
	}

	// 按学号查看学生
	public void userShowStuByID() {
		StudentDao studentDao = new StudentDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("确认查询请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入学生ID:");
				int stuId = scan.nextInt();
				List<Student> stuList = studentDao.selectStuById(stuId);
				for (Student stu : stuList) {
					System.out.println(stu);
				}
				System.out.println("请选择是否继续查询:1.是\t0.否");
				System.out.print("请选择您的操作：");
				String input = scan.next();
				switch (input) {
				case "1":
					break;
				case "0":
					flag = false;
					break;
				default:
					System.out.println("您的输入有误!");
					flag = false;
					break;
				}
			}
			break;
		case "0":
			System.out.println("您已取消查询!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}

	}

	// 按姓名查找学生
	public void userShowStuByName() {
		StudentDao studentDao = new StudentDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("确认查询请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入学生姓名:");
				String stuName = scan.next();
				List<Student> stuList = studentDao.selectStuByName(stuName);
				for (Student stu : stuList) {
					System.out.println(stu);
				}
				System.out.println("请选择是否继续查询:1.是\t0.否");
				System.out.print("请选择您的操作：");
				String input = scan.next();
				switch (input) {
				case "1":
					break;
				case "0":
					flag = false;
					break;
				default:
					System.out.println("您的输入有误!");
					flag = false;
					break;
				}
			}
			break;
		case "0":
			System.out.println("您已取消查询!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}

	}

	// 按学院查看学生
	public void userShowStuByDepart() {
		StudentDao studentDao = new StudentDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有的院系信息:");
		System.out.println("---------------------------------------------");
		userShowAllDeparts();
		System.out.println("---------------------------------------------");
		System.out.println("确认查询请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入院系ID:");
				int departID = scan.nextInt();
				List<Student> stuList = studentDao.selectStuByDepartID(departID);
				for (Student stu : stuList) {
					System.out.println(stu);
				}
				System.out.println("请选择是否继续查询:1.是\t0.否");
				System.out.print("请选择您的操作：");
				String input = scan.next();
				switch (input) {
				case "1":
					break;
				case "0":
					flag = false;
					break;
				default:
					System.out.println("您的输入有误!");
					flag = false;
					break;
				}
			}
			break;
		case "0":
			System.out.println("您已取消查询!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 按专业查看学生
	public void userShowStuBySpec() {
		StudentDao studentDao = new StudentDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有的专业信息:");
		System.out.println("---------------------------------------------");
		userShowAllSpecs();
		System.out.println("---------------------------------------------");
		System.out.println("确认查询请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入专业ID:");
				int specID = scan.nextInt();
				List<Student> stuList = studentDao.selectStuBySpecId(specID);
				for (Student stu : stuList) {
					System.out.println(stu);
				}
				System.out.println("请选择是否继续查询:1.是\t0.否");
				System.out.print("请选择您的操作：");
				String input = scan.next();
				switch (input) {
				case "1":
					break;
				case "0":
					flag = false;
					break;
				default:
					System.out.println("您的输入有误!");
					flag = false;
					break;
				}
			}
			break;
		case "0":
			System.out.println("您已取消查询!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 按班级查看学生
	public void userShowStuByClass() {
		StudentDao studentDao = new StudentDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有的班级信息:");
		System.out.println("---------------------------------------------");
		userShowAllClasses();
		System.out.println("---------------------------------------------");
		System.out.println("确认查询请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入班级ID:");
				int classID = scan.nextInt();
				List<Student> stuList = studentDao.selectStuByClassId(classID);
				for (Student stu : stuList) {
					System.out.println(stu);
				}
				System.out.println("请选择是否继续查询:1.是\t0.否");
				System.out.print("请选择您的操作：");
				String input = scan.next();
				switch (input) {
				case "1":
					break;
				case "0":
					flag = false;
					break;
				default:
					System.out.println("您的输入有误!");
					flag = false;
					break;
				}
			}
			break;
		case "0":
			System.out.println("您已取消查询!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 查看所有学生
	public void userShowAllStudents() {
		StudentDao studentDao = new StudentDao();
		List<Student> stuList = studentDao.selectAllStudents();
		for (Student stu : stuList) {
			System.out.println(stu);
		}
	}

	// 查询班级
	private void userShowClasses() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("**************欢迎进入班级查询模块**************");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.查看所有班级\t2.按专业查看班级\t3.按院系查看班级");
			System.out.println("0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 查看所有班级
				userShowAllClasses();
				break;
			case "2":
				// 按专业查看班级
				userShowClassesBySpec();
				break;
			case "3":
				// 按院系查看班级
				userShowClassesByDepart();
				break;
			case "0":
				// 返回上一层
				flag = false;
				break;
			case "Q":
			case "q":
				// 退出系统
				System.out.println("退出成功,欢迎下次使用~");
				System.exit(0);
				break;
			default:
				System.out.println("您的输入有误!");
				break;
			}
		}
	}

	// 按院系查看班级
	private void userShowClassesByDepart() {
		ClassDao classDao = new ClassDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有的院系信息:");
		System.out.println("---------------------------------------------");
		userShowAllDeparts();
		System.out.println("---------------------------------------------");
		System.out.println("确认查询请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入院系ID:");
				int departID = scan.nextInt();
				List<Classes> classesList = classDao.selectClassesByDepartID(departID);
				for (Classes classes : classesList) {
					System.out.println(classes);
				}
				System.out.println("请选择是否继续查询:1.是\t0.否");
				System.out.print("请选择您的操作：");
				String input = scan.next();
				switch (input) {
				case "1":
					break;
				case "0":
					flag = false;
					break;
				default:
					System.out.println("您的输入有误!");
					flag = false;
					break;
				}
			}
			break;
		case "0":
			System.out.println("您已取消查询!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 按专业查看班级
	private void userShowClassesBySpec() {
		ClassDao classDao = new ClassDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有的专业信息:");
		System.out.println("---------------------------------------------");
		userShowAllSpecs();
		System.out.println("---------------------------------------------");
		System.out.println("确认查询请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入专业ID:");
				int specID = scan.nextInt();
				List<Classes> classesList = classDao.selectClassesBySpecID(specID);
				for (Classes classes : classesList) {
					System.out.println(classes);
				}
				System.out.println("请选择是否继续查询:1.是\t0.否");
				System.out.print("请选择您的操作：");
				String input = scan.next();
				switch (input) {
				case "1":
					break;
				case "0":
					flag = false;
					break;
				default:
					System.out.println("您的输入有误!");
					flag = false;
					break;
				}
			}
			break;
		case "0":
			System.out.println("您已取消查询!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 查看所有班级
	private void userShowAllClasses() {
		ClassDao classDao = new ClassDao();
		List<Classes> classesList = classDao.selectAllClasses();
		for (Classes classes : classesList) {
			System.out.println(classes);
		}
	}

	// 查询专业
	private void userShowAllSpecs() {
		SpecDao specDao = new SpecDao();
		List<Spec> specList = specDao.selectAllSpecs();
		for (Spec spec : specList) {
			System.out.println(spec);
		}
	}

	// 查询院系
	private void userShowAllDeparts() {
		DepartDao departDao = new DepartDao();
		List<Depart> departList = departDao.selectAllDeparts();
		for (Depart depart : departList) {
			System.out.println(depart);
		}
	}

	// 修改个人密码
	private void modifyMyPwd(User user) {
		UserDao userDao = new UserDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("确认修改密码请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入新密码：");
			String upwd = scan.next();
			int num = userDao.updateMyPwd(user, upwd);
			if (num > 0) {
				System.out.println("密码修改成功~");
			} else {
				System.out.println("密码修改失败~");
			}
			break;
		case "0":
			System.out.println("您已取消修改!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

}