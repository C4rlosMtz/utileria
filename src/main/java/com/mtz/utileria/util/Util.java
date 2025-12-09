package com.mtz.utileria.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Util {

	private static final ModelMapper modelMapper = new ModelMapper();
	private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
	public static final char QUESTION_MARK = '?';

	private Util() {
		// Private constructor to prevent instantiation of the utility class
	}

	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
	}

	public static <T> void printJsonString(T type) {
		try {
			log.info("jsonStr: {}", objectMapper.writeValueAsString(type));
		} catch (JsonProcessingException e) {
			log.error("printJsonString::: ", e);
		}
	}

	public static <T> String jsonString(T type) {
		String jsonStr = null;

		try {
			jsonStr = objectMapper.writeValueAsString(type);
		} catch (JsonProcessingException e) {
			log.error("jsonString::: ", e);
		}

		return jsonStr;
	}

	/**
	 * This method purpose is to remove left zeros from a string, if the string
	 * contains just zeros, then it returns an empty string; if the string is null,
	 * it returns null.
	 * 
	 * @param original String to remove left zeros.
	 * @return A string without left zeros.
	 */
	public static String removeLeftZeros(String original) {
		return removeLeftChar(original, '0');
	}

	public static String removeLeftChar(String original, char ch) {
		if (original == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder(original);
		while (sb.length() != 0) {
			if (sb.charAt(0) == ch) {
				sb.deleteCharAt(0);
			} else {
				break;
			}
		}

		return sb.toString();
	}

	public static BigDecimal setScale(BigDecimal bigDecimal, int scale, RoundingMode roundingMode) {
		return bigDecimal == null ? null : bigDecimal.setScale(scale, roundingMode);
	}

	public static String toUpperCase(String string) {
		return string == null ? null : string.toUpperCase();
	}

	public static String substring(String string, int beginIndex) {
		return string == null ? null : string.substring(beginIndex);
	}

	public static String trim(String string) {
		return string == null ? null : string.trim();
	}

	public static String padZerosToLeft(String original, int size) {
		if (original == null)
			return null;

		StringBuilder paddedString = new StringBuilder(original);

		while (paddedString.length() < size) {
			paddedString.insert(0, "0");
		}
		return paddedString.toString();
	}

}
