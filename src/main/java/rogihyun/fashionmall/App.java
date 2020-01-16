package rogihyun.fashionmall;

import java.util.Scanner;
import rogihyun.fashionmall.Handler.DeliveryHandler;
import rogihyun.fashionmall.Handler.InfoHandler;
import rogihyun.fashionmall.Handler.PriceHandler;
public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    InfoHandler InfoHandler = new InfoHandler(keyboard);
    DeliveryHandler DeliveryHandler = new DeliveryHandler(keyboard);
    PriceHandler PriceHandler = new PriceHandler(keyboard);
    
    
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
          
        case "/info/update":
          InfoHandler.updateInfo();
          break;
          
        case "/info/delete":
          InfoHandler.updateInfo();
          break;
          
        case "/delivery/add":
          DeliveryHandler.addDelivery();
          break;

        case "/delivery/list":
          DeliveryHandler.listDelivery();
          break;
          
        case "/delivery/detail":
          DeliveryHandler.listDelivery();
          break;
          
        case "/delivery/update":
          DeliveryHandler.listDelivery();
          break;
          
        case "/delivery/delete":
          DeliveryHandler.listDelivery();
          break;

        case "/price/add":
          PriceHandler.addPrice();
          break;
        case "/price/list":
          PriceHandler.listPrice();
          break;
          
        case "/price/detail":
          PriceHandler.listPrice();
          break;
          
        case "/price/update":
          PriceHandler.listPrice();
          break;
          
        case "/price/delete":
          PriceHandler.listPrice();
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