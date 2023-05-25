package lam.ss5_baithuchanh.model.service;

import lam.ss5_baithuchanh.model.entity.Music;

import java.util.List;

public interface IServiceMusic {
    List<Music> findAll();

    Music findById(Long id);

    void deleteById(Long id);

    void save(Music music);
}
