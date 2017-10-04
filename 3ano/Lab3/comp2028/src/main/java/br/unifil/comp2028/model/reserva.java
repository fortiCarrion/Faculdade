package br.unifil.comp2028.model;

import java.io.Serializable;
import java.sql.Date;

public class reserva implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codReserva;
	private int idVisitante;
	private int idQuarto;
	private Date data_entrada;
	private Date data_saida;
	private String pagamento;
	private String status;
	private Date create_time;
	private Date alter_time;
	
	public reserva(){}
	
	public reserva(int a, int b, int c, Date d, Date e, String f, String g, Date h, Date i){
		setCodReserva(a);
		setIdVisitante(b);
		setIdQuarto(c);
		setData_entrada(d);
		setData_saida(e);
		setPagamento(f);
		setStatus(g);
		setCreate_time(h);
		setAlter_time(i);
		
	}
	
	public int getCodReserva() {
		return codReserva;
	}
	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}
	public int getIdVisitante() {
		return idVisitante;
	}
	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}
	public int getIdQuarto() {
		return idQuarto;
	}
	public void setIdQuarto(int idQuarto) {
		this.idQuarto = idQuarto;
	}
	public Date getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}
	public Date getData_saida() {
		return data_saida;
	}
	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}
	public String getPagamento() {
		return pagamento;
	}
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getAlter_time() {
		return alter_time;
	}
	public void setAlter_time(Date alter_time) {
		this.alter_time = alter_time;
	}
	
	
	
}
