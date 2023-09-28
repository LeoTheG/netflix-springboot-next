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
            String[] item1Images = new String[1];
            item1Images[0] = "/images/gilmore-girls-1.png";
            item1Images[1] = "/images/gilmore-girls-2.png";
            MediaItem item1 = new MediaItem("Gilmore Girls",
                    "Fiercely independent single mom Lorelai raises gifted, Ivy League-bound daughter Rory amid a continual stream of quick-witted repartee.",
                    new Date(), "Drama", "TV Show", item1Images, "/images/gilmore-girls.gif");

            mediaItemRepository.saveAll(List.of(item1));
            System.out.println("media items have been added to the database.");
        }
    }
}