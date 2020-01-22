package rogihyun.fashionmall.domain;

public class Delivery {
  private int no;
  private String deliveryMethod;
  private String averageDeliveryDate;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((averageDeliveryDate == null) ? 0 : averageDeliveryDate.hashCode());
    result = prime * result + ((deliveryMethod == null) ? 0 : deliveryMethod.hashCode());
    result = prime * result + no;
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
    Delivery other = (Delivery) obj;
    if (averageDeliveryDate == null) {
      if (other.averageDeliveryDate != null)
        return false;
    } else if (!averageDeliveryDate.equals(other.averageDeliveryDate))
      return false;
    if (deliveryMethod == null) {
      if (other.deliveryMethod != null)
        return false;
    } else if (!deliveryMethod.equals(other.deliveryMethod))
      return false;
    if (no != other.no)
      return false;
    return true;
  }
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

