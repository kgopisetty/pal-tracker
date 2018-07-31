package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {

        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        return new ResponseEntity(timeEntryRepository.create(timeEntry),HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {

        TimeEntry timeEntry = timeEntryRepository.find(id);
        ResponseEntity<TimeEntry> response;

        if (timeEntry == null) {
            response = new ResponseEntity(timeEntry,HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(timeEntry,HttpStatus.OK);
        }

        return response;

    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {

        TimeEntry timeEntry = timeEntryRepository.delete(id);
        ResponseEntity<TimeEntry> response = new ResponseEntity(timeEntry,HttpStatus.NO_CONTENT);
        return response;

    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {

        List<TimeEntry> list = timeEntryRepository.list();
        ResponseEntity<List<TimeEntry>> response = new ResponseEntity(list,HttpStatus.OK);
        return response;

    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry timeEntry) {
        TimeEntry updated = timeEntryRepository.update(id, timeEntry);

        ResponseEntity<TimeEntry> response;

        if (updated != null) {
            response = new ResponseEntity(updated,HttpStatus.OK);
        } else {
            response = new ResponseEntity(timeEntry,HttpStatus.NOT_FOUND);
        }

        return response;
    }
}
