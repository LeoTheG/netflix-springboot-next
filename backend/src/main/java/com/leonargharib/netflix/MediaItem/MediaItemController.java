package com.leonargharib.netflix.MediaItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mediaitems")
@CrossOrigin(origins = "*")
public class MediaItemController {

    @Autowired
    private MediaItemService mediaItemService;

    // Create a new media item
    @PostMapping
    public MediaItem createMediaItem(@RequestBody MediaItem mediaItem) {
        return mediaItemService.createMediaItem(mediaItem);
    }

    // Get all media items
    @GetMapping
    public List<MediaItem> getAllMediaItems() {
        return mediaItemService.getAllMediaItems();
    }

    // Get media item by ID
    @GetMapping("/{id}")
    public Optional<MediaItem> getMediaItemById(@PathVariable Long id) {
        return mediaItemService.getMediaItemById(id);
    }

    // Update media item by ID
    @PutMapping("/{id}")
    public MediaItem updateMediaItem(@PathVariable Long id, @RequestBody MediaItem mediaItemDetails) {
        return mediaItemService.updateMediaItem(id, mediaItemDetails);
    }

    // Delete all media items
    @DeleteMapping
    public String deleteAllMediaItems() {
        mediaItemService.deleteAllMediaItems();
        return "All media items have been deleted successfully.";
    }

    // Delete media item by ID
    @DeleteMapping("/{id}")
    public void deleteMediaItem(@PathVariable Long id) {
        mediaItemService.deleteMediaItem(id);
    }
}
