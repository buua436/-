package com.Igeek.client;

import java.awt.print.Printable;
import java.util.List;
import java.util.Scanner;

import com.Igeek.bean.Car;
import com. Igeek.dao.CarDao;

/**
 * ϵͳ����
 * @author 86181
 *
 */
public class SecondCarMainSystem {
	private Scanner in = new Scanner(System.in);
	private CarDao cdao = new CarDao();
	
	
	public void start()
	{
		System.out.println("��ӭ�������͹��Ӷ��ֳ��г�....");
		System.out.println("1.��¼\t2.ע��\t3.�鿴���¶��ֳ�\t4.��������\t5.�˳�ϵͳ");
		String choose = in.next();
		switch(choose)
		{
		case "1":
			//
			break;
		case "2":
			//
			break;
		case "3":
			lookNewCars();
			break;
		case "4":
			//
			break;
		}
		
		
	}
	
	//���ݼ۸��������
	public void searchByPrice()
	{
		//��ѡ��۸�����
		
		//���ݼ۸�������һؼ���
		int min=5;
		int max = 10;
		List<Car> list = cdao.findByPrice(min,max);
		printCarList(list);
	}
	
	//�鿴����10�����ֳ�
	private void lookNewCars() {
		//��ѯ���
		List<Car> list = cdao.findLastedTenCars();
		
		//��ӡ��������Ϣ
		printCarList(list);
		
	}
	//3��չ�ּ򵥳�����Ϣ
	private void printCarList(List<Car> list) {
		if(list==null || list.size()==0)
		{
			System.out.println("���޳�����Ϣ��");
			return ;
		}
		System.out.println("���\tƷ��\t����\t�����\t�۸�\t����ʱ��");
		int count = 1;
		for (Car car : list) {
			System.out.println(count+"\t"+car.getBrandName()+"\t"+car.getTypeName()+"\t"+car.getMileage()+"\t"+car.getPrice()+"\t"+car.getReleaseDate());
		}
		
	}
	
}
