package com.example.monumentos;

import com.example.monumentos.Monumentos;
import com.example.monumentos.MonumentosRepository;
import com.example.monumentos.MonumentoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    private final MonumentosRepository monumentoRepository;

    public List<Monumentos> getAll() {
        List<Monumentos> result = monumentoRepository.getAll();
        if (result.isEmpty())
            throw new MonumentoNotFoundException();
        return result;
    }

    public List<Monumentos> query(double maxLatitude, String sortDirection) {
        List<Monumentos> result = monumentoRepository.query(maxLatitude, sortDirection);
        if (result.isEmpty())
            throw new MonumentoNotFoundException();
        return result;
    }

    public Monumentos get(Long id) {
        return monumentoRepository.get(id)
                .orElseThrow(() -> new MonumentoNotFoundException(id));
    }

    public Monumentos add(Monumentos monumento) {
        return monumentoRepository.add(monumento);
    }

    public Monumentos edit(Long id, Monumentos newValue) {
        return monumentoRepository.edit(id, newValue)
                .orElseThrow(() -> new MonumentoNotFoundException(id));
    }

    public void delete(Long id) {
        monumentoRepository.delete(id);
    }



}