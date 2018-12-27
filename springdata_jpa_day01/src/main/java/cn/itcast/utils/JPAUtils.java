package cn.itcast.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
   private static EntityManagerFactory factory;
   static{  //虚拟机启动后,只会执行一次
      factory = Persistence.createEntityManagerFactory("myJpa");
   }
   //返回EntityManagerFactory
   public static EntityManagerFactory getEntityManagerFactory(){
     return factory; //每次返回的都是同一个实例
   }
   //通过EntityManagerFactory获得EntityManager并返回
   public static EntityManager getEntityManager(){
      return factory.createEntityManager();
   }

}
