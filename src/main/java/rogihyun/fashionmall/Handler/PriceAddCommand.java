package rogihyun.fashionmall.Handler;

import java.util.List;
import rogihyun.fashionmall.domain.Price;
import rogihyun.util.Prompt;

public class PriceAddCommand implements Command {

  List<Price> priceList;

  Prompt prompt;

  public PriceAddCommand(Prompt prompt, List<Price> list) {
    this.prompt = prompt;
    this.priceList = list;
  }

  @Override
  public void execute() {
    Price price = new Price();

    price.setNo(prompt.inputInt("번호? "));
    price.setPricetag(prompt.inputString("상품가격? "));
    price.setReduced(prompt.inputString("세일가격? "));
    price.setMembership(prompt.inputString("회원가격? "));

    this.priceList.add(price);

    System.out.println("저장하였습니다.");
  }

}


