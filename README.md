

​	

# 01  OA系统模块

![image-20221207154100747](D:\Desktop\报销单管理\image\image-20221207154100747.png)

## oa.pom

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.oa</groupId>
  <artifactId>oa</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>pom</packaging>
  <modules>
   <module>oa-dao</module>
   <module>oa-biz</module>
   <module>oa-web</module>
  </modules>
  
  <properties>
        <spring.version>4.0.2.RELEASE</spring.version>
    </properties>
    
    <build>
      <finalName>${project.artifactId}</finalName>
      <plugins>
         <!-- java编译插件 -->
         <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.2</version>
            <configuration>
               <source>1.8</source>
               <target>1.8</target>
               <encoding>UTF-8</encoding>
            </configuration>
         </plugin>
            <!-- 配置Tomcat插件 -->
            <plugin>
               <groupId>org.apache.tomcat.maven</groupId>
               <artifactId>tomcat7-maven-plugin</artifactId>
               <configuration>
                  <port>8080</port>
                  <path>/</path>
               </configuration>
            </plugin>
         </plugins>       
   </build>
</project>
```



##### dao.xml

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>com.oa</groupId>
    <artifactId>oa</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
  <artifactId>oa-dao</artifactId>
  
    <dependencies>
    <!--  MySQL驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.44</version>
        </dependency>
        <!--MyBatis-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.4</version>
        </dependency>
      <!--Spring基本的依赖包-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
      <!--Spring与MyBtis整合依赖-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.3.1</version>
        </dependency>
    </dependencies>
    <version>0.0.1-SNAPSHOT</version>
</project>
```

##### service.xml

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>com.oa</groupId>
    <artifactId>oa</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
  <artifactId>oa-biz</artifactId>
  
   <dependencies>
    <!--依赖持久层-->
        <dependency>
            <groupId>com.oa</groupId>
            <artifactId>oa-dao</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
      <!--声明式事务的依赖包-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!--AOP依赖-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!--Aspectj依赖-->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.8.0</version>
        </dependency>
    </dependencies>
</project>
```

##### web.xml

```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <import resource="spring-biz.xml"/>

    <context:component-scan base-package="com.oa.controller"/>
    <mvc:annotation-driven/>

    <mvc:default-servlet-handler/>

    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="/WEB-INF/pages/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

     <mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <bean class="com.oa.global.LoginInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors> 
</beans>
```



## 用到的数据库五张表

 

![image-20221207154025139](D:\Desktop\报销单管理\image\image-20221207154025139.png)

 

 

emploee 员工表 ，记录员工的信息，部门，和职位

departmenet 部门表，记录部门的信息

claim_voucher 是报销单表 记录报销事由，报销人，时间，下一个处理人，状态、报销总金额

claim_voucher_item 是报销费用明细表 ，每个报销单的明细信息

deal_record 是记录整个处理的流程表 包含报销单id  处理人 时间 处理状态 、结果和备注



## spring-dao

```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.oa.dao"/>

    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/oa?useUnicode=true&amp;useSSL=false&amp;characterEncoding=utf-8"/>
        <property name="username" value="root"/>
        <property name="password" value="root"/>
    </bean>

    <bean id="sessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="typeAliasesPackage" value="com.oa.entity"/>
    </bean>

    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="sqlSessionFactoryBeanName" value="sessionFactory"/>
        <property name="basePackage" value="com.oa.dao"/>
    </bean>

</beans>
```





## spring-service

```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd
    http://www.springframework.org/schema/aop
    http://www.springframework.org/schema/aop/spring-aop.xsd
    http://www.springframework.org/schema/tx
    http://www.springframework.org/schema/tx/spring-tx.xsd">

    <import resource="spring-dao.xml"/>

    <context:component-scan base-package="com.oa.biz"/>
    <aop:aspectj-autoproxy/>


    <bean id="transationManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <tx:advice id="txAdvice" transaction-manager="transationManager">
        <tx:attributes>
            <tx:method name="get*" read-only="true"/>
            <tx:method name="find*" read-only="true"/>
            <tx:method name="search*" read-only="true"/>
            <tx:method name="*" propagation="REQUIRED"/>
        </tx:attributes>
    </tx:advice>

    <aop:config>
        <aop:pointcut id="txpc" expression="execution(* com.oa.biz.*.*(..))"/>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="txpc"/>
    </aop:config>

</beans>
```



## spring-web.xml

```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <import resource="spring-biz.xml"/>

    <context:component-scan base-package="com.oa.controller"/>
    <mvc:annotation-driven/>

    <mvc:default-servlet-handler/>

    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="/WEB-INF/pages/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

     <mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <bean class="com.oa.global.LoginInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors> 
</beans>
```



## web.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

     <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
    <servlet-mapping>
        <servlet-name>default</servlet-name>
        <url-pattern>/assets/*</url-pattern>
        <url-pattern>/js/*</url-pattern>
        <url-pattern>/vendor/*</url-pattern>
        <url-pattern>*.js</url-pattern>
        <url-pattern>*.jpg</url-pattern>
        <url-pattern>*.gif</url-pattern>
        <url-pattern>*.png</url-pattern>
        <url-pattern>*.css</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>SpringMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring-web.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>SpringMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>


</web-app>
```



# 02 实现用户登录

#### login.jsp

```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>欢迎使用小菜鸟OA</title>
    <meta name="keywords" content="HTML5 Bootstrap 3 Admin Template UI Theme" />
    <meta name="description" content="AbsoluteAdmin - A Responsive HTML5 Admin UI Framework">
    <meta name="author" content="AbsoluteAdmin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="assets/img/favicon.ico">
</head>
<body class="external-page external-alt sb-l-c sb-r-c">
<div id="main" class="animated fadeIn">
    <section id="content_wrapper">
        <section id="content">
            <div class="admin-form theme-info mw500" id="login">
                <div class="content-header">
                    <h1> 小菜鸟OA</h1>
                    <p class="lead">欢迎使用小菜鸟自动化管理系统</p>
                </div>
                <div class="panel mt30 mb25">
                    <form method="post" action="login" id="contact">
                        <div class="panel-body bg-light p25 pb15">
                            <div class="section">
                                <label for="sn" class="field-label text-muted fs18 mb10">工号</label>
                                <label for="sn" class="field prepend-icon">
                                    <input type="text" name="sn" id="sn" class="gui-input" placeholder="请输入工号...">
                                    <label for="sn" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section">
                                <label for="password" class="field-label text-muted fs18 mb10">密码</label>
                                <label for="password" class="field prepend-icon">
                                    <input type="password" name="password" id="password" class="gui-input" placeholder="请输入密码...">
                                    <label for="password" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer clearfix">
                            <button type="submit" class="button btn-primary mr10 pull-right">登陆</button>
                            <label class="switch ib switch-primary mt10">
                                <input type="checkbox" name="remember" id="remember" checked="true">
                                <label for="remember" data-on="是" data-off="否"></label>
                                <span>记住我</span>
                            </label>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </section>
</div>
<script src="vendor/jquery/jquery-1.11.1.min.js"></script>
<script src="vendor/jquery/jquery_ui/jquery-ui.min.js"></script>
<script src="assets/js/utility/utility.js"></script>
<script src="assets/js/demo/demo.js"></script>
<script src="assets/js/main.js"></script>
</body>
</html>
```

#### LoginInterceptor.java

```
package com.oa.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        
        //获取URL判断是否拦截
        String url = httpServletRequest.getRequestURI();//获取请求路径
        System.out.println(url);
        if(url.toLowerCase().indexOf("login") >= 0){
            return true;
        }
        //判断当前状态是否登录
        HttpSession session = httpServletRequest.getSession();
        //判断emp是否为null,说明session中存储了emp,说明用户已经登录成功
        if(session.getAttribute("employee") != null){
            return true;
        }
        httpServletResponse.sendRedirect("/to_login");
        return false; //禁止访问
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
```

**由拦截器拦截验证 url 位数是否大于0，httpServletRequest获取session是否存在，其余情况登录都重定向到登录页面。**



#### 登录验证

```
@Autowired
private GlobalBiz globalBiz;

@RequestMapping("/to_login")
public String toLogin(){
    return "login";
}
```

```
@RequestMapping("/login")
public String login(HttpSession session, @RequestParam String sn, @RequestParam String password){
    Employee employee = globalBiz.login(sn,password);
    if (employee == null) {
        return "redirect:to_login";
    }
    session.setAttribute("employee",employee);
    return "redirect:self";
}
```

```
@Autowired
private EmployeeDao employeeDao;

public Employee login(String sn, String password) {
    Employee employee = employeeDao.select(sn);
    if(employee != null && employee.getPassword().equals(password)){
        return  employee;
    }
    return null;
}
```

**由GloablController验证登录，成功则重定向跳转到 self.jsp**



#### 登录退出

```
@RequestMapping("/quit")
public String quit(HttpSession session){
    session.setAttribute("employee",null);
    return "redirect:to_login";
}
```



### 修改密码

```
@RequestMapping("/to_change_password")
public String toChangePassword(){
    return "change_password";
}
```

```
@RequestMapping("/change_password")
public String changePassword(HttpSession session, @RequestParam String old, @RequestParam String new1 ,@RequestParam String new2){
    Employee employee = (Employee)session.getAttribute("employee");
    if(employee.getPassword().equals(old)){     //原始密码
        if(new1.equals(new2)){                  //新密码等于旧密码
            employee.setPassword(new1);
            globalBiz.changePassword(employee);    
            return "redirect:self";
        }
    }
    return "redirect:to_change_password";
}
```

```
public void changePassword(Employee employee) {
    employeeDao.update(employee);
}
```



# 03基础信息管理

### 通用类

```
package com.oa.global;

import java.util.ArrayList;
import java.util.List;

public class Contant {
    //职务
    public static final String POST_STAFF="员工";
    public static final String POST_FM="部门经理";
    public static final String POST_GM="总经理";
    public static final String POST_CASHIER="财务";
    public static List<String> getPosts(){
        List<String> list = new ArrayList<String>();
        list.add(POST_STAFF);
        list.add(POST_FM);
        list.add(POST_GM);
        list.add(POST_CASHIER);
        return list;
    }

    //费用类别
    public static List<String> getItems(){
        List<String> list = new ArrayList<String>();
        list.add("交通");
        list.add("餐饮");
        list.add("住宿");
        list.add("办公");
        return list;
    }

    //报销单状态
    public static final String CLAIMVOUCHER_CREATED="新创建";
    public static final String CLAIMVOUCHER_SUBMIT="已提交";
    public static final String CLAIMVOUCHER_APPROVED="已审核";
    public static final String CLAIMVOUCHER_BACK="已打回";
    public static final String CLAIMVOUCHER_TERMINATED="已终止";
    public static final String CLAIMVOUCHER_RECHECK="待复审";
    public static final String CLAIMVOUCHER_PAID="已打款";
    //审核额度
    public static final double LIMIT_CHECK=5000.00;

    //处理方式
    public static final String DEAL_CREATE="创建";
    public static final String DEAL_SUBMIT="提交";
    public static final String DEAL_UPDATE="修改";
    public static final String DEAL_BACK="打回";
    public static final String DEAL_REJECT="拒绝";
    public static final String DEAL_PASS="通过";
    public static final String DEAL_PAID="打款";
}
```



### 员工管理 

#### 查询所有员工信息

```
@Autowired
private EmployeeBiz employeeBiz;

@RequestMapping("/list")
public String list(Map<String,Object> map){
    map.put("list",employeeBiz.getAll());
    return "employee_list";
}
```

```
public List<Employee> getAll() {
    return employeeDao.selectAll();
}
```

​         **点击top.jsp中的 所有员工 按钮 跳转到  Controller 控制器 ，由  Controller 调用 service 层的接口的查询方法实现，再将结果封装成 list 返回到 employee_list.jsp展示。**



#### 添加员工 ：新员工的默认密码是000000

```
@RequestMapping("/to_add")
public String toAdd(Map<String,Object> map){
    map.put("employee",new Employee());
    map.put("dlist",departmentBiz.getAll());
    map.put("plist", Contant.getPosts());
    return "employee_add";
}
```

```
@Qualifier("employeeDao")
@Autowired
private EmployeeDao employeeDao;

public void add(Employee employee) {
    employee.setPassword("000000");     //设置默认密码为 000000
    employeeDao.insert(employee);
}
```

​         **点击top.jsp中的 添加员工 按钮 /employee/to_add 跳转到  Controller 控制器转到 employee_add 员工添加 页面(查询全部部门和全部职位遍历)，由  Controller 调用 service 层的接口的 添加方法实现，重定向到 查询全部的jsp页面。**



#### 编辑更新员工信息

```
  @RequestMapping(value = "/to_update",params = "sn")
    public String toUpdate(String sn,Map<String,Object> map){
        map.put("employee",employeeBiz.get(sn));
        map.put("dlist",departmentBiz.getAll());
        map.put("plist", Contant.getPosts());
        return "employee_update";
    }
```

```
   @RequestMapping("/update")
    public String update(Employee employee){
        employeeBiz.edit(employee);
        return "redirect:list";
    }
```

```
public void edit(Employee employee) {
    employeeDao.update(employee);
}
```

​    **根据前端传的 emp.sn 工号跳转到  更新页面 ，再由表单提交到 控制器 重定向到 查询全部  页面**



#### 删除员工信息

```
@RequestMapping(value = "/remove",params = "sn")
public String remove(String sn){
    employeeBiz.remove(sn);
    return "redirect:list";
}
```

```
public void remove(String sn) {
    employeeDao.delete(sn);
}
```

​     **根据前端传的 emp.sn 工号 传到 控制器 调用service 中的  删除方法  最后重定向到  查询全部  页面 **  



### 部门管理:

#### 查看部门列表

```
@Autowired
private DepartmentBiz departmentBiz;
@RequestMapping("/list")
public String list(Map<String,Object> map){
    map.put("list",departmentBiz.getAll());
    return "department_list";
}
```

```
public List<Department> getAll() {
    return departmentDao.selectAll();
}
```

​         **点击top.jsp中的 所有部门 按钮 跳转到  Controller 控制器 ，由  Controller 调用 service 层的接口的查询方法实现，再将结果封装成 list 返回到 department_list.jsp展示。**



#### 添加部门

```
@RequestMapping("/to_add")
public String toAdd(Map<String,Object> map){
    map.put("department",new Department());
    return "department_add";
}
```

```
@RequestMapping("/add")
public String add(Department department){
    departmentBiz.add(department);
    return "redirect:list";
}
```

​         **点击top.jsp中的 添加部门 按钮 /department/to_add 跳转到  Controller 控制器转到 department_add 部门添加 页面，由  Controller 调用 service 层的接口的 添加方法实现，重定向到 查询全部的jsp页面。**



#### 更新部门

```
@RequestMapping(value = "/to_update",params = "sn")
public String toUpdate(String sn,Map<String,Object> map){
    map.put("department",departmentBiz.get(sn));
    return "department_update";
}
```



```
@RequestMapping("/update")
public String update(Department department){
    departmentBiz.edit(department);
    return "redirect:list";
}
```

**根据前端传的 dept.sn 工号跳转到  更新页面 ，再由表单提交到 控制器 重定向到 查询全部  页面**



#### 删除操作

```
@RequestMapping(value = "/remove",params = "sn")
public String remove(String sn){
    departmentBiz.remove(sn);
    return "redirect:list";
}
```

​     **根据前端传的 dept.sn 工号 传到 控制器 调用service 中的  删除方法  最后重定向到  查询全部  页面 **  



# 04员工报销单管理

```
<form:input path="items[0].comment" cssClass="gui-input" placeholder="备注..." />
```

**相当于**

```
<input id="items0.comment" name="items[0].comment" class="gui-input" placeholder="备注..." type="text" value=""/>
```



#### 添加报销单

```
@Autowired
private ClaimVoucherBiz claimVoucherBiz;

//去填写
@RequestMapping("/to_add")
public String toAdd(Map<String,Object> map){
    map.put("items", Contant.getItems());     //传递常量类所有定义的类型
    map.put("info",new ClaimVoucherInfo());       //以info为键，创建ClaimVoucherInfo()
    return "claim_voucher_add";
}
```

```
//填写完后保存
@RequestMapping("/add")
public String add(HttpSession session, ClaimVoucherInfo info){    //info是要与上面的创建ClaimVoucherInfo()的键想对应
    Employee employee = (Employee)session.getAttribute("employee");       //创建者编号，表现层通过session拿出employee
    info.getClaimVoucher().setCreateSn(employee.getSn());
    claimVoucherBiz.save(info.getClaimVoucher(),info.getItems());
    return "redirect:detail?id=" + info.getClaimVoucher().getId();
}
```

> - [ ] ```
>   //保存报销单
>   void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);
>   ```

```
@Qualifier("employeeDao")
@Autowired
private EmployeeDao employeeDao;

public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
    claimVoucher.setCreateTime(new Date()); //设置创建时间
    claimVoucher.setNextDealSn(claimVoucher.getCreateSn()); //设置待处理人（创建者）
    claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);//设置状态（新创建）
    claimVoucherDao.insert(claimVoucher);



    for(ClaimVoucherItem item:items){
        item.setClaimVoucherId(claimVoucher.getId());
        claimVoucherItemDao.insert(item);
    }
}
```

**设置 在前端页面 没有设置 的数据库数据，然后  逐个遍历 设置 项目id 为报销单id **



#### **查询某个id报销单**

```
//保存完后跳转到详情界面
@RequestMapping("/detail")
public String detail(int id, Map<String,Object> map){
    map.put("claimVoucher",claimVoucherBiz.get(id));
    map.put("items",claimVoucherBiz.getItems(id));
    map.put("records",claimVoucherBiz.getRecords(id));
    return "claim_voucher_detail";
}
```



> - [ ] ```
>   //获取报销单对象
>   ClaimVoucher get(int id);
>   ```

```
public ClaimVoucher get(int id) {
    return claimVoucherDao.select(id);
}
```

> - [ ] ```
>   //获取报销单条目
>   List<ClaimVoucherItem> getItems(int cvid);
>   ```

```
public List<ClaimVoucherItem> getItems(int cvid) {
    return claimVoucherItemDao.selectByClaimVoucher(cvid);
}
```

> - [ ] ```
>   //审核记录
>   List<DealRecord> getRecords(int cvid);
>   ```

```
public List<DealRecord> getRecords(int cvid) {
    return dealRecordDao.selectByClaimVoucher(cvid);
}
```

**将前端所需数据逐个 查询出来 ，用Map集合或者Model 推到前端。**





#### 查询个人报销单

```
//个人报销单
@RequestMapping("/self")
public String self(HttpSession session, Map<String,Object> map){
    Employee employee = (Employee)session.getAttribute("employee");
    map.put("list",claimVoucherBiz.getForSelf(employee.getSn()));
    return "claim_voucher_self";
}
```

> - [ ] ```
>   //获取个人报销单
>   List<ClaimVoucher> getForSelf(String sn);
>   ```

```
public List<DealRecord> getRecords(int cvid) {
    return dealRecordDao.selectByClaimVoucher(cvid);
}
```

**claim_voucher_self.jsp的 详细信息 按钮 根据 Id  跳转 claim_voucher_detail.jsp**



#### 待处理报销单

```
//待处理报销单
@RequestMapping("/deal")
public String deal(HttpSession session, Map<String,Object> map){
    Employee employee = (Employee)session.getAttribute("employee");
    map.put("list",claimVoucherBiz.getForDeal(employee.getSn()));
    return "claim_voucher_deal";
}
```

> - [ ] ```
>   //获取待处理报销单
>   List<ClaimVoucher> getForDeal(String sn);
>   ```

```
public List<ClaimVoucher> getForDeal(String sn) {
    return claimVoucherDao.selectByNextDealSn(sn);
}
```

**根据 session 获取 登录的人 查询对应的  待处理**



##### `修改报销单`

```
package com.oa.dto;

import com.oa.entity.ClaimVoucher;
import com.oa.entity.ClaimVoucherItem;

import java.util.List;

public class ClaimVoucherInfo {
    //用一下的方式获取用户提交的信息
    private ClaimVoucher claimVoucher;      //报销单对象
    private List<ClaimVoucherItem> items;       //items集合

    public ClaimVoucher getClaimVoucher() {
        return claimVoucher;
    }

    public void setClaimVoucher(ClaimVoucher claimVoucher) {
        this.claimVoucher = claimVoucher;
    }

    public List<ClaimVoucherItem> getItems() {
        return items;
    }

    public void setItems(List<ClaimVoucherItem> items) {
        this.items = items;
    }
}
```

```
@RequestMapping("/to_update")
public String toUpdate(int id,Map<String,Object> map){
    map.put("items", Contant.getItems());
    ClaimVoucherInfo info =new ClaimVoucherInfo();
    info.setClaimVoucher(claimVoucherBiz.get(id));
    info.setItems(claimVoucherBiz.getItems(id));
    map.put("info",info);
    return "claim_voucher_update";
}
```

```
@RequestMapping("/update")
public String update(HttpSession session, ClaimVoucherInfo info){
    Employee employee = (Employee)session.getAttribute("employee");
    info.getClaimVoucher().setCreateSn(employee.getSn());  //设置创建人为登录的那个人
    claimVoucherBiz.update(info.getClaimVoucher(),info.getItems());
    return "redirect:deal";
}
```



> - [ ] ```
>   //修改报销单
>   void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);
>   ```



```
public void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
    claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
    claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);
    claimVoucherDao.update(claimVoucher);                    //更新报销单

    List<ClaimVoucherItem> olds = claimVoucherItemDao.selectByClaimVoucher(claimVoucher.getId());   //获取数据库已有的条目集合
    //删除我不要的条目
    for(ClaimVoucherItem old : olds){     //迭代其集合
        boolean isHave = false;
        for(ClaimVoucherItem item : items){       //寻找条目集合是否存在
            if(item.getId() == old.getId()){          
                isHave = true;
                break;
            }
        }
        if(!isHave){
            claimVoucherItemDao.delete(old.getId());   
        }
    }
    
    for(ClaimVoucherItem item : items){
        item.setClaimVoucherId(claimVoucher.getId());
        if(item.getId() != null && item.getId() > 0){
            //更新已经有了的条目
            claimVoucherItemDao.update(item);
        }else{
            //插入之前不存在的新条目
            claimVoucherItemDao.insert(item);
        }
    }
}
```

​        **根据数据库中两张不同的表 设置数据和更新， 多个项目item 先遍历 ，看数据库中是否存在相同id，根据id删除 所有旧选项，设置项目id  为 报销单id ， 根据id 判断 ，存在id则为更新，没有为 添加。**

​        **判断页面中进行保存的条目(新的)和数据表中存在的条目(旧的)对比，如果旧的条目在新的条目中有对应的id编号，如果存在不一样的，进行删除旧的条目**（一样的保留，不一样的删除）



##### 提交报销单

![image-20221207154147169](D:\Desktop\报销单管理\image\image-20221207154147169.png)

```
@RequestMapping("/submit")
public String submit(int id){
    claimVoucherBiz.submit(id);
    return "redirect:deal";
}
```

> - [ ] ```
>   //提交报销单
>   void submit(int id);
>   ```

```
public void submit(int id) {
    ClaimVoucher claimVoucher = claimVoucherDao.select(id);
    Employee employee = employeeDao.select(claimVoucher.getCreateSn());

    //报销单状态更新
    claimVoucher.setStatus(Contant.CLAIMVOUCHER_SUBMIT);
    claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(employee.getDepartmentSn(),Contant.POST_FM).get(0).getSn());
    claimVoucherDao.update(claimVoucher);

    DealRecord dealRecord = new DealRecord();
    dealRecord.setDealWay(Contant.DEAL_SUBMIT);
    dealRecord.setDealSn(employee.getSn());
    dealRecord.setClaimVoucherId(id);
    dealRecord.setDealResult(Contant.CLAIMVOUCHER_SUBMIT);
    dealRecord.setDealTime(new Date());
    dealRecord.setComment("无");
    dealRecordDao.insert(dealRecord);
}
```

**跟据数据库的各种 coloum  逐条设置 再整体插入**





##### 审核报销单

```
@RequestMapping("/to_check")
public String toCheck(int id,Map<String,Object> map){
    map.put("claimVoucher",claimVoucherBiz.get(id));
    map.put("items",claimVoucherBiz.getItems(id));
    map.put("records",claimVoucherBiz.getRecords(id));
    DealRecord dealRecord = new DealRecord();
    dealRecord.setClaimVoucherId(id);
    map.put("record",dealRecord);
    return "claim_voucher_check";  
}
```

**获取到 id 对应的各种信息，跳转到处理  报销单  页面**

![image-20221207154205461](D:\Desktop\报销单管理\image\image-20221207154205461.png)

```
@RequestMapping("/check")
public String check(HttpSession session, DealRecord dealRecord){
    Employee employee = (Employee)session.getAttribute("employee");
    dealRecord.setDealSn(employee.getSn());
    claimVoucherBiz.deal(dealRecord);
    return "redirect:deal";
}
```

**设置 处理人 为 从session 获取到 的 sn **

> - [ ] ```
>   //审核报销单
>   void deal(DealRecord dealRecord);
>   ```



```
public void deal(DealRecord dealRecord) {
    ClaimVoucher claimVoucher = claimVoucherDao.select(dealRecord.getClaimVoucherId());
    Employee employee = employeeDao.select(dealRecord.getDealSn());
    //设置处理时间
    dealRecord.setDealTime(new Date());

    if(dealRecord.getDealWay().equals(Contant.DEAL_PASS)){
        //金额小于5000或者处理报销单的人是总经理就不需要复审
        if(claimVoucher.getTotalAmount()<=Contant.LIMIT_CHECK || employee.getPost().equals(Contant.POST_GM)){
            //修改报销单状态:已审核
            claimVoucher.setStatus(Contant.CLAIMVOUCHER_APPROVED);
            //设置待处理人为财务
            claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(null,Contant.POST_CASHIER).get(0).getSn());
            //设置处理结果
            dealRecord.setDealResult(Contant.CLAIMVOUCHER_APPROVED);
        }else{      //需要复审的
            claimVoucher.setStatus(Contant.CLAIMVOUCHER_RECHECK);
            claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(null,Contant.POST_GM).get(0).getSn());
            dealRecord.setDealResult(Contant.CLAIMVOUCHER_RECHECK);
        }
    }else if(dealRecord.getDealWay().equals(Contant.DEAL_BACK)){        //打回的操作
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_BACK);
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        dealRecord.setDealResult(Contant.CLAIMVOUCHER_BACK);
    }else if(dealRecord.getDealWay().equals(Contant.DEAL_REJECT)){      //拒绝的操作
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_TERMINATED);
        claimVoucher.setNextDealSn(null);
        dealRecord.setDealResult(Contant.CLAIMVOUCHER_TERMINATED);
    }else if(dealRecord.getDealWay().equals(Contant.DEAL_PAID)){        //打款的操作
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_PAID);
        claimVoucher.setNextDealSn(null);
        dealRecord.setDealResult(Contant.CLAIMVOUCHER_PAID);
    }
    //报销单更新
    claimVoucherDao.update(claimVoucher);
    //审核记录插入
    dealRecordDao.insert(dealRecord);
}
```

**根据 claim_voucher_deal.jsp 的 claim_voucher/check 所传的id  跳转到 对应的  处理报销单 jsp页面，跟据业务设置service层，最后重定向到 待处理 页面。**

