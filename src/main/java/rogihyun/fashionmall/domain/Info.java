package rogihyun.fashionmall.domain;

  public class Info {
    private int no;
    private String gender;
    private String qscore;
    private  String sell;
    private String like;
    private  String review;

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((gender == null) ? 0 : gender.hashCode());
      result = prime * result + ((like == null) ? 0 : like.hashCode());
      result = prime * result + no;
      result = prime * result + ((qscore == null) ? 0 : qscore.hashCode());
      result = prime * result + ((review == null) ? 0 : review.hashCode());
      result = prime * result + ((sell == null) ? 0 : sell.hashCode());
      return result;
    }
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Info other = (Info) obj;
      if (gender == null) {
        if (other.gender != null)
          return false;
      } else if (!gender.equals(other.gender))
        return false;
      if (like == null) {
        if (other.like != null)
          return false;
      } else if (!like.equals(other.like))
        return false;
      if (no != other.no)
        return false;
      if (qscore == null) {
        if (other.qscore != null)
          return false;
      } else if (!qscore.equals(other.qscore))
        return false;
      if (review == null) {
        if (other.review != null)
          return false;
      } else if (!review.equals(other.review))
        return false;
      if (sell == null) {
        if (other.sell != null)
          return false;
      } else if (!sell.equals(other.sell))
        return false;
      return true;
    }
    public int getNo() {
      return no;
    }
    public void setNo(int no) {
      this.no = no;
    }
    public String getGender() {
      return gender;
    }
    public void setGender(String gender) {
      this.gender = gender;
    }
    public String getQscore() {
      return qscore;
    }
    public void setQscore(String qscore) {
      this.qscore = qscore;
    }
    public String getSell() {
      return sell;
    }
    public void setSell(String sell) {
      this.sell = sell;
    }
    public String getLike() {
      return like;
    }
    public void setLike(String like) {
      this.like = like;
    }
    public String getReview() {
      return review;
    }
    public void setReview(String review) {
      this.review = review;
    }
  }



