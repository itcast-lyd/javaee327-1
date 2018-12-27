package cn.itcast.test;

import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *详解:EntityManagerFactory
 *    功能1:保存配置信息
 *    功能2:创建EntityManager对象
 *
 * 注意:
 *    1.EntityManagerFactory线程安全
 *    2.EntityManagerFactory因为需要保存全部配置信息,内存占用较大.
 * 结论:一个项目中只需要创建一个EntityManagerFactory对象即可.
 */
public class EntityManagerFactoryTest {
   @Test
   public void fun1() {
      EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("myJpa");
      //创建EntityManager对象
      factory.createEntityManager();
   }
}
