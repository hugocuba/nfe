/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author a1502824
 */
public class Telephone {
	public static List separarDDD(String telefone) {
		
		List<String> tel = new ArrayList<>();
		
		Pattern pattern = Pattern.compile("\\((\\d+)\\)(\\d+)");
		
		Matcher matcher = pattern.matcher(telefone);

		if (matcher.find()) {
			tel.add(matcher.group(1));
			tel.add(matcher.group(2));
		}

		return tel;
	}
}
