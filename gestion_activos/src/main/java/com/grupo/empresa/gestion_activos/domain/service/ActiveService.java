package com.grupo.empresa.gestion_activos.domain.service;

import com.grupo.empresa.gestion_activos.domain.dto.ActiveDto;
import com.grupo.empresa.gestion_activos.domain.repository.IActiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActiveService {

    private final IActiveService iActiveService;

    public List<ActiveDto> getAllActive() {
        return iActiveService.getAllActive();
    }

    public Optional<ActiveDto> getActive(int id) {
        return iActiveService.getActive(id);}

    public ActiveDto saveActive(ActiveDto active) {
        return iActiveService.saveActive(active);
    }

    public boolean deleteActive(int activeId) {
        return getActive(activeId).map(active -> {
            iActiveService.deleteActive(activeId);
            return true;
        }).orElse(false);
    }

    public Optional<List<ActiveDto>> getActiveByType(String type){
        return iActiveService.getActiveByType(type);
    }
    
    public  Optional<List<ActiveDto>> getActiveBySerial(String serial){
        return  iActiveService.getActiveBySerial(serial);
    }
    
    public Optional<List<ActiveDto>> getActiveByDate(Date date){
        return  iActiveService.getActiveByDate(date);
    }

}
