package cn.itcast.test;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/*
   详解EntityManager对象

      1.CRUD操作都通过该对象完成
      2.获得事务操作对象
 */
public class EntityManagerTest {
   @Test
   //获得事务操作对象
   public void fun1() {
      EntityManager manager = JPAUtils.getEntityManager();
      //获得事务操作对象
      EntityTransaction tx = manager.getTransaction();
      //打开事务
      tx.begin();
      //提交事务
      tx.commit();
      //回滚事务
      tx.rollback();
   }

   @Test
   //保存
   public void fun2() {
      EntityManager manager = JPAUtils.getEntityManager();
      //获得事务操作对象
      EntityTransaction tx = manager.getTransaction();
      //打开事务
      tx.begin();
   //--------------------------------------------------------------------------------------
      Customer c = new Customer();
      c.setCustName("黑马程序员");

      manager.persist(c);
   //--------------------------------------------------------------------------------------
      //提交事务
      tx.commit();
      //关闭资源
      manager.close();
   }

   @Test
   //查询 - OID
   public void fun3_1() {
      EntityManager manager = JPAUtils.getEntityManager();
      //获得事务操作对象
      EntityTransaction tx = manager.getTransaction();
      //打开事务
      tx.begin();
      //--------------------------------------------------------------------------------------
      //查询
      //参数1: 要查询的实体类型
      //参数2: 主键值
      Customer customer = manager.find(Customer.class, 1L);
      System.out.println("hehe");
      System.out.println(customer);
      //--------------------------------------------------------------------------------------
      //提交事务
      tx.commit();
      //关闭资源
      manager.close();
   }
   @Test
   //查询 - OID (延迟加载:不立即查询,而是使用时才查询)
   public void fun3_2() {
      EntityManager manager = JPAUtils.getEntityManager();
      //获得事务操作对象
      EntityTransaction tx = manager.getTransaction();
      //打开事务
      tx.begin();
      //--------------------------------------------------------------------------------------
      //查询
      //参数1: 要查询的实体类型
      //参数2: 主键值
      Customer customer = manager.getReference(Customer.class, 1L);
      System.out.println("hehe");
      System.out.println(customer);
      //--------------------------------------------------------------------------------------
      //提交事务
      tx.commit();
      //关闭资源
      manager.close();
   }

   @Test
   //修改
   public void fun4() {
      EntityManager manager = JPAUtils.getEntityManager();
      //获得事务操作对象
      EntityTransaction tx = manager.getTransaction();
      //打开事务
      tx.begin();
      //--------------------------------------------------------------------------------------
     //先查
      Customer customer = manager.find(Customer.class, 1L);
      //后改
      customer.setCustName("有福洗头房");
      //更新
      manager.merge(customer);
      //--------------------------------------------------------------------------------------
      //提交事务
      tx.commit();
      //关闭资源
      manager.close();
   }
   @Test
   //删除
   public void fun5() {
      EntityManager manager = JPAUtils.getEntityManager();
      //获得事务操作对象
      EntityTransaction tx = manager.getTransaction();
      //打开事务
      tx.begin();
      //--------------------------------------------------------------------------------------
      //先查
      Customer customer = manager.find(Customer.class, 1L);
      //更新
      manager.remove(customer);
      //--------------------------------------------------------------------------------------
      //提交事务
      tx.commit();
      //关闭资源
      manager.close();
   }
}
