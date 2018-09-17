/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rastreamento.implementacao.crud;

import java.io.Serializable;
import javax.sql.DataSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shall
 */
@Component
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SimpleJdbcInsertImplements extends SimpleJdbcInsert implements Serializable {

    private static final long serialVersionUID = 1L;

    public SimpleJdbcInsertImplements(DataSource dataSource) {
        super(dataSource);
    }

}
