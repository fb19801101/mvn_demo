package com.mvn.servlet;

import com.mvn.service.LoginBeam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@WebServlet(name = "JspServlet")
public class JspServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected Logger log = Logger.getLogger(JspServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        String prefix = getServletContext().getRealPath("/");
        prefix = prefix.replace("//", "/");
        String file = getInitParameter("log4j-init-file");
        // if the log4j-init-file is not set, then no point in trying
        if (file != null) {
            System.out.println("read log4j.properties:"+prefix + file);
            PropertyConfigurator.configure(prefix + file);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取对应的请求参数
        String methodName = request.getParameter("method");
        try {
            // 利用反射获取方法
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //例如：getBooks方法为protected,而非public,故必须进行此操作
            method.setAccessible(true);
            // 执行相应的方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void IndexGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.write("<html>\n" +
                "<body>\n" +
                "<h2>Servlet Test Hello World!</h2>\n" +
                "</body>\n" +
                "</html>");
        out.flush();
        out.close();

//
//        //将页面转发到欢迎页面
//        response.sendRedirect("input.jsp");
    }

    protected void InputGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("LoginServlet...doPost...");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //用户名和密码是否为空
        if(username == null || username.equals("")) {
            request.setAttribute("msg_username", "用户名不能为空！");
            request.getRequestDispatcher("input.jsp").forward(request, response);
        } else if (password == null || password.equals("")) {
            //设置回显方便用户重新登录
            request.setAttribute("temp_username", username);
            request.setAttribute("msg_password", "密码不能为空！");
            request.getRequestDispatcher("input.jsp").forward(request, response);
        } else {
			System.out.println("数据验证通过！");
        }
    }

    protected void LoginGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("服务器启动了，log4j开始工作了");
        HttpSession session = request.getSession();
        LoginBeam account = new LoginBeam();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String autologin = request.getParameter("autologin");
        String remberpwd = request.getParameter("remberpwd");
        account.setPassword(password);
        account.setUsername(username);
        account.setAutologin(autologin != null?true:false);
        account.setRemberpwd(remberpwd != null?true:false);

        if ((username != null)) {
            if (username.trim().equals("jsp") && (password != null) && (password.trim().equals("1"))) {
                System.out.println("success");
                session.setAttribute("account", account);
                String login_success = "success.jsp";
                response.sendRedirect(login_success);
            }else {
                System.out.println("failed");
                session.setAttribute("account", account);
                String login_failure = "failure.jsp";
                response.sendRedirect(login_failure);
            }

            return;
        }

        String login = "login.jsp";
        response.sendRedirect(login);
    }
}