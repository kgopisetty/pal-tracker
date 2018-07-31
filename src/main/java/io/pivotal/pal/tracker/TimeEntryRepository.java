package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;

import java.util.List;

public interface TimeEntryRepository {

    TimeEntry create(TimeEntry timeEntry);

    TimeEntry find(Long id);

    TimeEntry update(long id, TimeEntry entry);

    TimeEntry delete(long id);

    List<TimeEntry> list();

}



