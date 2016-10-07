package com.netcracker.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.netcracker.StaticList;
import com.netcracker.domain.*;
import com.netcracker.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@Controller
public class EntityController {

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
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private CompositionService compositionService;

	Integer IdOfRecipe;
	boolean isAdditionalSearch = false;
	boolean isExtension = false;

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
	@RequestMapping(value = "/MenuPage", method = RequestMethod.GET)
	public String MenuPage(Map<String, Object> map){

		map.put("additional", isAdditionalSearch);
		map.put("adding", isExtension);

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

		if (isExtension)
			isExtension = false;
		isAdditionalSearch = true;

		return "redirect:/MenuPage";
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

	//-------------CATEGORY PAGE-------------
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String category(Map<String, Object> map){

		map.put("category", new Category());
		map.put("categoryList", categoryService.list());
		if(!StaticList.staticList.isEmpty()){
			Category category = categoryService.findById(StaticList.staticList.get(0));
			StaticList.staticList.clear();
			List<Recipe> recipes = recipeService.findByCategory(category);
			map.put("recipes", recipes);
		}

		return "Category";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, BindingResult result){

		categoryService.add(category);

		return "redirect:/category";
	}

	//-------------COMMENT PAGE-------------
	@RequestMapping("/showComment/{recipeId}")
	public String showComment(@PathVariable("recipeId") Integer recipeId, Map<String, Object> map) {

		IdOfRecipe = recipeId;
		map.put("commentList", recipeService.findById(recipeId).getComments());

		return "ShowComment";
	}

	//-------------ADD COMMENT PAGE-------------
	@RequestMapping(value = "/addComment/{id}")
	public String addComment(@PathVariable("id") Integer id, Map<String, Object> map){

		IdOfRecipe = id;
		map.put("comment", new Comment());

		return "AddComment";
	}

	@RequestMapping(value = "/addComment/newComment", method = RequestMethod.POST)
	public String newComment(@ModelAttribute("comment") Comment comment, BindingResult result){

		Recipe recipe = recipeService.findById(IdOfRecipe);
		comment.setId(commentService.list().size()+1);
		comment.setDate(Date.valueOf(LocalDate.now().toString()));
		commentService.add(comment);
		recipe.getComments().add(comment);
		recipeService.update(recipe);

		return "redirect:/showComment/" + IdOfRecipe;
	}

	//-------------ADDING-------------
	@RequestMapping(value = "/adding")
	public String adding(){

		if (isAdditionalSearch)
			isAdditionalSearch = false;
		isExtension = true;

		return "redirect:/MenuPage";
	}

	//-------------ADDING TIME-------------
	@RequestMapping(value = "/addingTime", method = RequestMethod.GET)
	public String addingTime(Map<String, Object> map){

		map.put("time", new Time());

		return "addingTime";
	}

	//-------------ADDING CUISINE-------------
	@RequestMapping(value = "/addingCuisine", method = RequestMethod.GET)
	public String addingCuisine(Map<String, Object> map){

		map.put("cuisine", new Cuisine());

		return "addingCuisine";
	}

	//-------------ADDING CATEGORY-------------
	@RequestMapping(value = "/addingCategory", method = RequestMethod.GET)
	public String addingCategory(Map<String, Object> map){

		map.put("category", new Category());

		return "addingCategory";
	}

	//-------------ADDING COOKING METHOD-------------
	@RequestMapping(value = "/addingCookMethod", method = RequestMethod.GET)
	public String addingCookMethod(Map<String, Object> map){

		map.put("method", new CookMethod());

		return "addingCookMethod";
	}

	//-------------ADDING RECIPE-------------
	@RequestMapping(value = "/addingRecipe", method = RequestMethod.GET)
	public String addingRecipe(Map<String, Object> map){

		map.put("recipe", new Recipe());
		map.put("categoryList", categoryService.list());
		map.put("cuisineList", cuisineService.list());
		map.put("methodList", cookMethodService.list());
		map.put("timeList", timeService.list());
		map.put("ingredientList", ingredientService.list());


		return "addingRecipe";
	}

	@RequestMapping(value = "/addRecipe", method = RequestMethod.POST)
	public String newRecipe(@ModelAttribute("recipe") Recipe recipe, BindingResult result){

		Category category = new Category();
		category.toCategory(recipe.getCategoryString());
		recipe.setCategory(category);

		Cuisine cuisine = new Cuisine();
		cuisine.toCuisine(recipe.getCuisineString());
		recipe.setCuisine(cuisine);

		CookMethod method = new CookMethod();
		method.toCookMethod(recipe.getMethodString());
		recipe.setMethod(method);

		Time time = new Time();
		time.toTime(recipe.getTimeString());
		recipe.setTime(time);

		recipeService.add(recipe);

		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		for (String s:recipe.getIngredients()){
			Ingredient ingredient = new Ingredient();
			ingredient.toIngredient(s);
			ingredients.add(ingredient);
		}

		Composition composition = new Composition();
		composition.setIngredient(ingredients);
		composition.setId(compositionService.list().size() + 1);
		composition.setRecipe(recipe);
		compositionService.add(composition);


		return "redirect:/BasicSearch";
	}

}
