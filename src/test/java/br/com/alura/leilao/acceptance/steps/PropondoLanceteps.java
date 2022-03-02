package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PropondoLanceteps {

    private Lance lance;
    private Leilao leilao;
    private ArrayList<Lance> lances;

    @Before
    public void setUp() {
        this.lances = new ArrayList<>();
        this.leilao = new Leilao("Tablet XPTO");
    }

    @After
    public void tearDown(){

    }

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("fulano");
        lance = new Lance(usuario, BigDecimal.TEN);
    }

    @Quando("propoe ao leilao")
    public void quando_propoe_o_lance() {
        leilao.propoe(lance);
    }

    @Entao("o lance eh aceito")
    public void então_o_lance_eh_aceito() {
        Assertions.assertEquals(1, leilao.getLances().size());
        Assertions.assertEquals(this.lance.getValor(), leilao.getLances().get(0).getValor());
    }

    //@Dado("varios lances valido")
    //public void varios_lances_valido() {
    //  Usuario usuario1 = new Usuario("Fulano");
    //lance1 = new Lance(usuario1, BigDecimal.ONE);

    //Usuario usuario2 = new Usuario("Beltrano");
    //lance10 = new Lance(usuario2, BigDecimal.TEN);

    //leilao = new Leilao("Tablet XPTO");
    //}

    @Dado("um lance de {double} real do usuario {string}")
    public void um_lance_de_real_do_usuario(Double valor, String nomeUsuario) {
        lances.add(new Lance(new Usuario(nomeUsuario), BigDecimal.valueOf(valor)));
    }

    @Quando("propoe varios lances ao leilao")
    public void propoe_varios_lances_ao_leilao() {
        lances.forEach(lance -> leilao.propoe(lance));
    }

    @Entao("os lances sao aceitos")
    public void os_lances_sao_aceitos() {
        Assertions.assertEquals(this.lances.size(), leilao.getLances().size());
        Assertions.assertEquals(this.lances.get(0).getValor(), leilao.getLances().get(0).getValor());
        Assertions.assertEquals(this.lances.get(1).getValor(), leilao.getLances().get(1).getValor());
    }

    @Dado("um lance invalido de {double} reais")
    public void um_lance_invalido_de_valor_reais(Double valor) {
        this.lance = new Lance(new BigDecimal(valor));
    }

    @Entao("o lance nao eh aceito")
    public void oLanceNaoEhAceito() {
        Assertions.assertEquals(0, leilao.getLances().size());
    }
}