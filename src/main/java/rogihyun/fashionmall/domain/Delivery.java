package rogihyun.fashionmall.domain;

public class Delivery {
  private int no;
  private String deliveryMethod;
  private String averageDeliveryDate;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getDeliveryMethod() {
    return deliveryMethod;
  }
  public void setDeliveryMethod(String deliveryMethod) {
    this.deliveryMethod = deliveryMethod;
  }
  public String getAverageDeliveryDate() {
    return averageDeliveryDate;
  }
  public void setAverageDeliveryDate(String averageDeliveryDate) {
    this.averageDeliveryDate = averageDeliveryDate;
  } 
  
}

