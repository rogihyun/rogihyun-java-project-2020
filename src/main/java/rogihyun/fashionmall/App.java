package rogihyun.fashionmall;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import rogihyun.fashionmall.Handler.Command;
import rogihyun.fashionmall.Handler.ComputePlusCommand;
import rogihyun.fashionmall.Handler.DeliveryAddCommand;
import rogihyun.fashionmall.Handler.DeliveryDeleteCommand;
import rogihyun.fashionmall.Handler.DeliveryDetailCommand;
import rogihyun.fashionmall.Handler.DeliveryListCommand;
import rogihyun.fashionmall.Handler.DeliveryUpdateCommand;
import rogihyun.fashionmall.Handler.HelloCommand;
import rogihyun.fashionmall.Handler.InfoAddCommand;
import rogihyun.fashionmall.Handler.InfoDeleteCommand;
import rogihyun.fashionmall.Handler.InfoDetailCommand;
import rogihyun.fashionmall.Handler.InfoListCommand;
import rogihyun.fashionmall.Handler.InfoUpdateCommand;
import rogihyun.fashionmall.Handler.PriceAddCommand;
import rogihyun.fashionmall.Handler.PriceDeleteCommand;
import rogihyun.fashionmall.Handler.PriceDetailCommand;
import rogihyun.fashionmall.Handler.PriceListCommand;
import rogihyun.fashionmall.Handler.PriceUpdateCommand;
import rogihyun.fashionmall.domain.Delivery;
import rogihyun.fashionmall.domain.Info;
import rogihyun.fashionmall.domain.Price;
import rogihyun.util.Prompt;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> commandMap = new HashMap<>();

    LinkedList<Info> infoList = new LinkedList<>();
    commandMap.put("/info/add", new InfoAddCommand(prompt, infoList));
    commandMap.put("/info/list", new InfoListCommand(infoList));
    commandMap.put("/info/detail", new InfoDetailCommand(prompt, infoList));
    commandMap.put("/info/update", new InfoUpdateCommand(prompt, infoList));
    commandMap.put("/info/delete", new InfoDeleteCommand(prompt, infoList));

    ArrayList<Delivery> deliveryList = new ArrayList<>();
    commandMap.put("/delivery/add", new DeliveryAddCommand(prompt, deliveryList));
    commandMap.put("/delivery/list", new DeliveryListCommand(deliveryList));
    commandMap.put("/delivery/detail", new DeliveryDetailCommand(prompt, deliveryList));
    commandMap.put("/delivery/update", new DeliveryUpdateCommand(prompt, deliveryList));
    commandMap.put("/delivery/delete", new DeliveryDeleteCommand(prompt, deliveryList));

    LinkedList<Price> priceList = new LinkedList<>();
    commandMap.put("/price/add", new PriceAddCommand(prompt, priceList));
    commandMap.put("/price/list", new PriceListCommand(priceList));
    commandMap.put("/price/detail", new PriceDetailCommand(prompt, priceList));
    commandMap.put("/price/update", new PriceUpdateCommand(prompt, priceList));
    commandMap.put("/price/delete", new PriceDeleteCommand(prompt, priceList));

    commandMap.put("/hello", new HelloCommand(prompt));
    commandMap.put("/compute/plus", new ComputePlusCommand(prompt));


    String command;

    while (true) {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      if (command.length() == 0)
        continue;

      if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      }

      commandStack.push(command);

      commandQueue.offer(command);

      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        commandHandler.execute();
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }

    keyboard.close();
  }

  // 이전에는 Stack에서 값을 꺼내는 방법과 Queue에서 값을 꺼내는 방법이 다르기 때문에
  // printCommandHistory()와 printCommandHistory2() 메서드를 따로 정의했다.
  // 이제 Stack과 Queue는 일관된 방식으로 값을 꺼내주는 Iterator가 있기 때문에
  // 두 메서드를 하나로 합칠 수 있다.
  // 파라미터로 Iterator를 받아서 처리하기만 하면 된다.
  //
  private static void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
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


