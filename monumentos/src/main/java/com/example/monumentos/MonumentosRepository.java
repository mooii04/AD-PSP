package com.example.monumentos;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MonumentosRepository {

    private HashMap<Long, Monumentos> monumentos = new HashMap<>();

    @PostConstruct
    public void init() {
        add(Monumentos.builder().id(1L).codigoPais("ES").nombrePais("España").nombreCiudad("Madrid").latitud(40.416775).longitud(-3.703790).nombreMonumento("Puerta del Sol").descripcion("Un famoso punto de referencia en Madrid.").url("http://example.com/puerta_del_sol.jpg").build());
        add(Monumentos.builder().id(2L).codigoPais("PT").nombrePais("Portugal").nombreCiudad("Lisboa").latitud(38.691583).longitud(-9.215000).nombreMonumento("Torre de Belém").descripcion("Una torre histórica situada en Lisboa.").url("http://example.com/torre_de_belem.jpg").build());
        add(Monumentos.builder().id(3L).codigoPais("PE").nombrePais("Perú").nombreCiudad("Cusco").latitud(-13.163141).longitud(-72.544963).nombreMonumento("Machu Picchu").descripcion("Una antigua ciudad inca en los Andes.").url("http://example.com/machu_picchu.jpg").build());
        add(Monumentos.builder().id(4L).codigoPais("ES").nombrePais("España").nombreCiudad("Ubeda").latitud(38.011935).longitud(-3.371483).nombreMonumento("Plaza Vázquez de Molina").descripcion("Una plaza renacentista en Ubeda.").url("http://example.com/plaza_vazquez_de_molina.jpg").build());
    }

    public Monumentos add(Monumentos monumento) {
        monumentos.put(monumento.getId(), monumento);
        return monumento;
    }

    public Optional<Monumentos> get(Long id) {
        return Optional.ofNullable(monumentos.get(id));
    }

    public List<Monumentos> getAll() {
        return List.copyOf(monumentos.values());
    }

    public Optional<Monumentos> edit(Long id, Monumentos newValue) {
        return Optional.ofNullable(monumentos.computeIfPresent(id, (k, v) -> {
            v.setCodigoPais(newValue.getCodigoPais());
            v.setNombrePais(newValue.getNombrePais());
            v.setNombreCiudad(newValue.getNombreCiudad());
            v.setLatitud(newValue.getLatitud());
            v.setLongitud(newValue.getLongitud());
            v.setNombreMonumento(newValue.getNombreMonumento());
            v.setDescripcion(newValue.getDescripcion());
            v.setUrl(newValue.getUrl());
            return v;
        }));
    }

    public void delete(Long id) {
        monumentos.remove(id);
    }

    //Ver y entender este metodo en casa
    public List<Monumentos> query(double maxLatitud, String sortDirection) {
        List<Monumentos> data = new ArrayList<>(monumentos.values());
        List<Monumentos> result;

        if (maxLatitud < 0) {
            return data;
        } else {
            result = data.stream().
                    filter(p -> p.getLatitud() <= maxLatitud).
                    collect(Collectors.toCollection(ArrayList::new));
        }

        if (sortDirection.equalsIgnoreCase("asc")) {
            result.sort(Comparator.comparing(Monumentos::getNombreMonumento));
        } else if (sortDirection.equalsIgnoreCase("desc")) {
            result.sort(Comparator.comparing(Monumentos::getNombreMonumento).reversed());
        }

        return Collections.unmodifiableList(result);
    }

}
