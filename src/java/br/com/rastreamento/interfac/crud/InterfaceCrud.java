package br.com.rastreamento.interfac.crud;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
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
public interface InterfaceCrud<T> extends Serializable {

    //Salvar os dados
    void save(T obj) throws Exception;

    void persist(T obj) throws Exception;

    //Salva ou atualiza
    void saveOrUpdate(T obj) throws Exception;

    //Atualiza os dados
    void update(T obj) throws Exception;

    //Excluir os dados
    void delete(T obj) throws Exception;

    //Salva ou atualiza e retorna objeto em estado persistente
    T merge(T obj) throws Exception;

    //Carrega a lista de determinada classe
    List<T> findList(Class<T> objs) throws Exception;

    Object findById(Class<T> entidade, Long id) throws Exception;

    T findByPorId(Class<T> entidade, Long id) throws Exception;

    List<T> findListByQueryDinamica(String s) throws Exception;

    //Executar update com HQL
    void executeUpdateQueryDinamica(String s) throws Exception;

    //Executar update com SQL
    void executeUpdateSQLDinamica(String s) throws Exception;

    //Limpa a sessao do Hibernate
    void clearSession() throws Exception;

    //Retira o objeto da sessao do hibernate
    void evict(Object objs) throws Exception;

    Session getSession() throws Exception;

    List<?> getListSQLDinamica(String sql) throws Exception;

    //JDBC do spring
    JdbcTemplate getJdbcTemplate();

    SimpleJdbcTemplate getSimpleJdbcTemplate();

    SimpleJdbcInsert getSimpleJdbcInsert();

    SimpleJdbcCall getSimpleJdbcClass();

    Long totalRegistro(String table) throws Exception;

    Query obterQuery(String query) throws Exception;

    //Carregamento dinamico JSF e Primefaces
    List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception;
}
