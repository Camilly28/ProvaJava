package modelo;

public class Produto 
{
	//atributo
	private String codigo;
	private String nome;
	private float quantidade;
	private float preco;
	
	//set e get
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	//metodo construtor
	public Produto (String cd, String nm, float qt, float p)
	{
			codigo = cd;
			nome = nm;
			quantidade = qt;
			preco = p;	
	}
	
}



