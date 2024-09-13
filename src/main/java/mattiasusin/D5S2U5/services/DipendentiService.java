package mattiasusin.D5S2U5.services;

import mattiasusin.D5S2U5.entities.Dipendente;
import mattiasusin.D5S2U5.payloads.NewDipendenteDTO;
import mattiasusin.D5S2U5.repositories.DipendentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DipendentiService {
    @Autowired
    private DipendentiRepository dipendentiRepository;

    @Autowired
    private Cloudnary cloudnary;

    public Dipendente save(NewDipendenteDTO body) {
        // 1 -->

        // 2 -->

        // 3 -->
    }

}
