package group.common;

import group.알람Application;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { 알람Application.class })
public class CucumberSpingConfiguration {}
