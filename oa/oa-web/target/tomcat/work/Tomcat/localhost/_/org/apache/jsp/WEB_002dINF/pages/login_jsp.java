/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-11-16 08:25:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>?????????????????????OA</title>\r\n");
      out.write("    <meta name=\"keywords\" content=\"HTML5 Bootstrap 3 Admin Template UI Theme\" />\r\n");
      out.write("    <meta name=\"description\" content=\"AbsoluteAdmin - A Responsive HTML5 Admin UI Framework\">\r\n");
      out.write("    <meta name=\"author\" content=\"AbsoluteAdmin\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/skin/default_skin/css/theme.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/admin-tools/admin-forms/css/admin-forms.css\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"assets/img/favicon.ico\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"external-page external-alt sb-l-c sb-r-c\">\r\n");
      out.write("<div id=\"main\" class=\"animated fadeIn\">\r\n");
      out.write("    <section id=\"content_wrapper\">\r\n");
      out.write("        <section id=\"content\">\r\n");
      out.write("            <div class=\"admin-form theme-info mw500\" id=\"login\">\r\n");
      out.write("                <div class=\"content-header\">\r\n");
      out.write("                    <h1> ?????????OA</h1>\r\n");
      out.write("                    <p class=\"lead\">??????????????????????????????????????????</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"panel mt30 mb25\">\r\n");
      out.write("                    <form method=\"post\" action=\"login\" id=\"contact\">\r\n");
      out.write("                        <div class=\"panel-body bg-light p25 pb15\">\r\n");
      out.write("                            <div class=\"section\">\r\n");
      out.write("                                <label for=\"sn\" class=\"field-label text-muted fs18 mb10\">??????</label>\r\n");
      out.write("                                <label for=\"sn\" class=\"field prepend-icon\">\r\n");
      out.write("                                    <input type=\"text\" name=\"sn\" id=\"sn\" class=\"gui-input\" placeholder=\"???????????????...\">\r\n");
      out.write("                                    <label for=\"sn\" class=\"field-icon\">\r\n");
      out.write("                                        <i class=\"fa fa-user\"></i>\r\n");
      out.write("                                    </label>\r\n");
      out.write("                                </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"section\">\r\n");
      out.write("                                <label for=\"password\" class=\"field-label text-muted fs18 mb10\">??????</label>\r\n");
      out.write("                                <label for=\"password\" class=\"field prepend-icon\">\r\n");
      out.write("                                    <input type=\"password\" name=\"password\" id=\"password\" class=\"gui-input\" placeholder=\"???????????????...\">\r\n");
      out.write("                                    <label for=\"password\" class=\"field-icon\">\r\n");
      out.write("                                        <i class=\"fa fa-lock\"></i>\r\n");
      out.write("                                    </label>\r\n");
      out.write("                                </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"panel-footer clearfix\">\r\n");
      out.write("                            <button type=\"submit\" class=\"button btn-primary mr10 pull-right\">??????</button>\r\n");
      out.write("                            <label class=\"switch ib switch-primary mt10\">\r\n");
      out.write("                                <input type=\"checkbox\" name=\"remember\" id=\"remember\" checked=\"true\">\r\n");
      out.write("                                <label for=\"remember\" data-on=\"???\" data-off=\"???\"></label>\r\n");
      out.write("                                <span>?????????</span>\r\n");
      out.write("                            </label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("    </section>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"vendor/jquery/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<script src=\"vendor/jquery/jquery_ui/jquery-ui.min.js\"></script>\r\n");
      out.write("<script src=\"assets/js/utility/utility.js\"></script>\r\n");
      out.write("<script src=\"assets/js/demo/demo.js\"></script>\r\n");
      out.write("<script src=\"assets/js/main.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
