package rogihyun.fashionmall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import com.google.gson.Gson;
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


  static List<Info> infoList = new ArrayList<>();
  static List<Delivery> deliveryList = new ArrayList<>();
  static List<Price> priceList = new ArrayList<>();

  public static void main(String[] args) {

    // 파일에서 데이터 로딩
    loadInfoData();
    loadDeliveryData();
    loadPriceData();

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
        try {
        commandHandler.execute();
        } catch (Exception e) {
          System.out.printf("명령어 실행 중 오류 발생: %s\n", e.getMessage());
        }
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }

    keyboard.close();

 // 데이터를 파일에 저장
    saveInfoData();
    saveDeliveryData();
    savePriceData();
  }

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
  private static void loadInfoData() {
    // 데이터가 보관된 파일을 정보를 준비한다.
    File file = new File("./info.json");

    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      infoList.addAll(Arrays.asList(new Gson().fromJson(in, Info[].class)));
      System.out.printf("총 %d 개의 수업 데이터를 로딩했습니다.\n", infoList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void saveInfoData() {
    // 데이터가 보관된 파일을 정보를 준비한다.
    File file = new File("./info.json");

    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      out.write(new Gson().toJson(infoList));
      System.out.printf("총 %d 개의 수업 데이터를 저장했습니다.\n", infoList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void loadDeliveryData() {
    File file = new File("./delivery.json");

    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      deliveryList.addAll(Arrays.asList(new Gson().fromJson(in, Delivery[].class)));
      System.out.printf("총 %d 개의 회원 데이터를 로딩했습니다.\n", deliveryList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void saveDeliveryData() {
    File file = new File("./delivery.json");

    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      out.write(new Gson().toJson(deliveryList));
      System.out.printf("총 %d 개의 회원 데이터를 저장했습니다.\n", deliveryList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void loadPriceData() {
    File file = new File("./price.json");

    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      priceList.addAll(Arrays.asList(new Gson().fromJson(in, Price[].class)));
      System.out.printf("총 %d 개의 게시물 데이터를 로딩했습니다.\n", priceList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void savePriceData() {
    File file = new File("./price.json");

    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      out.write(new Gson().toJson(priceList));
      System.out.printf("총 %d 개의 게시물 데이터를 저장했습니다.\n", priceList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    }
  }
}

