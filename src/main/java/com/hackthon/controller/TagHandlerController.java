package com.hackthon.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackthon.entities.QueryDTO;

@RestController
public class TagHandlerController {

	private static final Map<String, List<QueryDTO>> map = new HashMap<>();
	static {
		map.put("data",
				new ArrayList<>(Arrays.asList(new QueryDTO(
						"What are data plans?", "These are data plans."),
						new QueryDTO("I am facing data issues ?",
								"Below are solutions to fix them."))));
		map.put("data,plan",
				new ArrayList<>(Arrays.asList(new QueryDTO(
						"What are data plans?", "These are data plans."))));
		map.put("data,issue",
				new ArrayList<>(Arrays.asList(new QueryDTO(
						"I am facing data issues ?",
						"Below are solutions to fix them."))));
	}

	// http://localhost:8080/fetchQuery?tags=data&tags=issue
	@RequestMapping("/fetchQuery")
	public @ResponseBody List<QueryDTO> index(@RequestParam List<String> tags) {
		List<String> tagsToMatch = new ArrayList<>();
		for (String tag : tags) {
			if (tag.equals("issues")) {
				tagsToMatch.add("issue");
			} else if (tag.equals("plans")) {
				tagsToMatch.add("plan");
			} else {
				tagsToMatch.add(tag);
			}
		}
		List<String> distinctTagsToMatch = tagsToMatch.stream().distinct()
				.collect(Collectors.toList());
		for (Map.Entry<String, List<QueryDTO>> entry : map.entrySet()) {
			List<String> key = Arrays.asList(entry.getKey().split(","));
			System.out.println("distinctTagsToMatch : " + distinctTagsToMatch);
			System.out.println("key : " + key);
			if (key.containsAll(distinctTagsToMatch)
					&& key.size() == distinctTagsToMatch.size()) {
				System.out.println("---" + key);
				return entry.getValue();
			}
		}
		return null;
	}
}
