package com.iflytek.fwpt.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.iflytek.fwpt.interceptor.SqlPrintInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * <p>
 * 毒情监测Mysql数据源
 * </p>
 *
 * @author qingli8
 * @version 1.0
 * @since 2018年8月16日上午10:01:02
 *
 */
@Configuration
@MapperScan(basePackages = MysqlDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "mysqlSessionFactoryBean")
public class MysqlDataSourceConfig {

    static final String PACKAGE = "com.iflytek.fwpt.mapper";
    static final String MAPPER_LOCATION = "classpath:mapper/**/*.xml";

    private static final Logger LOGGER = LoggerFactory.getLogger(MysqlDataSourceConfig.class);

    @Autowired
    private SqlPrintInterceptor sqlPrintInterceptor;

    @Autowired
    private PageHelper pageHelper;

    @Value("${mybatis.configLocation}")
    private String configLocation;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;

    @Value("${spring.datasource.useGlobalDataSourceStat}")
    private boolean useGlobalDataSourceStat;

    @Bean(name = "mysqlDataSource", destroyMethod = "close", initMethod = "init")
    public DataSource mysqlDataSource() {
        DruidDataSource datasource = new DruidDataSource();

        try {
            datasource.setUrl(this.dbUrl);
            datasource.setUsername(username);
            datasource.setPassword(password);
            datasource.setDriverClassName(driverClassName);
            datasource.setInitialSize(initialSize);
            datasource.setMinIdle(minIdle);
            datasource.setMaxActive(maxActive);
            datasource.setMaxWait(maxWait);
            datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
            datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
            datasource.setValidationQuery(validationQuery);
            datasource.setTestWhileIdle(testWhileIdle);
            datasource.setTestOnBorrow(testOnBorrow);
            datasource.setTestOnReturn(testOnReturn);
            datasource.setPoolPreparedStatements(poolPreparedStatements);
            datasource.setFilters(filters);
            datasource.setConnectionProperties(connectionProperties);
            datasource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        } catch (SQLException e) {
            LOGGER.error("mysql druid configuration initialization filter", e);
        }

        return datasource;
    }

    @Bean(name = "mysqlSqlSessionTemplate")
    public SqlSessionTemplate mysqlSqlSessionTemplate(@Qualifier("mysqlSessionFactoryBean") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 事务管理
     *
     * @author qingli8
     * @since 2018年8月22日下午3:51:07
     * @return
     */
    @Bean(name = "mysqlTxManager")
    public PlatformTransactionManager mysqlTxManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 提供SqlSeesion
     *
     * @author qingli8
     * @since 2018年8月22日下午3:51:16
     * @return
     */
    @Bean(name = "mysqlSessionFactoryBean")
    public SqlSessionFactory mysqlSessionFactoryBean(@Qualifier("mysqlDataSource") DataSource dataSource) {
        try {
            final SqlSessionFactoryBean mysqlSessionFactoryBean = new SqlSessionFactoryBean();
            mysqlSessionFactoryBean.setDataSource(dataSource);
            mysqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MysqlDataSourceConfig.MAPPER_LOCATION));
            // 设置mybatis-config.xml配置文件位置
            mysqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(configLocation));

            // 添加分页插件、打印sql插件
            Interceptor[] plugins = new Interceptor[] {pageHelper, sqlPrintInterceptor};
            mysqlSessionFactoryBean.setPlugins(plugins);

            return mysqlSessionFactoryBean.getObject();
        } catch (IOException e) {
            LOGGER.error("mysql mybatis resolver mapper*xml is error", e);
            return null;
        } catch (Exception e) {
            LOGGER.error("mysql mybatis sqlSessionFactory create error", e);

            return null;
        }
    }
}
