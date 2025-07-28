package desafio.itau.springboot.controller;

import desafio.itau.springboot.DTO.TransacaoDTO;
import desafio.itau.springboot.model.Transacao;
import desafio.itau.springboot.service.TransascaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransascaoService transascaoService;

    public TransacaoController (TransascaoService transascaoService){

        this.transascaoService = transascaoService;

    }

    @PostMapping
    public ResponseEntity<Void> createTransacao(@Valid @RequestBody TransacaoDTO request){
        if(request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() <= 0){
            return  ResponseEntity.unprocessableEntity().build();
        }
        transascaoService.addTransacao(new Transacao(request.getValor(), request.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> limparTansacao(){
        transascaoService.linparTansacao();
        return ResponseEntity.ok().build();
    }



}
