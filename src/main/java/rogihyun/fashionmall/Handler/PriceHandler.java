package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Price;
import rogihyun.util.ArrayList;

public class PriceHandler {

  ArrayList<Price> priceList;

   Scanner input;

  public PriceHandler(Scanner input) {
    this.input = input;
    this.priceList = new ArrayList<>();
  }

  public PriceHandler(Scanner input, int capacity) {
    this.input = input;
    this.priceList = new ArrayList<>(capacity);
  }

  public  void listPrice() {
    Price[] arr = new Price[this.priceList.size()];
    this.priceList.toArray(arr);

    for (Price p : arr) {
      System.out.printf("%s, %s, %s\n",
          p.getPricetag(), p.getReduced(), p.getMembership());
    }
  }

  public  void addPrice() {
    Price price = new Price();

    System.out.print("번호? ");
    price.setNo(input.nextInt());

    input.nextLine();

    System.out.print("상품가격? ");
    price.setPricetag(input.nextLine());

    System.out.print("세일가격? ");
    price.setReduced(input.nextLine());

    System.out.print("회원가격? ");
    price.setMembership(input.nextLine());

    this.priceList.add(price);

    System.out.println("저장하였습니다.");
  }

  public void detailPrice() {
    System.out.print("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Price price = this.priceList.get(index);

    if (price == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", price.getNo());
    System.out.printf("상품가격: %s\n", price.getPricetag());
    System.out.printf("세일가격: %s\n", price.getReduced());
    System.out.printf("회원가격: %s\n", price.getMembership());
  }

  public void deletePrice() {
    System.out.print("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Price price = this.priceList.get(index);

    if (price == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    this.priceList.remove(index);

    System.out.println("게시글을 삭제했습니다.");
  }

  public void updatePrice() {
    System.out.print("번호? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Price oldPrice = this.priceList.get(index);

    if (oldPrice == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    boolean changed = false;
    String inputStr = null;
    Price newPrice = new Price();

    newPrice.setNo(oldPrice.getNo());

    System.out.printf("상품가격? ", oldPrice.getPricetag());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newPrice.setPricetag(oldPrice.getPricetag());
    } else {
      newPrice.setPricetag(inputStr);
      changed = true;
    }

    System.out.printf("세일가격? ", oldPrice.getReduced());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newPrice.setPricetag(oldPrice.getPricetag());
    } else {
      newPrice.setPricetag(inputStr);
      changed = true;
    }

    System.out.printf("회원가격? ",oldPrice.getMembership());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newPrice.setPricetag(oldPrice.getPricetag());
    } else {
      newPrice.setPricetag(inputStr);
      changed = true;
    }

    if (changed) {
      this.priceList.set(index, newPrice);
      System.out.println("회원을 변경했습니다.");
    } else {
      System.out.println("회원 변경을 취소하였습니다.");
    }
  }

}