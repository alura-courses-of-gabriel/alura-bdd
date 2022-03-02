package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.*;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

public class LeilaoSteps {

    private LoginPage loginPage;
    private Browser browser;
    private LeiloesPage leiloesPage;
    private NovoLeilaoPage novoLeilaoPage;

    @Dado("um usuario logado")
    public void um_usuario_logado() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
        leiloesPage = loginPage.realizaLoginComoFulano();
    }

    @Quando("acessa a pagina de novo leilao")
    public void acessa_a_pagina_de_novo_leilao() {
        novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
    }

    @Quando("preenche o formulario com dados validos")
    public void preenche_o_formulario_com_dados_validos() {
        this.leiloesPage = this.novoLeilaoPage.preencheForm("PC", "1500", "01/01/2020");
    }

    @Entao("volta para a pagina de leiloes")
    public void volta_para_a_pagina_de_leiloes() {
        Assertions.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
    }

    @Entao("novo leilao aparece na lista de leiloes")
    public void novo_leilao_aparece_na_lista_de_leiloes() {
        this.leiloesPage.existe("PC", "1500", "01/01/2020");
    }


}
