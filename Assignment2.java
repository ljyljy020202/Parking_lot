package Assignment.jylim;

import java.util.Scanner;

public class Assignment2 {

	public static Scanner scanner = new Scanner(System.in);
	
	static final int ROW = 4;
	static final int COL = 3;
	
	public static void main(String[] args) {
		String[][] space = new String[ROW][COL];
		int menu;
		do {
		System.out.println("202212128 임지예\n**** 주차 현황 ****");
		System.out.print("  ");
		for(int i=0;i<COL;i++)
			System.out.print((i+1)+" ");
		System.out.println();
		for(int j=0;j<ROW;j++) {
			System.out.print((j+1)+" ");
			for(int k=0;k<space[j].length;k++)
				if(space[j][k]==null)
					System.out.print("♡ ");
				else
					System.out.print("♥ ");
			System.out.println();
		}
		System.out.println("\n1) 주차하기 2) 차량검색 3) 출차하기 4) 종료");
		System.out.print("메뉴를 선택하세요 : ");
		
		menu=scanner.nextInt();
		switch(menu) {
		case 1: parking(space);break;
		case 2: search(space);break;
		case 3: out(space);break;
		case 4: System.out.println("\n시스템을 종료합니다.");break;
		default: System.out.println("\n메뉴 번호를 확인 후 다시 입력해 주세요.\n");
		}
		}while(menu!=4);
	}

	public static void parking(String space[][]) {
		System.out.println("\n**** 주차하기 ****");
		System.out.print("주차할 위치를 선택해 주세요(입력예 : 2 1) : ");
		int row = scanner.nextInt()-1;
		int col = scanner.nextInt()-1;
		if(row<0||row>=ROW||col<0||col>=COL) {
			System.out.println("위치 번호를 확인해 주세요. 처음부터 다시 시작해 주세요.\n");
			return;
		}
		else if(space[row][col]!=null){
			System.out.println("다른 차량이 주차되어 있습니다. 처음부터 다시 시작해 주세요.\n");
			return;
		}
		
		System.out.print("차량 번호를 입력해 주세요(입력예 : 20가1234 ) : ");
		String carNum = scanner.next();
		System.out.print("차량 번호 "+carNum+" 맞습니까?(y/n): ");
		String answer = scanner.next();
		if(answer.equals("y")) {
			space[row][col]=carNum;
			System.out.println(carNum+"차량의 주차를 완료하였습니다.\n");
			}
		else if(answer.equals("n"))
			System.out.println("처음부터 다시 진행해 주세요.");	
	}

	public static void search(String space[][]) {
		System.out.println("\n**** 차량검색 ****");
		System.out.print("차량 번호를 입력해 주세요 : ");
		String carNum = scanner.next();
		for(int i=0;i<space.length;i++) {
			for(int j=0;j<space[i].length;j++) {
				if(space[i][j]!=null&&space[i][j].equals(carNum)) {
					System.out.println(carNum+"는 ("+(i+1)+", "+(j+1)+")에 위치합니다.\n");
					return;
				}
			}
		}
		System.out.println("차량이 존재하지 않습니다. 차량 번호 확인 후 처음부터 다시 진행해 주세요.\n");
	}

	public static void out(String space[][]) {
		System.out.println("\n**** 출차하기 ****");
		System.out.print("차량 번호를 입력해 주세요 : ");
		String carNum = scanner.next();
		for(int i=0;i<space.length;i++) {
			for(int j=0;j<space[i].length;j++) {
				if(space[i][j]!=null&&space[i][j].equals(carNum)) {
					space[i][j]=null;
					System.out.println(carNum+"차량이 출차되었습니다. 안녕히 가세요.\n");
					return;
				}
			}
		}
		System.out.println("차량이 존재하지 않습니다. 차량 번호 확인 후 처음부터 다시 진행해 주세요.\n");
	}

}
