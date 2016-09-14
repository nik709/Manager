package com.netcracker.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.netcracker.StaticList;
import com.netcracker.domain.*;
import com.netcracker.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	@Autowired
	private TimeService timeService;
	@Autowired
	private RecipeService recipeService;
	@Autowired
	private IngredientService ingredientService;
	@Autowired
	private CookMethodService cookMethodService;
	@Autowired
	private CuisineService cuisineService;

	//-------------HOME-------------
	@RequestMapping("/")
	public String home() {
		return "redirect:/WelcomePage";
	}

	//-------------LOGIN-------------
	@RequestMapping(value = "/login")
	public String login(){
		return "/login";
	}

	//-------------WELCOME PAGE-------------
	@RequestMapping("/WelcomePage")
	public String listContacts(Map<String, Object> map) {

		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());

		return "WelcomePage";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact,
			BindingResult result) {

		contactService.addContact(contact);

		return "redirect:/WelcomePage";
	}

	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {

		contactService.removeContact(contactId);

		return "redirect:/WelcomePage";
	}

	//-------------MENU PAGE-------------
	@RequestMapping(value = "/MenuPage")
	public String MenuPage(){
		return "/MenuPage";
	}

	//-------------BASIC SEARCH-------------
	@RequestMapping(value = "/BasicSearch", method = RequestMethod.GET)
	public String BasicSearch(Map<String, Object> map){

		map.put("Ingredient", new Ingredient());
		map.put("ingredientList", ingredientService.list());
		if (!StaticList.staticList.isEmpty()){
			ArrayList<Recipe> recipes = new ArrayList<Recipe>();
			ArrayList<Ingredient> tmp = new ArrayList<Ingredient>();
			for (int i=0; i<StaticList.staticList.size(); i++){
				tmp.add(ingredientService.findById(StaticList.staticList.get(i)));
			}
			StaticList.staticList.clear();
			recipes= (ArrayList<Recipe>) recipeService.findByIngredients(tmp);
			map.put("recipes", recipes);
		}
		return "/BasicSearch";


	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(){

		return "redirect:/BasicSearch";
	}

	//-------------ADDITIONAL SEARCH-------------
	@RequestMapping(value = "/AdditionalSearch")
	public String AdditionalSearch(){
		return "/AdditionalSearch";
	}

	//-------------TIME PAGE-------------
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public String time(Map<String, Object> map){

		map.put("time", new Time());
		map.put("timeList", timeService.list());
		if(!StaticList.staticList.isEmpty()){
			List<Recipe> recipes;
			Time time = timeService.findById(StaticList.staticList.get(0));
			StaticList.staticList.clear();
			recipes = recipeService.findByTime(time);
			map.put("recipes", recipes);
		}

		return "time";
	}

	@RequestMapping(value = "/addTime", method = RequestMethod.POST)
	public String addTime(@ModelAttribute("time") Time time, BindingResult result){

		timeService.add(time);

		return "redirect:/time";
	}

	@RequestMapping("/deleteTime/{timeId}")
	public String deleteTime(@PathVariable("timeId") Integer timeId) {

		timeService.remove(timeId);

		return "redirect:/time";
	}

	@RequestMapping(value = "/AddSearch", method = RequestMethod.GET)
	public String AddSearch(){

		return "redirect:/time";
	}

	//-------------COOKING METHOD PAGE-------------
	@RequestMapping(value = "/CookingMethod", method = RequestMethod.GET)
	public String method(Map<String, Object> map){

		map.put("method", new CookMethod());
		map.put("methodList", cookMethodService.list());
		if (!StaticList.staticList.isEmpty()){
			List<Recipe> recipes;
			CookMethod cookMethod = cookMethodService.findById(StaticList.staticList.get(0));
			StaticList.staticList.clear();
			recipes = recipeService.findByMethod(cookMethod);
			map.put("recipes", recipes);
		}

		return "CookingMethod";
	}

	@RequestMapping(value = "/addMethod", method = RequestMethod.POST)
	public String addMethod(@ModelAttribute("method") CookMethod method, BindingResult result){

		cookMethodService.add(method);

		return "redirect:/CookingMethod";
	}

	//-------------CUISINE PAGE-------------
	@RequestMapping(value = "/cuisine", method = RequestMethod.GET)
	public String cuisine(Map<String, Object> map){

		map.put("cuisine", new Cuisine());
		map.put("cuisineList", cuisineService.list());
		if (!StaticList.staticList.isEmpty()){
			List<Recipe> recipes;
			Cuisine cuisine = cuisineService.findById(StaticList.staticList.get(0));
			StaticList.staticList.clear();
			recipes = recipeService.findByCuisine(cuisine);
			map.put("recipes", recipes);
		}

		return "cuisine";
	}


	@RequestMapping(value = "/addCuisine", method = RequestMethod.POST)
	public String addMethod(@ModelAttribute("cuisine") Cuisine cuisine, BindingResult result){

		cuisineService.add(cuisine);

		return "redirect:/cuisine";
	}

}
