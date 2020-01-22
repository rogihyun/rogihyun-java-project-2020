package rogihyun.fashionmall.domain;

public class Price {
  private int no;
  private String pricetag;
  private String reduced;
  private String membership;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((membership == null) ? 0 : membership.hashCode());
    result = prime * result + no;
    result = prime * result + ((pricetag == null) ? 0 : pricetag.hashCode());
    result = prime * result + ((reduced == null) ? 0 : reduced.hashCode());
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
    Price other = (Price) obj;
    if (membership == null) {
      if (other.membership != null)
        return false;
    } else if (!membership.equals(other.membership))
      return false;
    if (no != other.no)
      return false;
    if (pricetag == null) {
      if (other.pricetag != null)
        return false;
    } else if (!pricetag.equals(other.pricetag))
      return false;
    if (reduced == null) {
      if (other.reduced != null)
        return false;
    } else if (!reduced.equals(other.reduced))
      return false;
    return true;
  }
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
