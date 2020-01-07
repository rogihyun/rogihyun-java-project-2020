package rogihyun.fashionmall.Handler;

import java.sql.Date;
import java.util.Scanner;
import rogihyun.fashionmall.domain.Info;
import rogihyun.util.ArrayList;

public class InfoHandler {

  ArrayList<Info> infoList;

  Scanner input;

  public InfoHandler(Scanner input) {
    this.input = input;
    this.infoList = new ArrayList<>();
  }

  public InfoHandler(Scanner input, int capacity) {
    this.input = input;
    this.infoList = new ArrayList<>(capacity);
  }

  public void listInfo() {
    
    Info[] arr = new Info[this.infoList.size()];
    
   this.infoList.toArray(arr);
    
    for(Info i : arr) {
      System.out.printf("%s, %s, %s, %s, %s\n",
          i.getGender(), i.getQscore(), i.getSell(), i.getLike(), i.getReview());
    }
  }

  public void addInfo() {
    Info info = new Info();

    System.out.print("상품번호? ");
    info.setNo(input.nextInt());
    input.nextLine();

    System.out.print("성별? ");
    info.setGender(input.nextLine());

    System.out.print("인기도? ");
    info.setQscore(input.nextLine());

    System.out.print("판매도? ");
    info.setSell(input.nextLine());

    System.out.print("좋아요? ");
    info.setLike(input.nextLine());

    System.out.print("리뷰? ");
    info.setReview(input.nextLine());

    
    this.infoList.add(info);

    System.out.println("저장하였습니다.");
  }


  public void detailInfo() {
    System.out.print("번호는? ");
    int index = input.nextInt();
    input.nextLine() ;
    
    Info info = (Info)this.infoList.get(index);

    if (info == null) {
      System.out.println("가격이 유효하지 않습니다.");
      return;
    }

    System.out.printf("상품번호: %s\n", info.getNo());
    System.out.printf("성별: %s\n", info.getGender());
    System.out.printf("인기도: %s\n", info.getQscore());
  }
}