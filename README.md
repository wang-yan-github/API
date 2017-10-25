1.类级别注解

@Entity    映射实体类
@Table   映射数句库表
@Entity(name="tableName") - 必须，注解将一个类声明为一个实体bean。
属性：
name- 可选，对应数据库中的一个表。若表名与实体类名相同，则可以省略。
@Table(name="",catalog="",schema="") - 可选，通常和@Entity 配合使用，只能标注在实 体的 class 定义处，表示实体对应的数据库表的信息。
属性：
name - 可选，表示表的名称，默认地，表名和实体名称一致，只有在不一致的情况下才需          要指定表名
catalog - 可选，表示Catalog名称，默认为Catalog("").
schema - 可选 , 表示 Schema 名称 , 默认为Schema("").
2.属性级别注解

@Id    映射生成主键
@Version   定义乐观锁
@Column    映射表的列
@Transient    定义暂态属性  
2.1与主键相关注解

@Id - 必须，定义了映射到数据库表的主键的属性，一个实体只能有一个属性被映射为主 键，置于 getXxxx() 前。
@GeneratedValue(strategy=GenerationType,generator="")- 可选，用于定义主键生成策略。
属性：
Strategy -表示主键生成策略，取值有：
GenerationType.AUTO - 根据底层数据库自动选择（默认），若数据库支持自动增长类型，则为自动增长。
GenerationType.INDENTITY - 根据数据库的Identity字段生成，支持DB2、MySQL、 MS、SQLServer、SyBase与HyperanoicSQL数据库的Identity 类型主键。
GenerationType.SEQUENCE - 使用Sequence来决定主键的取值，适合Oracle、DB2等支持Sequence的数据库，一般结合@SequenceGenerator使用。
(Oracle没有自动增长类型，只能用Sequence)
GenerationType.TABLE  -使用指定表来决定主键取值，结合@TableGenerator使用。
如：
@Id
@TableGenerator(name="tab_cat_gen",allocationSize=1)
@GeneratedValue(Strategy=GenerationType.Table)
Generator - 表示主键生成器的名称，这个属性通常和ORM框架相关, 例如：
Hibernate 可以指定 uuid 等主键生成方式
@SequenceGenerator — 注解声明了一个数据库序列。
属性：
name -表示该表主键生成策略名称，它被引用在@GeneratedValue中设置的“gernerator”值中。
sequenceName - 表示生成策略用到的数据库序列名称。
initialValue - 表示主键初始值，默认为0.
allocationSize -每次主键值增加的大小，例如设置成1，则表示每次创建新记录后自动加1，默认为50.
示例 :
   @Id
   @GeneratedValues(strategy=StrategyType.SEQUENCE)
   public int getPk() {
      return pk;  
   } 
Hibernate的访问类型为field时，在字段上进行注解声；
访问类型为property时，在getter方法上进行注释声明。
2.2 与非主键相关注解

@Version - 可以在实体bean中使用@Version注解,通过这种方式可添加对乐观锁定的支持
@Basic- 用于声明属性的存取策略：
@Basic(fetch=FetchType.EAGER)  即时获取（默认的存取策略）
@Basic(fetch=FetchType.LAZY)   延迟获取
@Temporal - 用于定义映射到数据库的时间精度：
@Temporal(TemporalType=DATE)      日期
@Temporal(TemporalType=TIME)      时间
@Temporal(TemporalType=TIMESTAMP)两者兼具
@Column - 可将属性映射到列，使用该注解来覆盖默认值，@Column描述了数据库表中          该字段的详细定义，这对于根据 JPA 注解生成数据库表结构的工具非常有作用。
属性：
name - 可选，表示数据库表中该字段的名称，默认情形属性名称一致
nullable -可选，表示该字段是否允许为null，默认为true
unique - 可选，表示该字段是否是唯一标识，默认为 false
length - 可选，表示该字段的大小，仅对 String 类型的字段有效，默认值255.
insertable -可选，表示在ORM框架执行插入操作时，该字段是否应出现INSETRT             语句中，默认为true
updateable -可选，表示在ORM框架执行更新操作时，该字段是否应该出现在             UPDATE语句中，默认为true.对于一经创建就不可以更改的字段，该         属性非常有用，如对于birthday字段。
columnDefinition - 可选，表示该字段在数据库中的实际类型。通常ORM框架可以根    据属性类型自动判断数据库中字段的类型，但是对于Date类型仍无法确定数据      库中字段类型究竟是DATE,TIME还是TIMESTAMP. 此外 ,String的默认映射类型为VARCHAR,如果要将String 类型映射到特定数据库的BLOB或TEXT字段类型，该属性非常有用。
示例 :
   @Column(name="BIRTH",nullable="false",columnDefinition="DATE")
   public String getBithday() {
      return birthday;
   }
@Transient - 可选，表示该属性并非一个到数据库表的字段的映射，ORM框架将忽略该属性，如果一个属性并非数据库表的字段映射，就务必将其标示为@Transient，否则ORM框架默认其注解为 @Basic
示例 :
   // 根据 birth 计算出 age 属性
   @Transient
   public int getAge() {
      return getYear(new Date()) - getYear(birth);
   }
2.3无注解属性的默认值

如果属性为单一类型,则映射为@Basic，
否则,如果属性对应的类型定义了@Embeddable注解,则映射为@Embedded，
否则,如果属性对应的类型实现了Serializable,则属性被映射为@Basic并在一个列中保存该对象的serialized版本，
否则,如果该属性的类型为java.sql.Clob或java.sql.Blob,则作为@Lob并映射到适当的LobType.。
3.映射继承关系

@Inheritance注解来定义所选择的策略.这个注解需要在每个类层次结构(class hierarchy) 最顶端的实体类上使用
4.映射实体bean的关联关系

4.1关联映射的一些定义

单向一对多：一方有集合属性，包含多个多方，而多方没有一方的引用。用户--->电子邮件
单向多对一：多方有一方的引用，一方没有多方的引用。论文类别--->类别
双向一对多：两边都有多方的引用，方便查询。班级--->学生
双向多对一：两边都有多方的引用，方便查询。
单向多对多：需要一个中间表来维护两个实体表。论坛--->文章
单向一对一：数据唯一，数据库数据也是一对一。舰船--->水手
主键相同的一对一：使用同一个主键，省掉外键关联。客户--->地址
单向：关系写哪边，就由谁管理。
双向：一般由多方管理。
@OneToMany(mappedBy="对方")//反向配置，对方管理。
4.2 关联映射的一些共有属性

@OneToOne、@OneToMany、@ManyToOne、ManyToMany的共有属性：
fetch - 配置加载方式。取值有
Fetch.EAGER - 及时加载，多对一默认是Fetch.EAGER 
Fetch.LAZY - 延迟加载，一对多默认是Fetch.LAZY
cascade - 设置级联方式，取值有：
CascadeType.PERSIST - 保存
CascadeType.REMOVE - 删除
CascadeType.MERGE - 修改
CascadeType.REFRESH - 刷新
CascadeType.ALL - 全部
targetEntity - 配置集合属性类型，如：@OneToMany(targetEntity=Book.class)
@JoinColumn - 可选，用于描述一个关联的字段。
@JoinColumn和@Column类似，介量描述的不是一个简单字段，而是一个关联字段，例如描述一个@ManyToOne 的字段。
属性：
name - 该字段的名称，由于@JoinColumn描述的是一个关联字段，如ManyToOne,则默认的名称由其关联的实体决定。
例如，实体 Order 有一个user 属性来关联实体 User, 则 Order 的 user 属性为一个外键 ,
其默认的名称为实体User的名称+ 下划线 + 实体User的主键名称
4.3 一对一关联

@OneToOne–表示一个一对一的映射
1.主表类A与从表类B的主键值相对应。
 主表：@OneToOne(cascade= CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public B getB(){
  Returnb;
   }
从表：无
 
2.主表A中有一个从表属性是B类型的b
主表：@OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="主表外键")  //这里指定的是数据库中的外键字段。
   publicB getB(){
return b;
      }
从表：无
 
3.主表A中有一个从表属性是B类型的b，同时，从表B中有一个主表属性是A类型的a
主表：@OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="主表外键")  //这里指定的是数据库中的外键字段。
   publicB getB(){
return b;
      }
从表：@OneToOne(mappedBy= "主表类中的从表属性")
   public主表类get主表类(){
return 主表对象
     }
  注意：@JoinColumn是可选的。默认值是从表变量名+"_"+从表的主键（注意，这里加的是主键。而不是主键对应的变量）。
4.4 多对一关联

@ManyToOne - 表示一个多对一的映射，该注解标注的属性通常是数据库表的外键。
1.单向多对一：多方有一方的引用，一方没有多方的引用。
         在多方
@ManyToOne(targetEntity=XXXX.class)  //指定关联对象
@JoinColumn(name="")                           //指定产生的外键字段名
2.双向多对一：配置方式同双向一对多。
示例 :
   // 订单 Order 和用户 User 是一个 ManyToOne 的关系
   // 在 Order 类中定义
   @ManyToOne()
   @JoinColumn(name="USER")
   public User getUser() {
      return user;
}
4.5 一对多关联

@OneToMany - 描述一个一对多的关联，该属性应该为集合类型，在数据库中并没有实际字段。
1.单向一对多：一方有集合属性，包含多个多方，而多方没有一方的引用。
@OneToMany 默认会使用连接表做一对多关联
添加@JoinColumn(name="xxx_id") 后，就会使用外键关联，而不使用连接表了。
2.双向一对多
1）在多方
@ManyToOne
@JoinColumn(name="自己的数据库外键列名")
2）在一方
@OneToMany(mappedBy="多端的关联属性名")
@JoinColumn(name="对方的数据库外键列名")
4.6 多对多关联

@ManyToMany - 可选，描述一个多对多的关联。
属性：
targetEntity - 表示多对多关联的另一个实体类的全名，例如：package.Book.class
mappedBy - 用在双向关联中，把关系的维护权翻转。
1.单向多对多关联：
   在主控方加入@ManyToMany注解即可。
2.双向多对多关联：
   两个实体间互相关联的属性必须标记为@ManyToMany，并相互指定targetEntity属性。有且只有一个实体的@ManyToMany注解需要指定mappedBy属性，指向targetEntity的集合属性名称。
[From:blog_935ebb670101dnre.html]
@Entity，注册在类头上，将一个类声明为一个实体bean(即一个持久化POJO类) 。
@Table，注册在类头上，注解声明了该实体bean映射指定的表（table）。
@Id用来注册主属性，@GeneratedValue用来注册主属性的生成策略，@Column用来注册属性，@Version用来注册乐观锁，@Transient用来注册不是属性。
以上的@Id、@GeneratedValue、 @Column 、@Version，可以用来注册属性，既可以写在Java类的属性上，也可以注册在属性对应的getter上。
@Transient注册在多余的属性或多余的getter上，但是必须与以上的@Column等对应。
@Column
标识属性对应的字段，示例：@Column(name=“userName")

@Column(
   name="columnName";                               (1)
    booleanunique() defaultfalse;                  (2)
    booleannullable() defaulttrue;                 (3)
    booleaninsertable() defaulttrue;               (4)
    booleanupdatable() defaulttrue;                (5)
    StringcolumnDefinition() default"";            (6)
    Stringtable() default"";                       (7)
    int length()default255;                        (8)
    intprecision() default 0; // decimalprecision   (9)
    int scale()default 0; // decimalscale          (10)
(1) name 可选,列名(默认值是属性名)
(2) unique 可选,是否在该列上设置唯一约束(默认值false)
(3) nullable 可选,是否设置该列的值可以为空(默认值false)
(4) insertable 可选,该列是否作为生成的insert语句中的一个列(默认值true)
(5) updatable 可选,该列是否作为生成的update语句中的一个列(默认值true)
(6) columnDefinition 可选: 为这个特定列覆盖SQL DDL片段(这可能导致无法在不同数据库间移植)
(7) table 可选,定义对应的表(默认为主表)
(8) length 可选,列长度(默认值255)
(8) precision 可选,列十进制精度(decimal precision)(默认值0)
(10) scale 可选,如果列十进制数值范围(decimal scale)可用,在此设置(默认值0)
@Id，标识这个属性是实体类的唯一识别的值。
注意：这个注解只能标注单一列构成的主键，如tbl_grade那种有两个字段组成的联合主键由其他注解标识。
回忆*.hbm.xml：
"uuid">
"assigned"/>
       
@Id，只是标识这个属性是主键，但是并没有指出其生成策略，如上例中的assigned就是由程序员指定的生成策略。
如果仅仅写出@Id，即是使用assigned生成略，如：
@Id
@Column
private int uuid;
如果想使用Oracle支持的sequence取主键，必须通过@GeneratedValue来指定生成策略，而由@SequenceGenerator指定如何使用sequence。
@Id
@Column
@GeneratedValue(
strategy = GenerationType.SEQUENCE,//使用sequence生成主键
generator =“generator“//引用下面名为gernator的生成策略
)
@SequenceGenerator(
name = “generator”,//定义名为generator的生成策略
allocationSize = 1，//每次sequence加1
name=“seq_a”//引用名为seq_a的sequence
)
private int uuid;
@Version
标识这个属性用来映射乐观锁的version
@Transient
标识这个属性不用持久化
@Embeddable【小对象的头上】
标识实体中可以定义一个嵌入式组件(embeddedcomponent)。组件类必须在类一级定义@Embeddable注解。
@Embedded【大对象的属性头上】
引用定义的小对象。
@Embeddable【小对象的头上】
标识实体中可以定义一个嵌入式组件(embeddedcomponent)。组件类必须在类一级定义@Embeddable注解。
注意：如果这个小对象作为复合主键，一定要实现Serializable接口。这并不是注解决定的，而是Hibernate的主键都需要实现Serializable接口。
@EmbeddedId 【大对象的属性头上】
引用定义的小对象作为主键。
注意：不需要再使用@Id注解。
  
[html] view plain copy
@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)//主键默认策略(由底层数据库决定主键策略)  
    public Integer getId() {  
        return id;  
    }  
    public void setId(Integer id) {  
        this.id = id;  
    }  
      
    @ManyToMany(  
            //targetEntity配置集合属性类型  
            targetEntity=cn.com.goevent.omms.bean.CompanyInfo.class,  
            //fetch 加载方式,延迟加载  
            fetch=FetchType.LAZY)  
    //关联表  
    @JoinTable(  
            name="exhibition_user",//关联表表名 (exhibition_user为多对多关系维护数据表)  
            joinColumns={@JoinColumn(name="exhibition_id")},//维护端外键   
            inverseJoinColumns={@JoinColumn(name="userid")})//被维护端外键   

XML的配置
主1【tbl_product】：

从1【tbl_product_info】：
product【引用自己的Java属性名】
注解的配置
主1【tbl_product】：
@OneToOne(cascade=CascadeType.ALL)
@PrimaryKeyJoinColumn
private ProductInfoModel info;
从1【tbl_product_info】：
@Id
@Column
@GeneratedValue(generator=“copy【引用生成策略】")
@GenericGenerator(name=“copy【定义生成策略】”,strategy=“foreign【写死，使用外来策略】”,parameters=@Parameter(name=“property”,value=“product【引用自己的Java属性】"))
private int uuid;
@OneToOne(mappedBy=“info【引用对方的Java属性】")
private ProductModel product;
 标准的1:M
  XML的配置
1【tbl_parent】：
 多【tbl_child】：
注解的配置
 
1【tbl_parent】：
@OneToMany
@JoinColumn(name="puuid【对方的数据库外键列名】")
private Set children = new HashSet();
多【tbl_child】：
@ManyToOne
@JoinColumn(name="puuid【自己的数据库外键列名】")
private ParentModel parent;
 

主1【tbl_product】：  
" cascade="all"/>  
从1【tbl_product_info】：  
true【写死】"/>  
注解的配置
主1【tbl_product】：
@OneToOne(cascade=CascadeType.ALL,mappedBy=“product【对方的Java类属性名】")
private ProductInfoModel info;
从1【tbl_product_info】：
@OneToOne
@JoinColumn(name=“puuid【自己的数据库外键列名】")
private ProductModel product;
Hibernate4注解方法

XML的配置
1【tbl_parent】：
class=“cn.javass.model.d.ChildModel【对方的Java类名】"/>
注解的配置
1【tbl_parent】：  
@OneToMany(mappedBy="parent【对方的Java类属性名 】")  
private Set children = new HashSet();  
多【tbl_child】：  
@ManyToOne  
@JoinTable(  
name=“tbl_parent_child【联接表】",  
joinColumns=@JoinColumn(name="cuuid【联接表里代表自己的数据库字段名】"),  
inverseJoinColumns=@JoinColumn(name="puuid【联接表里代表对方的数据库字段名】")  
)   
private ParentModel parent;  
Hibernate4注解方法

XML的配置
1【tbl_product】：
注解的配置
1【tbl_product】：
@ManyToOne
@JoinTable(
name=" tbl_product_relation 【联接表】",
joinColumns=@JoinColumn(name="suuid【联接表里代表自己的列名】"),
inverseJoinColumns=@JoinColumn(name="cuuid【联接表里代表对方的列名】",unique=true【写死】)
)
private CourseModel course;
错误一
错误信息：javax.persistence.Table.indexes([Ljavax/persistence/Index
原因：Hibernate4.3不支持@table(name="tablename")
解决方案：使用@entity(name="tablename")代替@table(name="tablename")
错误二
错误信息：javax.persistence.JoinColumn.foreignKey()Ljavax/persistence/ForeignKey
原因：Hibernate4.3在多对一映射的时候不能使用@JoinColumn
解决方案：只写@ManyToOne
错误三
错误信息：javax.persistence.OneToMany.orphanRemoval()Z
原因：javaee、ejb或junit的jar包与hibernate-jpa-2.0-api-1.0.0.Final.jar冲突
解决方案：查看是否存在以上jar包，如果存在，去掉即可
