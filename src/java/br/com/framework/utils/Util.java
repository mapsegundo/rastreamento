/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.framework.utils;

import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 *
 * @author Shall
 */
@Component
public class Util implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();
    
    public synchronized static ThreadLocal<Long> getThreadLocal(){
        return threadLocal;
    }
    
    
    
}
