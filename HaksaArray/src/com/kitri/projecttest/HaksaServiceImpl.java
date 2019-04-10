package com.kitri.projecttest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HaksaServiceImpl implements HaksaService {
	private List<HaksaDto> list = new ArrayList<HaksaDto>();
	private String job[] = {"�й�","����","�μ�"};
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
		System.out.println("========== �޴� ���� ==========");
		System.out.println("1. ���");
		System.out.println("2. ã��");
		System.out.println("3. ����");
		System.out.println("4. ��ü ���");
		System.out.println("-----------------------");
		System.out.println("0. ����");
		System.out.println("-----------------------");
		System.out.println("��ȣ�� ������ �ּ���..");
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
				System.out.println("0~4�� ���ڸ� ���ڸ� �Է��ϼ���.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("����Ͻ÷��� 1,�����Ͻ÷��� 0�� �Է����ּ���.");
			try {
				String infile = in.readLine();
				if (infile.equals("1")) {
					menu();
					return;
				} else if (infile.equals("0")) {
					processExit();
				} else {
					System.out.println("1,0�߿� ������.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}



	@Override
	public void registerMenu() {
		System.out.println("1. �л�");
		System.out.println("2. ����");
		System.out.println("3. ������");
		System.out.println("4. �����޴�");
		System.out.println("��ȣ�� ������ �ּ���..");

		register(haksaDto);
	}

	@Override
	public void register(HaksaDto haksaDto) {
		try {
			String infile = in.readLine();
			if(infile.equals("1")||infile.equals("2")||infile.equals("3")) {
				key = Integer.parseInt(infile);
				System.out.println("���� : ");
				String ageStr = in.readLine();
				age = Integer.parseInt(ageStr);
				System.out.println("�̸� : ");
				name = in.readLine();
				System.out.println(job[key-1]+" : ");
				value = in.readLine();
				list.add(new HaksaDto(age, name, key, value));
			} else if(infile.equals("4")) {
				menu();
			} else {
				System.out.println("1~4�� ���ڸ� ���ڸ� �Է��ϼ���.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void findNameMenu() {
		System.out.println("ã�� �̸��� �Է��� �ּ���.");
		System.out.println("�̸� : ");
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
				System.out.println("�̸� : " + list.get(i).getName() 
						+ "\t���� : " + list.get(i).getAge()
						+"\t"+job[list.get(i).getKey()-1]+list.get(i).getValue());
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println(name + "�̶� ����� �����ϴ�.");
		}
		return null;
	}

	@Override
	public void deleteMenu() {
		System.out.println("������ ����� �̸��� �Է��� �ּ���.");
		System.out.println("�̸� : ");
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
				System.out.println(name + "���� �����Ͽ����ϴ�.");
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println(name + "�̶� ����� �����ϴ�.");
		}

		return 0;
	}

	@Override
	public void selectAll() {
		int size = list.size();
//		System.out.println(size);
		if (size != 0) {

			for (int i = 0; i < size; i++) { // list�� get�� �̿��ؼ� i��°�� ���� �� �ִ�.

				System.out.println("�̸� : " + list.get(i).getName() 
						+ "\t���� : " + list.get(i).getAge() 
						+ "\t"+job[list.get(i).getKey()-1]+ list.get(i).getValue());

			}
		} else {
			System.out.println("�ƹ��� �����ϴ�.");
		}
	}

	@Override
	public void processExit() {
		System.exit(0);

	}
}
