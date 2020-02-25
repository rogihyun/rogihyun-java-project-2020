package rogihyun.fashionmall.Handler;

import java.util.List;
import rogihyun.fashionmall.domain.Info;
import rogihyun.util.Prompt;

public class InfoUpdateCommand implements Command {

  List<Info> infoList;

  Prompt prompt;

  public InfoUpdateCommand(Prompt prompt, List<Info> list) {
    this.prompt = prompt;
    this.infoList = list;
  }

  @Override
  public void execute() {
    int index = indexOfLesson(prompt.inputInt("상품 인덱스? "));

    if (index == -1) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    Info oldInfo = this.infoList.get(index);
    Info newInfo = new Info();

    newInfo.setNo(oldInfo.getNo());

    newInfo.setNo(prompt.inputInt(
        String.format("번호(%s)? ", oldInfo.getNo()),
        oldInfo.getNo()));

    newInfo.setGender(prompt.inputString(
        String.format("성별(%s)?", oldInfo.getGender()),
        oldInfo.getGender()));

    newInfo.setQscore(prompt.inputString(
        String.format("인기도(%s)?", oldInfo.getQscore()),
        oldInfo.getQscore()));

    newInfo.setSell(prompt.inputString(
        String.format("판매도(%s)?", oldInfo.getSell()),
        oldInfo.getSell()));

    newInfo.setLike(prompt.inputString(
        String.format("좋아요(%s)?", oldInfo.getLike()),
        oldInfo.getLike()));

    newInfo.setReview(prompt.inputString(
        String.format("좋아요(%s)?", oldInfo.getReview()),
        oldInfo.getReview()));

    if (oldInfo.equals(newInfo)) {
      System.out.println("상품변경을 취소하였습니다.");
      return;
    }
    this.infoList.set(index, newInfo);
    System.out.println("수업을 변경했습니다.");
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

