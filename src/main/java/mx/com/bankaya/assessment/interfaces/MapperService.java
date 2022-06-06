package mx.com.bankaya.assessment.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MapperService<SOURCE, TARGET> {

    TARGET convert(SOURCE source);

    default List<TARGET> convertAll(final List<SOURCE> sources) {
        List<TARGET> targets = new ArrayList<>();
        Optional.ofNullable(sources).ifPresent(list -> list.stream().map(this::convert).forEach(targets::add));
        return targets;
    }

}
