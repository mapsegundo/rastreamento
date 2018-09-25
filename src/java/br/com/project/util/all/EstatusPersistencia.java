package br.com.project.util.all;

/**
 *
 * @author Shall
 */
public enum EstatusPersistencia {
    
    ERRO("Erro"), SUCESSO("Sucesso"),
    OBJETO_REFERENCIADO("Esse objeto não pode ser apagado por possuir referências ao mesmo.");
    
    private String nome;
    
    private EstatusPersistencia(String s){
        this.nome = s;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
}
