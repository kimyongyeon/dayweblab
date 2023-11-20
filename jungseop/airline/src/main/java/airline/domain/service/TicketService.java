package airline.domain.service;

import airline.domain.vo.Ticket;
import airline.infra.repo.TicketRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public Ticket issueTicket(Ticket ticket) {
        ticketRepository.create(ticket);
        return ticketRepository.findById(ticket.getTicketId());
    }

    public boolean refundTicket(long ticketId) {
        return ticketRepository.delete(ticketId);
    }

}
