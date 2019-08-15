package com.sura.frauddetection.steps;

import com.sura.frauddetection.AnalisisDefraudadores;

import net.thucydides.core.annotations.Step;

public class PrediccionesSteps {
	private AnalisisDefraudadores analisisDefraudadores=new AnalisisDefraudadores();

	@Step("Dado el empleado {0}")
	public void dadoElEmpleado(String cedula) {
	}

	@Step("Cuando se examinan sus variables")
	public void cuandoSeExaminanSusVariables() {
	}

	@Step("Entonces se debe obtener una prediccion")
	public void entoncesSeDebeObtenerUnaPrediccion(String cedula, String prediccion) {
		analisisDefraudadores.generarReporte(cedula, prediccion);
	}
}