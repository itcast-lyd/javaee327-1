package cn.itcast.domain;

import javax.persistence.*;


//@Entity表示该类是与数据库中表对应的实体类
@Entity
//@Table 指定实体类对应数据库中的哪张表
@Table(name = "cst_customer")
public class Customer {

   /** 主键生成策略=>指定数据库表主键值如何生成
    *    jpa规范一共规定了4种: Indentity|Sequence|Table|Auto
    *    hibernate最先提出,hibernate提出了7种: Indentity|Sequence|HILO|native|assigned|Increment|UUID
    *
    *    **Indentity:依赖于数据库的主键自增,适用于提供了主键自增功能的数据库: MYSQL|DB2|SQLServer|SQLLite
    *    **Sequence:使用于支持序列的数据库.主键值通过序列维护:Oracle
    *    Table : 使用数据库中的表来保管主键值
    *    Auto : 是自动从以上三个策略中选择.
    * **/
   @GeneratedValue(strategy = GenerationType.IDENTITY)

 /*  @TableGenerator(name ="hehe",
         table = "table_sequence",   //指定表名
         pkColumnName = "pk_id",     //指定表的第一列列名
         pkColumnValue = "t_customer_id",//指定第一列的值
         valueColumnName ="id_value", //指定第二列的列名
         initialValue = 0, //初始值,默认值就是0
         allocationSize = 1) //每次递增步长,默认值是50*/

   //@Id标识实体类中哪个属性对应数据库中的主键列,也就是OID.
   @Id
   /** @Column用于描述属性与列映射的细节
    *  name: 该属性与表的那一列对应，默认值就是属性名
    *  updatable：生成update语句时，是否包含该列，默认值：true
    *  insertable： 生成insert语句时，是否包含该列，默认值：true
    *  length ： 指定列的最大长度 ，默认值：使用最大长度
    *  unique ： 是否唯一 ，默认不唯一
    *  nullable：是否可为空，默认可为空
    * **/
   @Column(name="cust_id" )
   private Long custId;

   @Column(name="cust_name")
   private String custName;

   @Column(name="cust_source")
   private String custSource;

   @Column(name="cust_industry")
   private String custIndustry;

   @Column(name="cust_level")
   private String custLevel;

   @Column(name="cust_address")
   private String custAddress;

   @Column(name="cust_phone")
   private String custPhone;


   public Long getCustId() {
      return custId;
   }

   public void setCustId(Long custId) {
      this.custId = custId;
   }

   public String getCustName() {
      return custName;
   }

   public void setCustName(String custName) {
      this.custName = custName;
   }

   public String getCustSource() {
      return custSource;
   }

   public void setCustSource(String custSource) {
      this.custSource = custSource;
   }

   public String getCustIndustry() {
      return custIndustry;
   }

   public void setCustIndustry(String custIndustry) {
      this.custIndustry = custIndustry;
   }

   public String getCustLevel() {
      return custLevel;
   }

   public void setCustLevel(String custLevel) {
      this.custLevel = custLevel;
   }

   public String getCustAddress() {
      return custAddress;
   }

   public void setCustAddress(String custAddress) {
      this.custAddress = custAddress;
   }

   public String getCustPhone() {
      return custPhone;
   }

   public void setCustPhone(String custPhone) {
      this.custPhone = custPhone;
   }

   @Override
   public String toString() {
      return "Customer{" +
       "custId=" + custId +
       ", custName='" + custName + '\'' +
       '}';
   }
}
