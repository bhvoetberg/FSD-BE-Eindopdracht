package nl.novi.fsdbe.service;

import nl.novi.fsdbe.exception.RecordNotFoundException;
import nl.novi.fsdbe.model.Deviation;
import nl.novi.fsdbe.repository.DeviationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DeviationService {

    @Autowired
    private DeviationRepository deviationRepository;

    public List<Deviation> getDeviations() {
        return deviationRepository.findAll();
    }

    public Deviation getDeviation(Long id) {
        Optional<Deviation> optionalDeviation = deviationRepository.findById(id);

        if (optionalDeviation.isPresent()) {
            return optionalDeviation.get();
        } else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public void deleteDeviation(Long id) {
        if (deviationRepository.existsById(id)) {
            deviationRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID does not exist!!!");
        }
    }

    public Long addDeviation(Deviation deviation) {
        Deviation newDeviation = deviationRepository.save(deviation);
        return newDeviation.getId();
    }


    public void updateDeviation(Long id, Deviation deviation) {
        Optional<Deviation> optionalDeviation = deviationRepository.findById(id);

        if (optionalDeviation.isPresent()) {
            Deviation storedDeviation = optionalDeviation.get();

            deviation.setId(storedDeviation.getId());
            deviationRepository.save(deviation);
        } else {
            throw new RecordNotFoundException("ID does not exist!");
        }
    }

    public void partialUpdateDeviation(Long id, Deviation deviation) {
        Optional<Deviation> optionalDeviation = deviationRepository.findById(id);

        if (optionalDeviation.isPresent()) {
            Deviation storedDeviation = deviationRepository.findById(id).orElse(null);

            if (deviation.getFinding() != null && !deviation.getFinding().isEmpty()) {
                storedDeviation.setFinding(deviation.getFinding());
            }
            if (deviation.getResolution() != null && !deviation.getResolution().isEmpty()) {
                storedDeviation.setResolution(deviation.getResolution());
            }

            if (deviation.isEnabled() == true || deviation.isEnabled() == false) {
                storedDeviation.setEnabled(deviation.isEnabled());
            }
            deviationRepository.save(storedDeviation);
        } else {
            throw new RecordNotFoundException("No valid update data present!");
        }
    }
}
