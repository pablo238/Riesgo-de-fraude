package com.sura.frauddetection.runner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.sura.frauddetection.steps.PrediccionesSteps;

import cucumber.api.CucumberOptions;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;


@RunWith(SerenityParameterizedRunner.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber.json" }, glue = "com.sura.frauddetection.steps", monochrome = false)
@Concurrent(threads = "4")
@UseTestDataFrom(value = "ejm.csv", separator = ',')
public class TestDefraudadores {
	private String cedula;
	private String prediccion;

	@Qualifier
	public String qualifier() {
		return cedula + ": " + prediccion;
	}

	@Steps
	PrediccionesSteps prediccionesSteps;


	@Test
	public void prediccion()  {
		prediccionesSteps.dadoElEmpleado(cedula);
		prediccionesSteps.cuandoSeExaminanSusVariables();
		prediccionesSteps.entoncesSeDebeObtenerUnaPrediccion(cedula, prediccion);
	}
}