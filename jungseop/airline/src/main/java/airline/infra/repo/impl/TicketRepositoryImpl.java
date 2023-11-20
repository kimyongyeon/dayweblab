package airline.infra.repo.impl;

import airline.domain.vo.Ticket;
import airline.infra.repo.TicketRepository;

import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {

    private final List<Ticket> store = new ArrayList<>();

    @Override
    public void create(Ticket ticket) {
        store.add(ticket);
    }

    @Override
    public boolean update(long id, Ticket newTicket) {
        boolean result = delete(id);
        if (result == true) {
            store.add(newTicket);
        }

        return result;
    }

    @Override
    public boolean delete(long id) {
        return store.removeIf(ticket -> ticket.getTicketId() == id);
    }

    @Override
    public Ticket findById(long id) {
        return store.stream()
                .filter(ticket -> ticket.getTicketId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Ticket> findAll() {
        return store;
    }
}
