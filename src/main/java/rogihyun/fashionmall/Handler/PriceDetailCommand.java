package rogihyun.fashionmall.Handler;

import java.util.List;
import rogihyun.fashionmall.domain.Price;
import rogihyun.util.Prompt;

// "/board/detail" 명령 처리
public class PriceDetailCommand implements Command {

  List<Price> priceList;

  Prompt prompt;

  public PriceDetailCommand(Prompt prompt, List<Price> list) {
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

    Price price = this.priceList.get(index);
    System.out.printf("번호: %d\n", price.getNo());
    System.out.printf("상품가격: %s\n", price.getPricetag());
    System.out.printf("세일가격: %s\n", price.getReduced());
    System.out.printf("회원가격: %s\n", price.getMembership());
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


