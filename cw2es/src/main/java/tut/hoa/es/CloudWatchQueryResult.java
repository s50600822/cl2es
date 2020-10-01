package tut.hoa.es;


import java.util.List;

public class CloudWatchQueryResult {
    List<CloudWatchEvent> events;
    List<SearchedLogStreams> searchedLogStreams;

    public List<CloudWatchEvent> getEvents() {
        return events;
    }

    public void setEvents(List<CloudWatchEvent> events) {
        this.events = events;
    }

    public List<SearchedLogStreams> getSearchedLogStreams() {
        return searchedLogStreams;
    }

    public void setSearchedLogStreams(List<SearchedLogStreams> searchedLogStreams) {
        this.searchedLogStreams = searchedLogStreams;
    }
}
