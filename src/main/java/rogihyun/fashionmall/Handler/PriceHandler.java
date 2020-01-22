package rogihyun.fashionmall.Handler;

import java.util.LinkedList;
import rogihyun.fashionmall.domain.Price;
import rogihyun.util.Prompt;

public class PriceHandler {

  LinkedList<Price> priceList;

  Prompt prompt;

  public PriceHandler(Prompt prompt) {
    this.prompt = prompt;
    this.priceList = new LinkedList<>();
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

    price.setNo(prompt.inputInt("번호? "));
    price.setPricetag(prompt.inputString("상품가격? "));
    price.setReduced(prompt.inputString("세일가격? "));
    price.setMembership(prompt.inputString("회원가격? "));

    this.priceList.add(price);

    System.out.println("저장하였습니다.");
  }

  public void detailPrice() {
    int index = indexOfPrice(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    Price price = this.priceList.get(index);
    System.out.printf("번호: %d\n", price.getNo());
    System.out.printf("상품가격: %s\n", price.getPricetag());
    System.out.printf("세일가격: %s\n", price.getReduced());
    System.out.printf("회원가격: %s\n", price.getMembership());
  }

  public void deletePrice() {
    int index = indexOfPrice(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    this.priceList.remove(index);

    System.out.println("게시글을 삭제했습니다.");
  }

  public void updatePrice() {
    int index = indexOfPrice(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    Price oldPrice = this.priceList.get(index);
    Price newPrice = new Price();

    newPrice.setPricetag(prompt.inputString(
        String.format("상품가격(%s)? ", oldPrice.getPricetag()),
        oldPrice.getPricetag()));

    newPrice.setReduced(prompt.inputString(
        String.format("상품가격(%s)? ", oldPrice.getReduced()),
        oldPrice.getReduced()));

    newPrice.setMembership(prompt.inputString(
        String.format("상품가격(%s)? ", oldPrice.getMembership()),
        oldPrice.getMembership()));

  if (oldPrice.equals(newPrice)) {
    System.out.println("게시글 변경을 취소했습니다.");
    return;
  }

  this.priceList.set(index, newPrice);
  System.out.println("게시글을 변경했습니다.");
}

  private int indexOfPrice(int no) {
    for (int i = 0; i < this.priceList.size(); i++) {
      if (this.priceList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

 }
