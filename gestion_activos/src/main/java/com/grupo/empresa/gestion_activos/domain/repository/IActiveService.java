package com.grupo.empresa.gestion_activos.domain.repository;

import com.grupo.empresa.gestion_activos.domain.dto.ActiveDto;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IActiveService extends IAbstractRepository<ActiveDto, Integer> {

    List<ActiveDto> getAllActive();
    Optional<ActiveDto> getActive(int id);
    ActiveDto saveActive(ActiveDto active);
    void deleteActive(int activeId);
    Optional<List<ActiveDto>> getActiveByType(String type);
    Optional<List<ActiveDto>> getActiveBySerial(String serial);
    Optional<List<ActiveDto>> getActiveByDate(Date date);
}
