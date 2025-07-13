package com.ticketingsystem.model.interfaces;

import com.ticketingsystem.model.entities.Evento;

import java.util.List;

public interface EventInterface {
    void newEvent();
    void listEvents();
    Evento getEventById(String eventId);
    List<Evento> getEvents();
    void deleteEvent();
}
