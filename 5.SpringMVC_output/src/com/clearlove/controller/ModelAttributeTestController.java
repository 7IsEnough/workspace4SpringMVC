package com.clearlove.controller;

import com.clearlove.bean.Book;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 测试ModelAttribute注解：
 * 使用场景：书城的图书修改
 * 1.页面端
 *    显示要修改的图书的信息，图书的所有字段都在
 * 2.servlet收到修改请求，调用dao
 *    String sql = "update bs_book set title=?,
 *                  author=?, price=?,
 *                  sales=?, stock=?, img_path=?
 *                  where id=?";
 * 3.实际场景?
 *     并不是全字段修改；只会修改部分字段，以修改用户信息为例
 *     username   password   address
 *     1) 不修改的字段可以在页面进行展示，但不要提供修改输入框
 *     2) 为了简单，Controller直接在参数位置来写Book对象
 *     3) SpringMVC为我们自动封装book；(没有带的值是Null)
 *     4) 如果接下来调用了一个全字段更新的dao操作；会将其他的字段可能变为Null
 *          sql = "update bs_book set"
 *          if(book.getBookName()) {
 *            sql += "bookName=?,"
 *          }
 *          if(book.getPrice()) {
 *            sql += "price=?,"
 *          }
 *          拼接sql时会出现问题
 *
 * 4.如何能保证全字段更新的时候，只更新了页面携带的数据；
 *     1) 修改dao；代价大?
 *     2) Book对象是如何封装的?
 *          1)) SpringMVC创建一个book对象，每个属性都有默认值，bookName就是null
 *              1))) 让SpringMVC别创建book对象，直接从数据库中先取出一个id=100的book对象的信息
 *              2))) id=100, bookName='西游记', author='张三', stock=12, sales=32, price=98.98
 *          2)) 将请求中所有与book对应的属性一一设置过来
 *              1))) 使用刚才从数据库取出的book对象，给它的里面设置值；(请求参数带了哪些值就覆盖之前的值)
 *              2))) 带了的字段就改为携带的值，没带的字段就保持之前的值
 *          3)) 调用全字段更新就有问题
 *              1))) 将之前从数据库中查到的对象，并且封装了请求参数的对象。进行保存
 *
 *
 *
 * @author promise
 * @date 2021/5/12 - 22:24
 */
//@SessionAttributes("haha")
/** 最好不要使用
 *      1.为了避免可能引发的异常
 *          保证两点：
 *             1) 要么隐含模型中有@SessionAttributes标注的属性；
 *             2) 如果隐含模型中没有，session说有就一定要有，否则抛异常
 */
@Controller
public class ModelAttributeTestController {


  private Object o1;
  private Object o2;

  private Object b1;
  private Object b2;

  /**
   * 可以告诉SpringMVC不要new这个book对象
   * 使用从数据库查询出并保存的book对象
   *
   * 同都是BindingAwareModelMap
   * @param book
   * @return
   */
  @RequestMapping("/updateBook")
  public String updateBook(@RequestParam(value = "author") String author,
      Map<String, Object> model,
      HttpServletRequest request,
      @ModelAttribute("haha") Book book) {
    o2 = model;
    b2 = book;
    Object object = model.get("book");
    //    System.out.println("传入的model：" + model.getClass());
    System.out.println("o1==o2?" + (o1==o2));
    System.out.println("b1==b2?" + (b1==b2) + "-->" +(b2 == object));
    System.out.println("页面要提交过来的图书信息：" + book);
    // bookDao.update(book);
//    id=100, bookName='null', author='张三', stock=12, sales=32, price=98.98
    // 容易把null值赋给sql进行修改
//    String sql = "update bs_book set bookName=?,
//                  author=?, price=?,
//                  sales=?, stock=?, img_path=?
//                  where id=?";
    return "success";
  }

  /**
   * 1.SpringMVC要封装请求参数的Book对象不应该是自己new出来的
   *    而应该是从【数据库中】拿到的准备好的对象
   * 2.再来使用这个对象封装请求参数
   *
   * @ModelAttribute
   *    参数：取出刚才保存的数据
   *    方法位置：这个方法就会提前于目标方法先运行
   *        1) 我们可以在这里提前查出数据库中图书的信息
   *        2) 将这个图书信息保存起来(方便下一个方法还能使用)
   *
   * 参数的map：BindingAwareModelMap
   * @ModelAttribute 标注的方法会提前运行，并把方法的运行结果放在隐含模型中
   *    放的时候会使用一个Key;
   *        如果@ModelAttribute("book")指定了，就用指定的book；
   *        如果没指定就用返回值类型的首字母小写作为key
   */
  @ModelAttribute("haha")
  public void hahaMyModelAttribute(Map<String, Object> map) {
    Book book = new Book(100, "西游记", "吴承恩", 98, 10, 98.98);
    System.out.println("数据库中查到的信息是：" + book);
    map.put("book", book);
    b1 = book;
    o1 = map;
    System.out.println("modelAttribute方法。。。查询了图书并保存了...使用map的类型：" + map.getClass());
//    return book;
  }

}
