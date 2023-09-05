package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Financiamento;

@WebServlet(name = "ControleFinanciamento",
urlPatterns = {"/calcular", "/limpar"})

public class ControleFinanciamento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                                                     throws ServletException, IOException {

        if (request.getRequestURI().endsWith("calcular")) {
            calcularFinanciamento(request);
        }

        if (request.getRequestURI().endsWith("limpar")) {
            limparFormularioFinanciamento(request);
        }

        response.sendRedirect("index.jsp");        
    }

    private void calcularFinanciamento(HttpServletRequest request) {
        HttpSession sessao = request.getSession();
        
        float valorFinanciado = 0;
        float taxaJuros = 0;
        float custoMensal = 0;
        float prazoTotal = 0;
        
        String valor = request.getParameter("valor");
        if (valor != null && valor.trim().length() > 0) {
                valorFinanciado = Float.parseFloat(request.getParameter(valor));
        } else {
            sessao.setAttribute("erro", "O valor do financiamento nao foi informado. Favor preencher o campo.");
        }
        
        String taxa = request.getParameter("taxa");
        if (taxa != null && taxa.trim().length() > 0) {
                taxaJuros = Float.parseFloat(request.getParameter(taxa));
        } else {
            sessao.setAttribute("erro", "A taxa de juros nao foi informada. Favor preencher o campo.");
        }
        
        String custo = request.getParameter("custo");
        if (custo != null && custo.trim().length() > 0) {
                custoMensal = Float.parseFloat(request.getParameter(custo));
        } else {
            sessao.setAttribute("erro", "O custo mensal nao foi informado. Favor preencher o campo.");
        }
        
        String prazo = request.getParameter("prazo");
        if (prazo != null && prazo.trim().length() > 0) {
                prazoTotal = Float.parseFloat(request.getParameter(prazo));
        } else {
            sessao.setAttribute("erro", "O prazo de pagamento nao foi informado. Favor preencher o campo.");
        }
        
        Financiamento financiamento = new Financiamento(valorFinanciado, taxaJuros, custoMensal, prazoTotal);
    }

    private void limparFormularioFinanciamento(HttpServletRequest request) {
        HttpSession sessao = request.getSession();
        sessao.setAttribute("financiamento", new Financiamento());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
