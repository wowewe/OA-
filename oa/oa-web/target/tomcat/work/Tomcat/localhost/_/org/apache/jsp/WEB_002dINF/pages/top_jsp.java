/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-11-18 02:35:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <!-- Meta, title, CSS, favicons, etc. -->\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("    <title> OA--欢迎使用小菜鸟的OA系统 </title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/assets/skin/default_skin/css/theme.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/assets/admin-tools/admin-forms/css/admin-forms.css\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"/assets/img/favicon.ico\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"admin-validation-page\" data-spy=\"scroll\" data-target=\"#nav-spy\" data-offset=\"200\">\r\n");
      out.write("<div id=\"main\">\r\n");
      out.write("    <header class=\"navbar navbar-fixed-top navbar-shadow\">\r\n");
      out.write("        <div class=\"navbar-branding\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"dashboard.html\">\r\n");
      out.write("                <b>小菜鸟</b>OA\r\n");
      out.write("            </a>\r\n");
      out.write("            <span id=\"toggle_sidemenu_l\" class=\"ad ad-lines\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("            <li class=\"dropdown menu-merge\">\r\n");
      out.write("                <a href=\"#\" class=\"dropdown-toggle fw600 p15\" data-toggle=\"dropdown\">\r\n");
      out.write("                    <img src=\"https://i01piccdn.sogoucdn.com/a70ac2c544b3c4ec\" alt=\"avatar\" class=\"mw30 br64\">\r\n");
      out.write("                    <span class=\"hidden-xs pl15\"> admin </span>\r\n");
      out.write("                    <span class=\"caret caret-tp hidden-xs\"></span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <ul class=\"dropdown-menu list-group dropdown-persist w250\" role=\"menu\">\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <a href=\"/self\" class=\"animated animated-short fadeInUp\">\r\n");
      out.write("                            <span class=\"fa fa-user\"></span> 个人信息\r\n");
      out.write("                            <span class=\"label label-warning\"></span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"list-group-item\">\r\n");
      out.write("                        <a href=\"/to_change_password\" class=\"animated animated-short fadeInUp\">\r\n");
      out.write("                            <span class=\"fa fa-gear\"></span> 设置密码 </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"dropdown-footer\">\r\n");
      out.write("                        <a href=\"/quit\" class=\"\">\r\n");
      out.write("                            <span class=\"fa fa-power-off pr5\"></span> 退出 </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </header>\r\n");
      out.write("    <aside id=\"sidebar_left\" class=\"nano nano-light affix\">\r\n");
      out.write("        <div class=\"sidebar-left-content nano-content\">\r\n");
      out.write("            <header class=\"sidebar-header\">\r\n");
      out.write("                <div class=\"sidebar-widget author-widget\">\r\n");
      out.write("                    <div class=\"media\">\r\n");
      out.write("                        <a class=\"media-left\" href=\"#\">\r\n");
      out.write("                            <img src=\"https://i01piccdn.sogoucdn.com/a70ac2c544b3c4ec\" class=\"img-responsive\">\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <div class=\"media-body\">\r\n");
      out.write("                            <div class=\"media-author\">admin--总经理</div>\r\n");
      out.write("                            <div class=\"media-links\">\r\n");
      out.write("                                <a href=\"/quit\">退出</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"sidebar-widget search-widget hidden\">\r\n");
      out.write("                    <div class=\"input-group\">\r\n");
      out.write("                        <span class=\"input-group-addon\">\r\n");
      out.write("                            <i class=\"fa fa-search\"></i>\r\n");
      out.write("                        </span>\r\n");
      out.write("                        <input type=\"text\" id=\"sidebar-search\" class=\"form-control\" placeholder=\"Search...\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </header>\r\n");
      out.write("            <ul class=\"nav sidebar-menu\">\r\n");
      out.write("                <li class=\"sidebar-label pt20\">日常管理</li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"/claim_voucher/deal\">\r\n");
      out.write("                        <span class=\"glyphicon glyphicon-book\"></span>\r\n");
      out.write("                        <span class=\"sidebar-title\">待处理报销单</span>\r\n");
      out.write("                        <span class=\"sidebar-title-tray\">\r\n");
      out.write("                <span class=\"label label-xs bg-primary\">New</span>\r\n");
      out.write("              </span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"active\">\r\n");
      out.write("                    <a href=\"/claim_voucher/self\">\r\n");
      out.write("                        <span class=\"glyphicon glyphicon-home\"></span>\r\n");
      out.write("                        <span class=\"sidebar-title\">个人报销单</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"/claim_voucher/to_add\">\r\n");
      out.write("                        <span class=\"fa fa-calendar\"></span>\r\n");
      out.write("                        <span class=\"sidebar-title\">填写报销单</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"sidebar-label pt15\">基础信息管理</li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a class=\"accordion-toggle\" href=\"#\">\r\n");
      out.write("                        <span class=\"glyphicon glyphicon-check\"></span>\r\n");
      out.write("                        <span class=\"sidebar-title\">员工管理</span>\r\n");
      out.write("                        <span class=\"caret\"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"nav sub-nav\">\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"/employee/list\">\r\n");
      out.write("                                <span class=\"glyphicon glyphicon-calendar\"></span> 所有员工 </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"active\">\r\n");
      out.write("                            <a href=\"/employee/to_add\">\r\n");
      out.write("                                <span class=\"glyphicon glyphicon-check\"></span> 添加员工 </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a class=\"accordion-toggle\" href=\"#\">\r\n");
      out.write("                        <span class=\"fa fa-columns\"></span>\r\n");
      out.write("                        <span class=\"sidebar-title\">部门管理</span>\r\n");
      out.write("                        <span class=\"caret\"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"nav sub-nav\">\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"/department/list\">\r\n");
      out.write("                                <span class=\"glyphicon glyphicon-calendar\"></span> 所有部门 </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"active\">\r\n");
      out.write("                            <a href=\"/department/to_add\">\r\n");
      out.write("                                <span class=\"glyphicon glyphicon-check\"></span> 添加部门 </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <div class=\"sidebar-toggle-mini\">\r\n");
      out.write("                <a href=\"#\">\r\n");
      out.write("                    <span class=\"fa fa-sign-out\"></span>\r\n");
      out.write("                </a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </aside>\r\n");
      out.write("    <section id=\"content_wrapper\">");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
