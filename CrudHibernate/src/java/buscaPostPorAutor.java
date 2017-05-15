/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc
 */
public class buscaPostPorAutor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            
            String autor = request.getParameter("autor");
            
            Criteria c = sessao.createCriteria(Post.class);
            
            if(autor != null && !autor.trim().equals("")){
                c.add(Restrictions.like("autor", autor));
            }
            /*
            if(sobrenome != null && !sobrenome.trim().equals("")){
                c.add(Restrictions.eq("sobrenome", sobrenome));
            }
            if(disciplina != null && !disciplina.trim().equals("")){
                c.add(Restrictions.eq("disciplina", disciplina));
            }
            */
            List<Post> result = c.list();
            if(result != null && result.size() > 0) {
                for(Post p : result){
                    out.println("<br>"+p.getAutor());
                    out.println("<div style='border:2px solid #cecece'><br>"+p.getTitulo());
                    out.println("<br>"+p.getConteudo()+"</div>");
                    out.println("<a href='deletaPost?codigo="+p.getIdPost()+"'>Deletar</a>");
                    out.println();
                    out.println();
                }
            } else {
                out.println("Nenhum resultado encontrado");
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>buscaPostPorAutor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
