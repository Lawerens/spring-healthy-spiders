package com.hodowla.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hodowla.entity.Pajaki;
import com.hodowla.service.ObslugaPajaki;

@Controller
@RequestMapping("/pajaki")
public class SpiderController {
	
	@Autowired
	private ObslugaPajaki obslugaPajaki;
	
	@RequestMapping("/list")
	public String listSpiders(Model theModel) {
		List<Pajaki> theSpiders = obslugaPajaki.getPajak();
		theModel.addAttribute("pajaki", theSpiders);
		return "list-pajaki";
	}
	
	@RequestMapping("/addForm")
	public String addForm(Model theModel) {
		Pajaki theSpiders = new Pajaki();
		theModel.addAttribute("pajaki", theSpiders);
		return "pajaki-form";
	}
	
	@GetMapping("/zapiszPajaka")
	public String zapiszPajaka(
			@Valid @ModelAttribute("pajaki") Pajaki theSpider, BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()) {
			return "pajaki-form";
		}
		else {
			obslugaPajaki.zapiszPajaka(theSpider);
			return "redirect:/pajaki/list";
		}
	}
	
	@GetMapping("/edytujPajaka")
	public String edytujPajaka(@RequestParam("IdPajak") int ID_edytuj, Model theModel) {
		Pajaki theSpiders = obslugaPajaki.getPajak(ID_edytuj);
		theModel.addAttribute("pajaki", theSpiders);
		return "pajaki-form";
	}
	
	@GetMapping("/usunPajaka")
	public String usunPajaka(@RequestParam("IdPajak") int ID_usun) {
		obslugaPajaki.usunPajaka(ID_usun);
		return "redirect:/pajaki/list";
	}
	
	@GetMapping("/wyszukaj")
	public String wyszukajPajaka(@RequestParam("szukanaNazwa") String szukanaNazwa, Model theModel) {
		List<Pajaki> theSpiders = obslugaPajaki.wyszukajPajaka(szukanaNazwa);
		theModel.addAttribute("pajaki", theSpiders);
		return "list-pajaki";
	}
	
	@GetMapping("/sortowanieR")
	public String sortujPajakaR(Model theModel) {
		List<Pajaki> theSpiders = obslugaPajaki.sortujPajakaR();
		theModel.addAttribute("pajaki", theSpiders);
		return "list-pajaki";
	}
	
	@GetMapping("/sortowanieM")
	public String sortujPajakaM(Model theModel) {
		List<Pajaki> theSpiders = obslugaPajaki.sortujPajakaM();
		theModel.addAttribute("pajaki", theSpiders);
		return "list-pajaki";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
