package rogihyun.fashionmall;

import java.util.Scanner;
import rogihyun.fashionmall.Handler.DeliveryHandler;
import rogihyun.fashionmall.Handler.InfoHandler;
import rogihyun.fashionmall.Handler.priceHandler;
import rogihyun.fashionmall.Handler.priceHandler2;
public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    InfoHandler.keyboard = keyboard;
    DeliveryHandler.keyboard = keyboard;
    priceHandler.keyboard = keyboard;
    priceHandler2.keyboard = keyboard;
    
    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/info/add":
          InfoHandler.addInfo();
          break;

        case "/info/list":
          InfoHandler.listInfo();
          break;

        case "/info/detail":
          InfoHandler.detailInfo();
          break;
          
          
        case "/delivery/add":
          DeliveryHandler.addDelivery();
          break;

        case "/delivery/list":
          DeliveryHandler.listDelivery();
          break;

        case "/price/add":
          priceHandler.addPrice();
          break;
        case "/price/list":
          priceHandler.listPrice();
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
