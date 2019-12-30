package rogihyun.fashionmall.Handler;
import java.util.Scanner;
import rogihyun.fashionmall.domain.Info;
import rogihyun.fashionmall.domain.Price;

public class InfoHandler {

    Info[] infos = new Info[INFO_SIZE];
   int infoCount = 0;
  
   Scanner input;
   
  static final int INFO_SIZE = 100;
  
  public InfoHandler(Scanner input) {
    this.input = input;
    this.infos = new Info[INFO_SIZE];
  }
  
  public InfoHandler(Scanner input, int capacity) {
    this.input = input;
    if (capacity < INFO_SIZE || capacity > 10000)
      this.infos = new Info[INFO_SIZE];
    else 
      this.infos = new Info[capacity];
  }
  
  public void addInfo() {
    Info info = new Info();

    System.out.print("상품번호? ");
    info.no = input.nextInt();
    input.nextLine();
    
    System.out.print("성별? ");
    info.gender = input.nextLine();

    System.out.print("인기도? ");
    info.qscore = input.nextLine();

    System.out.print("판매도? ");
    info.sell = input.nextLine();

    System.out.print("좋아요? ");
    info.like = input.nextLine();

    System.out.print("리뷰? ");
    info.review = input.nextLine();

    this.infos[this.infoCount++] = info;
    System.out.println("저장하였습니다.");
  }


 public void listInfo() {
    for(int i= 0; i < this.infoCount; i++) {
      Info in = this.infos[i];
      System.out.printf("%s, %s, %s, %s, %s\n",
          in.gender, in.qscore, in.sell, in.like, in.review);
    }
  }
 public void detailInfo() {
   System.out.print("번호는? ");
   int no = input.nextInt();
   input.nextLine() ;
   
   Info info = null;
   for (int i = 0; i < this.infoCount; i++) {
     if (this.infos[i].no == no) {
       info = this.infos[i];
       break;
     }
   }
   
   if (info == null) {
     System.out.println("가격이 유효하지 않습니다.");
     return;
   }
   
   System.out.printf("상품번호: %s\n", info.no);
   System.out.printf("성별: %s\n", info.gender);
   System.out.printf("인기도: %s\n", info.qscore);
}
}
