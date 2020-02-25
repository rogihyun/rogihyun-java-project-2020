package rogihyun.fashionmall.Handler;

import java.util.List;
import rogihyun.fashionmall.domain.Price;
import rogihyun.util.Prompt;

// "/board/update" 명령 처리
public class PriceUpdateCommand implements Command {

  List<Price> priceList;

  Prompt prompt;

  public PriceUpdateCommand(Prompt prompt, List<Price> list) {
    this.prompt = prompt;
    this.priceList = list;
  }

  @Override
  public void execute() {
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


