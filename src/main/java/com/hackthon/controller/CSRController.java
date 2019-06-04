package com.hackthon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hackthon.entities.QueryDTO;

@Controller
public class CSRController {

	@RequestMapping("/csr")
	public String indexPage(Model model) {

		List<QueryDTO> suggestions = new ArrayList<>();
		suggestions.add(new QueryDTO("Question1", "Answer1"));
		suggestions.add(new QueryDTO("Question2", "Answer2"));
		suggestions.add(new QueryDTO("Question3", "Answer3"));
		suggestions.add(new QueryDTO("Question4", "Answer4"));
		model.addAttribute("suggestions", suggestions);

		List<String> questions = new ArrayList<>();
		questions.add("Question1");
		questions.add("Question2");
		questions.add("Question3");
		questions.add("Question4");
		questions.add("Question5");
		questions.add("Question6");
		questions.add("Question7");
		questions.add("Question8");
		questions.add("Question9");
		questions.add("Question10");
		model.addAttribute("questions", questions);

		return "csr";
	}

	@RequestMapping(value = "/sendQuery", method = RequestMethod.POST)
	public @ResponseBody String getSolution(
			@RequestParam("question") String question) {
		System.out
				.println("Inside getSolution.................!!!!!!!!!!!!!!!");
		switch (question) {
		case "Question1":
			return "Answer1";
		case "Question2":
			return "Answer2";
		case "Question3":
			return "Answer3";
		case "Question4":
			return "Answer4";
		case "Question5":
			return "Answer5";
		case "Question6":
			return "Answer6";
		case "Question7":
			return "Answer7";
		case "Question8":
			return "Answer8";
		case "Question9":
			return "Answer9";
		case "Question10":
			return "Answer10";
		}
		return "";
	}
}
