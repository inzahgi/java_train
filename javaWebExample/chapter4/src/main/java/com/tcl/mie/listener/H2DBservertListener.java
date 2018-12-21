package com.tcl.mie.listener;

import com.tcl.mie.framework.helper.DatabaseHelper;
import org.h2.tools.Server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

public class H2DBservertListener implements ServletContextListener {

    private Server server;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try{
            System.out.println("===== start H2 DATABASE =======");
            //使用org.h2.tools.Server这个类创建一个H2数据库的服务并启动服务，由于没有指定任何参数，
            // 那么H2数据库启动时默认占用的端口就是8082
            server = Server.createTcpServer().start();
            System.out.println("++++++ H2 DB start success!!! ++++++");
            DatabaseHelper.executeSqlFile("sql/create_table.sql");
            DatabaseHelper.executeSqlFile("sql/insert.sql");
        }catch (SQLException e){
            System.out.println("start H2 Db is wrong !!! " + e.toString());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if(this.server != null){
            this.server.stop();
            this.server = null;
        }
    }
}
