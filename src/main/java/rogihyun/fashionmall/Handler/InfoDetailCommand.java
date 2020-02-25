package rogihyun.fashionmall.Handler;

import java.util.List;
import rogihyun.fashionmall.domain.Info;
import rogihyun.util.Prompt;

public class InfoDetailCommand implements Command {

  List<Info> infoList;

  Prompt prompt;

  public InfoDetailCommand(Prompt prompt, List<Info> list) {
    this.prompt = prompt;
    this.infoList = list;
  }

  @Override
  public void execute() {
    int index = indexOfLesson(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 수업이 없습니다.");
      return;
    }

    Info info = this.infoList.get(index);

    System.out.printf("상품번호: %s\n", info.getNo());
    System.out.printf("성별: %s\n", info.getGender());
    System.out.printf("인기도: %s\n", info.getQscore());
    System.out.printf("판매도: %s\n", info.getSell());
    System.out.printf("좋아요: %s\n", info.getLike());
    System.out.printf("리뷰: %s\n", info.getReview());
  }

  private int indexOfLesson(int no) {
    for (int i = 0; i < this.infoList.size(); i++) {
      if (this.infoList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}


