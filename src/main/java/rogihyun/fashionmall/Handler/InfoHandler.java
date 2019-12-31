package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Info;

public class InfoHandler {

  InfoList infoList;

  Scanner input;

  public InfoHandler(Scanner input) {
    this.input = input;
    this.infoList = new InfoList();
  }

  public InfoHandler(Scanner input, int capacity) {
    this.input = input;
    this.infoList = new InfoList(capacity);
  }

  public void listInfo() {
    Info[] infos = infoList.toArray();
    for(Info i : infos) {
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

    infoList.add(info);

    System.out.println("저장하였습니다.");
  }


  public void detailInfo() {
    System.out.print("번호는? ");
    int no = input.nextInt();
    input.nextLine() ;
    
    Info info = this.infoList.get(no);

    if (info == null) {
      System.out.println("가격이 유효하지 않습니다.");
      return;
    }

    System.out.printf("상품번호: %s\n", info.getNo());
    System.out.printf("성별: %s\n", info.getGender());
    System.out.printf("인기도: %s\n", info.getQscore());
  }
}
