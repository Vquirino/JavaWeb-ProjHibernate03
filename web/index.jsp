<%@page import="model.*" %>
<%@page import="persistence.*" %>
<%@page import="java.util.*" %>

<%-- Carregar os dados dos produtos --%>
<%

    List<Produto> produtos = new ArrayList<Produto>();
    
    try{
        produtos = new ProdutoDao().listar();
    }
    catch (Exception e){
        out.print(e.getMessage());
    }

%>

<strong>COTI Informática - WebDeveloper</strong>
<hr size="1"/>

Cadastro de Estoque
<br/><br/>

<form name="f" method="post" action="Controle">
    
    Descrição do estoque: <br/>
    <textarea name="descricao" rows="4" cols="60"></textarea>
    
    <br/><br/>
    Marque o(s) produto(s): <br/>
    
    <%
        for(Produto p : produtos) { //for-each
    %>
    
            <input type="checkbox" name="produtos" value="<%= p.getIdProduto() %>"/>
            <%= p.getNome() %>, <%= p.getMarca() %>
            <br/>
    
    <%
        }
    %>
    <br/><br/>
    <input type="submit" value="Cadastrar Estoque"/>
    <input type="reset" value="Apagar"/>
    
</form>
    
<h3> ${mensagem} </h3>