package InnovaatioImpulssi.InnovaatiImpulssiLippu.service;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.LippuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LippuService {

    @Autowired
    private LippuRepository lippuRepository;

}
