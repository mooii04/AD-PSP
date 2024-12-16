package com.example.monumentosv2.models;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class MonumentoRepository {

    private HashMap<Long, Monumento> monumentos = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {
        add(Monumento.builder().id(1L).countryCode("ES").countryName("España").cityName("Madrid").latitude(40.416775).longitude(-3.703790).name("Puerta del Sol").description("Un famoso punto de referencia en Madrid.").image("http://example.com/puerta_del_sol.jpg").build());
        add(Monumento.builder().id(2L).countryCode("PT").countryName("Portugal").cityName("Lisboa").latitude(38.691583).longitude(-9.215000).name("Torre de Belém").description("Una torre histórica situada en Lisboa.").image("http://example.com/torre_de_belem.jpg").build());
        add(Monumento.builder().id(3L).countryCode("PE").countryName("Perú").cityName("Cusco").latitude(-13.163141).longitude(-72.544963).name("Machu Picchu").description("Una antigua ciudad inca en los Andes.").image("http://example.com/machu_picchu.jpg").build());
        add(Monumento.builder().id(4L).countryCode("ES").countryName("España").cityName("Ubeda").latitude(38.011935).longitude(-3.371483).name("Plaza Vázquez de Molina").description("Una plaza renacentista en Ubeda.").image("http://example.com/plaza_vazquez_de_molina.jpg").build());
        add(Monumento.builder().id(5L).countryCode("ES").countryName("España").cityName("Sevilla").latitude(37.388630).longitude(-5.982160).name("La Giralda").description("La Giralda es el nombre que recibe el campanario de la Catedral de Santa María de la Sede de la ciudad de Sevilla, en Andalucía, España.").image("giralda.jpg").build());
    }

    public Monumento add(Monumento monumento) {
        long id = counter.incrementAndGet();
        monumento.setId(id);
        monumentos.put(id, monumento);
        return monumento;
    }

    public Optional<Monumento> get(Long id) {
        return Optional.ofNullable((Monumento) monumentos.get(id));
    }

    public List<Monumento> getAll() {
        return List.copyOf(monumentos.values());
    }

    public Optional<Monumento> edit(Long id, Monumento newMonument) {
        return Optional.ofNullable(monumentos.computeIfPresent(id, (k, v) -> {
            v.setCityName(newMonument.getCityName());
            v.setImage(newMonument.getImage());
            v.setDescription(newMonument.getDescription());
            v.setLatitude(newMonument.getLatitude());
            v.setCountryCode(newMonument.getCountryCode());
            v.setLongitude(newMonument.getLongitude());
            v.setCountryName(newMonument.getCountryName());
            v.setName(newMonument.getName());

            return v;
        }));
    }

    public void delete(Long id) {
        monumentos.remove(id);
    }

    public List<Monumento> query(double maxLatitude, String sortDirection) {
        List<Monumento> data = new ArrayList<>(monumentos.values());
        List<Monumento> result;

        if (maxLatitude < 0) {
            result = data;
        } else {
            result = data
                    .stream()
                    .filter(m -> m.getLatitude() <= maxLatitude)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (sortDirection.equalsIgnoreCase("asc"))
            result.sort(Comparator.comparing(Monumento::getName));
        else if (sortDirection.equalsIgnoreCase("desc"))
            result.sort(Comparator.comparing(Monumento::getName).reversed());

        return Collections.unmodifiableList(result);
    }


}

