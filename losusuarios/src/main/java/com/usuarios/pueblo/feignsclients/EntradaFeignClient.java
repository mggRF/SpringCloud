package com.usuarios.pueblo.feignsclients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuarios.pueblo.model.EntradaDTO;
import com.usuarios.pueblo.model.EntradaRec;

//FeignClient(name="loscines",url="http://localhost:8001")
@FeignClient(name="loscines")
public interface EntradaFeignClient {

	@PostMapping("/api/entrada")
	EntradaRec alta(@RequestBody EntradaDTO c) ;

}
