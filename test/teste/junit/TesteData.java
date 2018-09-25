/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.junit;

import br.com.project.report.util.DateUtils;
import java.util.Calendar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Shall
 */
public class TesteData {
    
    @Test
    public void test(){
        try{
        assertEquals("25092018", DateUtils.getDateAtualReportName());
        assertEquals("'2018-09-25'", DateUtils.formatDateSql(Calendar.getInstance().getTime()));
        assertEquals("2018-09-25", DateUtils.formatDateSqlSimple(Calendar.getInstance().getTime()));
        } catch (Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
