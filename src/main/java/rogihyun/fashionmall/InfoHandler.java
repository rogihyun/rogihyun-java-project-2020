package rogihyun.fashionmall;

import java.util.Scanner;

public class InfoHandler {
  
  static class Info {
    int no; 
    String gender; 
    String qscore; 
    String sell; ; 
    String like; ; 
    String review; 
  }

  static final int INFO_SIZE = 100;
  static  Info[] infos = new Info[INFO_SIZE];
  static int infoCount = 0;
  static Scanner keyboard;
  
  static void addInfo() {
    Info info = new Info();

    System.out.print("상품번호? ");
    info.no = keyboard.nextInt();

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

    infos[infoCount++] = info;
    System.out.println("저장하였습니다.");
  }


  static void listInfo() {
    for(int i= 0; i < infoCount; i++) {
      Info in = infos[i];
      System.out.printf("%s, %s, %s, %s, %s\n",
          in.gender, in.qscore, in.sell, in.like, in.review);
    }
  }
}
