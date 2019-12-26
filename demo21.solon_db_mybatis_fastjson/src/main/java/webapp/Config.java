package webapp;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.noear.solon.XApp;
import org.noear.solon.annotation.XBean;
import org.noear.solon.annotation.XConfiguration;
import org.noear.solon.core.XMap;

import java.io.IOException;
import java.io.Reader;

@XConfiguration
public class Config {
    /**
     * 使用 xml 配置创建
     * */
    @XBean
    public SqlSession getSqlSession_cfg() throws IOException {
        //通过配置文件获取数据库连接信息
        Reader reader = Resources.getResourceAsReader("mybatis.xml");

        //通过配置信息构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //通过SqlSessionFactory打开一个数据库会话
        SqlSession sqlsession = sqlSessionFactory.openSession();
        return sqlsession;
    }


    /**
     * 使用 java 配置创建
     * */
    @XBean("sqlSession2")
    public SqlSession getSqlSession_java() throws IOException {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource_java());
        Configuration configuration = new Configuration(environment);

        //添加 typeAliases
        configuration.getTypeAliasRegistry().registerAliases("webapp.model");

        //添加 mappers
        configuration.addMappers("webapp.dso.db");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        //通过SqlSessionFactory打开一个数据库会话
        SqlSession sqlsession = sqlSessionFactory.openSession();
        return sqlsession;
    }

    public HikariDataSource dataSource_java() {
        XMap map = XApp.cfg().getXmap("test.db");

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(map.get("url"));
        dataSource.setUsername(map.get("username"));
        dataSource.setPassword(map.get("password"));

        return dataSource;
    }
}
