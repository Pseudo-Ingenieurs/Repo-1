package fr.espi.gl.quizz.web;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class HelloResourceTest {

    @Test
    public void ditbienHello() {
        String coucou = new HelloResource().hello();

        assertThat(coucou).isEqualTo("hello world!!!");

    }
}
