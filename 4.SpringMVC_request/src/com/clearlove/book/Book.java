package com.clearlove.book;

/**
 * 书名
 * 作者
 * 价格
 * 库存
 * 销量
 * @author promise
 * @date 2021/5/9 - 11:51
 */
public class Book {

  private String bookName;

  private String author;

  private Double price;

  private Integer stock;

  private Integer sales;

  private Address address;

  // 一定有无参构造器


  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public Integer getSales() {
    return sales;
  }

  public void setSales(Integer sales) {
    this.sales = sales;
  }

  @Override
  public String toString() {
    return "Book{" +
        "bookName='" + bookName + '\'' +
        ", author='" + author + '\'' +
        ", price=" + price +
        ", stock=" + stock +
        ", sales=" + sales +
        ", address=" + address +
        '}';
  }
}
