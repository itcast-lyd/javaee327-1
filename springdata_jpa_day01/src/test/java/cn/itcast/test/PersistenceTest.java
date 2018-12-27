package cn.itcast.test;

import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 介绍Persistence
 *
 * 功能1: 读取配置文件(persistence.xml)
 * 功能2: 创建EntityManagerFactory对象
 *
 */
public class PersistenceTest {

   @Test
   public void fun1() {
      //读取配置文件,并创建EntityManagerFactory
      EntityManagerFactory factory =
         Persistence.createEntityManagerFactory("myJpa");
   }
}
