package org.wcci.apimastery.controllers;

import org.springframework.stereotype.Controller;
import org.wcci.apimastery.repositories.AlbumRepository;
import org.wcci.apimastery.storage.AlbumStorage;

@Controller
public class AlbumController {
    AlbumStorage albumStorage;
    AlbumRepository albumRepo;

    public AlbumController(AlbumStorage albumStorage, AlbumRepository albumRepo){
        this.albumStorage = albumStorage;
        this.albumRepo = albumRepo;
    }

}
