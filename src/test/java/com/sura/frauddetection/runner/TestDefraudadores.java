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
@UseTestDataFrom(value = "..\\..\\testpython\\Notificacion.csv", separator = ',')
public class TestDefraudadores {
	private String Datos;
	private String Fraude;

	@Qualifier
	public String qualifier() {
		return Datos + ": " + Fraude;
	}

	@Steps
	PrediccionesSteps prediccionesSteps;


	@Test
	public void prediccion()  {
		prediccionesSteps.dadoElEmpleado(Datos);
		prediccionesSteps.cuandoSeExaminanSusVariables();
		prediccionesSteps.entoncesSeDebeObtenerUnaPrediccion(Datos, Fraude);
	}
}