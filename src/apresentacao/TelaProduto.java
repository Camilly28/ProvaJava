package apresentacao;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import modelo.Produto;

public class TelaProduto extends JFrame
{	
	//atributos comuns
	private JLabel lCodigo,lNome,lQuantidade,lPreco;
	private JTextField tCodigo,tNome,tQuantidade,tPreco;
	private JButton bSalvar,bListar,bLimpar,bFechar;
	private JPanel painelTopo,painelCentral,painelInferior;
	private int screenHeight;
	private int screenWidth;
	
	
	//atributo de referência
	private Produto produto;
	
	//variáveis locais para armazenar o que for digitado pelo usuário
	String codigo,nome,quantidade,preco;

	//método construtor
	public TelaProduto()
	{
		//configurações da janela TelaLivro
		this.setTitle("Tela de Gerenciamento de Produto");
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
	    screenHeight = d.height-400;
        screenWidth = d.width-720;
        this.setSize(screenWidth,screenHeight);
		this.setResizable(false);
		this.setLocationRelativeTo(null); //centraliza a janela na abertura
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //fecha somente a janela ativa
		
        //muda o ícone de controle da janela tela livro
        Image img = tk.getImage("src/imagens/icone.png");
        this.setIconImage(img);

		//captura da área útil da janela (container da janela)
		Container c = this.getContentPane();
				
		//definição do gerenciador de layout e aplicação ao container da janela
		BorderLayout layout = new BorderLayout(5,5);
		c.setLayout(layout);
		
		//criando painéis para estruturar as áreas na tela 
        //cria um painel para o topo da janela com uma imagem e um título;
		//adiciona o painel ao container da janela em seu topo (parte supperior)
		JPanel painelSuperior = new JPanel();
		ImageIcon iconLogo = new ImageIcon("src/imagens/produto.png");
		JLabel imagem = new JLabel();
		imagem.setIcon(iconLogo);
		JLabel texto = new JLabel("     TELA DE PRODUTO");
		texto.setFont(new Font ("Arial",Font.BOLD,20));
		painelSuperior.add(imagem);
		painelSuperior.add(texto);
		c.add(painelSuperior,BorderLayout.NORTH);	 
		 
		//cria um painel para o centro da janela
        //definição do gerenciador de layout e aplicação ao painel central da janela
		JPanel painelCentral = new JPanel();
		GridLayout layoutCentral = new GridLayout(4,2,5,5);
		painelCentral.setLayout(layoutCentral);

		//criando rótulos e caixas de texto e adicionando-os
		//ao painel central de acordo com o gerenciador de layout definido 
		lCodigo = new JLabel("     Código do Produto: ");
		lCodigo.setFont(new Font ("Arial",Font.BOLD,16));
		painelCentral.add(lCodigo);	
		
		tCodigo = new JTextField();
		painelCentral.add(tCodigo);

		lNome = new JLabel("     Nome do Produto: ");
		lNome.setFont(new Font ("Arial",Font.BOLD,16));
		painelCentral.add(lNome);	
		
		tNome = new JTextField();
		painelCentral.add(tNome);
		
		lQuantidade = new JLabel("     Quantidade do Produto: ");
		lQuantidade.setFont(new Font ("Arial",Font.BOLD,16));
		painelCentral.add(lQuantidade);
		
		tQuantidade = new JTextField();
		painelCentral.add(tQuantidade);
				
		lPreco = new JLabel("     Preço do Produto: ");
		lPreco.setFont(new Font ("Arial",Font.BOLD,16));
		painelCentral.add(lPreco);
		
		tPreco = new JTextField();
		painelCentral.add(tPreco);
		
		//cria um painel para o rodapé (parte inferior) da janela
        //definição do gerenciador de layout e aplicação ao painel inferior da janela
		JPanel painelInferior = new JPanel();
		GridLayout layoutInferior = new GridLayout(1,4,0,0);
		painelInferior.setLayout(layoutInferior);
		
		//criando classe interna para funcionar como ouvinte dos eventos de mouse
		class BatSinal extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				//se o botão Salvar for clicado pelo mouse...
				if (e.getSource() == bSalvar)
				{	codigo = tCodigo.getText();
					nome = tNome.getText();
					quantidade = tQuantidade.getText();
					preco = tPreco.getText();
					//produto = new Produto(codigo,nome,quantidade,preco);
					JOptionPane.showMessageDialog(null,"Produto criado com sucesso!");
				}
				//se o botão Listar for clicado pelo mouse...				
				if (e.getSource() == bListar)
				{	if(produto==null)
					{	JOptionPane.showMessageDialog(null,"Não há o que listar!");	}
					else
					{	JOptionPane.showMessageDialog(null,"DADOS DO PRODUTO:"
						+ "\nCódigo: "+produto.getCodigo()
						+ "\nTítulo: "+produto.getNome()
						+ "\nQuantidade: "+produto.getQuantidade()
						+ "\nPreço: "+produto.getPreco());
					}
				}	
				//se o botão Limpar for clicado pelo mouse...				
				if (e.getSource() == bLimpar)
				{	tCodigo.setText("");
					tNome.setText("");
					tQuantidade.setText("");
					tPreco.setText("");
				}	
				//se o botão Fechar for clicado pelo mouse...
				if (e.getSource() == bFechar)
				{	dispose();	}
			}
		}
		
		//adicionando ouvinte do mouse para os botões
		BatSinal batman = new BatSinal();
		
		//criando os botões e adicionando-os
		//ao painel inferior de acordo com o gerenciador de layout definido 
		bSalvar = new JButton("Criar Produto");
		bSalvar.setFont(new Font ("Arial",Font.BOLD,14));
		bSalvar.setForeground(Color.white);
		bSalvar.setBackground(new Color(3,101,173));
		bSalvar.addMouseListener(batman); //aplicando o ouvinte do mouse a cada botão
		painelInferior.add(bSalvar);
		
		bListar = new JButton("Mostrar Produto");
		bListar.setFont(new Font ("Arial",Font.BOLD,14));
		bListar.setForeground(Color.white);
		bListar.setBackground(new Color(3,101,173));
		bListar.addMouseListener(batman); //aplicando o ouvinte do mouse a cada botão
		painelInferior.add(bListar);

		bLimpar = new JButton("Limpar");
		bLimpar.setFont(new Font ("Arial",Font.BOLD,14));
		bLimpar.setForeground(Color.white);
		bLimpar.setBackground(new Color(3,101,173));
		bLimpar.addMouseListener(batman); //aplicando o ouvinte do mouse a cada botão
		painelInferior.add(bLimpar);
		
		bFechar = new JButton("Fechar");
		bFechar.setFont(new Font ("Arial",Font.BOLD,14));
		bFechar.setForeground(Color.white);
		bFechar.setBackground(new Color(3,101,173));
		bFechar.addMouseListener(batman); //aplicando o ouvinte do mouse a cada botão
		painelInferior.add(bFechar);
					
		//adicionando os painéis central e inferior
		//ao gerenciador de layout da tela livro nas posições centro e rodapé
		c.add(painelCentral,BorderLayout.CENTER);
		c.add(painelInferior,BorderLayout.SOUTH);
}
}