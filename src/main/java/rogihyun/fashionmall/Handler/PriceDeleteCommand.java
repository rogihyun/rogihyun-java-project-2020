package rogihyun.fashionmall.Handler;

import java.util.List;
import rogihyun.fashionmall.domain.Price;
import rogihyun.util.Prompt;

// "/board/delete" 명령 처리
public class PriceDeleteCommand implements Command {

  List<Price> priceList;

  Prompt prompt;

  public PriceDeleteCommand(Prompt prompt, List<Price> list) {
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

    this.priceList.remove(index);

    System.out.println("게시글을 삭제했습니다.");
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


