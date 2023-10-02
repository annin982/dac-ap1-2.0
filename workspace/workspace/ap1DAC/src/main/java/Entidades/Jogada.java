package Entidades;
import java.text.SimpleDateFormat;  
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "jogada")
public class Jogada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "jogador1")
    private String jogador1;

    @Column(name = "jogador2")
	private String jogador2;

	@Column(name = "jogada1")
	private String jogada1;

	@Column(name = "jogada2")
	private String jogada2;

	@Column(name = "resultado")
	private String resultado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;
	
	public String getDataFormatada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(data);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJogador1() {
		return jogador1;
	}

	public void setJogador1(String jogador1) {
		this.jogador1 = jogador1;
	}

	public String getJogador2() {
		return jogador2;
	}

	public void setJogador2(String jogador2) {
		this.jogador2 = jogador2;
	}

	public String getJogada1() {
		return jogada1;
	}

	public void setJogada1(String jogada1) {
		this.jogada1 = jogada1;
	}

	public String getJogada2() {
		return jogada2;
	}

	public void setJogada2(String jogada2) {
		this.jogada2 = jogada2;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	public static void exibirMensagem(String string) {
			
	}
}