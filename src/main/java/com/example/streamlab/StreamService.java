package com.example.streamlab;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Service
public class StreamService {
    public int countVisited(List<String> values, AtomicInteger visited) {
        Stream<String> pipeline = values.stream().filter(v -> { visited.incrementAndGet(); return v.startsWith("a"); });
        return (int) pipeline.count();
    }

    public Stream<String> buildPipeline(List<String> values, AtomicInteger visited) {
        return values.stream().filter(v -> { visited.incrementAndGet(); return v.startsWith("a"); });
    }
}
