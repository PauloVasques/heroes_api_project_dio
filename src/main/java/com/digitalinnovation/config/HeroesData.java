package com.digitalinnovation.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.digitalinnovation.constants.HeroesConstant;

public class HeroesData {
  public static void main(String[] args) throws Exception {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
      .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(HeroesConstant.ENDPOINT_DYNAMO, HeroesConstant.REGION_DYNAMO))
      .build();
    DynamoDB dynamoDB = new DynamoDB(client);

    Table table = dynamoDB.getTable("Heroes_Api_Table");

    Item hero = new Item()
      .withPrimaryKey("id", "1")
      .withString("name", "Batman")
      .withString("universe", "DC Comics")
      .withNumber("films", 8);

    Item hero2 = new Item()
      .withPrimaryKey("id", "2")
      .withString("name", "Superman")
      .withString("universe", "DC Comics")
      .withNumber("films", 6);

    Item hero3 = new Item()
      .withPrimaryKey("id", "3")
      .withString("name", "Flash")
      .withString("universe", "DC Comics")
      .withNumber("films", 2);

    Item hero4 = new Item()
      .withPrimaryKey("id", "4")
      .withString("name", "Ironman")
      .withString("universe", "Marvel")
      .withNumber("films", 3);

    Item hero5 = new Item()
      .withPrimaryKey("id", "5")
      .withString("name", "Thor")
      .withString("universe", "Marvel")
      .withNumber("films", 3);

    Item hero6 = new Item()
      .withPrimaryKey("id", "6")
      .withString("name", "Hulk")
      .withString("universe", "Marvel")
      .withNumber("films", 4);

    PutItemOutcome outcome1 = table.putItem(hero);
    PutItemOutcome outcome2 = table.putItem(hero2);
    PutItemOutcome outcome3 = table.putItem(hero3);
    PutItemOutcome outcome4 = table.putItem(hero4);
    PutItemOutcome outcome5 = table.putItem(hero5);
    PutItemOutcome outcome6 = table.putItem(hero6);

  }

}

