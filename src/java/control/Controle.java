package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Estoque;
import model.Produto;
import persistence.EstoqueDao;

public class Controle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            Estoque e = new Estoque();
            e.setDescricao(request.getParameter("descricao"));
            
            // resgatar o campo checkbox dos produtos
            String[] produtos = request.getParameterValues("produtos"); //vetor
            List<Produto> lote = new ArrayList<Produto>();
            
            // validação para saber se foi marcado algum checkbox
            for(String idproduto : produtos){
                Produto p = new Produto();
                p.setIdProduto(new Integer(idproduto));
                lote.add(p);
            }
            
            e.setLote(lote); // associando Estoque ao Lote de produtos marcados na página
            
            try{
                new EstoqueDao().salvar(e);
                request.setAttribute("mensagem", "Estoque cadastrado com sucesso!");
            }
            catch (Exception ex){
                request.setAttribute("mensagem", ex.getMessage());
            }
            finally{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
