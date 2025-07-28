package desafio.itau.springboot.controller;

import desafio.itau.springboot.DTO.EstatísticaDTO;
import desafio.itau.springboot.service.TransascaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatística")
public class EstatísticaController {

    private final TransascaoService transascaoService;

    public EstatísticaController(TransascaoService transascaoservice){
        this.transascaoService = transascaoservice;
    }

    @GetMapping
    public ResponseEntity<EstatísticaDTO> getEstatísticas(){
        DoubleSummaryStatistics stats = transascaoService.getEstatística();
        return ResponseEntity.ok(new EstatísticaDTO(stats));

    }

}
