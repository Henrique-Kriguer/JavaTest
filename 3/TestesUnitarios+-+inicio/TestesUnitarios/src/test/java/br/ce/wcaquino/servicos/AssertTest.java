package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class AssertTest {
    @Test
    public void test(){
        Assert.assertTrue(true);
        Assert.assertFalse(false);

        Assert.assertEquals(1, 1);
        Assert.assertEquals(0.5123, 0.51234, 0.0001);  // o terceiro parametro é o delta
        // que corresponde ao número de casas decimais que são permitidos fazer a comparação.

        Assert.assertEquals(Math.PI, 3.1415 , 0.0001);

        // Classes Wrapper - (tipo primitivo e objeto)
        int i = 5;
        Integer i2 = 5;

        // passando o tipo primitivo para objeto:
        Assert.assertEquals(Integer.valueOf(i), i2);

        // passando o objeto para tipo primitivo:
        Assert.assertEquals(i, i2.intValue());

        Assert.assertEquals("bola","bola");

        // comparando dois atributos ignorando letra maiuscula
        Assert.assertTrue("bola".equalsIgnoreCase("Bola"));

        // comparando dois atributos somente o radical:
        Assert.assertTrue("bola".startsWith("bo"));

        Usuario u1 = new Usuario("usuario1");
        Usuario u2 = new Usuario("usuario1");

        Assert.assertEquals(u1, u2);
        // este método de comparação vai dar erro se não for implementado antes o metodo equals na classe usuario

        // para assegurar que a semelhança seja para o nível de instância de memória:

        //Assert.assertSame(u1, u2);

        // assertiva para valor nulo:

        Usuario u3 = null;

        Assert.assertNull(u3);
    }
}
