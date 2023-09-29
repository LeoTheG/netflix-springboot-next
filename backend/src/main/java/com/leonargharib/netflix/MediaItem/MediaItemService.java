package com.leonargharib.netflix.MediaItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaItemService {

    @Autowired
    private MediaItemRepository mediaItemRepository;

    // Create a new media item
    public MediaItem createMediaItem(MediaItem mediaItem) {
        return mediaItemRepository.save(mediaItem);
    }

    // Get all media items
    public List<MediaItem> getAllMediaItems() {
        return mediaItemRepository.findAll();
    }

    // Get media item by ID
    public Optional<MediaItem> getMediaItemById(Long id) {
        return mediaItemRepository.findById(id);
    }

    // Update media item
    public MediaItem updateMediaItem(Long id, MediaItem mediaItemDetails) {
        Optional<MediaItem> mediaItem = mediaItemRepository.findById(id);
        if (mediaItem.isPresent()) {
            MediaItem existingMediaItem = mediaItem.get();
            existingMediaItem.setTitle(mediaItemDetails.getTitle());
            existingMediaItem.setDescription(mediaItemDetails.getDescription());
            existingMediaItem.setReleaseDate(mediaItemDetails.getReleaseDate());
            existingMediaItem.setGenre(mediaItemDetails.getGenre());
            existingMediaItem.setType(mediaItemDetails.getType());
            existingMediaItem.setImageUrls(mediaItemDetails.getImageUrls());
            existingMediaItem.setPreviewImageUrl(mediaItemDetails.getPreviewImageUrl());
            existingMediaItem.setTitleLogoUrl(mediaItemDetails.getTitleLogoUrl());
            return mediaItemRepository.save(existingMediaItem);
        }
        return null;
    }

    // Delete all media items
    public void deleteAllMediaItems() {
        mediaItemRepository.deleteAll();
    }

    // Delete media item
    public void deleteMediaItem(Long id) {
        mediaItemRepository.deleteById(id);
    }

    // Other business logic related to media items
}
