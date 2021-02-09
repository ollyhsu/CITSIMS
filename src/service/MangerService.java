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

public class MangerService {
	// 后台管理系统界面
	public void manger() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("***********欢迎使用CIT学生信息管理系统***********");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.用户管理\t2.院系管理\t3.专业管理");
			System.out.println("4.班级管理\t5.学生管理\t6.课程管理");
			System.out.println("7.成绩管理\t0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 用户管理
				userManger();
				break;
			case "2":
				// 院系管理
				departManger();
				break;
			case "3":
				// 专业管理
				specManger();
				break;
			case "4":
				// 班级管理
				classManger();
				break;
			case "5":
				// 学生管理
				stuManger();
				break;
			case "6":
				// 课程管理
				courseManger();
				break;
			case "7":
				// 成绩管理
				scoreManger();
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

	// 成绩管理
	public void scoreManger() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("**************欢迎进入成绩管理模块**************");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.查询成绩信息\t2.录入成绩信息\t3.删除成绩信息");
			System.out.println("4.修改成绩信息\t0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 查询成绩信息
				showScores();
				break;
			case "2":
				// 录入成绩信息
				addScores();
				break;
			case "3":
				// 删除成绩信息
				deleteScores();
				break;
			case "4":
				// 修改成绩信息
				modifyScoreById();
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
	// 修改成绩信息
	public void modifyScoreById() {
		ScoreDao scoreDao = new ScoreDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("确认修改成绩信息请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.println("请输入你要修改的成绩ID:");
			int scoreId = scan.nextInt();
			System.out.println("请输入你要修改的新成绩分数:");
			Double score = scan.nextDouble();
			int num = scoreDao.updateScoreById(score, scoreId);
			if (num > 0) {
				System.out.println("成绩信息修改成功~");
			} else {
				System.out.println("成绩信息修改失败~");
			}
			break;
		}
		
	}

	// 删除成绩信息
	public void deleteScores() {
		ScoreDao scoreDao = new ScoreDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("！注意：️删除成绩信息会该学生成绩数据，无法找回，请慎重删除！");
		System.out.println("确认删除请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入你要删除的成绩单ID:");
			int scoreID = scan.nextInt();
			int num = scoreDao.deleteScoreById(scoreID);
			if (num > 0) {
				System.out.println("成绩删除成功~");
			} else {
				System.out.println("成绩删除失败~");
			}
			break;
		case "0":
			System.out.println("您已取消删除!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 录入成绩信息
	public void addScores() {
		ScoreDao scoreDao = new ScoreDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("确认添加请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入课程ID:");
				int courseId = scan.nextInt();
				System.out.print("请输入学生ID:");
				int stuId = scan.nextInt();
				System.out.println("请输入成绩:");
				double Score = scan.nextDouble();
				int num = scoreDao.addScores(courseId,stuId,Score);
				if (num > 0) {
					System.out.println("学生成绩添加成功~");
					System.out.println("请选择是否继续添加成绩信息:1.是\t0.否");
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
				} else {
					System.out.println("学生成绩添加失败~");
				}
			}
			break;
		case "0":
			System.out.println("您已取消添加!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 查询成绩信息
	public void showScores() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("**************欢迎进入成绩查询模块**************");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.查看所有成绩\t2.按姓名查找成绩\t3.按课程查看成绩");
			System.out.println("4.按班级查看成绩\t5.按专业查看成绩\t6.统计不及格学生");
			System.out.println("0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 查看所有成绩
				showAllScores();
				break;
			case "2":
				// 按姓名查找成绩
				showScoresByName();
				break;
			case "3":
				// 按课程查看成绩
				showScoresByCourse();
				break;
			case "4":
				// 按班级查看成绩
				showScoresByClass();
				break;
			case "5":
				// 按专业查看成绩
				showScoresBySpec();
				break;
			case "6":
				// 统计不及格学生
				showStuWhoFailed();
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
	
	// 统计不及格学生
	public void showStuWhoFailed() {
		ScoreDao scoreDao = new ScoreDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("确认查询请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			List<Score> scoList = scoreDao.selectStuWhoFailed();
			for (Score sco : scoList) {
				System.out.println(sco);
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

	// 按专业查看成绩
	public void showScoresBySpec() {
		ScoreDao scoreDao = new ScoreDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有专业信息:");
		System.out.println("---------------------------------------------");
		showAllSpecs();
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
				switch(pxchoose) {
				case "1":
					//降序输出专业成绩
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
					//升序输出专业成绩
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
	public void showScoresByClass() {
		ScoreDao scoreDao = new ScoreDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有班级信息:");
		System.out.println("---------------------------------------------");
		showAllClasses();
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
				switch(pxchoose) {
				case "1":
					//降序输出班级成绩
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
					//升序输出班级成绩
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
	public void showScoresByCourse() {
		ScoreDao scoreDao = new ScoreDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有课程信息:");
		System.out.println("---------------------------------------------");
		showAllCourses();
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
				switch(pxchoose) {
				case "1":
					//降序输出课程成绩
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
					//升序输出成绩
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
	public void showScoresByName() {
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
	public void showAllScores() {
		ScoreDao scoreDao = new ScoreDao();
		List<Score> scoList = scoreDao.selectAllScores();
		for (Score sco : scoList) {
			System.out.println(sco);
		}
	}

	/************************* 管理员课程管理模块开始 *************************/
	// 课程管理模块
	public void courseManger() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("**************欢迎进入课程管理模块**************");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.查看课程信息\t2.添加课程信息\t3.删除课程信息");
			System.out.println("4.修改课程信息\t0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 查看课程信息
				showAllCourses();
				break;
			case "2":
				// 添加课程信息
				addCourse();
				break;
			case "3":
				// 删除课程信息
				deleteCourse();
				break;
			case "4":
				// 修改课程信息
				modifyCourseInfo();
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

	// 修改课程信息
	public void modifyCourseInfo() {
		CourseDao courseDao = new CourseDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("确认修改课程信息请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.println("1.仅修改课程名");
			System.out.println("2.仅修改课程学分");
			System.out.println("3.同时修改课程名、课程学分");
			System.out.print("请选择您的操作(取消请输入[0])：");
			String input = scan.next();
			switch (input) {
			case "1":
				System.out.println("请输入你要修改的课程ID:");
				int coId1 = scan.nextInt();
				System.out.println("请输入你要修改的新课程名:");
				String coName1 = scan.next();
				int num1 = courseDao.updateCoNameById(coName1, coId1);
				if (num1 > 0) {
					System.out.println("课程信息修改成功~");
				} else {
					System.out.println("课程信息修改失败~");
				}
				break;
			case "2":
				System.out.println("请输入你要修改的课程ID:");
				int coId2 = scan.nextInt();
				System.out.println("请输入你要修改的新课程学分:");
				double coScore2 = scan.nextDouble();
				int num2 = courseDao.updateCoScoreById(coScore2, coId2);
				if (num2 > 0) {
					System.out.println("课程信息修改成功~");
				} else {
					System.out.println("课程信息修改失败~");
				}
				break;
			case "3":
				System.out.println("请输入你要修改的课程ID:");
				int coId3 = scan.nextInt();
				System.out.println("请输入你要修改的新课程名:");
				String coName3 = scan.next();
				System.out.println("请输入你要修改的新课程学分:");
				double coScore3 = scan.nextDouble();
				int num3 = courseDao.updateCoInfoById(coName3, coScore3, coId3);
				if (num3 > 0) {
					System.out.println("课程信息修改成功~");
				} else {
					System.out.println("课程信息修改失败~");
				}
				break;
			case "0":
				System.out.println("您已取消修改!");
				break;
			default:
				System.out.println("您的输入有误!");
				break;
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

	// 删除课程信息
	public void deleteCourse() {
		CourseDao courseDao = new CourseDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("！注意：️删除课程信息会同步删除该课程的所有学生成绩等信息数据，请慎重删除！");
		System.out.println("确认删除请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入你要删除的课程ID:");
			int courseID = scan.nextInt();
			int num = courseDao.deleteCourseById(courseID);
			if (num > 0) {
				System.out.println("课程删除成功~");
			} else {
				System.out.println("课程删除失败~");
			}
			break;
		case "0":
			System.out.println("您已取消删除!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 添加课程信息
	public void addCourse() {
		CourseDao courseDao = new CourseDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("确认添加请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入课程名称:");
				String courseName = scan.next();
				System.out.println("请输入课程学分:");
				double courseScore = scan.nextDouble();
				int num = courseDao.addCourse(courseName, courseScore);
				if (num > 0) {
					System.out.println("课程添加成功~");
					System.out.println("请选择是否继续添加课程信息:1.是\t0.否");
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
				} else {
					System.out.println("课程添加失败~");
				}
			}
			break;
		case "0":
			System.out.println("您已取消添加!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 查看课程信息
	public void showAllCourses() {
		CourseDao courseDao = new CourseDao();
		List<Course> courseList = courseDao.selectAllCourses();
		for (Course course : courseList) {
			System.out.println(course);
		}
	}

	/************************* 管理员课程管理模块结束 *************************/

	/************************* 管理员学生管理模块开始 *************************/
	// 学生管理模块
	public void stuManger() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("**************欢迎进入学生管理模块**************");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.查看学生信息\t2.添加学生信息\t3.删除学生信息");
			System.out.println("4.修改学生信息\t0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 查看学生信息
				showStudents();
				break;
			case "2":
				// 添加学生信息
				addStudents();
				break;
			case "3":
				// 删除学生信息
				deleteStudent();
				break;
			case "4":
				// 修改学生信息
				modifyStuInfo();
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

	// 修改学生信息
	public void modifyStuInfo() {
		StudentDao studentDao = new StudentDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("确认修改学生信息请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.println("1.仅修改学生姓名");
			System.out.println("2.仅修改学生生日");
			System.out.println("3.仅修改学生班级");
			System.out.println("4.同时修改学生姓名、生日、班级");
			System.out.print("请选择您的操作(取消请输入[0])：");
			String input = scan.next();
			switch (input) {
			case "1":
				System.out.println("请输入你要修改的学生ID:");
				int stuId1 = scan.nextInt();
				System.out.println("请输入你要修改的新学生姓名:");
				String stuName1 = scan.next();
				int num1 = studentDao.updateStuNameById(stuName1, stuId1);
				if (num1 > 0) {
					System.out.println("学生信息修改成功~");
				} else {
					System.out.println("学生信息修改失败~");
				}
				break;
			case "2":
				System.out.println("请输入你要修改的学生ID:");
				int stuId2 = scan.nextInt();
				System.out.println("请输入你要修改的新学生生日(格式:19991001):");
				String stuBirth2 = scan.next();
				int num2 = studentDao.updateStuBirthById(stuBirth2, stuId2);
				if (num2 > 0) {
					System.out.println("学生信息修改成功~");
				} else {
					System.out.println("学生信息修改失败~");
				}
				break;
			case "3":
				System.out.println("请输入你要修改的学生ID:");
				int stuId3 = scan.nextInt();
				System.out.print("请输入你要修改学生的新班级ID:");
				int classId3 = scan.nextInt();
				int num3 = studentDao.updateStuClassById(classId3, stuId3);
				if (num3 > 0) {
					System.out.println("学生信息修改成功~");
				} else {
					System.out.println("学生信息修改失败~");
				}
				break;
			case "4":
				System.out.println("请输入你要修改的学生ID:");
				int stuId4 = scan.nextInt();
				System.out.println("请输入你要修改的新学生姓名:");
				String stuName4 = scan.next();
				System.out.println("请输入你要修改的新学生生日(格式:19991001):");
				String stuBirth4 = scan.next();
				System.out.print("请输入你要修改学生的新班级ID:");
				int classId4 = scan.nextInt();
				int num4 = studentDao.updateStuInfoById(stuName4, stuBirth4, classId4, stuId4);
				if (num4 > 0) {
					System.out.println("学生信息修改成功~");
				} else {
					System.out.println("学生信息修改失败~");
				}
				break;
			case "0":
				System.out.println("您已取消修改!");
				break;
			default:
				System.out.println("您的输入有误!");
				break;
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

	// 删除学生信息
	public void deleteStudent() {
		StudentDao studentDao = new StudentDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("！注意：️删除学生信息会同步删除该学生对应的课程成绩等信息数据，请慎重删除！");
		System.out.println("确认删除请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入你要删除的学生ID:");
			int stuID = scan.nextInt();
			int num = studentDao.deleteStuById(stuID);
			if (num > 0) {
				System.out.println("学生信息删除成功~");
			} else {
				System.out.println("学生信息删除失败~");
			}
			break;
		case "0":
			System.out.println("您已取消删除!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 添加学生信息
	public void addStudents() {
		StudentDao studentDao = new StudentDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有的班级信息:");
		System.out.println("---------------------------------------------");
		showAllClasses();
		System.out.println("---------------------------------------------");
		System.out.println("确认添加学生信息请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入学生姓名:");
				String stuName = scan.next();
				System.out.print("请输入学生性别(男[1],女[0],输入对应的数字即可):");
				int stuSex = scan.nextInt();
				System.out.println("请输入学生的生日(格式:19991001):");
				String stuBirth = scan.next();
				System.out.print("请输入该学生所属的班级ID：");
				int classId = scan.nextInt();
				int num = studentDao.addStudents(stuName, stuSex, stuBirth, classId);
				if (num > 0) {
					System.out.println("学生信息添加成功~");
					System.out.println("请选择是否继续添加学生信息:1.是\t0.否");
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
				} else {
					System.out.println("学生信息添加失败~");
				}
			}
			break;
		case "0":
			System.out.println("您已取消添加!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 查看学生信息
	public void showStudents() {
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
				showAllStudents();
				break;
			case "2":
				// 按班级查看学生
				showStuByClass();
				break;
			case "3":
				// 按专业查看学生
				showStuBySpec();
				break;
			case "4":
				// 按学院查看学生
				showStuByDepart();
				break;
			case "5":
				// 按姓名查看学生
				showStuByName();
				break;
			case "6":
				// 按学号查看学生
				showStuByID();
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
	public void showStuByID() {
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
	public void showStuByName() {
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
	public void showStuByDepart() {
		StudentDao studentDao = new StudentDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有的院系信息:");
		System.out.println("---------------------------------------------");
		showAllDeparts();
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
	public void showStuBySpec() {
		StudentDao studentDao = new StudentDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有的专业信息:");
		System.out.println("---------------------------------------------");
		showAllSpecs();
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
	public void showStuByClass() {
		StudentDao studentDao = new StudentDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有的班级信息:");
		System.out.println("---------------------------------------------");
		showAllClasses();
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
	public void showAllStudents() {
		StudentDao studentDao = new StudentDao();
		List<Student> stuList = studentDao.selectAllStudents();
		for (Student stu : stuList) {
			System.out.println(stu);
		}
	}

	/************************* 管理员学生管理模块结束 *************************/

	/************************* 管理员班级管理模块开始 *************************/
	// 班级管理模块
	public void classManger() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("**************欢迎进入班级管理模块**************");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.查看班级信息\t2.添加班级信息\t3.删除班级信息");
			System.out.println("4.修改班级名称\t0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 查看班级信息
				showClasses();
				break;
			case "2":
				// 添加班级信息
				addClasses();
				break;
			case "3":
				// 删除班级信息
				deleteClasses();
				break;
			case "4":
				// 修改班级名称
				modifyClassName();
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

	// 修改班级名称
	public void modifyClassName() {
		ClassDao classDao = new ClassDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("确认修改班级名称请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入你要修改的班级ID:");
			int classId = scan.nextInt();
			System.out.println("请输入你要修改的新班级名称：");
			String className = scan.next();
			int num = classDao.updateClassNameById(className, classId);
			if (num > 0) {
				System.out.println("班级名称修改成功~");
			} else {
				System.out.println("班级名称修改失败~");
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

	// 删除班级信息
	public void deleteClasses() {
		ClassDao classDao = new ClassDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("！注意：️删除班级信息会同步删除该班级下面所有学生、成绩等信息数据，请慎重删除！");
		System.out.println("确认删除请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入你要删除的班级ID:");
			int classID = scan.nextInt();
			int num = classDao.deleteClassById(classID);
			if (num > 0) {
				System.out.println("班级删除成功~");
			} else {
				System.out.println("班级删除失败~");
			}
			break;
		case "0":
			System.out.println("您已取消删除!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 添加班级信息
	public void addClasses() {
		ClassDao classDao = new ClassDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有的专业信息:");
		System.out.println("---------------------------------------------");
		showAllSpecs();
		System.out.println("---------------------------------------------");
		System.out.println("确认添加请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入班级名称：");
				String className = scan.next();
				System.out.print("请输入该班级所属的专业ID：");
				int spceId = scan.nextInt();
				int num = classDao.addClasses(className, spceId);
				if (num > 0) {
					System.out.println("班级添加成功~");
					System.out.println("请选择是否继续添加班级信息:1.是\t0.否");
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
				} else {
					System.out.println("班级添加失败~");
				}
			}
			break;
		case "0":
			System.out.println("您已取消添加!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 查看班级信息
	public void showClasses() {
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
				showAllClasses();
				break;
			case "2":
				// 按专业查看班级
				showClassesBySpec();
				break;
			case "3":
				// 按院系查看班级
				showClassesByDepart();
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
	public void showClassesByDepart() {
		ClassDao classDao = new ClassDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有的院系信息:");
		System.out.println("---------------------------------------------");
		showAllDeparts();
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
	public void showClassesBySpec() {
		ClassDao classDao = new ClassDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有的专业信息:");
		System.out.println("---------------------------------------------");
		showAllSpecs();
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
	public void showAllClasses() {
		ClassDao classDao = new ClassDao();
		List<Classes> classesList = classDao.selectAllClasses();
		for (Classes classes : classesList) {
			System.out.println(classes);
		}
	}

	/************************* 管理员班级管理模块结束 *************************/

	/************************* 管理员专业管理模块开始 *************************/
	// 专业管理模块
	public void specManger() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("**************欢迎进入专业管理模块**************");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.查看专业信息\t2.添加专业信息\t3.删除专业信息");
			System.out.println("4.修改专业名称\t0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 查看专业信息
				showAllSpecs();
				break;
			case "2":
				// 添加专业信息
				addSpec();
				break;
			case "3":
				// 删除专业信息
				deleteSpec();
				break;
			case "4":
				// 修改专业名称
				modifySpecName();
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

	// 修改专业名称
	public void modifySpecName() {
		SpecDao specDao = new SpecDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("确认修改院系名称请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入你要修改的专业ID:");
			int specId = scan.nextInt();
			System.out.println("请输入你要修改的新专业名称：");
			String specName = scan.next();
			int num = specDao.updateSpecNameById(specName, specId);
			if (num > 0) {
				System.out.println("专业名称修改成功~");
			} else {
				System.out.println("专业名称修改失败~");
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

	// 删除专业信息
	public void deleteSpec() {
		SpecDao specDao = new SpecDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("！注意：️删除专业信息会同步删除该专业下面所有的班级、学生、成绩等信息数据，请慎重删除！");
		System.out.println("确认删除请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入你要删除的专业ID:");
			int specID = scan.nextInt();
			int num = specDao.deleteSpecById(specID);
			if (num > 0) {
				System.out.println("专业删除成功~");
			} else {
				System.out.println("专业删除失败~");
			}
			break;
		case "0":
			System.out.println("您已取消删除!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 添加专业信息
	public void addSpec() {
		SpecDao specDao = new SpecDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("下面将列出所有院系信息:");
		System.out.println("---------------------------------------------");
		showAllDeparts();
		System.out.println("---------------------------------------------");
		System.out.println("确认添加请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入专业名称：");
				String specName = scan.next();
				System.out.print("请输入该专业所属的院系ID：");
				int departId = scan.nextInt();
				int num = specDao.addSpec(specName, departId);
				if (num > 0) {
					System.out.println("专业添加成功~");
					System.out.println("请选择是否继续添加专业信息:1.是\t0.否");
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
				} else {
					System.out.println("专业添加失败~");
				}
			}
			break;
		case "0":
			System.out.println("您已取消添加!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 查看专业信息
	public void showAllSpecs() {
		SpecDao specDao = new SpecDao();
		List<Spec> specList = specDao.selectAllSpecs();
		for (Spec spec : specList) {
			System.out.println(spec);
		}
	}

	/************************* 管理员专业管理模块结束 *************************/

	/************************* 管理员院系管理模块开始 *************************/
	// 院系管理模块
	public void departManger() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("**************欢迎进入院系管理模块**************");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.查看院系信息\t2.添加院系信息\t3.删除院系信息");
			System.out.println("4.修改院系名称\t0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 查看院系信息
				showAllDeparts();
				break;
			case "2":
				// 添加院系信息
				addDepart();
				break;
			case "3":
				// 删除院系信息
				deleteDepart();
				break;
			case "4":
				// 修改院系名称
				modifyDepartName();
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

	// 修改院系名称
	public void modifyDepartName() {
		DepartDao departDao = new DepartDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("确认修改院系名称请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入你要修改的院系ID:");
			int departId = scan.nextInt();
			System.out.println("请输入你要修改的新院系名称：");
			String departName = scan.next();
			int num = departDao.updateDepartNameById(departName, departId);
			if (num > 0) {
				System.out.println("院系名称修改成功~");
			} else {
				System.out.println("院系名称修改失败~");
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

	// 删除院系信息
	public void deleteDepart() {
		DepartDao departDao = new DepartDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("！注意：️删除院系信息会同步删除该院系下面所有的专业、班级、学生、成绩等信息数据，请慎重删除！");
		System.out.println("确认删除请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入你要删除的院系ID:");
			int departID = scan.nextInt();
			int num = departDao.deleteDepartById(departID);
			if (num > 0) {
				System.out.println("院系删除成功~");
			} else {
				System.out.println("院系删除失败~");
			}
			break;
		case "0":
			System.out.println("您已取消删除!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 添加院系信息
	public void addDepart() {
		DepartDao departDao = new DepartDao();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("确认添加请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			while (flag) {
				System.out.print("请输入院系名称:");
				String departName = scan.next();
				int num = departDao.addDepart(departName);
				if (num > 0) {
					System.out.println("院系添加成功~");
					System.out.println("请选择是否继续添加院系信息:1.是\t0.否");
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
				} else {
					System.out.println("院系添加失败~");
				}
			}
			break;
		case "0":
			System.out.println("您已取消添加!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 查看院系信息
	public void showAllDeparts() {
		DepartDao departDao = new DepartDao();
		List<Depart> departList = departDao.selectAllDeparts();
		for (Depart depart : departList) {
			System.out.println(depart);
		}
	}

	/************************* 管理员院系管理模块结束 *************************/

	/************************* 管理员用户管理模块开始 *************************/
	// 用户管理模块
	public void userManger() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("**************欢迎进入用户管理模块**************");
			System.out.println("您可以进行如下操作：(选择编号即可)");
			System.out.println("1.显示用户列表\t2.修改用户密码\t3.删除用户");
			System.out.println("4.修改用户权限\t0.返回上一层\tq.退出系统");
			System.out.print("请选择您的操作：");
			String input = scan.next();
			switch (input) {
			case "1":
				// 显示所有用户信息
				showAllUsers();
				break;
			case "2":
				// 修改用户密码
				modifyUserPwd();
				break;
			case "3":
				// 删除用户信息
				deleteUser();
				break;
			case "4":
				// 修改用户权限
				modifyUserType();
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

	// 修改用户权限
	public void modifyUserType() {
		UserDao userDao = new UserDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("确认修改用户权限请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入你要修改权限的用户名:");
			String userName = scan.next();
			System.out.println("请设置用户权限（1:管理员\t0.普通用户）");
			System.out.println("请输入用户权限对应的数字即可：");
			int utype = scan.nextInt();
			int num = userDao.updateUserTypeByName(userName, utype);
			if (num > 0) {
				System.out.println("用户权限修改成功~");
			} else {
				System.out.println("用户权限修改失败~");
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

	// 删除用户信息
	public void deleteUser() {
		UserDao userDao = new UserDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("确认删除请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入你要删除的用户名:");
			String userName = scan.next();
			int num = userDao.deleteUserByName(userName);
			if (num > 0) {
				System.out.println("用户删除成功~");
			} else {
				System.out.println("用户删除失败~");
			}
			break;
		case "0":
			System.out.println("您已取消删除!");
			break;
		default:
			System.out.println("您的输入有误!");
			break;
		}
	}

	// 修改用户密码
	public void modifyUserPwd() {
		UserDao userDao = new UserDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("确认修改用户密码请输入[1],取消请输入[0]：");
		String choose = scan.next();
		switch (choose) {
		case "1":
			System.out.print("请输入你要修改的用户名:");
			String userName = scan.next();
			System.out.print("请输入新密码：");
			String upwd = scan.next();
			int num = userDao.updateUserByName(userName, upwd);
			if (num > 0) {
				System.out.println("用户密码修改成功~");
			} else {
				System.out.println("用户密码修改失败~");
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

	// 显示所有用户信息
	public void showAllUsers() {
		UserDao userDao = new UserDao();
		List<User> userList = userDao.selectAllUsers();
		for (User user : userList) {
			System.out.println(user);
		}
	}
	/************************* 管理员用户管理模块结束 *************************/
}