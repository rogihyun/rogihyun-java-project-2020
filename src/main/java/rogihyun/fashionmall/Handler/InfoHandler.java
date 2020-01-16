package rogihyun.fashionmall.Handler;

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

  public void listInfo() {
    
    Info[] arr = this.infoList.toArray(new Info[this.infoList.size()]);
    
    for(Info i : arr) {
      System.out.printf("%s, %s, %s, %s, %s\n",
          i.getGender(), i.getQscore(),
          i.getSell(), i.getLike(), i.getReview());
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
    
    Info info = this.infoList.get(index);

    if (info == null) {
      System.out.println("가격이 유효하지 않습니다.");
      return;
    }

    System.out.printf("상품번호: %s\n", info.getNo());
    System.out.printf("성별: %s\n", info.getGender());
    System.out.printf("인기도: %s\n", info.getQscore());
    System.out.printf("판매도: %s\n", info.getSell());
    System.out.printf("좋아요: %s\n", info.getLike());
    System.out.printf("리뷰: %s\n", info.getReview());
    
  }
  
  public void updateInfo() {
    System.out.print("상품 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    Info oldInfo = this.infoList.get(index);
    
    if (oldInfo == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }
    
    boolean changed = false;
    String inputStr = null;
    Info newInfo = new Info();
    
    newInfo.setNo(oldInfo.getNo());
    
    System.out.printf("상품번호(%s)? ", oldInfo.getNo());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newInfo.setNo(oldInfo.getNo());
    }else {
      newInfo.setNo(Integer.parseInt(inputStr));
      changed = true;
    }
    
    System.out.printf("성별(%s)? ", oldInfo.getGender());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newInfo.setGender(oldInfo.getGender());
    }else {
      newInfo.setGender(inputStr);
      changed = true;
    }
    
    System.out.printf("인기도(%s)? ", oldInfo.getQscore());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newInfo.setQscore(oldInfo.getQscore());
    }else {
      newInfo.setQscore(inputStr);
      changed = true;
    }
    
    System.out.printf("판매도(%s)? ", oldInfo.getSell());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newInfo.setSell(oldInfo.getSell());
    }else {
      newInfo.setSell(inputStr);
      changed = true;
    }
    
    System.out.printf("좋아요(%s)? ", oldInfo.getLike());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newInfo.setLike(oldInfo.getLike());
    }else {
      newInfo.setLike(inputStr);
      changed = true;
    }
    
    System.out.printf("리뷰(%s)? ", oldInfo.getReview());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newInfo.setReview(oldInfo.getReview());
    }else {
      newInfo.setReview(inputStr);
      changed = true;
    }
    
    if (changed) {
      this.infoList.set(index, newInfo);
      System.out.println("상품을 변경했습니다.");
    } else {
      System.out.println("상품변경을 취소하였습니다.");
    }
  }
  
  public void deleteInfo() {
    System.out.print("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); 
    
    Info info = this.infoList.get(index);
    
    if (info == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }
    
    this.infoList.remove(index);
    
    System.out.println("게시글을 삭제했습니다.");
  }
}