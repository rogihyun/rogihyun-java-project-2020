package rogihyun.fashionmall;

import java.util.Scanner;
import rogihyun.fashionmall.Handler.DeliveryHandler;
import rogihyun.fashionmall.Handler.InfoHandler;
import rogihyun.fashionmall.Handler.PriceHandler;
import rogihyun.util.Prompt;
import rogihyun.util.Queue;
import rogihyun.util.Stack;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();

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
        case "history":
          printCommandHistory();
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
  private static void printCommandHistory() {
    Stack<String> historyStack = commandStack.clone();
    int count = 0;
    while (!historyStack.empty()) {
      System.out.println(historyStack.pop());
      count++;

      if ((count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
}