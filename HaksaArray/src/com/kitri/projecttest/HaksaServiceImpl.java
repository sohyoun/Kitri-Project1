package com.kitri.projecttest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HaksaServiceImpl implements HaksaService {
	private List<HaksaDto> list = new ArrayList<HaksaDto>();
	private String job[] = {"학번","과목","부서"};
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	HaksaDto haksaDto;
	int age = 0;
	String name = null;
	int key = 0;
	String value = null;

	public HaksaServiceImpl() {

	}

	@Override
	public void menu() {
		System.out.println("========== 메뉴 선택 ==========");
		System.out.println("1. 등록");
		System.out.println("2. 찾기");
		System.out.println("3. 삭제");
		System.out.println("4. 전체 출력");
		System.out.println("-----------------------");
		System.out.println("0. 종료");
		System.out.println("-----------------------");
		System.out.println("번호를 선택해 주세요..");
		try {

			String infile = in.readLine();
			if (infile.equals("1")) {
				registerMenu();
			} else if (infile.equals("2")) {
				findNameMenu();
			} else if (infile.equals("3")) {
				deleteMenu();
			} else if (infile.equals("4")) {
				selectAll();
			} else if (infile.equals("0")) {
				processExit();
			} else {
				System.out.println("0~4의 한자리 숫자를 입력하세요.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("계속하시려면 1,종료하시려면 0을 입력해주세요.");
			try {
				String infile = in.readLine();
				if (infile.equals("1")) {
					menu();
					return;
				} else if (infile.equals("0")) {
					processExit();
				} else {
					System.out.println("1,0중에 고르세요.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}



	@Override
	public void registerMenu() {
		System.out.println("1. 학생");
		System.out.println("2. 교수");
		System.out.println("3. 관리자");
		System.out.println("4. 이전메뉴");
		System.out.println("번호를 선택해 주세요..");

		register(haksaDto);
	}

	@Override
	public void register(HaksaDto haksaDto) {
		try {
			String infile = in.readLine();
			if(infile.equals("1")||infile.equals("2")||infile.equals("3")) {
				key = Integer.parseInt(infile);
				System.out.println("나이 : ");
				String ageStr = in.readLine();
				age = Integer.parseInt(ageStr);
				System.out.println("이름 : ");
				name = in.readLine();
				System.out.println(job[key-1]+" : ");
				value = in.readLine();
				list.add(new HaksaDto(age, name, key, value));
			} else if(infile.equals("4")) {
				menu();
			} else {
				System.out.println("1~4의 한자리 숫자를 입력하세요.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void findNameMenu() {
		System.out.println("찾을 이름을 입력해 주세요.");
		System.out.println("이름 : ");
		try {
			String name = in.readLine();
			findName(name);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public HaksaDto findName(String name) {
		boolean flag = false;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if (list.get(i).getName().equals(name)) {
				System.out.println("이름 : " + list.get(i).getName() 
						+ "\t나이 : " + list.get(i).getAge()
						+"\t"+job[list.get(i).getKey()-1]+list.get(i).getValue());
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println(name + "이란 사람은 없습니다.");
		}
		return null;
	}

	@Override
	public void deleteMenu() {
		System.out.println("삭제할 사람의 이름을 입력해 주세요.");
		System.out.println("이름 : ");
		try {
			String name = in.readLine();
			delete(name);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int delete(String name) {
		boolean flag = false;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if (list.get(i).getName().equals(name)) {
				list.remove(i);
				System.out.println(name + "님을 삭제하였습니다.");
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println(name + "이란 사람은 없습니다.");
		}

		return 0;
	}

	@Override
	public void selectAll() {
		int size = list.size();
//		System.out.println(size);
		if (size != 0) {

			for (int i = 0; i < size; i++) { // list는 get을 이용해서 i번째를 뽑을 수 있다.

				System.out.println("이름 : " + list.get(i).getName() 
						+ "\t나이 : " + list.get(i).getAge() 
						+ "\t"+job[list.get(i).getKey()-1]+ list.get(i).getValue());

			}
		} else {
			System.out.println("아무도 없습니다.");
		}
	}

	@Override
	public void processExit() {
		System.exit(0);

	}
}
