package persistence;

import model.Estoque;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EstoqueDao {
    
    public void salvar(Estoque e) throws Exception{
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(e);
        t.commit();
    }
    
}
