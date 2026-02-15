package com.anturia.picshare.service;

import com.anturia.picshare.model.Pic;
import com.anturia.picshare.repository.PicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicService {

    private final PicRepository picRepository;

    public PicService(PicRepository picRepository) {
        this.picRepository = picRepository;
    }

    public List<Pic> getAllPics() {
        return picRepository.findAll();
    }

    public Pic getPic(Long id) {
        return picRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pic not found"));
    }

    public Pic createPic(Pic pic) {
        return picRepository.save(pic);
    }

    public Pic updatePic(Long id, Pic updatedPic) {
        Pic pic = getPic(id);

        pic.setTitle(updatedPic.getTitle());
        pic.setDescription(updatedPic.getDescription());
        pic.setUrl(updatedPic.getUrl()); 

        return picRepository.save(pic);
    }

    public void deletePic(Long id) {
        picRepository.deleteById(id);
    }
}
