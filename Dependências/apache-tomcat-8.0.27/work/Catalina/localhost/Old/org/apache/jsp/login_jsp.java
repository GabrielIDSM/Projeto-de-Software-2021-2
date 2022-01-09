/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.27
 * Generated at: 2021-06-24 17:51:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/components/scripts.html", Long.valueOf(1624237988030L));
    _jspx_dependants.put("/components/head.html", Long.valueOf(1624237988027L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-BR\">\n");
      out.write("    <!-- Incluindo a tag head que é comum em toda a aplicação -->\n");
      out.write("    ");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    \n");
      out.write("    <!-- LINKS -->\n");
      out.write("    <!-- BOOTSTRAP -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"Bootstrap/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("    <!-- FONT AWESOME ICONS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"FontAwesome/css/all.css\">\n");
      out.write("\n");
      out.write("    <!-- CSS PERSONALIZADO -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles/styles.css\">\n");
      out.write("\n");
      out.write("    <!-- TÃTULO DA PÃGINA -->\n");
      out.write("    <title>Trabalho Dev Web - Entrega 1</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- NAVBAR -->\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("            <!-- CONTAINER NAVBAR -->\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.jsp\"><b>Dev Web</b></a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item mx-3\">\n");
      out.write("                            <a class=\"nav-link\" href=\"index.jsp\"><i class=\"fas fa-home\"></i> Início <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item mx-3\">\n");
      out.write("                            <a class=\"nav-link\" href=\"ProdutoController?acao=disponiveis\"><i class=\"fas fa-box-open\"></i> Produtos Disponíveis</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <a class=\"btn btn-outline-dark my-2 my-sm-0 disabled\"><i class=\"fas fa-sign-in-alt\"></i> Fazer Login</a>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <!-- ALERTA DE SUCESSO/ERRO -->\n");
      out.write("            ");
                       
                // Existem mensagens que devem ser mostradas?
                if (request.getAttribute("mensagem") != null) {
            
      out.write("\n");
      out.write("                    <div class=\"alert alert-danger m-5\" role=\"alert\">\n");
      out.write("                        ");
      out.print( (String) request.getAttribute("mensagem") );
      out.write("\n");
      out.write("                    </div>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            <div class=\"rounded border border-dark p-4 m-5\">\n");
      out.write("                <!-- FORMULÁRIO LOGIN -->\n");
      out.write("                <form method=\"POST\" action=\"LoginController\">\n");
      out.write("                    <!-- CPF -->\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"cpf\"><b>CPF</b></label>\n");
      out.write("                        <input type=\"text\" class=\"form-control cpf\" name=\"cpf\" id=\"cpf\" autocomplete=\"off\" placeholder=\"Digite o CPF do Usuário\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- SENHA -->\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"senha\"><b>Senha</b></label>\n");
      out.write("                        <input type=\"password\" class=\"form-control\" name=\"senha\" id=\"senha\" autocomplete=\"off\" placeholder=\"Digite a Senha do Usuário\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- TIPO DE CONTA -->\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label><b>Tipo de Conta</b></label>\n");
      out.write("                        <br>\n");
      out.write("                        <div class=\"form-check form-check-inline\">\n");
      out.write("                            <input class=\"form-check-input\" type=\"radio\" name=\"tipoUsuario\" id=\"administrador\" value=\"0\">\n");
      out.write("                            <label class=\"form-check-label\" for=\"administrador\">Administrador</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-check form-check-inline\">\n");
      out.write("                            <input class=\"form-check-input\" type=\"radio\" name=\"tipoUsuario\" id=\"vendedor\" value=\"1\" checked>\n");
      out.write("                            <label class=\"form-check-label\" for=\"vendedor\">Vendedor</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-check form-check-inline\">\n");
      out.write("                            <input class=\"form-check-input\" type=\"radio\" name=\"tipoUsuario\" id=\"comprador\" value=\"2\">\n");
      out.write("                            <label class=\"form-check-label\" for=\"comprador\">Comprador</label>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- BOTÃO SUBMIT -->\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-dark\"><i class=\"fas fa-check\"></i> Entrar</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Incluindo os scripts que são comuns em toda a aplicação -->\n");
      out.write("        ");
      out.write("<!-- SCRIPTS -->\n");
      out.write("<!-- JQUERY -->\n");
      out.write("<script src=\"JQuery/jquery-3.5.1.min.js\"></script>\n");
      out.write("<!-- JQUERY MASK -->\n");
      out.write("<script src=\"JQuery/jquery.mask.min.js\"></script>\n");
      out.write("<!-- POPPER -->\n");
      out.write("<script src=\"Popper/popper-2.8.4.min.js\"></script>\n");
      out.write("<!-- BOOTSTRAP -->\n");
      out.write("<script src=\"Bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function(){\n");
      out.write("        // SETANDO AS MÃSCARAS\n");
      out.write("        $('.cpf').mask('999.999.999-99');\n");
      out.write("        $('.cnpj').mask('99.999.999/9999-99');\n");
      out.write("        $('.data').mask('99/99/9999');\n");
      out.write("        $('.telefone').mask('(99) 99999-9999');\n");
      out.write("    });\n");
      out.write("</script>");
      out.write("\n");
      out.write("    </body>\n");
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
