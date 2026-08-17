package com.example.streamlab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StreamServiceTest {
    @Autowired StreamService service;

    @Test
    void terminal_operation_should_trigger_lazy_pipeline() {
        AtomicInteger visited = new AtomicInteger();
        assertThat(service.countVisited(List.of("apple", "berry"), visited)).isEqualTo(1);
        assertThat(visited).hasValue(2);
    }

    @Test
    void building_pipeline_alone_should_not_execute_intermediate_operation() {
        AtomicInteger visited = new AtomicInteger();
        service.buildPipeline(List.of("apple", "berry"), visited);
        assertThat(visited).as("終端操作がないため中間操作はまだ実行されない").hasValue(0);
    }
}
