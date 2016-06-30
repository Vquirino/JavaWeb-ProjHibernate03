package persistence;

import java.util.List;
import model.Produto;
import org.hibernate.Session;

public class ProdutoDao {
    
    // metodo para listar produtos
    public List<Produto> listar() throws Exception{
        Session s = HibernateUtil.getSessionFactory().openSession(); //sessão com o banco de dados
        return s.createQuery("from Produto order by nome").list(); //HQL - Hibernate Query Language
    }
    
}
