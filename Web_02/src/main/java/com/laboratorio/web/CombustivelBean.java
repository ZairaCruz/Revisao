package com.laboratorio.web;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

@ManagedBean (name="bean")
public class CombustivelBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Float litros;
	private String desconto;
	private Float valorLitro;
	private Float valorPagar;
	private Float valorDesc;
	private String nomeCombustivel = "";
	
	
	
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	public Float getLitros() {
		return litros;
	}
	public void setLitros(Float litros) {
		this.litros = litros;
	}
	
	public Float getValorLitro() {
		return valorLitro;
	}
	public void setValorLitro(Float valorLitro) {
		this.valorLitro = valorLitro;
	}
	public Float getValorPagar() {
		return valorPagar;
	}
	public void setValorPagar(Float valorPagar) {
		this.valorPagar = valorPagar;
	}
	public Float getValorDesc() {
		return valorDesc;
	}
	public void setValorDesc(Float valorDesc) {
		this.valorDesc = valorDesc;
	}
	public String getNomeCombustivel() {
		return nomeCombustivel;
	}
	public void setNomeCombustivel(String nomeCombustivel) {
		this.nomeCombustivel = nomeCombustivel;
	}
	////////////necesários para o radio
	public enum Tipo{Alcool, Gasolina};
	private Tipo combustivel = Tipo.Alcool;
	
	public static void setTipoItens(Map<String, Tipo> tipoItens){
		CombustivelBean.tipoItens = tipoItens;
	}
	public Map<String, Tipo> getTipoItens(){
		return tipoItens;
	}
	private static Map<String, Tipo> tipoItens;
		static{
		tipoItens = new LinkedHashMap<String, Tipo>();
		tipoItens.put("Alcool", Tipo.Alcool);
		tipoItens.put("Gasolina", Tipo.Gasolina);
	};
	
	public Tipo getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(Tipo combustivel) {
		this.combustivel = combustivel;
	}
	///////////////////////////////////////////
	
	public String calcular(){
		nomeCombustivel = combustivel.name();
		if(combustivel == Tipo.Alcool){
			valorLitro = (float) 1.90;
			if(litros <= 20){
				desconto = "3%";
				valorDesc = (float) (valorLitro - 
						(valorLitro * 0.03));
				valorPagar = valorDesc * litros;
			}else{
				desconto = "5%";
				valorDesc = (float) (valorLitro - (valorLitro * 0.05));
				valorPagar = valorDesc * litros;
			}
		}
		if(combustivel == Tipo.Gasolina){
			valorLitro = (float) 2.50;
			if(litros <= 20){
				desconto = "4%";
				valorDesc = (float) (valorLitro - 
						(valorLitro * 0.04));
				valorPagar = valorDesc * litros;
			}else{
				desconto = "6%";
				valorDesc = (float) (valorLitro - (valorLitro * 0.06));
				valorPagar = valorDesc * litros;
			}
		}
		return null;
	}
}
