package rogihyun.fashionmall;

import java.util.Scanner;
import rogihyun.fashionmall.Handler.DeliveryHandler;
import rogihyun.fashionmall.Handler.InfoHandler;
import rogihyun.fashionmall.Handler.PriceHandler;
import rogihyun.fashionmall.Handler.PriceHandler2;
public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    InfoHandler 상품정보 = new InfoHandler(keyboard);
    
    DeliveryHandler 배송정보 = new DeliveryHandler(keyboard);
    
    PriceHandler 가격정보1 = new PriceHandler(keyboard);
    
    PriceHandler2 가격정보2 = new PriceHandler2(keyboard);
    
    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/info/add":
          상품정보.addInfo();
          break;

        case "/info/list":
          상품정보.listInfo();
          break;

        case "/info/detail":
          상품정보.detailInfo();
          break;
          
          
        case "/delivery/add":
          배송정보.addDelivery();
          break;

        case "/delivery/list":
          배송정보.listDelivery();
          break;

        case "/price/add":
          가격정보1.addPrice();
          break;
        case "/price/list":
          가격정보1.listPrice();
          break;

        case "/price2/add":
          가격정보2.addPrice();
          break;
        case "/price2/list":
          가격정보2.listPrice();
          break;
          
        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          } 
      }

    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("감사합니다.!");

    keyboard.close();
  }

}
