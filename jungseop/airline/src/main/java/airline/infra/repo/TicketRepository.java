package airline.infra.repo;

import airline.domain.vo.Ticket;
import airline.infra.MemoryRepository;

public interface TicketRepository extends MemoryRepository<Ticket> {
}
