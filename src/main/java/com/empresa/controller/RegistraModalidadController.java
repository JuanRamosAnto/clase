package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Deporte;
import com.empresa.entity.Modalidad;
import com.empresa.service.DeporteService;
import com.empresa.service.ModalidadService;

@Controller
public class RegistraModalidadController {

	@Autowired
	private DeporteService service;
	
	@Autowired
	private ModalidadService modalidadService;
		
	@GetMapping(value = "/verRegistraModalidad" )
	public String verAlumno() {return "registraModalidad";}
	
	@ResponseBody //tipo en JSON 
	@GetMapping(value = "/listaDeporte")
	public List<Deporte> cargaDeporte(){
		return service.listaDeporte();
	}
			
	
	@PostMapping("/registraModalidad")
	@ResponseBody
	public Map<?, ?> registra(Modalidad obj) {
		HashMap<String, String> map = new HashMap<String, String>();
		Modalidad objSalida = modalidadService.insertaModalidad(obj);
		if (objSalida == null) {
			map.put("MENSAJE", "Error en el registro");
		} else {
			map.put("MENSAJE", "Registro exitoso");
		}
		return map;
	}
	
	@GetMapping("/buscaPorNombreModalidad")
	@ResponseBody
	public String validaNombre(String nombre) {
		List<Modalidad> lstModalidad = modalidadService.buscaPorNombre(nombre);
		if (CollectionUtils.isEmpty(lstModalidad)) {
			return "{\"valid\" : true }";//Si no existe
		} else {	
			return "{\"valid\" : false }";//Si ya existe
		}
	}
}







