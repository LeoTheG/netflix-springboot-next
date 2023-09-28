package com.example.demo.MediaItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class MediaItemSeeder implements CommandLineRunner {

    @Autowired
    private MediaItemRepository mediaItemRepository;

    @Override
    public void run(String... args) throws Exception {
        long count = mediaItemRepository.count();

        if (count == 0) {
            String[] item1Images = new String[2];
            item1Images[0] = "http://localhost:8080/images/gilmore-girls-1.png";
            item1Images[1] = "http://localhost:8080/images/gilmore-girls-2.png";
            MediaItem item1 = new MediaItem(
                    "Gilmore Girls",
                    "Fiercely independent single mom Lorelai raises gifted, Ivy League-bound daughter Rory amid a continual stream of quick-witted repartee.",
                    new Date(),
                    "Drama",
                    "TV Show",
                    item1Images,
                    "https://training-images-leogh.s3.amazonaws.com/gilmore-girls.gif",
                    "http://localhost:8080/images/gilmore-girls-title-logo.png");

            String[] item2Images = new String[1];
            item2Images[0] = "http://localhost:8080/images/suits-1.png";

            MediaItem item2 = new MediaItem(
                    "Suits",
                    "When he impresses a big lawyer with his razor-sharp mind, a college dropout scores a coveted associate job, even though he has no legal credentials.",
                    new Date(),
                    "Drama",
                    "TV Show",
                    item2Images,
                    "https://training-images-leogh.s3.amazonaws.com/suits.gif",
                    "http://localhost:8080/images/suits-title-logo.png");

            mediaItemRepository.saveAll(List.of(item1, item2));
            System.out.println("media items have been added to the database.");
        }
    }
}