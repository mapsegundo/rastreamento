/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.project.bean.geral;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.web.context.request.FacesRequestAttributes;

/**
 *
 * @author Shall
 */
@SuppressWarnings("unchecked")
public class ViewScope implements Scope, Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String VIEW_SCOPE_CALLBACKS = "viewScope.callBacks";

    @Override
    public Object get(String nome, ObjectFactory<?> objectFactory) {
        Object instance = getViewMap().get(nome);
        if (instance == null) {
            instance = objectFactory.getObject();
            getViewMap().put(nome, instance);
        }
        return instance;
    }

    @Override
    public Object remove(String nome) {
        Object instance = getViewMap().remove(nome);
        if (instance != null) {
            Map<String, Runnable> callbacks = (Map<String, Runnable>) getViewMap().get(VIEW_SCOPE_CALLBACKS);
            if (callbacks != null) {
                callbacks.remove(nome);
            }
        }
        return instance;
    }

    @Override
    public void registerDestructionCallback(String nome, Runnable runnable) {
        Map<String, Runnable> callbacks = (Map<String, Runnable>) getViewMap().get(VIEW_SCOPE_CALLBACKS);
        if(callbacks != null){
            callbacks.put(VIEW_SCOPE_CALLBACKS, runnable);
        }
    }

    @Override
    public Object resolveContextualObject(String nome) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesRequestAttributes facesRequestAttributes = new FacesRequestAttributes(facesContext);
        return facesRequestAttributes.resolveReference(nome);
    }

    @Override
    public String getConversationId() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesRequestAttributes facesRequestAttributes = new FacesRequestAttributes(facesContext);
        return facesRequestAttributes.getSessionId() + "-" + facesContext.getViewRoot().getViewId();
    }

    // getViewRoot()
    // Retorna o componente raiz que esta associado a esta solicitacao (request)
    // getViewMap()
    // Retorna um map que atua como a interface para o armazenamento de dados
    private Map<String, Object> getViewMap() {
        return FacesContext.getCurrentInstance() != null
                ? FacesContext.getCurrentInstance().getViewRoot().getViewMap()
                : new HashMap<String, Object>();
    }
}
