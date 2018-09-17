/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rastreamento.implementacao.crud;

import br.com.rastreamento.interfac.crud.InterfaceCrud;
import br.com.rastreamento.hibernate.session.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shall
 */
@Component
@Transactional
public class ImplementacaoCrud<T> implements InterfaceCrud<T> {

    private static final long serialVersionUID = 1L;

    private static SessionFactory sessionFactory = HibernateUtil.getseSessionFactory();

    @Autowired
    private JdbcTemplateImpl jdbcTemplateImpl;

    @Autowired
    private SimpleJdbcTemplateImpl simpleJdbcTemplateImpl;

    @Autowired
    private SimpleJdbcInsertImplements simpleJdbcInsertImplements;

    @Autowired
    private SimpleJdbcClassImpl simpleJdbcClassImpl;

    @Override
    public void save(T obj) throws Exception {

    }

    @Override
    public void persist(T obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveOrUpdate(T obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(T obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(T obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T merge(T obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> findList(Class<T> objs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(Class<T> enteidade, Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findByPorId(Class<T> enteidade, Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> findListByQueryDinamica(String s) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void executeUpdateQueryDinamica(String s) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void executeUpdateSQLDinamica(String s) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearSession() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void evict(Object objs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Session getSession() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> getListSQLDinamica(String sql) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplateImpl;
    }

    @Override
    public SimpleJdbcTemplate getSimpleJdbcTemplate() {
        return simpleJdbcTemplateImpl;
    }

    @Override
    public SimpleJdbcInsert getSimpleJdbcInsert() {
        return simpleJdbcInsertImplements;
    }

    @Override
    public SimpleJdbcCall getSimpleJdbcClass() {
        return simpleJdbcClassImpl;
    }

    @Override
    public Long totalRegistro(String table) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Query obterQuery(String query) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void validaSessionFactory(){
        if(sessionFactory == null){
            sessionFactory = HibernateUtil.getseSessionFactory();
        }
        validaTransaction();
    }

    private void validaTransaction() {
        if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
            sessionFactory.getCurrentSession().beginTransaction();
        }
    }

    private void commitProcessoAjax() {
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    private void rollBackProcessoAjax() {
        sessionFactory.getCurrentSession().beginTransaction().rollback();
    }

}
