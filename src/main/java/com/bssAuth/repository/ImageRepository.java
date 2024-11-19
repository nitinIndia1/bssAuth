package com.bssAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bssAuth.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
