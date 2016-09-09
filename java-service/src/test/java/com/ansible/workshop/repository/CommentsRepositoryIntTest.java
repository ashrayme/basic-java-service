package com.ansible.workshop.repository;

import com.ansible.workshop.model.Comment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import static com.ansible.workshop.model.CommentBuilder.aComment;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentsRepositoryIntTest {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Before
    @After
    public void setUp() throws Exception {
        String mongo_system_collections_prefix = "system";
        mongoTemplate.getCollectionNames().forEach(collectionName -> {
            if (!collectionName.startsWith(mongo_system_collections_prefix)) {
                mongoTemplate.remove(new Query(), collectionName);
            }
        });
    }

    @Test
    public void shouldSaveCommentToDatabase() {
        assertThat(commentsRepository.findAll(), is(empty()));
        Comment comment = aComment().withComment("Hello World!").withEmail("me@helloworld.com").build();

        commentsRepository.save(comment);

        assertThat(commentsRepository.findAll(), hasSize(1));
        assertThat(commentsRepository.findAll(), hasItem(comment));
    }
}