package com.leonargharib.netflix.MediaItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class MediaItemSeeder implements CommandLineRunner {

    @Autowired
    private MediaItemRepository mediaItemRepository;

    @Autowired
    private BaseUrlProvider baseUrlProvider;

    @Override
    public void run(String... args) throws Exception {

        String baseUrl = baseUrlProvider.getBaseUrl(); // get the base URL based on

        mediaItemRepository.deleteAll();

        String[] item1Images = new String[2];
        item1Images[0] = baseUrl + "/images/gilmore-girls-1.png";
        item1Images[1] = baseUrl + "/images/gilmore-girls-2.png";
        MediaItem item1 = new MediaItem(
                "Gilmore Girls",
                "Fiercely independent single mom Lorelai raises gifted, Ivy League-bound daughter Rory amid a continual stream of quick-witted repartee.",
                new Date(),
                "Drama",
                "TV Show",
                item1Images,
                "https://training-images-leogh.s3.amazonaws.com/gilmore-girls.gif",
                baseUrl + "/images/gilmore-girls-title-logo.png");

        String[] item2Images = new String[1];
        item2Images[0] = baseUrl + "/images/suits-1.png";

        MediaItem item2 = new MediaItem(
                "Suits",
                "When he impresses a big lawyer with his razor-sharp mind, a college dropout scores a coveted associate job, even though he has no legal credentials.",
                new Date(),
                "Drama",
                "TV Show",
                item2Images,
                "https://training-images-leogh.s3.amazonaws.com/suits.gif",
                baseUrl + "/images/suits-title-logo.png");

        String[] item3Images = new String[1];
        item3Images[0] = baseUrl + "/images/greys-anatomy-1.png";

        MediaItem item3 = new MediaItem(
                "Grey's Anatomy",
                "Intern (and eventual resident) Meredith Grey finds herself caught up in personal and professional passions with fellow doctors at a Seattle hospital.",
                new Date(),
                "Drama",
                "TV Show",
                item3Images,
                "https://training-images-leogh.s3.amazonaws.com/greys-anatomy.gif",
                baseUrl + "/images/greys-anatomy-title-logo.png");

        String[] item4Images = new String[1];
        item4Images[0] = baseUrl + "/images/stranger-things-1.jpg";

        MediaItem item4 = new MediaItem(
                "Stranger Things",
                "When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces and one strange little girl.",
                new Date(),
                "Drama",
                "TV Show",
                item4Images,
                "https://training-images-leogh.s3.amazonaws.com/stranger-things.gif",
                baseUrl + "/images/stranger-things-title-logo.png");

        String[] item5Images = new String[1];
        item5Images[0] = baseUrl + "/images/breaking-bad-1.png";

        MediaItem item5 = new MediaItem(
                "Breaking Bad",
                "A high school chemistry teacher dying of cancer teams with a former student to secure his family's future by manufacturing and selling crystal meth.",
                new Date(),
                "Drama",
                "TV Show",
                item5Images,
                "https://training-images-leogh.s3.amazonaws.com/breaking-bad.gif",
                baseUrl + "/images/breaking-bad-title-logo.png");

        mediaItemRepository.saveAll(List.of(item1, item2, item3, item4, item5));
        System.out.println("media items have been added to the database.");
    }
}