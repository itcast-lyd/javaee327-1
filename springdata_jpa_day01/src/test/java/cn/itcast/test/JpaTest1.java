package cn.itcast.test;

import cn.itcast.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest1 {
   @Test
   //保存
   public void testSave() {
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");

      EntityManager manager = factory.createEntityManager();

      EntityTransaction tx = manager.getTransaction();

      tx.begin();
      //-----------------------------------------------------------------------------------------------------
     //创建Customer
      Customer  c = new Customer();
      c.setCustName("传智播客");
      //将客户对象保存到数据库
      manager.persist(c);
      //-----------------------------------------------------------------------------------------------------
      tx.commit();

      manager.close();

      factory.close();
   }
}
