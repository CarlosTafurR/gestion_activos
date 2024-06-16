package com.grupo.empresa.gestion_activos.pesistence;

import com.grupo.empresa.gestion_activos.domain.dto.PossessionDto;
import com.grupo.empresa.gestion_activos.domain.repository.IFurnitureRepository;
import com.grupo.empresa.gestion_activos.pesistence.crud.InMuebleRepository;
import com.grupo.empresa.gestion_activos.pesistence.entity.InmuebleEntity;
import com.grupo.empresa.gestion_activos.pesistence.mapper.FurnitureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MuebleRepositoryImpl implements IFurnitureRepository {

    private final FurnitureMapper furnitureMapper;
    private final InMuebleRepository muebleCRUDRepository;

    @Override
    public List<PossessionDto> getAllFurniture() {
        return furnitureMapper.mapListDto((List<InmuebleEntity>) muebleCRUDRepository.findAll());
    }

    @Override
    public Optional<PossessionDto> getFurniture(int id) {
        return muebleCRUDRepository.findById(id).map(furnitureMapper::mapDto);
    }

    @Override
    public PossessionDto saveFurniture(PossessionDto furniture) {
        return furnitureMapper.mapDto(muebleCRUDRepository.save(furnitureMapper.mapEntity(furniture)));
    }

    @Override
    public void deleteFurniture(int furnitureId) {
        muebleCRUDRepository.deleteById(furnitureId);
    }
}
