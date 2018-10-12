package com.rajim.springbootelasticsearch.repository;

import com.rajim.springbootelasticsearch.entity.Book;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;

/**
 * @author rajim on 10/11/18
 */
@Repository
public class BookRepository {
    private final String INDEX = "bookdata";
    private final String TYPE = "books";
    private RestHighLevelClient restHighLevelClient;
    private ObjectMapper objectMapper;

    public BookRepository( ObjectMapper objectMapper, RestHighLevelClient restHighLevelClient) {
        this.objectMapper = objectMapper;
        this.restHighLevelClient = restHighLevelClient;
    }

    public Book insert(Book book) {
        book.setId(UUID.randomUUID().toString());
        Map dataMap = objectMapper.convertValue(book, Map.class);
        IndexRequest indexRequest = new IndexRequest(INDEX, TYPE, book.getId())
                .source(dataMap);
        try {
            IndexResponse response = restHighLevelClient.index(indexRequest);
        } catch(ElasticsearchException e) {
            e.getDetailedMessage();
        } catch (java.io.IOException ex){
            ex.getLocalizedMessage();
        }
        return book;
    }
}
