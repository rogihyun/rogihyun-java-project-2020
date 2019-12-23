package rogihyun.fashionmall;

import java.util.Scanner;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static class Info {
    int no; //상품번호
    String gender; //성별
    String qscore; //인기도
    String sell; ; // 판매도
    String like; ; // 좋아요
    String review; //후기
  }

  static final int INFO_SIZE = 100;
  static  Info[] infos = new Info[INFO_SIZE];
  static int infoCount = 0;

  static class Delivery {
    String deliveryMethod;
    String averageDeliveryDate; 
  }

  static final int DELIVERY_SIZE = 100;
  static Delivery[] deliveries = new Delivery[DELIVERY_SIZE];
  static int deliveryCount = 0;

  static class Price {
    String pricetag;   //상품가격
    String reduced;     //세일가격
    String membership;  //회원가격
  }

  static final int PRICE_SIZE = 100;
  static Price[] prices = new Price[PRICE_SIZE];
  static int priceCount = 0;

  public static void main(String[] args) {

    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/info/add":
          addInfo();
          break;

        case "/info/list":
          listInfo();
          break;

        case "/delivery/add":
          addDelivery();
          break;

        case "/delivery/list":
          addDelivery();
          break;

        case "/price/add":
          addPrice();
          break;

        case "/price/list":
          listPrice();
          break;

        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          } 
      }

    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("안녕!");

    keyboard.close();
  }

  
  static void addInfo() {
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
  }

  
  static void listInfo() {
    for(int i= 0; i < infoCount; i++) {
      Info in = infos[i];
      System.out.printf("%s, %s, %s, %s, %s\n",
          in.gender, in.qscore, in.sell, in.like, in.review);
    }
  }

  
  static void addPrice() {
    Price price = new Price();

    System.out.print("상품가격? ");
    price.pricetag = keyboard.nextLine();

    System.out.print("세일가격? ");
    price.reduced = keyboard.nextLine();

    System.out.print("회원가격? ");
    price.membership = keyboard.nextLine();

    prices[priceCount++] = price;
    System.out.println("저장하였습니다.");
  }      

  
  static void listPrice() {
    for (int i = 0; i < priceCount; i++) {
      Price p = prices[i];
      System.out.printf("%s, %s, %s\n",
          p.pricetag, p.reduced, p.membership);
    }
  }

  
  static void addDelivery() {
    Delivery delivery = new Delivery();

    System.out.print("배송방법? ");
    delivery.deliveryMethod = keyboard.nextLine();

    System.out.print("평균배송일");
    delivery.averageDeliveryDate = keyboard.nextLine();

    deliveries[deliveryCount++] = delivery;
    System.out.println("저장하였습니다.");
  }


  static void listDelivery() {
    for (int i = 0; i < deliveryCount; i++) {
      Delivery d = deliveries[i];
      System.out.printf("%s, %s \n",
          d.deliveryMethod, d.averageDeliveryDate);
    }
  }

  
}
