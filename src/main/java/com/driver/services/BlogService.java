package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;
    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) throws Exception{
        //create a blog at the current time
        Optional <User> optionalUser=userRepository1.findById(userId);
        if(optionalUser.isEmpty()){
            throw new Exception();
        }

        //create newblog and set user
        //add newblog to user's bloglist<>

        User usertobelinked=optionalUser.get();
        Blog newblog=new Blog(title,content);

        newblog.setUser(usertobelinked);
        usertobelinked.getBlogList().add(newblog);

        blogRepository1.save(newblog);
        userRepository1.save(usertobelinked);

        return newblog;
    }

    public void deleteBlog(int blogId) throws  Exception{
        //delete blog and corresponding images
        Optional<Blog>optionalBlog=blogRepository1.findById(blogId);
        if (optionalBlog.isEmpty()){
            throw new Exception();
        }
        blogRepository1.deleteById(blogId);
    }
}
