package rogihyun.fashionmall;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    class Info {
      int no; //상품번호
      String gender; //성별
      String qscore; //인기도
      String sell; ; // 판매도
      String like; ; // 좋아요
      String review; //후기
    }

    final int INFO_SIZE = 100;
    Info[] infos = new Info[INFO_SIZE];
    int infoCount = 0;

    class Delivery {
      String deliveryMethod;
      String averageDeliveryDate; 
    }

    final int DELIVERY_SIZE = 100;
    Delivery[] deliveries = new Delivery[DELIVERY_SIZE];
    int deliveryCount = 0;

    class Price {
      String pricetag;   //상품가격
      String reduced;     //세일가격
      String membership;  //회원가격

    }

    final int PRICE_SIZE = 100;
    Price[] prices = new Price[PRICE_SIZE];
    int priceCount = 0;

    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/info/add":
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

          infos[infoCount++] = info;
          System.out.println("저장하였습니다.");

          break;
        case"/info/list":
          for (int i = 0; i < infoCount; i++) {
            Info in = infos[i];
            System.out.printf("%d, %s, %s ~ %s, %s\n",
                in.no, in.gender, 
                in.qscore, in.sell, 
                in.like, in.review);
          }
          break;
        case "/delivery/add":
          Delivery delivery = new Delivery();

          System.out.print("배송방법? ");
          delivery.deliveryMethod = keyboard.nextLine();

          System.out.print("평균배송일");
          delivery.averageDeliveryDate = keyboard.nextLine();

          deliveries[deliveryCount++] = delivery;
          System.out.println("저장하였습니다.");




        case "/delivery/list":
          for (int i = 0; i < deliveryCount; i++) {
            Delivery d = deliveries[i];
            System.out.printf("%s, %s \n",
                d.deliveryMethod, d.averageDeliveryDate
                );
          }
          break;

        case "/price/add":
          Price price = new Price();

          System.out.print("상품가격? ");
          price.pricetag = keyboard.nextLine();

          System.out.print("세일가격? ");
          price.reduced = keyboard.nextLine();

          System.out.print("회원가격? ");
          price.membership = keyboard.nextLine();

          prices[priceCount++] = price;
          System.out.println("저장하였습니다.");
          break;

        case"/price/list":
          for (int i = 0; i < priceCount; i++) {
            Price p = prices[i];
            System.out.printf("%s, %s, %s\n",
                p.pricetag, p.reduced, 
                p.membership);
          }// 출력시 실행할수없는 명령입니다가 같이 뜨는 문제

        default:
          if (!command.equalsIgnoreCase("quit")) 
            System.out.println("실행할 수 없는 명령입니다.");

      } // switch
    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("안녕!");

    keyboard.close();

  }//main
}//class

