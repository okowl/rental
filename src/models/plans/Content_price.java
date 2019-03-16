package models.plans;

public enum Content_price {

    //check this prices later

    BR_price(8.00),
    DVD_price(4.00),
    CD_price(2.00);

    final Double price;

  Content_price(Double price){
      this.price = price;
  }

    public Double getPrice() {
        return price;
    }
}
