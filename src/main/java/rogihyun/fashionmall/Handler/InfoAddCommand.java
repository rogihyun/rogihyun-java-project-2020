package rogihyun.fashionmall.Handler;

import java.util.List;
import rogihyun.fashionmall.domain.Info;
import rogihyun.util.Prompt;

public class InfoAddCommand implements Command {

  List<Info> infoList;

  Prompt prompt;

  public InfoAddCommand(Prompt prompt, List<Info> list) {
    this.prompt = prompt;
    this.infoList = list;
  }

  @Override
  public void execute() {
    Info info = new Info();

    info.setNo(prompt.inputInt("상품번호? "));
    info.setGender(prompt.inputString("성별? "));
    info.setQscore(prompt.inputString("인기도? "));
    info.setSell(prompt.inputString("판매도? "));
    info.setLike(prompt.inputString("좋아요? "));
    info.setReview(prompt.inputString("리뷰? "));

    infoList.add(info);

    System.out.println("저장하였습니다.");
  }
}


