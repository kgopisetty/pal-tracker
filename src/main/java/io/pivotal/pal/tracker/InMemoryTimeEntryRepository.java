package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long, TimeEntry> timeEntryMap = new HashMap<>();
    private long idsequence = 1;

    public TimeEntry create(TimeEntry timeEntry) {
        long id = idsequence++;

        TimeEntry created = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());

        timeEntryMap.put(id, created);
        return created;
    }


    public TimeEntry find(Long id) {
        TimeEntry timeEntry = timeEntryMap.get(id);
        return timeEntry;
    }

    public TimeEntry update(long id, TimeEntry entry) {
        if (timeEntryMap.get(id) == null) {
            return null;
        }

        TimeEntry update = new TimeEntry(id, entry.getProjectId(), entry.getUserId(), entry.getDate(), entry.getHours());

        timeEntryMap.put(id, update);

        return update;
    }

    public TimeEntry delete(long id) {
        TimeEntry timeEntry = timeEntryMap.get(id);
        timeEntryMap.remove(id);
        return timeEntry;
    }

    public List<TimeEntry> list() {
        List list = new ArrayList(timeEntryMap.values());
        return list;
    }
//    private TimeEntryRepository repo;
//
//    public InMemoryTimeEntryRepository() {
//        this.repo = new TimeEntryRepository();
//    }
//
//    public TimeEntry create(TimeEntry entry) {
//        repo.create(entry);
//
//        return entry;
//    }
//
//    public TimeEntry find(long id) {
//        return repo.find(id);
//    }
//
//    public TimeEntry update(long id, TimeEntry entry) {
//        repo.update(id, entry);
//        return entry;
//    }
//
//    public void delete(long id) {
//        repo.delete(id);
//    }
}
