package com.empresa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Pais;
import com.empresa.entity.Proveedor;
import com.empresa.entity.Tipo;
import com.empresa.service.PaisService;
import com.empresa.service.ProveedorService;
import com.empresa.service.TipoService;

@Controller
public class RegistraProveedorController {


	@Autowired
	private ProveedorService ProveedorService;
	
	@Autowired
	private PaisService service1;
	
	@Autowired
	private TipoService service2;
	
	@GetMapping(value = "/verRegistraProveedor" )
	public String verProveedor() {return "registraProveedor";}

	@ResponseBody //tipo en JSON 
	@GetMapping(value = "/listaPais")
	public List<Pais> cargaPais(){
		return service1.listaPais();
	}
	@ResponseBody //tipo en JSON 
	@GetMapping(value = "/listaTipo")
	public List<Tipo> cargaTipo(){
		return service2.listaTipo();
	}
	@PostMapping("/registraProveedor")
	@ResponseBody
	public Map<?, ?> registra(Proveedor obj) {
		HashMap<String, String> map = new HashMap<String, String>();
		obj.setFechaRegistro(new Date());
		Proveedor objSalida = ProveedorService.insertaProveedor(obj);
		if (objSalida == null) {
			map.put("MENSAJE", "Error en el registro");
		} else {
			map.put("MENSAJE", "Registro exitoso");
		}
		return map;
	}
	
	

}