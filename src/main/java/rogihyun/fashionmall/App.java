package rogihyun.fashionmall;

import java.util.Scanner;
import rogihyun.fashionmall.Handler.DeliveryHandler;
import rogihyun.fashionmall.Handler.InfoHandler;
import rogihyun.fashionmall.Handler.PriceHandler;
import rogihyun.fashionmall.domain.Delivery;
import rogihyun.fashionmall.domain.Info;
import rogihyun.fashionmall.domain.Price;
import rogihyun.util.ArrayList;
import rogihyun.util.LinkedList;
import rogihyun.util.Prompt;
import rogihyun.util.Queue;
import rogihyun.util.Stack;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);

    LinkedList<Price> priceList = new LinkedList<>();
    PriceHandler priceHandler = new PriceHandler(prompt, priceList);

    ArrayList<Info> infoList = new ArrayList<>();
    InfoHandler infoHandler = new InfoHandler(prompt, infoList);

    ArrayList<Delivery> deliveryList = new ArrayList<>();
    DeliveryHandler deliveryHandler = new DeliveryHandler(prompt, deliveryList);

    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      if (command.length() == 0)
        continue;

      commandStack.push(command);

      commandQueue.offer(command);


      switch (command) {
        case "/info/add":
          infoHandler.addInfo();
          break;

        case "/info/list":
          infoHandler.listInfo();
          break;

        case "/info/detail":
          infoHandler.detailInfo();
          break;

        case "/info/update":
          infoHandler.updateInfo();
          break;

        case "/info/delete":
          infoHandler.deleteInfo();
          break;

        case "/delivery/add":
          deliveryHandler.addDelivery();
          break;

        case "/delivery/list":
          deliveryHandler.listDelivery();
          break;

        case "/delivery/detail":
          deliveryHandler.detailDelivery();
          break;

        case "/delivery/update":
          deliveryHandler.updateDelivery();
          break;

        case "/delivery/delete":
          deliveryHandler.deleteDelivery();
          break;

        case "/price/add":
          priceHandler.addPrice();
          break;
        case "/price/list":
          priceHandler.listPrice();
          break;

        case "/price/detail":
          priceHandler.detailPrice();
          break;

        case "/price/update":
          priceHandler.updatePrice();
          break;

        case "/price/delete":
          priceHandler.deletePrice();
          break;
        case "history":
          printCommandHistory();
          break;
        case "history2":
          printCommandHistory2();
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

  private static void printCommandHistory2() {
    Queue<String> historyQueue = commandQueue.clone();
    int count = 0;

    while (historyQueue.size() > 0) {
      System.out.println(historyQueue.poll());

      if ((++count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }

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
