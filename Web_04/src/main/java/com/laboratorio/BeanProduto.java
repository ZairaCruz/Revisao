package com.laboratorio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import com.laboratorio.model.Produto;
import com.laboratorio.util.ConnectionFactory;

@ManagedBean (name="beanProduto")
@SessionScoped
public class BeanProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto = new Produto();

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String actionShowStatusProduto(){
		return "status_produto";
	}
	public String actionIncluir(){
		Connection conexao = null;
		PreparedStatement ps = null;
		String sql = "insert into produto(descricao, tipo)" 
				+ "values (?, ?)";
		try{
			conexao = ConnectionFactory.getConnection();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, produto.getDescricao());
			ps.setString(2, produto.getTipo());
			ps.executeUpdate();
			produto = new Produto();
		}catch(Exception e){
			System.err.println("--------------------------------");
			System.err.println("Erro no insert");
			e.printStackTrace();
		}
		return "index";
	}
}
