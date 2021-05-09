package com.clearlove.book;

/**
 * @author promise
 * @date 2021/5/9 - 12:03
 */
public class Address {

  private String province;

  private String city;

  private String street;

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  @Override
  public String toString() {
    return "Address{" +
        "province='" + province + '\'' +
        ", city='" + city + '\'' +
        ", street='" + street + '\'' +
        '}';
  }
}
