package cn.wangyanfsd.api.base;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-10-24
 */
@SuppressWarnings("unchecked")
public class BeanUtils {
	

	
	//公共部分
	private static final String N_1 = "\n";
	private static final String N_2 = "\n\n";
	private static final String RT_1 = "\r\n";
	private static final String RT_2 = RT_1+RT_1;
	private static final String BLANK_1 =" ";
	private static final String BLANK_4 ="    ";
	private static final String BLANK_8 =BLANK_4 + BLANK_4;
	
	
	
	//注释部分
	private static final String ANNOTATION_AUTHOR_PARAMTER = "@author ";
	private static final String ANNOTATION_AUTHOR_NAME = "wangy(wangy@cnliren.com)";
	private static final String ANNOTATION_AUTHOR = ANNOTATION_AUTHOR_PARAMTER + ANNOTATION_AUTHOR_NAME;
	private static final String ANNOTATION_DATE = "@date ";
	private static final String ANNOTATION = "/**"+RT_1+BLANK_1+"*"+BLANK_1+ANNOTATION_AUTHOR +RT_1+BLANK_1+"*"+BLANK_1+ANNOTATION_DATE +getDate()+RT_1+BLANK_1+"*/"+RT_1;
	
	
	//文件 地址
	//private static final String BEAN_PATH = "cn/wangyanfsd/api/bean";
	private static final String DAO_PATH = "cn/wangyanfsd/api/dao";
	private static final String DAO_IMPL_PATH = "cn/wangyanfsd/api/dao/impl";
	private static final String SERVICE_PATH = "cn/wangyanfsd/api/service";
	private static final String SERVICE_IMPL_PATH = "cn/wangyanfsd/api/service/impl";
	private static final String ACTION_IMPL_PATH = "cn/wangyanfsd/api/web/action";

	
	
	//包名
	private static final String BEAN_URL = "cn.wangyanfsd.api.bean";
	private static final String DAO_URL = "cn.wangyanfsd.api.dao";
	private static final String DAO_IMPL_URL = "cn.wangyanfsd.api.dao.impl";
	private static final String SERVICE_URL = "cn.wangyanfsd.api.service";
	private static final String SERVICE_IMPL_URL = "cn.wangyanfsd.api.service.impl";
	private static final String ACTION_IMPL_URL = "cn.wangyanfsd.api.web.action";

	//基本类名称
	private static final String BASE_DAO_NAME = DAO_URL + ".BaseDao";
	private static final String ABSTRACT_BASE_DAO_IMPL_NAME = DAO_IMPL_URL + ".AbstractBaseDaoImpl";
	private static final String BASE_SERVICE_NAME = SERVICE_URL + ".BaseService";
	private static final String ABSTRACT_BASE_SERVICE_IMPL_NAME = SERVICE_IMPL_URL + ".AbstractBaseServiceImpl";
	
	
	/**
	 * 创建bean的Dao<br>
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void createBeanDao(Class c) throws Exception {
		String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/" + DAO_PATH
				+ "/" + getLastChar(cName) + "Dao.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write("package "+DAO_URL+";"+RT_2+ANNOTATION+"public interface " + 
				getLastChar(cName) + "Dao extends "+BASE_DAO_NAME+" <" + cName + "> {"+RT_2+"}");
		fw.flush();
		fw.close();
		showInfo(fileName);
	}

    /**
     * 创建bean的Dao的实现类
     * @param c
     * @throws Exception
     */
    public void createBeanDaoImpl(Class c) throws Exception{
    	String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/" + DAO_IMPL_PATH
				+ "/" + getLastChar(cName) + "DaoImpl.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write("package "+DAO_IMPL_URL+";"+RT_2+ANNOTATION+"public class " + 
				getLastChar(cName) + "DaoImpl extends "+ABSTRACT_BASE_DAO_IMPL_NAME+"<" + 
				cName + "> implements "+DAO_URL+"."+getLastChar(cName)+"Dao{"+RT_2+"}");
		fw.flush();
		fw.close();
		showInfo(fileName);
    }
    
    
    
    /**
     * 创建bean的service
     * @param c
     * @throws Exception
     */
    public void createBeanService(Class c) throws Exception{
    	String cName = c.getName();
		String fileName = System.getProperty("user.dir") + "/src/" + SERVICE_PATH
				+ "/" + getLastChar(cName) + "Service.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write("package "+SERVICE_URL+";"+RT_2+ANNOTATION+"public interface " + 
				getLastChar(cName) + "Service extends "+BASE_SERVICE_NAME+"<"+ cName +">{"+RT_2+"}");
		fw.flush();
		fw.close();
		showInfo(fileName);
    }
    
    /**
     * 创建bean的service的实现类
     * @param c
     * @throws Exception
     */
    public void createBeanServiceImpl(Class c) throws Exception{
    	String cName = c.getName();
    	String fileName = System.getProperty("user.dir") + "/src/" + SERVICE_IMPL_PATH 
    			+ "/" +getLastChar(cName)+"ServiceImpl.java";
    	File f = new File(fileName);
    	FileWriter fw = new FileWriter(f);
    	fw.write("package "+SERVICE_IMPL_URL+";"+RT_2+ANNOTATION+"public class " 
    			+ getLastChar(cName) + "ServiceImpl extends "+ABSTRACT_BASE_SERVICE_IMPL_NAME+"<"+ cName 
    			+ "> implements "+SERVICE_URL+"."+getLastChar(cName)+"Service{"+RT_2+BLANK_4
				+"private "+DAO_URL+"."+getLastChar(cName)+"Dao "+getLowercaseChar(getLastChar(cName))
				+"Dao = new " + DAO_IMPL_URL+"."+getLastChar(cName) +"DaoImpl();"
				+RT_2+BLANK_4
				// 列表查询
				+"@Override"+RT_1+BLANK_4+"public "+"java.util.List<"+BEAN_URL+"."+getLastChar(cName)+"> list(){"+RT_1+BLANK_8
				+"return "+getLowercaseChar(getLastChar(cName))+"Dao.list();"+RT_1+BLANK_4+"}"+RT_2+BLANK_4
				// 列表条件查询
				+"@Override"+RT_1+BLANK_4+"public "+"java.util.List<"+BEAN_URL+"."+getLastChar(cName)+"> list(String where,Object... params){"+RT_1+BLANK_8
				+"return "+getLowercaseChar(getLastChar(cName))+"Dao.list(where,params);"+RT_1+BLANK_4+"}"+RT_2+BLANK_4
				// 新增
				+"@Override"+RT_1+BLANK_4+"public void save("+BEAN_URL+"."+getLastChar(cName)+" t){"+RT_1+BLANK_8
				+getLowercaseChar(getLastChar(cName))+"Dao.save(t);"+RT_1+BLANK_4+"}"+RT_2+BLANK_4
				// 修改
				+"@Override"+RT_1+BLANK_4+"public void update("+BEAN_URL+"."+getLastChar(cName)+" t){"+RT_1+BLANK_8
				+getLowercaseChar(getLastChar(cName))+"Dao.update(t);"+RT_1+BLANK_4+"}"+RT_2+BLANK_4
				// 根据ID查询
				+"@Override"+RT_1+BLANK_4+"public "+BEAN_URL+"."+getLastChar(cName)+" find(java.io.Serializable id){"+RT_1+BLANK_8
				+"return "+getLowercaseChar(getLastChar(cName))+"Dao.find(id);"+RT_1+BLANK_4+"}"+RT_2+BLANK_4
				// 根据ID删除
				+"@Override"+RT_1+BLANK_4+"public void remove(java.io.Serializable id){"+RT_1+BLANK_8
				+getLowercaseChar(getLastChar(cName))+"Dao.remove(id);"+RT_1+BLANK_4+"}"+RT_2+BLANK_4
				
				
				+"}");
    	fw.flush();
		fw.close();
		showInfo(fileName);
    }
    
    /**
     * 创建bean的Action的实现类
     * @param c
     * @throws Exception
     */
    public void createAction(Class c) throws Exception{
    	String cName = c.getName();
    	String fileName = System.getProperty("user.dir") + "/src/" + ACTION_IMPL_PATH 
    			+ "/" +getLastChar(cName)+"Action.java";
    	File f = new File(fileName);
    	FileWriter fw = new FileWriter(f);
    	fw.write("package "+ACTION_IMPL_URL+";"+RT_2
    			
    			+ "import java.io.IOException;"+RT_1
    			+ "import java.io.PrintWriter;"+RT_1
    			+ "import java.util.HashMap;"+RT_1
    			+ "import java.util.ArrayList;"+RT_1
    			+ "import java.util.List;"+RT_1
    			+ "import java.util.Map;"+RT_2
    			
    			+ "import javax.servlet.ServletException;"+RT_1
    			+ "import javax.servlet.http.HttpServlet;"+RT_1
    			+ "import javax.servlet.http.HttpServletRequest;"+RT_1
    			+ "import javax.servlet.http.HttpServletResponse;"+RT_2
    			
    			+ "import cn.wangyanfsd.api.util.JSONUtils;"+RT_1
    			+ "import cn.wangyanfsd.api.util.StrUtil;"+RT_1
    			+ "import cn.wangyanfsd.api.util.TransactionUtil;"+RT_2
    			
    			+ "import "+BEAN_URL+"."+getLastChar(cName)+";"+RT_1
    			+ "import "+SERVICE_URL+"."+getLastChar(cName)+"Service;"+RT_1
    			+ "import "+SERVICE_IMPL_URL+"."+getLastChar(cName)+"ServiceImpl;"+RT_2
    			
    			+"public class "+getLastChar(cName)+"Action extends HttpServlet {"+RT_2+BLANK_4
    			
    			+"private "+getLastChar(cName)+"Service "+getLowercaseChar(getLastChar(cName))+"Service = ("+getLastChar(cName)+"Service)new TransactionUtil().newProxy(new "+getLastChar(cName)+"ServiceImpl());"+RT_1+BLANK_4
    			+"Map <Object,Object> map;"+RT_1+BLANK_4
    			+"private HttpServletRequest request;"+RT_1+BLANK_4
    			+"private String message;"+RT_2+RT_1+BLANK_4
    			
    			
				// Action列表
				+"@Override"+RT_1+BLANK_4+"protected void service(HttpServletRequest request, HttpServletResponse response)"+RT_1+BLANK_8
				+"throws ServletException, IOException {"+RT_2+BLANK_8
				
				+"this.request = request;"+RT_1+BLANK_8
				+"request.setCharacterEncoding(\"UTF-8\");"+RT_1+BLANK_8
				+"String choice = request.getParameter(\"choice\");"+RT_1+BLANK_8
				+"Result r = null;"+RT_2+BLANK_8
				
				+"if (\"save\".equals(choice)) {"+RT_1+BLANK_8+BLANK_4
				+"r = save();"+RT_1+BLANK_8
				+"} else if (\"remove\".equals(choice)) {"+RT_1+BLANK_8+BLANK_4
				+"r = remove();"+RT_1+BLANK_8
				+"} else if (\"update\".equals(choice)) {"+RT_1+BLANK_8+BLANK_4
				+"r = update();"+RT_1+BLANK_8
				+"} else if (\"list\".equals(choice)) {"+RT_1+BLANK_8+BLANK_4
				+"r = list();"+RT_1+BLANK_8
				+"} else if (\"find\".equals(choice)) {"+RT_1+BLANK_8+BLANK_4
				+"r = find();"+RT_1+BLANK_8
				+"}"+RT_2+BLANK_8
				
				+"PrintWriter out = response.getWriter();"+RT_1+BLANK_8
				+"out.println(message);"+RT_1+BLANK_8
				+"out.flush();"+RT_2+BLANK_8
				
				+"response.setCharacterEncoding(\"UTF-8\");"+RT_1+BLANK_8
				+"response.setContentType(\"text/html;charset=UTF-8\");"+RT_1+BLANK_4
				+"}"+RT_2+BLANK_4
				
				// 增加
				+"private Result save() {"+RT_2+BLANK_8
				
				+"String title = request.getParameter(\"title\");"+RT_1+BLANK_8
				+"String content = request.getParameter(\"content\");"+RT_1+BLANK_8
				+"String date = request.getParameter(\"date\");"+RT_1+BLANK_8
				+"String person = request.getParameter(\"person\");"+RT_1+BLANK_8
				+"map = new HashMap<Object,Object>();"+RT_2+BLANK_8
				
				+"if(!\"\".equals(title)&&title!=null&&!\"\".equals(content)&&content!=null&&!\"\".equals(date)&&date!=null&&!\"\".equals(person)&&person!=null){"+RT_1+BLANK_8+BLANK_4
				+getLastChar(cName)+" "+getLowercaseChar(getLastChar(cName))+" = new "+getLastChar(cName)+"();"+RT_1+BLANK_8+BLANK_4
				+getLowercaseChar(getLastChar(cName))+".setTitle(title);"+RT_1+BLANK_8+BLANK_4
				+getLowercaseChar(getLastChar(cName))+".setContent(content);"+RT_1+BLANK_8+BLANK_4
				+getLowercaseChar(getLastChar(cName))+".setDate(date);"+RT_1+BLANK_8+BLANK_4
				+getLowercaseChar(getLastChar(cName))+".setPerson(person);"+RT_1+BLANK_8+BLANK_4
				+getLowercaseChar(getLastChar(cName))+"Service.save("+getLowercaseChar(getLastChar(cName))+");"+RT_1+BLANK_8+BLANK_4
				+"map.put(\""+getLowercaseChar(getLastChar(cName))+"\", "+getLowercaseChar(getLastChar(cName))+");"+RT_1+BLANK_8+BLANK_4
				+"map.put(\"message\", \"添加成功\");"+RT_1+BLANK_8
				+"}else{"+RT_1+BLANK_8
				+"map.put(\"message\", \"输入参错不正确，或内容不存在\");"+RT_1+BLANK_8
				+"}"+RT_2+BLANK_8
				
				+"message = JSONUtils.toJSONString(map);"+RT_1+BLANK_8
				+"request.setAttribute(\"message\",map);"+RT_1+BLANK_8
				+"return new Result(\"/WEB-INF/index.html\");"+RT_1+BLANK_4
				+"}"+RT_2+BLANK_4
				
				// 删除
				+"private Result remove() {"+RT_2+BLANK_8
				
				+"String id = request.getParameter(\"id\");"+RT_1+BLANK_8
				+"map = new HashMap<Object,Object>();"+RT_2+BLANK_8
				
				+"if(!\"\".equals(id)&&id!=null&&StrUtil.isNumeric(id)){"+RT_1+BLANK_8+BLANK_4
				+"int i = Integer.parseInt(id);"+RT_1+BLANK_8+BLANK_4
				+"map.put(\""+getLowercaseChar(getLastChar(cName))+"\", "+getLowercaseChar(getLastChar(cName))+"Service.find(i));"+RT_1+BLANK_8+BLANK_4
				+getLowercaseChar(getLastChar(cName))+"Service.remove(i);"+RT_1+BLANK_8+BLANK_4
				+"map.put(\"message\", \"删除成功\");"+RT_1+BLANK_8
				+"}else{"+RT_1+BLANK_8
				+"map.put(\"message\", \"输入参错不正确，或内容不存在\");"+RT_1+BLANK_8
				+"}"+RT_2+BLANK_8
				
				+"message = JSONUtils.toJSONString(map);"+RT_1+BLANK_8
				+"request.setAttribute(\"message\",map);"+RT_1+BLANK_8
				+"return new Result(\"/WEB-INF/index.html\");"+RT_1+BLANK_4
				+"}"+RT_2+BLANK_4
				
				// 修改
				+"private Result update() {"+RT_2+BLANK_8
				
				+"String id = request.getParameter(\"id\");"+RT_1+BLANK_8
				+"String title = request.getParameter(\"title\");"+RT_1+BLANK_8
				+"String content = request.getParameter(\"content\");"+RT_1+BLANK_8
				+"String date = request.getParameter(\"date\");"+RT_1+BLANK_8
				+"String person = request.getParameter(\"person\");"+RT_1+BLANK_8
				+"map = new HashMap<Object,Object>();"+RT_2+BLANK_8
				
				+"if(!\"\".equals(id)&&id!=null&&StrUtil.isNumeric(id)&&!\"\".equals(title)&&title!=null&&!\"\".equals(content)&&content!=null&&!\"\".equals(date)&&date!=null&&!\"\".equals(person)&&person!=null){"+RT_1+BLANK_8+BLANK_4
				+getLastChar(cName)+" "+getLowercaseChar(getLastChar(cName))+" = new "+getLastChar(cName)+"();"+RT_1+BLANK_8+BLANK_4
				+getLowercaseChar(getLastChar(cName))+".setId(Integer.parseInt(id));"+RT_1+BLANK_8+BLANK_4
				+getLowercaseChar(getLastChar(cName))+".setTitle(title);"+RT_1+BLANK_8+BLANK_4
				+getLowercaseChar(getLastChar(cName))+".setContent(content);"+RT_1+BLANK_8+BLANK_4
				+getLowercaseChar(getLastChar(cName))+".setDate(date);"+RT_1+BLANK_8+BLANK_4
				+getLowercaseChar(getLastChar(cName))+".setPerson(person);"+RT_1+BLANK_8+BLANK_4
				+getLowercaseChar(getLastChar(cName))+"Service.update("+getLowercaseChar(getLastChar(cName))+");"+RT_1+BLANK_8+BLANK_4
				+"map.put(\""+getLowercaseChar(getLastChar(cName))+"\", "+getLowercaseChar(getLastChar(cName))+");"+RT_1+BLANK_8+BLANK_4
				+"map.put(\"message\", \"修改成功\");"+RT_1+BLANK_8
				+"}else{"+RT_1+BLANK_8
				+"map.put(\"message\", \"输入参错不正确，或内容不存在\");"+RT_1+BLANK_8
				+"}"+RT_2+BLANK_8
				
				+"message = JSONUtils.toJSONString(map);"+RT_1+BLANK_8
				+"request.setAttribute(\"message\",map);"+RT_1+BLANK_8
				+"return new Result(\"/WEB-INF/index.html\");"+RT_1+BLANK_4
				+"}"+RT_2+BLANK_4
				
				// 查询多条
				+"private Result list() {"+RT_2+BLANK_8
				
				+"String where = request.getParameter(\"where\");"+RT_1+BLANK_8
				+"List list = new ArrayList();"+RT_2+BLANK_8
				
				+"if(!\"\".equals(where)&&where!=null){"+RT_1+BLANK_8+BLANK_4
				+"message = JSONUtils.toJSONString("+getLowercaseChar(getLastChar(cName))+"Service.list(\" title LIKE '%\""+"+"+"where"+"+\"%' OR content LIKE '%\""+"+"+"where"+"+\"%'  \",null));"+RT_1+BLANK_8
				+"}else{"+RT_1+BLANK_8+BLANK_4
				+"message = JSONUtils.toJSONString("+getLowercaseChar(getLastChar(cName))+"Service.list());"+RT_1+BLANK_8
				+"}"+RT_1+BLANK_8
				
				+"request.setAttribute(\"message\",message);"+RT_1+BLANK_8
				+"return new Result(\"/WEB-INF/index.html\");"+RT_1+BLANK_4
				+"}"+RT_2+BLANK_4
				
				// 查询详情
				+"private Result find() {"+RT_2+BLANK_8
				
				+"String id = request.getParameter(\"id\");"+RT_1+BLANK_8
				+"map = new HashMap<Object,Object>();"+RT_2+BLANK_8
				
				+"if(!\"\".equals(id)&&id!=null&&StrUtil.isNumeric(id)){"+RT_1+BLANK_8+BLANK_4
				+"int i = Integer.parseInt(id);"+RT_1+BLANK_8+BLANK_4
				+"map.put(\""+getLowercaseChar(getLastChar(cName))+"\", "+getLowercaseChar(getLastChar(cName))+"Service.find(i));"+RT_1+BLANK_8+BLANK_4
				+"map.put(\"message\", \"查询详情成功\");"+RT_1+BLANK_8
				+"}else{"+RT_1+BLANK_8
				+"map.put(\"message\", \"输入参错不正确，或内容不存在\");"+RT_1+BLANK_8
				+"}"+RT_2+BLANK_8
				
				+"message = JSONUtils.toJSONString(map);"+RT_1+BLANK_8
				+"request.setAttribute(\"message\",map);"+RT_1+BLANK_8
				+"return new Result(\"/WEB-INF/index.html\");"+RT_1+BLANK_4
				+"}"+RT_2
				
				
				+"}");
    	fw.flush();
		fw.close();
		showInfo(fileName);
    }

	/**
	 * 获取路径的最后面字符串<br>
	 * 如：<br>
	 *     <code>str = "com.b510.base.bean.User"</code><br>
	 *     <code> return "User";<code>
	 * @param str
	 * @return
	 */
	public String getLastChar(String str) {
		if ((str != null) && (str.length() > 0)) {
			int dot = str.lastIndexOf('.');
			if ((dot > -1) && (dot < (str.length() - 1))) {
				return str.substring(dot + 1);
			}
		}
		return str;
	}
	
	/**
	 * 把第一个字母变为小写<br>
	 * 如：<br>
	 *     <code>str = "UserDao";</code><br>
	 *     <code>return "userDao";</code>
	 * @param str
	 * @return
	 */
	public String getLowercaseChar(String str){
		return str.substring(0,1).toLowerCase()+str.substring(1);
	}

	/**
	 * 显示信息
	 * @param info
	 */
	public void showInfo(String info){
		System.out.println("创建文件："+ info+ "成功！");
	}
	
	/**
	 * 获取系统时间
	 * @return
	 */
	public static String getDate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(new Date());
	}
}
