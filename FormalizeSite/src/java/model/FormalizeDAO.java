/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author gabriel.esmunoz
 */
public class FormalizeDAO {
    
    private EntityManagerFactory conn;
    private EntityManager manager;
    
    public void connect(){
        conn = Persistence.createEntityManagerFactory("FormalizeSitePU");//Nome tirado da pasta "Configuration Files", "pesistence.xml";
        manager = conn.createEntityManager();
    }
    
    public Acesso validarLogin(String u, String s) {
        connect();
        try { 
            TypedQuery<Acesso> q = manager.createNamedQuery("Acesso.findByEmailSenha", Acesso.class);//Query tirado da classe "Acesso",query para pegar usuario e senha;
            q.setParameter("email", u);
            q.setParameter("senha", s);
            Acesso acesso = q.getSingleResult();
            return acesso;
        } catch (NoResultException ex) {
            return null;
        }
        
    }
    
    public int criarForm(Servico servico){
        connect();
        try{
            manager.getTransaction().begin();
            manager.persist(servico);
            manager.getTransaction().commit();
            return 1;
        }catch(NoResultException e){
            return 2;
        } 
    }
    
    public int criarCli(Cliente cliente){
        connect();
        try{
            manager.getTransaction().begin();
            manager.persist(cliente);
            manager.getTransaction().commit();
            return 1;
        }catch(NoResultException e){
            return 2;
        } 
    }
    
    public int criarVei(Veiculo veiculo){
        connect();
        try{
            manager.getTransaction().begin();
            manager.persist(veiculo);
            manager.getTransaction().commit();
            return 1;
        }catch(NoResultException e){
            return 2;
        } 
    }
    
    public List<Servico> listarServico() {
        connect();
        try {
            TypedQuery<Servico> q = manager.createNamedQuery("Servico.findAll", Servico.class);//Query tirado da classe "Funcionario";
            List<Servico> servicos = q.getResultList();
            return servicos;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public int excluirServico(int idServ) {
        connect();

        try {
            Servico serv = manager.find(Servico.class, idServ);
            if (serv == null) {
                return 2;//Nao Existe;
            } else {
                manager.getTransaction().begin();
                manager.remove(serv);//So aceita tipos Object;
                manager.getTransaction().commit();
                return 1;//Encontrados;
            }
        } catch (Exception ex) {
            return 0;//Nao encontrado;
        }

    }
    
}
