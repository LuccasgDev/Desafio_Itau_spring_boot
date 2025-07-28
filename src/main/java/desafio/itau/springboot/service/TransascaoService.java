package desafio.itau.springboot.service;

import desafio.itau.springboot.model.Transacao;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransascaoService {

    private final Queue<Transacao> transacaes = new ConcurrentLinkedDeque<>();

    public void addTransacao(Transacao transacao){
        transacaes.add(transacao);
    }

    public void linparTansacao(){
        transacaes.clear();
    }

    public DoubleSummaryStatistics getEstatística(){
        OffsetDateTime now = OffsetDateTime.now();
        return transacaes.stream()
                //.filter( t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();
    }



}
