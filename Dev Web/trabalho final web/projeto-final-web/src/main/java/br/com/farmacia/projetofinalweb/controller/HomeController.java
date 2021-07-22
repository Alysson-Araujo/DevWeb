package br.com.farmacia.projetofinalweb.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.farmacia.funcionario.Funcionario;

@Controller
public class HomeController {
    

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/cliente")
    public String cliente(){
        return "cliente";
    }
    
    @RequestMapping("/funcionario")
    public String funcionario(){
        return "funcionario";
    }

    @RequestMapping("result")
    public String result(){
        return"result";
    }
    /* 
    @GetMapping("/teste")
    public String home(ModelMap model) {
        model.addAttribute("nomeDoAtributo", "Treinaweb");

        return "teste";
    }

    @Deprecated
	@GetMapping("/funcionario")
	public String greetingForm(Model model) {
		model.addAttribute("funcionario", new Funcionario());
		return "funcionario";
	}

	@PostMapping("/funcionario")
	public String funcionario(@ModelAttribute Funcionario funcionario, Model model) {
		model.addAttribute("funcionario", "teste123");
		return "funcionario";
	}

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
 */
   
}
