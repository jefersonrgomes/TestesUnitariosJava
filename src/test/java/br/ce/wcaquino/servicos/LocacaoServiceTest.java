package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Optional;

public class LocacaoServiceTest {
    @Test
    public void teste() {

        //cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario();
        Filme filme = new Filme("Filme 1", 2, 5.6);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);
        //verificação
        //Assert.assertTrue(locacao.getValor()  ==  5.6);
        //Assert.assertFalse(locacao.getValor()  ==  7);
        Assert.assertEquals(Double.valueOf(5.6),locacao.getValor());
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

        Usuario u1 = new Usuario("usuario 01");
        Usuario u2 = new Usuario("usuario 01");

        Assert.assertEquals(u1, u2);

    }
}
