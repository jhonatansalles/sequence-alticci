package com.winprovit.alticci.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AlticciService {

    @Autowired
    RedisService redisService;

    public Long sequence(Long indice) {
        log.info("INDICE informado {}", indice);

        // verifica se o indice já foi calculado e recupera do cache
        if (BooleanUtils.isTrue(redisService.hasKey(indice)))
            return redisService.get(indice);

        long alticci = this.calculateAlticci(indice);
        log.info("Sequencia Alticci calculada {}", alticci);

        // armazena o calculo para consultas futuras
        redisService.set(indice, alticci);

        return alticci;
    }

    private long calculateAlticci(Long indice) {

        long sequenciaCalculada;
        if (indice == 0L) {
            sequenciaCalculada = indice;
        } else if (indice == 1L || indice == 2L) {
            sequenciaCalculada = 1L;
        } else {
            sequenciaCalculada = (this.calculateAlticci(indice - 3) + this.calculateAlticci(indice - 2));
        }

        log.info("Sequencia interna calculando {}", sequenciaCalculada);
        return sequenciaCalculada;
    }
}
