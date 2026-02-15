package com.anturia.picshare.controller;

import com.anturia.picshare.model.Pic;
import com.anturia.picshare.service.PicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pics")
public class PicController {

    private final PicService picService;

    public PicController(PicService picService) {
        this.picService = picService;
    }

    @GetMapping
    public List<Pic> getAllPics() {
        return picService.getAllPics();
    }

    @GetMapping("/{id}")
    public Pic getPic(@PathVariable Long id) {
        return picService.getPic(id);
    }

    @PostMapping
    public Pic createPic(@RequestBody Pic pic) {
        return picService.createPic(pic);
    }

    @PutMapping("/{id}")
    public Pic updatePic(@PathVariable Long id, @RequestBody Pic pic) {
        return picService.updatePic(id, pic);
    }

    @DeleteMapping("/{id}")
    public void deletePic(@PathVariable Long id) {
        picService.deletePic(id);
    }
}
