package test;

import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TESTE: verifica se o JSON eestá sendo gerado corretamente
public class PixPayloadBuilderTest {
    @Test
    public void testBuilderJson() {
        PixPayloadBuilder pixPayloadBuilder = new PixPayloadBuilder()
                .withChavePix("minhaChavePix")
                .withNome("Nome")
                .withValor(250.00);

        String expectedJson = "{\"chavePix\":\"minhaChavePix\",\"nome\":\"Nome\",\"valor\":100.00}";

        assertEquals(expectedJson, pixPayloadBuilder.buildJson());
    }

}
