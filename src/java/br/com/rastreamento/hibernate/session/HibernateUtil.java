package br.com.rastreamento.hibernate.session;

import br.com.rastreamento.implementacao.crud.ConexaoUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.faces.bean.ApplicationScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.SessionFactoryImplementor;

/**
 * Responsavel por estabelecer conexao com hibernate
 *
 * @author Shall
 */
@ApplicationScoped
public class HibernateUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String JAVA_COMP_ENV_JDBC_DATA_SOURCE = "java:/comp/env/jdbc/datasource";

    private static SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Responsavel por ler o arquivo de configuração hibernate.cfg.xml
     *
     * @return sessionFactory
     */
    private static SessionFactory buildSessionFactory() {

        try {
            if (sessionFactory == null) {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }
            return sessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Erro ao criar conexão SessionFactory");
        }

    }

    /**
     * Retorna o SessionFactory corrente
     *
     * @return SessionFactory
     */
    public static SessionFactory getseSessionFactory() {
        return sessionFactory;
    }

    /**
     * Retorna uma sessao do SessionFactory
     *
     * @return Session
     */
    public static Session getCurrSession() {
        return getseSessionFactory().getCurrentSession();
    }

    /**
     * Abre uma nova sessao no SessionFactory
     *
     * @return Session
     */
    public static Session openSession() {
        if (sessionFactory == null) {
            buildSessionFactory();
        }
        return sessionFactory.openSession();
    }

    /**
     * Obtem a conection do provedor de conexões configurado
     *
     * @return ConnectionSQL
     * @throws SQLException
     */
    public static Connection getConnectionProvider() throws SQLException {
        return ((SessionFactoryImplementor) sessionFactory).getConnectionProvider().getConnection();
    }
    
    /**
     * 
     * @return Connection no InitialConnection java:/comp/env/jdbc/datasource
     * @throws Exception 
     */
    public static Connection getConnection() throws Exception{
        InitialContext context = new InitialContext();
        DataSource ds = (DataSource) context.lookup(JAVA_COMP_ENV_JDBC_DATA_SOURCE);
        return ds.getConnection();
    }
    
    /**
     * 
     * @return DataSource JNDI Tomcat
     * @throws NamingException 
     */
    public DataSource getDataSource() throws NamingException{
        InitialContext context = new InitialContext();
        return (DataSource) context.lookup(ConexaoUtil.JAVA_COMP_ENV_JDBC_DATA_SOURCE);
    }
}
