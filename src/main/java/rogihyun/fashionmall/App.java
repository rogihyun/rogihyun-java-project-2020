package rogihyun.fashionmall;

import java.util.Scanner;
import rogihyun.fashionmall.Handler.DeliveryHandler;
import rogihyun.fashionmall.Handler.InfoHandler;
import rogihyun.fashionmall.Handler.PriceHandler;
import rogihyun.util.Prompt;
public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);

    InfoHandler InfoHandler = new InfoHandler(prompt);
    DeliveryHandler DeliveryHandler = new DeliveryHandler(prompt);
    PriceHandler PriceHandler = new PriceHandler(prompt);

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
          InfoHandler.deleteInfo();
          break;

        case "/delivery/add":
          DeliveryHandler.addDelivery();
          break;

        case "/delivery/list":
          DeliveryHandler.listDelivery();
          break;

        case "/delivery/detail":
          DeliveryHandler.detailDelivery();
          break;

        case "/delivery/update":
          DeliveryHandler.updateDelivery();
          break;

        case "/delivery/delete":
          DeliveryHandler.deleteDelivery();
          break;

        case "/price/add":
          PriceHandler.addPrice();
          break;
        case "/price/list":
          PriceHandler.listPrice();
          break;

        case "/price/detail":
          PriceHandler.detailPrice();
          break;

        case "/price/update":
          PriceHandler.updatePrice();
          break;

        case "/price/delete":
          PriceHandler.deletePrice();
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