package rogihyun.fashionmall.domain;

public class Price {
  private int no;
  private String pricetag;   
  private String reduced;     
  private String membership;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getPricetag() {
    return pricetag;
  }
  public void setPricetag(String pricetag) {
    this.pricetag = pricetag;
  }
  public String getReduced() {
    return reduced;
  }
  public void setReduced(String reduced) {
    this.reduced = reduced;
  }
  public String getMembership() {
    return membership;
  }
  public void setMembership(String membership) {
    this.membership = membership;
  }  
  
  }
