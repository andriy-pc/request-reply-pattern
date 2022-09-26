package com.requestreply.shipment.config;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class TopicCreator {

    private final AdminClient adminClient;

    @Value("#{'${listener.topics.shipment.request}, ${listener.topics.shipment.response}'.split(', ')}")
    Collection<String> topicNamesToCreate;

    @EventListener(ApplicationReadyEvent.class)
    @SneakyThrows
    public void createTopicsIfNecessary() {
        ListTopicsResult listTopicsResult = adminClient.listTopics();
        Set<String> topicNames = listTopicsResult.names().get(10, SECONDS);
        topicNames.forEach(topicNamesToCreate::remove);
        adminClient.createTopics(buildTopics(topicNamesToCreate));
    }

    Collection<NewTopic> buildTopics(Collection<String> topicsToCreate) {
        return topicsToCreate
                .stream()
                .map(name -> new NewTopic(name, 1, (short) 1))
                .collect(toList());
    }

}
