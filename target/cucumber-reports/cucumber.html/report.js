$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/API/TesteSovos.feature");
formatter.feature({
  "name": "SovosTest",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@MichaelAlba"
    },
    {
      "name": "@testeSovos"
    }
  ]
});
formatter.scenarioOutline({
  "name": "\"\u003ccenary\u003e\"",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I create a new student \"\u003ccenary\u003e\"",
  "keyword": "Given "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "cenary"
      ]
    },
    {
      "cells": [
        "001 - API - Create a new student"
      ]
    }
  ]
});
formatter.scenario({
  "name": "\"001 - API - Create a new student\"",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@MichaelAlba"
    },
    {
      "name": "@testeSovos"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I create a new student \"001 - API - Create a new student\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.API.APIGetStep.iCreateANewStudent(java.lang.String)"
});
formatter.result({
  "error_message": "com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `JSON.Students` (no Creators, like default construct, exist): cannot deserialize from Object value (no delegate- or property-based Creator)\n at [Source: (FileInputStream); line: 3, column: 3]\r\n\tat com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67)\r\n\tat com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1589)\r\n\tat com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1055)\r\n\tat com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1297)\r\n\tat com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:326)\r\n\tat com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:159)\r\n\tat com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4202)\r\n\tat com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3242)\r\n\tat pages.API.StudentsData.createNewStudent(StudentsData.java:13)\r\n\tat pages.API.APIPage.POSTMethod(APIPage.java:18)\r\n\tat steps.API.APIGetStep.iCreateANewStudent(APIGetStep.java:22)\r\n\tat ✽.I create a new student \"001 - API - Create a new student\"(file:///C:/Users/gffer/Desktop/desafio-web-alelo-Michael/src/test/java/features/API/TesteSovos.feature:6)\r\n",
  "status": "failed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});