package com.sura.frauddetection;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;

import net.serenitybdd.core.Serenity;

public class AnalisisDefraudadores {
	public static List<List<String>> resultLogScenarios;
	public static List<String> headers;

	public static List<Object[]> getData(Path path) throws IOException {
		List<List<String>> data;
		try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
			data = reader.lines().map(Splitter.on(",")::splitToList).collect(Collectors.toList());
		}
		headers = data.remove(0);
		resultLogScenarios = data;
		return data.stream().map(list -> list.subList(0, 4).toArray()).collect(Collectors.toList());
	}

	public void generarReporte(String cedula, String prediccion){
		Serenity.recordReportData().withTitle("Detalles").andContents("Cedula:" + cedula);
		assertEquals("El empleado",prediccion, "No es sospechoso de fraude");
	}




}