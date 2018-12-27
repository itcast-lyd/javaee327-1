package cn.itcast.test;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/*
   详解EntityManager对象

     JPQL(JPA Query Language)语句 -> 用于面向对象的复杂查询

         Sun公司借鉴的Hibernate的HQL语句,与HQL(Hibernate QueryLanguage)语句语法一模一样.

 */
public class EntityManagerTest2 {
   @Test
   //查询所有客户
   public void fun1() {
      EntityManager manager = JPAUtils.getEntityManager();
      //获得事务操作对象
      EntityTransaction tx = manager.getTransaction();
      //打开事务
      tx.begin();
      //----------------------------------------------------------------------------------
      //1 创建JPQL语句
     // String jpql = " select c from cn.itcast.domain.Customer c ";
     // String jpql = " select c from Customer c ";
      String jpql = " from Customer  ";
      //2 根据JPQL封装查询对象
      Query query = manager.createQuery(jpql);
      //3 查询,并返回结果
      List<Customer> list = query.getResultList();

      System.out.println(list);
      //----------------------------------------------------------------------------------
      //提交事务
      tx.commit();
      manager.close();
   }
   @Test
   //条件查询客户 -> 名称中包含"有福"的客户 -> 问号占位符
   public void fun2() {
      EntityManager manager = JPAUtils.getEntityManager();
      //获得事务操作对象
      EntityTransaction tx = manager.getTransaction();
      //打开事务
      tx.begin();
      //----------------------------------------------------------------------------------
      //1 创建JPQL语句
      String jpql = " from Customer  where custName like ?";
      //2 根据JPQL封装查询对象
      Query query = manager.createQuery(jpql);
      //3 设置参数,参数1:问号的索引,参数2:问号的值
      query.setParameter(1,"%有福%");
      //4 查询,并返回结果
      List<Customer> list = query.getResultList();

      System.out.println(list);
      //----------------------------------------------------------------------------------
      //提交事务
      tx.commit();
      manager.close();
   }

   @Test
   //条件查询客户 -> 名称中包含"有福"的客户 -> 命名占位符
   public void fun2_2() {
      EntityManager manager = JPAUtils.getEntityManager();
      //获得事务操作对象
      EntityTransaction tx = manager.getTransaction();
      //打开事务
      tx.begin();
      //----------------------------------------------------------------------------------
      //1 创建JPQL语句
      String jpql = " from Customer  where custName like :abc  ";
      //2 根据JPQL封装查询对象
      Query query = manager.createQuery(jpql);
      //3 设置参数,参数1:问号的索引,参数2:问号的值
      query.setParameter("abc","%有福%");
      //4 查询,并返回结果
      List<Customer> list = query.getResultList();

      System.out.println(list);
      //----------------------------------------------------------------------------------
      //提交事务
      tx.commit();
      manager.close();
   }

   @Test
   //分页
   public void fun3() {
      EntityManager manager = JPAUtils.getEntityManager();
      //获得事务操作对象
      EntityTransaction tx = manager.getTransaction();
      //打开事务
      tx.begin();
      //----------------------------------------------------------------------------------
      //1 创建JPQL语句
      String jpql = " from Customer  ";
      //2 根据JPQL封装查询对象
      Query query = manager.createQuery(jpql);
      //3 设置分页参数   limit?,?
      query.setFirstResult(2); //limit的第一个问号
      query.setMaxResults(2);  //limit的第二个问号
      //4 查询,并返回结果
      List<Customer> list = query.getResultList();

      System.out.println(list);
      //----------------------------------------------------------------------------------
      //提交事务
      tx.commit();
      manager.close();
   }

   @Test
   //排序
   public void fun4() {
      EntityManager manager = JPAUtils.getEntityManager();
      //获得事务操作对象
      EntityTransaction tx = manager.getTransaction();
      //打开事务
      tx.begin();
      //----------------------------------------------------------------------------------
      //1 创建JPQL语句
      String jpql = " from Customer  order by custId desc ";
      //2 根据JPQL封装查询对象
      Query query = manager.createQuery(jpql);
      //3 查询,并返回结果
      List<Customer> list = query.getResultList();

      System.out.println(list);
      //----------------------------------------------------------------------------------
      //提交事务
      tx.commit();
      manager.close();
   }

   @Test
   //聚合函数
   public void fun5() {
      EntityManager manager = JPAUtils.getEntityManager();
      //获得事务操作对象
      EntityTransaction tx = manager.getTransaction();
      //打开事务
      tx.begin();
      //----------------------------------------------------------------------------------
      //1 创建JPQL语句
//      String jpql = "select sum(c.custId) from Customer c  ";
//      String jpql = "select avg(c.custId) from Customer c  ";
//      String jpql = "select count(c.custId) from Customer c  ";
//      String jpql = "select min(c.custId) from Customer c  ";
      String jpql = "select max(c.custId) from Customer c  ";
      //2 根据JPQL封装查询对象
      Query query = manager.createQuery(jpql);
      //3 查询,并返回唯一结果
      System.out.println(query.getSingleResult());
      //----------------------------------------------------------------------------------
      //提交事务
      tx.commit();
      manager.close();
   }
}
