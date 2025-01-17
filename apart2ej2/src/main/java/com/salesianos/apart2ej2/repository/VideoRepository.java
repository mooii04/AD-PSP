package com.salesianos.apart2ej2.repository;

import com.salesianos.apart2ej2.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
