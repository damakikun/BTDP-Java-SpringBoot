package com.belajar.jwt;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;


import java.util.Optional;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.belajar.jwt.controller.BlogController;
import com.belajar.jwt.model.Blog;
import com.belajar.jwt.repository.BlogRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBelajarJwtApplicationTests  {

    @MockBean(name = "blogRepository")
    BlogRepository blogRepository;

    @Autowired
    private BlogController blogController;


        @Test
        public void blogById () {
                Blog blog = new Blog();
                blog.setTitle("Testing");
                blog.setContent("A blog about Testing");
                blog.setId(1);
                blog.setAuthor("Adam");
                Mockito.when(blogRepository.findById(blog.getId())).thenReturn(Optional.of(blog));
                Optional<Blog> blog_service_abc = Optional.ofNullable(blogController.show("1"));
                assertThat(blog.getTitle()).isEqualTo(blog_service_abc.get().getTitle());
                assertTrue(blog.getContent().matches(".*blog about.*"));
            }


        }


