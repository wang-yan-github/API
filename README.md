1.�༶��ע��

@Entity    ӳ��ʵ����
@Table   ӳ��������
@Entity(name="tableName") - ���룬ע�⽫һ��������Ϊһ��ʵ��bean��
���ԣ�
name- ��ѡ����Ӧ���ݿ��е�һ������������ʵ��������ͬ�������ʡ�ԡ�
@Table(name="",catalog="",schema="") - ��ѡ��ͨ����@Entity ���ʹ�ã�ֻ�ܱ�ע��ʵ ��� class ���崦����ʾʵ���Ӧ�����ݿ�����Ϣ��
���ԣ�
name - ��ѡ����ʾ������ƣ�Ĭ�ϵأ�������ʵ������һ�£�ֻ���ڲ�һ�µ�����²���          Ҫָ������
catalog - ��ѡ����ʾCatalog���ƣ�Ĭ��ΪCatalog("").
schema - ��ѡ , ��ʾ Schema ���� , Ĭ��ΪSchema("").
2.���Լ���ע��

@Id    ӳ����������
@Version   �����ֹ���
@Column    ӳ������
@Transient    ������̬����  
2.1���������ע��

@Id - ���룬������ӳ�䵽���ݿ������������ԣ�һ��ʵ��ֻ����һ�����Ա�ӳ��Ϊ�� �������� getXxxx() ǰ��
@GeneratedValue(strategy=GenerationType,generator="")- ��ѡ�����ڶ����������ɲ��ԡ�
���ԣ�
Strategy -��ʾ�������ɲ��ԣ�ȡֵ�У�
GenerationType.AUTO - ���ݵײ����ݿ��Զ�ѡ��Ĭ�ϣ��������ݿ�֧���Զ��������ͣ���Ϊ�Զ�������
GenerationType.INDENTITY - �������ݿ��Identity�ֶ����ɣ�֧��DB2��MySQL�� MS��SQLServer��SyBase��HyperanoicSQL���ݿ��Identity ����������
GenerationType.SEQUENCE - ʹ��Sequence������������ȡֵ���ʺ�Oracle��DB2��֧��Sequence�����ݿ⣬һ����@SequenceGeneratorʹ�á�
(Oracleû���Զ��������ͣ�ֻ����Sequence)
GenerationType.TABLE  -ʹ��ָ��������������ȡֵ�����@TableGeneratorʹ�á�
�磺
@Id
@TableGenerator(name="tab_cat_gen",allocationSize=1)
@GeneratedValue(Strategy=GenerationType.Table)
Generator - ��ʾ���������������ƣ��������ͨ����ORM������, ���磺
Hibernate ����ָ�� uuid ���������ɷ�ʽ
@SequenceGenerator �� ע��������һ�����ݿ����С�
���ԣ�
name -��ʾ�ñ��������ɲ������ƣ�����������@GeneratedValue�����õġ�gernerator��ֵ�С�
sequenceName - ��ʾ���ɲ����õ������ݿ��������ơ�
initialValue - ��ʾ������ʼֵ��Ĭ��Ϊ0.
allocationSize -ÿ������ֵ���ӵĴ�С���������ó�1�����ʾÿ�δ����¼�¼���Զ���1��Ĭ��Ϊ50.
ʾ�� :
   @Id
   @GeneratedValues(strategy=StrategyType.SEQUENCE)
   public int getPk() {
      return pk;  
   } 
Hibernate�ķ�������Ϊfieldʱ�����ֶ��Ͻ���ע������
��������Ϊpropertyʱ����getter�����Ͻ���ע��������
2.2 ����������ע��

@Version - ������ʵ��bean��ʹ��@Versionע��,ͨ�����ַ�ʽ����Ӷ��ֹ�������֧��
@Basic- �����������ԵĴ�ȡ���ԣ�
@Basic(fetch=FetchType.EAGER)  ��ʱ��ȡ��Ĭ�ϵĴ�ȡ���ԣ�
@Basic(fetch=FetchType.LAZY)   �ӳٻ�ȡ
@Temporal - ���ڶ���ӳ�䵽���ݿ��ʱ�侫�ȣ�
@Temporal(TemporalType=DATE)      ����
@Temporal(TemporalType=TIME)      ʱ��
@Temporal(TemporalType=TIMESTAMP)���߼��
@Column - �ɽ�����ӳ�䵽�У�ʹ�ø�ע��������Ĭ��ֵ��@Column���������ݿ����          ���ֶε���ϸ���壬����ڸ��� JPA ע���������ݿ��ṹ�Ĺ��߷ǳ������á�
���ԣ�
name - ��ѡ����ʾ���ݿ���и��ֶε����ƣ�Ĭ��������������һ��
nullable -��ѡ����ʾ���ֶ��Ƿ�����Ϊnull��Ĭ��Ϊtrue
unique - ��ѡ����ʾ���ֶ��Ƿ���Ψһ��ʶ��Ĭ��Ϊ false
length - ��ѡ����ʾ���ֶεĴ�С������ String ���͵��ֶ���Ч��Ĭ��ֵ255.
insertable -��ѡ����ʾ��ORM���ִ�в������ʱ�����ֶ��Ƿ�Ӧ����INSETRT             ����У�Ĭ��Ϊtrue
updateable -��ѡ����ʾ��ORM���ִ�и��²���ʱ�����ֶ��Ƿ�Ӧ�ó�����             UPDATE����У�Ĭ��Ϊtrue.����һ�������Ͳ����Ը��ĵ��ֶΣ���         ���Էǳ����ã������birthday�ֶΡ�
columnDefinition - ��ѡ����ʾ���ֶ������ݿ��е�ʵ�����͡�ͨ��ORM��ܿ��Ը�    �����������Զ��ж����ݿ����ֶε����ͣ����Ƕ���Date�������޷�ȷ������      �����ֶ����;�����DATE,TIME����TIMESTAMP. ���� ,String��Ĭ��ӳ������ΪVARCHAR,���Ҫ��String ����ӳ�䵽�ض����ݿ��BLOB��TEXT�ֶ����ͣ������Էǳ����á�
ʾ�� :
   @Column(name="BIRTH",nullable="false",columnDefinition="DATE")
   public String getBithday() {
      return birthday;
   }
@Transient - ��ѡ����ʾ�����Բ���һ�������ݿ����ֶε�ӳ�䣬ORM��ܽ����Ը����ԣ����һ�����Բ������ݿ����ֶ�ӳ�䣬����ؽ����ʾΪ@Transient������ORM���Ĭ����ע��Ϊ @Basic
ʾ�� :
   // ���� birth ����� age ����
   @Transient
   public int getAge() {
      return getYear(new Date()) - getYear(birth);
   }
2.3��ע�����Ե�Ĭ��ֵ

�������Ϊ��һ����,��ӳ��Ϊ@Basic��
����,������Զ�Ӧ�����Ͷ�����@Embeddableע��,��ӳ��Ϊ@Embedded��
����,������Զ�Ӧ������ʵ����Serializable,�����Ա�ӳ��Ϊ@Basic����һ�����б���ö����serialized�汾��
����,��������Ե�����Ϊjava.sql.Clob��java.sql.Blob,����Ϊ@Lob��ӳ�䵽�ʵ���LobType.��
3.ӳ��̳й�ϵ

@Inheritanceע����������ѡ��Ĳ���.���ע����Ҫ��ÿ�����νṹ(class hierarchy) ��˵�ʵ������ʹ��
4.ӳ��ʵ��bean�Ĺ�����ϵ

4.1����ӳ���һЩ����

����һ�Զࣺһ���м������ԣ���������෽�����෽û��һ�������á��û�--->�����ʼ�
������һ���෽��һ�������ã�һ��û�ж෽�����á��������--->���
˫��һ�Զࣺ���߶��ж෽�����ã������ѯ���༶--->ѧ��
˫����һ�����߶��ж෽�����ã������ѯ��
�����Զࣺ��Ҫһ���м����ά������ʵ�����̳--->����
����һ��һ������Ψһ�����ݿ�����Ҳ��һ��һ������--->ˮ��
������ͬ��һ��һ��ʹ��ͬһ��������ʡ������������ͻ�--->��ַ
���򣺹�ϵд�ıߣ�����˭����
˫��һ���ɶ෽����
@OneToMany(mappedBy="�Է�")//�������ã��Է�����
4.2 ����ӳ���һЩ��������

@OneToOne��@OneToMany��@ManyToOne��ManyToMany�Ĺ������ԣ�
fetch - ���ü��ط�ʽ��ȡֵ��
Fetch.EAGER - ��ʱ���أ����һĬ����Fetch.EAGER 
Fetch.LAZY - �ӳټ��أ�һ�Զ�Ĭ����Fetch.LAZY
cascade - ���ü�����ʽ��ȡֵ�У�
CascadeType.PERSIST - ����
CascadeType.REMOVE - ɾ��
CascadeType.MERGE - �޸�
CascadeType.REFRESH - ˢ��
CascadeType.ALL - ȫ��
targetEntity - ���ü����������ͣ��磺@OneToMany(targetEntity=Book.class)
@JoinColumn - ��ѡ����������һ���������ֶΡ�
@JoinColumn��@Column���ƣ����������Ĳ���һ�����ֶΣ�����һ�������ֶΣ���������һ��@ManyToOne ���ֶΡ�
���ԣ�
name - ���ֶε����ƣ�����@JoinColumn��������һ�������ֶΣ���ManyToOne,��Ĭ�ϵ��������������ʵ�������
���磬ʵ�� Order ��һ��user ����������ʵ�� User, �� Order �� user ����Ϊһ����� ,
��Ĭ�ϵ�����Ϊʵ��User������+ �»��� + ʵ��User����������
4.3 һ��һ����

@OneToOne�C��ʾһ��һ��һ��ӳ��
1.������A��ӱ���B������ֵ���Ӧ��
 ����@OneToOne(cascade= CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public B getB(){
  Returnb;
   }
�ӱ���
 
2.����A����һ���ӱ�������B���͵�b
����@OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="�������")  //����ָ���������ݿ��е�����ֶΡ�
   publicB getB(){
return b;
      }
�ӱ���
 
3.����A����һ���ӱ�������B���͵�b��ͬʱ���ӱ�B����һ������������A���͵�a
����@OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="�������")  //����ָ���������ݿ��е�����ֶΡ�
   publicB getB(){
return b;
      }
�ӱ�@OneToOne(mappedBy= "�������еĴӱ�����")
   public������get������(){
return �������
     }
  ע�⣺@JoinColumn�ǿ�ѡ�ġ�Ĭ��ֵ�Ǵӱ������+"_"+�ӱ��������ע�⣬����ӵ���������������������Ӧ�ı�������
4.4 ���һ����

@ManyToOne - ��ʾһ�����һ��ӳ�䣬��ע���ע������ͨ�������ݿ��������
1.������һ���෽��һ�������ã�һ��û�ж෽�����á�
         �ڶ෽
@ManyToOne(targetEntity=XXXX.class)  //ָ����������
@JoinColumn(name="")                           //ָ������������ֶ���
2.˫����һ�����÷�ʽͬ˫��һ�Զࡣ
ʾ�� :
   // ���� Order ���û� User ��һ�� ManyToOne �Ĺ�ϵ
   // �� Order ���ж���
   @ManyToOne()
   @JoinColumn(name="USER")
   public User getUser() {
      return user;
}
4.5 һ�Զ����

@OneToMany - ����һ��һ�Զ�Ĺ�����������Ӧ��Ϊ�������ͣ������ݿ��в�û��ʵ���ֶΡ�
1.����һ�Զࣺһ���м������ԣ���������෽�����෽û��һ�������á�
@OneToMany Ĭ�ϻ�ʹ�����ӱ���һ�Զ����
���@JoinColumn(name="xxx_id") �󣬾ͻ�ʹ���������������ʹ�����ӱ��ˡ�
2.˫��һ�Զ�
1���ڶ෽
@ManyToOne
@JoinColumn(name="�Լ������ݿ��������")
2����һ��
@OneToMany(mappedBy="��˵Ĺ���������")
@JoinColumn(name="�Է������ݿ��������")
4.6 ��Զ����

@ManyToMany - ��ѡ������һ����Զ�Ĺ�����
���ԣ�
targetEntity - ��ʾ��Զ��������һ��ʵ�����ȫ�������磺package.Book.class
mappedBy - ����˫������У��ѹ�ϵ��ά��Ȩ��ת��
1.�����Զ������
   �����ط�����@ManyToManyע�⼴�ɡ�
2.˫���Զ������
   ����ʵ��以����������Ա�����Ϊ@ManyToMany�����໥ָ��targetEntity���ԡ�����ֻ��һ��ʵ���@ManyToManyע����Ҫָ��mappedBy���ԣ�ָ��targetEntity�ļ����������ơ�
[From:blog_935ebb670101dnre.html]
@Entity��ע������ͷ�ϣ���һ��������Ϊһ��ʵ��bean(��һ���־û�POJO��) ��
@Table��ע������ͷ�ϣ�ע�������˸�ʵ��beanӳ��ָ���ı�table����
@Id����ע�������ԣ�@GeneratedValue����ע�������Ե����ɲ��ԣ�@Column����ע�����ԣ�@Version����ע���ֹ�����@Transient����ע�᲻�����ԡ�
���ϵ�@Id��@GeneratedValue�� @Column ��@Version����������ע�����ԣ��ȿ���д��Java��������ϣ�Ҳ����ע�������Զ�Ӧ��getter�ϡ�
@Transientע���ڶ�������Ի�����getter�ϣ����Ǳ��������ϵ�@Column�ȶ�Ӧ��
@Column
��ʶ���Զ�Ӧ���ֶΣ�ʾ����@Column(name=��userName")

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
(1) name ��ѡ,����(Ĭ��ֵ��������)
(2) unique ��ѡ,�Ƿ��ڸ���������ΨһԼ��(Ĭ��ֵfalse)
(3) nullable ��ѡ,�Ƿ����ø��е�ֵ����Ϊ��(Ĭ��ֵfalse)
(4) insertable ��ѡ,�����Ƿ���Ϊ���ɵ�insert����е�һ����(Ĭ��ֵtrue)
(5) updatable ��ѡ,�����Ƿ���Ϊ���ɵ�update����е�һ����(Ĭ��ֵtrue)
(6) columnDefinition ��ѡ: Ϊ����ض��и���SQL DDLƬ��(����ܵ����޷��ڲ�ͬ���ݿ����ֲ)
(7) table ��ѡ,�����Ӧ�ı�(Ĭ��Ϊ����)
(8) length ��ѡ,�г���(Ĭ��ֵ255)
(8) precision ��ѡ,��ʮ���ƾ���(decimal precision)(Ĭ��ֵ0)
(10) scale ��ѡ,�����ʮ������ֵ��Χ(decimal scale)����,�ڴ�����(Ĭ��ֵ0)
@Id����ʶ���������ʵ�����Ψһʶ���ֵ��
ע�⣺���ע��ֻ�ܱ�ע��һ�й��ɵ���������tbl_grade�����������ֶ���ɵ���������������ע���ʶ��
����*.hbm.xml��
"uuid">
"assigned"/>
       
@Id��ֻ�Ǳ�ʶ������������������ǲ�û��ָ�������ɲ��ԣ��������е�assigned�����ɳ���Աָ�������ɲ��ԡ�
�������д��@Id������ʹ��assigned�����ԣ��磺
@Id
@Column
private int uuid;
�����ʹ��Oracle֧�ֵ�sequenceȡ����������ͨ��@GeneratedValue��ָ�����ɲ��ԣ�����@SequenceGeneratorָ�����ʹ��sequence��
@Id
@Column
@GeneratedValue(
strategy = GenerationType.SEQUENCE,//ʹ��sequence��������
generator =��generator��//����������Ϊgernator�����ɲ���
)
@SequenceGenerator(
name = ��generator��,//������Ϊgenerator�����ɲ���
allocationSize = 1��//ÿ��sequence��1
name=��seq_a��//������Ϊseq_a��sequence
)
private int uuid;
@Version
��ʶ�����������ӳ���ֹ�����version
@Transient
��ʶ������Բ��ó־û�
@Embeddable��С�����ͷ�ϡ�
��ʶʵ���п��Զ���һ��Ƕ��ʽ���(embeddedcomponent)��������������һ������@Embeddableע�⡣
@Embedded������������ͷ�ϡ�
���ö����С����
@Embeddable��С�����ͷ�ϡ�
��ʶʵ���п��Զ���һ��Ƕ��ʽ���(embeddedcomponent)��������������һ������@Embeddableע�⡣
ע�⣺������С������Ϊ����������һ��Ҫʵ��Serializable�ӿڡ��Ⲣ����ע������ģ�����Hibernate����������Ҫʵ��Serializable�ӿڡ�
@EmbeddedId ������������ͷ�ϡ�
���ö����С������Ϊ������
ע�⣺����Ҫ��ʹ��@Idע�⡣
  
[html] view plain copy
@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)//����Ĭ�ϲ���(�ɵײ����ݿ������������)  
    public Integer getId() {  
        return id;  
    }  
    public void setId(Integer id) {  
        this.id = id;  
    }  
      
    @ManyToMany(  
            //targetEntity���ü�����������  
            targetEntity=cn.com.goevent.omms.bean.CompanyInfo.class,  
            //fetch ���ط�ʽ,�ӳټ���  
            fetch=FetchType.LAZY)  
    //������  
    @JoinTable(  
            name="exhibition_user",//��������� (exhibition_userΪ��Զ��ϵά�����ݱ�)  
            joinColumns={@JoinColumn(name="exhibition_id")},//ά�������   
            inverseJoinColumns={@JoinColumn(name="userid")})//��ά�������   

XML������
��1��tbl_product����

��1��tbl_product_info����
product�������Լ���Java��������
ע�������
��1��tbl_product����
@OneToOne(cascade=CascadeType.ALL)
@PrimaryKeyJoinColumn
private ProductInfoModel info;
��1��tbl_product_info����
@Id
@Column
@GeneratedValue(generator=��copy���������ɲ��ԡ�")
@GenericGenerator(name=��copy���������ɲ��ԡ���,strategy=��foreign��д����ʹ���������ԡ���,parameters=@Parameter(name=��property��,value=��product�������Լ���Java���ԡ�"))
private int uuid;
@OneToOne(mappedBy=��info�����öԷ���Java���ԡ�")
private ProductModel product;
 ��׼��1:M
  XML������
1��tbl_parent����
 �ࡾtbl_child����
ע�������
 
1��tbl_parent����
@OneToMany
@JoinColumn(name="puuid���Է������ݿ����������")
private Set children = new HashSet();
�ࡾtbl_child����
@ManyToOne
@JoinColumn(name="puuid���Լ������ݿ����������")
private ParentModel parent;
 

��1��tbl_product����  
" cascade="all"/>  
��1��tbl_product_info����  
true��д����"/>  
ע�������
��1��tbl_product����
@OneToOne(cascade=CascadeType.ALL,mappedBy=��product���Է���Java����������")
private ProductInfoModel info;
��1��tbl_product_info����
@OneToOne
@JoinColumn(name=��puuid���Լ������ݿ����������")
private ProductModel product;
Hibernate4ע�ⷽ��

XML������
1��tbl_parent����
class=��cn.javass.model.d.ChildModel���Է���Java������"/>
ע�������
1��tbl_parent����  
@OneToMany(mappedBy="parent���Է���Java�������� ��")  
private Set children = new HashSet();  
�ࡾtbl_child����  
@ManyToOne  
@JoinTable(  
name=��tbl_parent_child�����ӱ�",  
joinColumns=@JoinColumn(name="cuuid�����ӱ�������Լ������ݿ��ֶ�����"),  
inverseJoinColumns=@JoinColumn(name="puuid�����ӱ������Է������ݿ��ֶ�����")  
)   
private ParentModel parent;  
Hibernate4ע�ⷽ��

XML������
1��tbl_product����
ע�������
1��tbl_product����
@ManyToOne
@JoinTable(
name=" tbl_product_relation �����ӱ�",
joinColumns=@JoinColumn(name="suuid�����ӱ�������Լ���������"),
inverseJoinColumns=@JoinColumn(name="cuuid�����ӱ������Է���������",unique=true��д����)
)
private CourseModel course;
����һ
������Ϣ��javax.persistence.Table.indexes([Ljavax/persistence/Index
ԭ��Hibernate4.3��֧��@table(name="tablename")
���������ʹ��@entity(name="tablename")����@table(name="tablename")
�����
������Ϣ��javax.persistence.JoinColumn.foreignKey()Ljavax/persistence/ForeignKey
ԭ��Hibernate4.3�ڶ��һӳ���ʱ����ʹ��@JoinColumn
���������ֻд@ManyToOne
������
������Ϣ��javax.persistence.OneToMany.orphanRemoval()Z
ԭ��javaee��ejb��junit��jar����hibernate-jpa-2.0-api-1.0.0.Final.jar��ͻ
����������鿴�Ƿ��������jar����������ڣ�ȥ������
