package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import Entidades.Jogada;
import dao.JogadaDAO;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@ManagedBean
public class JogadaBean {
    private Jogada jogada = new Jogada();
    private ListDataModel<Jogada> jogadasModel;

    public JogadaBean() {
        listarJogadas();
    }

    public Jogada getJogada() {
        return jogada;
    }

    public void setJogada(Jogada jogada) {
        this.jogada = jogada;
    }

    public ListDataModel<Jogada> getJogadasModel() {
        return jogadasModel;
    }

    private void listarJogadas() {
        List<Jogada> jogadas = JogadaDAO.listar();
        jogadasModel = new ListDataModel<>(jogadas);
    }

    public void preencherJogadasAutomaticamente() {
        String[] aleatorio = { "Pedra", "Papel", "Tesoura" };
        Random random = new Random();

        jogada.setJogada1(aleatorio[random.nextInt(aleatorio.length)]);
        jogada.setJogada2(aleatorio[random.nextInt(aleatorio.length)]);

        if (jogada.getJogada1().equals(jogada.getJogada2())) {
            jogada.setResultado("Empate");
        } else if ((jogada.getJogada1().equals("Pedra") && jogada.getJogada2().equals("Tesoura"))
                || (jogada.getJogada1().equals("Papel") && jogada.getJogada2().equals("Pedra"))
                || (jogada.getJogada1().equals("Tesoura") && jogada.getJogada2().equals("Papel"))) {
            jogada.setResultado("Jogador 1");
        } else {
            jogada.setResultado("Jogador 2");
        }
    }

    public void salvarJogada() {
        preencherJogadasAutomaticamente();
        JogadaDAO.salvar(jogada);
        jogada = new Jogada();
        listarJogadas();
        Jogada.exibirMensagem("Jogada salva com sucesso!");
    }

    public void iniciarEdicao(Jogada jogada) {
        this.jogada = jogada;
    }

    public void editarNomes(Jogada jogada) {
        JogadaDAO.editar(jogada);
        
        Jogada.exibirMensagem("Nomes dos jogadores editados com sucesso!");
    }
    public void excluirJogada(Jogada jogada) {
        JogadaDAO.excluir(jogada);
        listarJogadas();
        Jogada.exibirMensagem("Jogada excluída com sucesso!");
    }

    public void voltarParaListagem() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listagem.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int contarJogada(String jogada) {
        int contagem = 0;
        List<Jogada> jogadas = JogadaDAO.listar();
        for (Jogada j : jogadas) {
            if (j.getJogador1().equals(jogada) || j.getJogador2().equals(jogada)) {
                contagem++;
            }
        }
        return contagem;
    }
}
