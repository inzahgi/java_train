package com.tcl.mie.framework;

import com.tcl.mie.framework.bean.Data;
import com.tcl.mie.framework.bean.Handler;
import com.tcl.mie.framework.bean.Param;
import com.tcl.mie.framework.bean.View;
import com.tcl.mie.framework.helper.BeanHelper;
import com.tcl.mie.framework.helper.ConfigHelper;
import com.tcl.mie.framework.helper.ControllerHelper;
import com.tcl.mie.framework.helper.RequestHelper;
import com.tcl.mie.framework.helper.ServletHelper;
import com.tcl.mie.framework.helper.UploadHelper;
import com.tcl.mie.framework.util.ArrayUtil;
import com.tcl.mie.framework.util.CodecUtil;
import com.tcl.mie.framework.util.JsonUtil;
import com.tcl.mie.framework.util.ReflectionUtil;
import com.tcl.mie.framework.util.StreamUtil;
import com.tcl.mie.framework.util.StringUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * url地址分发
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    //初始化servlet配置
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //初始化加载相关ioc容器
        HelperLoader.init();
        //获取servlet上下文地址
        ServletContext servletContext = servletConfig.getServletContext();
        //生成servlet注册类
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        //添加jsp路径 生成对应的servlet类
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        //生成默认的注册类
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
        //初始化上传操作
        UploadHelper.init(servletContext);
    }

    //主要的服务接口
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        ServletHelper.init(req, resp);
        try {
            //请求方式
            String requestMethod = req.getMethod().toLowerCase();
            //请求路径
            String requestPath = req.getPathInfo();
            //查找对应的注册的handler方法
            Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
            if (handler != null) {
                //查找对应的controller的类型
                Class<?> controllerClass = handler.getControllerClass();
                //从ioc容器中获取该bean
                Object controllerBean = BeanHelper.getBean(controllerClass);

                Param param;
                if (UploadHelper.isMultipart(req)) {
                    param = UploadHelper.createParam(req);
                } else {
                    param = RequestHelper.createParam(req);
                }

                Object result;
                Method actionMethod = handler.getActionMethod();
                if (param.isEmpty()) {
                    result = ReflectionUtil.invokeMethod(controllerBean, actionMethod);
                } else {
                    result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
                }

                if (result instanceof View) {
                    handleViewResult((View) result, req, resp);
                } else {
                    handleDataResult((Data) result, resp);
                }
            }
        }finally {
            ServletHelper.destory();
        }
    }

    //处理返回视图
    private void handleViewResult(View view, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        String path = view.getPath();
        if(StringUtil.isNotEmpty(path)){
            if(path.startsWith("/")){
                response.sendRedirect(request.getContextPath() + path);
            }else{
                Map<String, Object> model = view.getModel();
                for(Map.Entry<String, Object> entry : model.entrySet()){
                    request.setAttribute(entry.getKey(), entry.getValue());
                }
                request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(request, response);
            }
        }
    }

    //处理数据返回
    private void handleDataResult(Data data, HttpServletResponse response) throws IOException{
        Object model = data.getModel();
        if(model != null){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            String json = JsonUtil.toString(model);
            writer.write(json);
            writer.flush();
            writer.close();
        }
    }
}
