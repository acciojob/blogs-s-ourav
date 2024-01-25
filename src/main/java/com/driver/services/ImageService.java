package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog=blogRepository2.findById(blogId).get();
        Image newimage=new Image(description,dimensions);
        newimage.setBlog(blog);
        blog.getImageList().add(newimage);
        //Image savedImage= imageRepository2.save(newimage);
        blogRepository2.save(blog);
        return newimage;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image=imageRepository2.findById(id).get();

        String wrd[]=screenDimensions.split("X");
        int screenh=Integer.parseInt(wrd[0]);
        int screenw=Integer.parseInt(wrd[1]);

        String wrd1[]=image.getDimensions().split("X");
        int imageh= Integer.parseInt(wrd1[0]) ;
        int imagew= Integer.parseInt(wrd1[1]);

        int res= (screenh/imageh) * (screenw/imagew) ;
        return res;
    }
}
