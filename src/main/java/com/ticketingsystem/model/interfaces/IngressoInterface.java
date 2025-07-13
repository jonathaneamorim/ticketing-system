package com.ticketingsystem.model.interfaces;

import com.ticketingsystem.model.entities.Ingresso;
import com.ticketingsystem.model.enums.CategoriaEnum;

import java.util.List;
import java.util.Optional;

public interface IngressoInterface {
    List<Ingresso> getIngressosByEventoId(String eventoId);
    void removerIngressoERegistrarBilhete(Ingresso ingresso);
}
