// 프로젝트 : 패션쇼핑몰 자재관리
//
package rogihyun.fashionmall;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    System.out.println("패션쇼핑몰에 오신걸 환영합니다.");

    Scanner keyboard = new Scanner(System.in);

    class Info {
      int no; //상품번호
      String gender; //성별
      String qscore; //인기도
      String sell; ; // 판매도
      String like; ; // 좋아요
      String review; //후기
    }

    final int SIZE = 100;

    Info[] infos = new Info[SIZE];

    int count = 0;

    for (int i = 0; i < SIZE; i++) {

      count++;

      Info info = new Info();


      System.out.print("상품번호? ");
      info.no = keyboard.nextInt();

      keyboard.nextLine(); // nextInt() 후에 남아 있는 줄바꿈 기호를 제거한다.

      System.out.print("성별? ");
      info.gender = keyboard.nextLine();

      System.out.print("인기도? ");
      info.qscore = keyboard.nextLine();

      System.out.print("판매도? ");
      info.sell = keyboard.nextLine();

      System.out.print("좋아요? ");
      info.like = keyboard.nextLine();

      System.out.print("리뷰? ");
      info.review = keyboard.nextLine();

      infos[i] = info;

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;
    }
    System.out.println();

    for (int i = 0; i < count; i++) {
      Info info = infos[i];
      System.out.printf("%d, %s, %s ~ %s, %s\n",
          info.no, info.gender, 
          info.qscore, info.sell, 
          info.like, info.review);
    }

    keyboard.close();
  }
}
