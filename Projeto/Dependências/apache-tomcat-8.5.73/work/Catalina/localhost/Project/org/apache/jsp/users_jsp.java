/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.73
 * Generated at: 2022-01-30 03:48:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Repository.UserRepository;
import DTO.UserDTO;
import Model.ServiceHistoryModel;
import Model.ServiceModel;
import java.util.List;
import java.util.ArrayList;
import Model.UserModel;

public final class users_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/components/commonscript.html", Long.valueOf(1643474405571L));
    _jspx_dependants.put("/components/session.jsp", Long.valueOf(1643483288219L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("Repository.UserRepository");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("Model.UserModel");
    _jspx_imports_classes.add("DTO.UserDTO");
    _jspx_imports_classes.add("Model.ServiceHistoryModel");
    _jspx_imports_classes.add("Model.ServiceModel");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    UserRepository userRepository = new UserRepository();
    List<UserModel> userModelList = userRepository.allModel();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"pt-BR\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"FontAwesome/css/all.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/isdown.css\">\r\n");
      out.write("\r\n");
      out.write("        <title>Is Down ?</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    UserModel user = (UserModel) session.getAttribute("user");
    
    if (user == null)
        response.sendRedirect("User?a=login");

      out.write('\n');
      out.write("\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"index.jsp\">Is Down ?</a>\r\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Alterna navegação\">\r\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n");
      out.write("                <ul class=\"navbar-nav\">\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"index.jsp\">Página Inicial</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    ");

                        if (user != null) {
                            if (user.getRole().getName().compareTo("Administrator") == 0) {
                    
      out.write("\r\n");
      out.write("                                <li class=\"nav-item active\">\r\n");
      out.write("                                    <a class=\"nav-link\" href=\"User\">Usuários <span class=\"sr-only\">(Página atual)</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" href=\"Service\">Serviços</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                    ");

                                                    
                            }
                        }
                    
      out.write("\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"User?a=logout\">Logout</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <div class=\"album py-5\">\r\n");
      out.write("            ");
                       
                if (request.getAttribute("message") != null) {
            
      out.write("\r\n");
      out.write("                <div class=\"d-flex justify-content-center\">\r\n");
      out.write("                    <div class=\"alert alert-primary w-25 p-3 d-flex justify-content-center\" role=\"alert\">\r\n");
      out.write("                        ");
      out.print( (String) request.getAttribute("message") );
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <a class=\"btn btn-success\"><i class=\"fa fa-plus\"></i> Novo </a>\r\n");
      out.write("                <br/>\r\n");
      out.write("                <br/>\r\n");
      out.write("                <table class=\"table table-striped\">\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th scope=\"col\">ID</th>\r\n");
      out.write("                            <th scope=\"col\">Nome</th>\r\n");
      out.write("                            <th scope=\"col\">Função</th>\r\n");
      out.write("                            <th scope=\"col\">Ações</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <tbody>\r\n");
      out.write("                        ");
 for (UserModel userModel : userModelList) {
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                ");
      out.print( userModel.getId());
      out.write("\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                ");
      out.print( userModel.getUsername() );
      out.write("\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                ");
      out.print( userModel.getRole().getName() );
      out.write("\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <a class=\"btn btn-outline-primary\"><i class=\"fa fa-edit\"></i> Editar </a>\r\n");
      out.write("                                <a class=\"btn btn-outline-danger\"><i class=\"fa fa-trash\"></i> Excluir </a>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        ");
 }
      out.write("\r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
      out.write("<script src=\"JQuery/jquery-3.5.1.min.js\"></script>\n");
      out.write("<script src=\"JQuery/jquery.mask.min.js\"></script>\n");
      out.write("<script src=\"Popper/popper-2.8.4.min.js\"></script>\n");
      out.write("<script src=\"Bootstrap/js/bootstrap.min.js\"></script>");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
