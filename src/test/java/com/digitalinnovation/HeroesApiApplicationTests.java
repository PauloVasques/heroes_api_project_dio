package com.digitalinnovation;

import com.digitalinnovation.constants.HeroesConstant;
import com.digitalinnovation.document.Heroes;
import com.digitalinnovation.repository.HeroesRepository;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;


@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class HeroesApiApplicationTests {

  @Autowired
  WebTestClient webTestClient;


  @Autowired
  HeroesRepository heroesRepository;


  @Test
  public void listAllHeroes(){

    webTestClient.get().uri(HeroesConstant.HEROES_ENDPOINT_LOCAL)
            .exchange()
            .expectStatus().isOk()
            .expectBody();
  }


  @Test
  public void getOneHeroById(){

    webTestClient.get().uri(HeroesConstant.HEROES_ENDPOINT_LOCAL.concat("/{id}"),"2")
      .exchange()
      .expectStatus().isOk()
      .expectBody();


  }

  @Test
  public void getOneHeroNotFound(){

    webTestClient.get().uri(HeroesConstant.HEROES_ENDPOINT_LOCAL.concat("/{id}"),"10")
      .exchange()
      .expectStatus().isNotFound();

  }


  @Test
  public void deleteHero(){

    webTestClient.delete().uri(HeroesConstant.HEROES_ENDPOINT_LOCAL.concat("/{id}"),"3")
      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().is2xxSuccessful()
      .expectBody(Void.class);

  }

  @Test
  public void createHero(){
    Heroes heroes = new Heroes();
    heroes.setId("30");
    heroes.setName("Spiderman");
    heroes.setUniverse("Marvel");
    heroes.setFilms(7);

    webTestClient.post()
            .uri(HeroesConstant.HEROES_ENDPOINT_LOCAL)
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromObject(heroes))
            .exchange()
            .expectStatus().isCreated();

  }

}


