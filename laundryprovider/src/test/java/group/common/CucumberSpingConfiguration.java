package group.common;

import group.LaundryproviderApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { LaundryproviderApplication.class })
public class CucumberSpingConfiguration {}
