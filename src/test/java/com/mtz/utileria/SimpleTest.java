package com.mtz.utileria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleTest {

	private final String PATH_TELEMETRIA = "\\\\TPJWLAPP\\compartida\\Telemetria";

	@Test
	public void test() {
		getFilesPaths(Paths.get(PATH_TELEMETRIA)).forEach(path -> {
			try {
				Files.lines(path).forEach(line -> log.info("{}", line));
			} catch (IOException e) {
				log.error("Error:::", e);
			}
		});
	}

	private List<Path> getFilesPaths(Path carpeta) {
		List<Path> list = new ArrayList<>();

		try (Stream<Path> rutas = Files.walk(carpeta)) {
			list.addAll(rutas.filter(Files::isRegularFile).map(Path::toAbsolutePath).collect(Collectors.toList()));
		} catch (IOException e) {
			log.error("Error:::", e);
		}

		return list;
	}

}
